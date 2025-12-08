package app.model;

import java.util.List;
import java.util.Objects;

// clase que representa las preguntas
public class Question {


    private String category;
    private String text;
    // opciones originales en su orden (la correcta puede estar en cualquier índice)
    private List<String> options;
    // índice en 'options' de la respuesta correcta
    private int correctIndex;
    // nivel de dificultad (1,2,3)
    private int level;

    // Campos para manejo temporal en cada ronda
    private List<String> shuffledOptions;
    private int shuffledCorrectIndex = -1;

    // constructor
    public Question(String category, String text, List<String> options, int correctIndex, int level) {
        this.category = category;
        this.text = text;
        this.options = options;
        this.correctIndex = correctIndex;
        this.level = level;
    }


    // métodos getters
    // categoria
    public String getCategory() {
        return category;
    }

    // texto
    public String getText() {
        return text;
    }

    // Devuelve las opciones ORIGINALES (sin mezclar)
    public List<String> getOptions() {
        return options;
    }

    // Índice de la respuesta correcta en la lista ORIGINAL de opciones.
    public int getCorrectIndex() {
        return correctIndex;
    }

    // nivel
    public int getLevel() {
        return level;
    }


    // Establece la lista de opciones mezcladas para esta instancia (temporal).
    public void setShuffledOptions(List<String> shuffledOptions) {
        this.shuffledOptions = shuffledOptions;
    }

    // Establece el índice correcto dentro de la lista mezclada.
    public void setShuffledCorrectIndex(int shuffledCorrectIndex) {
        this.shuffledCorrectIndex = shuffledCorrectIndex;
    }


     //Devuelve la lista de opciones que debe usarse en la UI:
     // si hay opciones mezcladas, las retorna; si no, retorna las originales.
    public List<String> getShuffledOptions() {
        return (shuffledOptions != null) ? shuffledOptions : options;
    }

    // Devuelve el índice correcto en la lista actual (mezclada si existe, si no la original).
    public int getShuffledCorrectIndex() {
        return (shuffledCorrectIndex != -1) ? shuffledCorrectIndex : correctIndex;
    }

    // Limpia el estado de shuffle (usar cuando termines la ronda para resetear).
    public void clearShuffle() {
        this.shuffledOptions = null;
        this.shuffledCorrectIndex = -1;
    }

    @Override
    public String toString() {
        return "Question{" +
                "category='" + category + '\'' +
                ", text='" + text + '\'' +
                ", options=" + options +
                ", correctIndex=" + correctIndex +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return correctIndex == question.correctIndex &&
                level == question.level &&
                Objects.equals(category, question.category) &&
                Objects.equals(text, question.text) &&
                Objects.equals(options, question.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, text, options, correctIndex, level);
    }
}
