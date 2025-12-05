package app.controller;

import app.model.*;
import app.view.*;
import app.util.Utils;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Timer;

import javax.swing.*;

public class MainController {

    private StartView startView;
    private RegisterView registerView;
    private CategoriesView categoriesView;
    private GameView gameView;
    private ResultView resultView;
    private GameWonView gameWonView;

    private QuestionBank bank;
    private ScoreManager scoreManager;
    private Player currentPlayer;

    private List<Question> currentQuestions;
    private int currentIndex;
    private int score;
    private int level = 1;

    private Timer questionTimer;
    private final int timePerQuestion = 15;

    /* ===============================================================
     *                      CONSTRUCTOR
     * =============================================================== */
    public MainController() {

        bank = new QuestionBank();
        scoreManager = new ScoreManager();

        startView = new StartView();
        registerView = new RegisterView();
        categoriesView = new CategoriesView(new String[]{"Historia", "Ciencia", "Cultura"});
        gameView = new GameView();
        resultView = new ResultView();
        gameWonView = new GameWonView();

        Utils.centerFrame(startView);
        Utils.centerFrame(registerView);
        Utils.centerFrame(categoriesView);
        Utils.centerFrame(gameView);
        Utils.centerFrame(resultView);
        Utils.centerFrame(gameWonView);

        attachListeners();
    }

    public void showStart() {
        startView.setVisible(true);
    }

    /* ===============================================================
     *                      LISTENERS
     * =============================================================== */
    private void attachListeners() {

        /* ------------------- START VIEW ------------------- */

        startView.btnPlay.addActionListener(e -> {
            if (currentPlayer == null) {
                startView.setVisible(false);
                registerView.setVisible(true);
                return;
            }
            startView.setVisible(false);
            categoriesView.setVisible(true);
        });

        startView.btnExit.addActionListener(e -> System.exit(0));


        /* ------------------- REGISTER VIEW ------------------- */

        registerView.btnSave.addActionListener(e -> handleUserRegistration());

        registerView.btnBack.addActionListener(e -> {
            registerView.setVisible(false);
            startView.setVisible(true);
        });


        /* ------------------- CATEGORIES VIEW ------------------- */

        categoriesView.btnStart.addActionListener(e -> {

            String category = categoriesView.getSelectedCategory();
            startRound(category);

            categoriesView.setVisible(false);
            gameView.setVisible(true);
        });

        categoriesView.btnBack.addActionListener(e -> {
            categoriesView.setVisible(false);
            startView.setVisible(true);
        });


        /* ------------------- GAME VIEW ------------------- */

        gameView.btnNext.addActionListener(e -> processAnswerAndNext());

        gameView.btnQuit.addActionListener(e -> {
            int res = JOptionPane.showConfirmDialog(
                    gameView,
                    "¿Seguro que deseas terminar la partida?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION
            );

            if (res == JOptionPane.YES_OPTION) {
                if (questionTimer != null && questionTimer.isRunning()) questionTimer.stop();
                gameView.setVisible(false);
                startView.setVisible(true);
            }
        });


        /* ------------------- RESULT VIEW ------------------- */

        resultView.btnReplay.addActionListener(e -> {
            resultView.setVisible(false);
            level = 1;
            categoriesView.setVisible(true);
        });

        resultView.btnNextLevel.addActionListener(e -> handleNextLevel());

        resultView.btnExit.addActionListener(e -> System.exit(0));


        /* ------------------- GAME WON VIEW ------------------- */

        gameWonView.btnBackToMenu.addActionListener(e -> {
            level = 1;
            gameWonView.setVisible(false);
            startView.setVisible(true);
        });
    }

    /* ===============================================================
     *             REGISTRO DE JUGADOR
     * =============================================================== */
    private void handleUserRegistration() {

        String name = registerView.txtName.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(registerView, "Ingrese un nombre válido");
            return;
        }

        if (scoreManager.userExists(name)) {
            JOptionPane.showMessageDialog(registerView, "Este nombre ya está registrado.");
            return;
        }

        scoreManager.registerUser(name);
        currentPlayer = new Player(name);

        JOptionPane.showMessageDialog(registerView,
                "Jugador registrado correctamente.\nBienvenido " + name);

        registerView.txtName.setText("");

        registerView.setVisible(false);
        categoriesView.setVisible(true);
    }

    /* ===============================================================
     *                   INICIO DE RONDA
     * =============================================================== */
    private void startRound(String category) {

        currentQuestions = bank.getRandomQuestionsFallback(category, level, 10);

        currentIndex = 0;
        score = 0;

        gameView.lblScore.setText("Puntaje: 0");
        gameView.setLevelText("Nivel: " + level);

        loadQuestion();
    }

    /* ===============================================================
     *                   CARGAR PREGUNTA
     * =============================================================== */
    private void loadQuestion() {

        if (currentIndex >= currentQuestions.size()) {
            endRound();
            return;
        }

        Question q = currentQuestions.get(currentIndex);

        // -------- 1) Mezclar opciones aleatoriamente --------
        List<String> mixedOptions = new ArrayList<>(q.getOptions());
        Collections.shuffle(mixedOptions);

        // -------- 2) Guardar índice nuevo de respuesta correcta -------
        int newCorrectIndex = mixedOptions.indexOf(q.getOptions().get(q.getCorrectIndex()));

        // Actualizar objeto pregunta (solo para esta ronda, no permanente)
        q.setShuffledOptions(mixedOptions);
        q.setShuffledCorrectIndex(newCorrectIndex);

        // -------- 3) Actualizar GUI --------
        gameView.setQuestionText(
                String.format(
                        "(%d/%d)\n\n%s",
                        currentIndex + 1,
                        currentQuestions.size(),
                        q.getText()
                )
        );

        for (int i = 0; i < gameView.radioOptions.length; i++) {
            if (i < mixedOptions.size()) {
                gameView.radioOptions[i].setText(mixedOptions.get(i));
                gameView.radioOptions[i].setVisible(true);
            } else {
                gameView.radioOptions[i].setVisible(false);
            }
        }

        gameView.clearSelection();
        gameView.lblFeedback.setText(" ");
        startTimer();
    }


    /* ===============================================================
     *                        TIMER
     * =============================================================== */
    private void startTimer() {

        if (questionTimer != null && questionTimer.isRunning())
            questionTimer.stop();

        final int[] remaining = {timePerQuestion};
        gameView.lblTimer.setText("Tiempo: " + remaining[0]);

        questionTimer = new Timer(1000, null);

        questionTimer.addActionListener(e -> {

            remaining[0]--;
            gameView.lblTimer.setText("Tiempo: " + remaining[0]);

            if (remaining[0] <= 0) {

                questionTimer.stop();
                gameView.lblFeedback.setText("Se acabó el tiempo. Incorrecta.");

                Timer pause = new Timer(1500, ev -> {
                    ((Timer) ev.getSource()).stop();
                    currentIndex++;
                    loadQuestion();
                });

                pause.setRepeats(false);
                pause.start();
            }
        });

        questionTimer.start();
    }

    /* ===============================================================
     *              PROCESAR RESPUESTA Y SIGUIENTE
     * =============================================================== */
    private void processAnswerAndNext() {

        // Evita doble click
        gameView.setNextButtonEnabled(false);

        // Detener timer si sigue corriendo
        if (questionTimer != null && questionTimer.isRunning())
            questionTimer.stop();

        Question q = currentQuestions.get(currentIndex);

        int selected = gameView.getSelectedIndex();

        // Si NO seleccionó nada, no avanzar
        if (selected == -1) {
            gameView.lblFeedback.setText("Seleccione una opción.");
            gameView.setNextButtonEnabled(true);
            startTimer();
            return;
        }

        // ===== USAR RESPUESTAS MEZCLADAS =====
        int correctIndex = q.getShuffledCorrectIndex();    // índice dinámico
        List<String> opts = q.getShuffledOptions();        // lista mezclada

        if (selected == correctIndex) {
            score++;
            gameView.lblFeedback.setText("¡Correcto!");
        } else {
            gameView.lblFeedback.setText(
                    "Incorrecto. Correcta: " + opts.get(correctIndex)
            );
        }

        // Actualizar puntaje en pantalla
        gameView.lblScore.setText("Puntaje: " + score);

        // Pausa para ver feedback
        Timer pause = new Timer(1800, e -> {
            ((Timer) e.getSource()).stop();
            currentIndex++;
            gameView.setNextButtonEnabled(true);
            loadQuestion();
        });

        pause.setRepeats(false);
        pause.start();
    }


    /* ===============================================================
     *                     FIN DE RONDA
     * =============================================================== */
    private void endRound() {

        if (currentPlayer != null) {
            scoreManager.saveScore(
                    currentPlayer.getName(),
                    score,
                    currentQuestions.isEmpty() ? "N/A" : currentQuestions.get(0).getCategory(),
                    level
            );
        }

        gameView.setVisible(false);

        boolean passed = score >= 6;

        String msg = "<html><center>Tu puntaje: " + score +
                " / " + currentQuestions.size() +
                "<br>Nivel: " + level +
                (passed
                        ? "<br>¡Aprobaste este nivel!"
                        : "<br>No alcanzaste el puntaje mínimo (6 pts)") +
                "</center></html>";

        resultView.lblResult.setText(msg);

        if (passed) {

            if (level == 3) {
                // ✔ FINAL DEL JUEGO
                resultView.setVisible(false);
                gameWonView.setVisible(true);
                return;
            }

            resultView.btnNextLevel.setVisible(true);
            resultView.setNextLevelButtonText(level + 1);

        } else {
            resultView.btnNextLevel.setVisible(false);
        }

        resultView.setVisible(true);
    }

    /* ===============================================================
     *               LÓGICA DE SIGUIENTE NIVEL
     * =============================================================== */
    private void handleNextLevel() {

        if (score < 6) {
            JOptionPane.showMessageDialog(resultView,
                    "No alcanzaste el puntaje mínimo para subir de nivel.");
            return;
        }

        level++;

        resultView.setVisible(false);
        categoriesView.setVisible(true);
    }
}
