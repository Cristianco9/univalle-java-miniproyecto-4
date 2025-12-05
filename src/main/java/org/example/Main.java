package app;

import app.controller.MainController;
import javax.swing.SwingUtilities;

/**
 * Punto de entrada
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainController controller = new MainController();
            controller.showStart();
        });
    }
}
