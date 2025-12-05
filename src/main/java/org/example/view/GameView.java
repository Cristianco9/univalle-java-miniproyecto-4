package app.view;

import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {

    // --- HUD ---
    public JLabel lblTimer = new JLabel("Tiempo: 00");
    public JLabel lblScore = new JLabel("Puntaje: 0");
    public JLabel lblLevel = new JLabel("Nivel: 1");

    // --- Pregunta ---
    public JTextArea txtQuestionArea = new JTextArea();
    public JScrollPane questionScroll;

    // --- Opciones ---
    public JRadioButton[] radioOptions = new JRadioButton[4];
    public ButtonGroup group = new ButtonGroup();

    // --- Inferior ---
    public JLabel lblFeedback = new JLabel(" ", SwingConstants.CENTER);
    public JButton btnNext = new JButton("Responder");
    public JButton btnQuit = new JButton("Terminar Juego");

    public GameView() {

        setTitle("Preguntados - Cyberpunk Battle Mode");
        setSize(700, 700);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* ============================================================
         *                 PANEL DE FONDO CYBERPUNK
         * ============================================================ */
        JPanel bg = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(10, 0, 40),
                        0, getHeight(), new Color(90, 0, 140)
                );

                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bg.setLayout(new BorderLayout());
        add(bg);

        /* ============================================================
         *                         HUD SUPERIOR
         * ============================================================ */
        JPanel hud = new JPanel(new BorderLayout());
        hud.setBackground(new Color(0, 0, 0, 80));
        hud.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Puntaje
        lblScore.setForeground(Color.CYAN);
        lblScore.setFont(new Font("Consolas", Font.BOLD, 18));

        // Nivel
        lblLevel.setForeground(new Color(0, 255, 180));
        lblLevel.setFont(new Font("Consolas", Font.BOLD, 18));
        lblLevel.setHorizontalAlignment(SwingConstants.CENTER);

        // Timer
        lblTimer.setForeground(new Color(255, 255, 0));
        lblTimer.setFont(new Font("Consolas", Font.BOLD, 18));
        lblTimer.setHorizontalAlignment(SwingConstants.RIGHT);

        hud.add(lblScore, BorderLayout.WEST);
        hud.add(lblLevel, BorderLayout.CENTER);
        hud.add(lblTimer, BorderLayout.EAST);

        bg.add(hud, BorderLayout.NORTH);

        /* ============================================================
         *                 TARJETA CENTRAL DE PREGUNTAS
         * ============================================================ */
        JPanel questionCard = new JPanel();
        questionCard.setLayout(new BorderLayout(20, 20));
        questionCard.setBackground(new Color(0, 0, 0, 100));
        questionCard.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Texto de pregunta con scroll
        txtQuestionArea.setEditable(false);
        txtQuestionArea.setWrapStyleWord(true);
        txtQuestionArea.setLineWrap(true);
        txtQuestionArea.setForeground(new Color(255, 0, 150));
        txtQuestionArea.setBackground(new Color(0, 0, 0, 0));
        txtQuestionArea.setFont(new Font("Consolas", Font.BOLD, 20));
        txtQuestionArea.setOpaque(false);

        questionScroll = new JScrollPane(txtQuestionArea);
        questionScroll.setOpaque(false);
        questionScroll.getViewport().setOpaque(false);
        questionScroll.setBorder(null);

        questionCard.add(questionScroll, BorderLayout.NORTH);

        /* ============================================================
         *                     OPCIONES DE RESPUESTA
         * ============================================================ */
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 15, 15));
        optionsPanel.setOpaque(false);

        for (int i = 0; i < radioOptions.length; i++) {
            radioOptions[i] = createNeonRadioButton("Opción " + (i + 1));
            group.add(radioOptions[i]);
            optionsPanel.add(radioOptions[i]);
        }

        questionCard.add(optionsPanel, BorderLayout.CENTER);
        bg.add(questionCard, BorderLayout.CENTER);

        /* ============================================================
         *                     PANEL INFERIOR
         * ============================================================ */
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(new Color(0, 0, 0, 80));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        lblFeedback.setForeground(new Color(0, 255, 255));
        lblFeedback.setFont(new Font("Consolas", Font.BOLD, 16));
        bottomPanel.add(lblFeedback, BorderLayout.NORTH);

        // Botón Responder
        styleNeonButton(btnNext, new Color(255, 0, 255));

        styleNeonButton(btnQuit, new Color(255, 80, 80));

        JPanel btnPanel = new JPanel();
        btnPanel.setOpaque(false);

        btnPanel.add(btnNext);
        btnPanel.add(Box.createHorizontalStrut(20)); // separador estético
        btnPanel.add(btnQuit); // agregar botón terminar

        bottomPanel.add(btnPanel, BorderLayout.SOUTH);
        bg.add(bottomPanel, BorderLayout.SOUTH);
    }

    /* ============================================================
     *                 RADIOBUTTON ESTILO NEON
     * ============================================================ */
    private JRadioButton createNeonRadioButton(String text) {
        JRadioButton rb = new JRadioButton(text);

        rb.setOpaque(false);
        rb.setForeground(new Color(0, 255, 255));
        rb.setFont(new Font("Consolas", Font.PLAIN, 18));
        rb.setFocusPainted(false);
        rb.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Hover
        rb.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                rb.setForeground(new Color(255, 0, 255));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                if (!rb.isSelected())
                    rb.setForeground(new Color(0, 255, 255));
            }
        });

        return rb;
    }

    /* ============================================================
     *               BOTÓN NEON CYBERPUNK
     * ============================================================ */
    private void styleNeonButton(JButton btn, Color neonColor) {

        btn.setFocusPainted(false);
        btn.setForeground(neonColor);
        btn.setFont(new Font("Consolas", Font.BOLD, 20));
        btn.setBackground(new Color(0, 0, 0, 0));
        btn.setBorder(BorderFactory.createLineBorder(neonColor, 2));
        btn.setPreferredSize(new Dimension(200, 50));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setForeground(neonColor.brighter());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setForeground(neonColor);
            }
        });
    }

    /* ============================================================
     *                   MÉTODOS ÚTILES (Controller)
     * ============================================================ */

    /** Establecer el texto de la pregunta */
    public void setQuestionText(String text) {
        txtQuestionArea.setText(text);
    }

    /** Actualizar nivel */
    public void setLevelText(String text) {
        lblLevel.setText(text);
    }

    /** Obtener opción seleccionada */
    public int getSelectedIndex() {
        for (int i = 0; i < radioOptions.length; i++) {
            if (radioOptions[i].isSelected()) return i;
        }
        return -1;
    }

    /** Limpiar selección */
    public void clearSelection() {
        group.clearSelection();
    }

    public void setNextButtonEnabled(boolean enabled) {
        btnNext.setEnabled(enabled);
    }

    public void setButtonsEnabled(boolean enabled) {
        btnNext.setEnabled(enabled);
        btnQuit.setEnabled(enabled);
    }
}
