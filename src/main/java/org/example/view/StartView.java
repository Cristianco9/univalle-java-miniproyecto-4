package app.view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StartView extends JFrame {

    // Botones públicos para el controller
    public JButton btnPlay = new JButton("Jugar");
    public JButton btnExit = new JButton("Salir");

    public StartView() {

        /* ===============================
         *   CONFIGURACIÓN DE LA VENTANA
         * =============================== */
        setTitle("Preguntados");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        /* ===============================
         *  PANEL DE FONDO CYBERPUNK
         * =============================== */
        JPanel bg = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;

                GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(10, 0, 40),
                        0, getHeight(), new Color(90, 0, 140)
                );

                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        bg.setLayout(new BorderLayout());
        add(bg);

        /* ===============================
         *          TÍTULO
         * =============================== */
        JLabel title = new JLabel("P  R  E  G  U  N  T  A  D  O  S", SwingConstants.CENTER);
        title.setFont(new Font("Consolas", Font.BOLD, 36));
        title.setForeground(new Color(255, 0, 150));
        title.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));

        bg.add(title, BorderLayout.NORTH);

        /* ===============================
         *      PANEL CENTRAL (BOTONES)
         * =============================== */
        JPanel centerCard = new JPanel();
        centerCard.setLayout(new GridLayout(2, 1, 0, 22));  // <-- ahora son DOS BOTONES
        centerCard.setBackground(new Color(0, 0, 0, 80)); // translúcido
        centerCard.setBorder(BorderFactory.createEmptyBorder(100, 170, 100, 170));

        bg.add(centerCard, BorderLayout.CENTER);

        // Aplicar estilo neon a cada botón
        styleNeonButton(btnPlay, new Color(0, 255, 255));   // Cian neon
        styleNeonButton(btnExit, new Color(255, 255, 0));   // Amarillo neon

        // Añadir botones
        centerCard.add(btnPlay);
        centerCard.add(btnExit);

        /* ===============================
         *          FOOTER
         * =============================== */
        bg.add(createFooter(), BorderLayout.SOUTH);
    }

    /* =====================================================
     *             MÉTODO QUE CREA EL FOOTER
     * ===================================================== */
    private JPanel createFooter() {

        JPanel footer = new JPanel();
        footer.setPreferredSize(new Dimension(700, 150));
        footer.setBackground(new Color(15, 0, 45));
        footer.setLayout(new BoxLayout(footer, BoxLayout.Y_AXIS));
        footer.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JLabel lblFecha = new JLabel("Fecha:", SwingConstants.CENTER);
        JLabel lblFechaValue = new JLabel("Viernes, 5 Diciembre 2025",SwingConstants.CENTER);

        JLabel lblAutor = new JLabel("Desarrollado por:", SwingConstants.CENTER);
        JLabel lblAutorValue = new JLabel("Cristian Camilo Cortes Ortiz", SwingConstants.CENTER);

        styleFooterLabel(lblFecha, new Color(0, 255, 255), true);
        styleFooterLabel(lblFechaValue, new Color(0, 255, 255), false);
        styleFooterLabel(lblAutor, new Color(255, 0, 255), true);
        styleFooterLabel(lblAutorValue, new Color(255, 0, 255), false);

        lblFecha.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblFechaValue.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblAutor.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblAutorValue.setAlignmentX(Component.CENTER_ALIGNMENT);

        footer.add(lblFecha);
        footer.add(Box.createVerticalStrut(8));
        footer.add(lblFechaValue);
        footer.add(Box.createVerticalStrut(12));
        footer.add(lblAutor);
        footer.add(Box.createVerticalStrut(8));
        footer.add(lblAutorValue);

        return footer;
    }

    /* =====================================================
     *         ESTILO DE LABELS DEL FOOTER
     * ===================================================== */
    private void styleFooterLabel(JLabel label, Color color, boolean bold) {
        label.setForeground(color);
        label.setFont(new Font("Consolas", bold ? Font.BOLD : Font.PLAIN, 14));
    }

    /* =====================================================
     *         ESTILO DE BOTONES CYBERPUNK NEON
     * ===================================================== */
    private void styleNeonButton(JButton btn, Color neonColor) {

        btn.setFocusPainted(false);
        btn.setForeground(neonColor);
        btn.setFont(new Font("Consolas", Font.BOLD, 18));
        btn.setBackground(new Color(0, 0, 0, 0));
        btn.setBorder(BorderFactory.createLineBorder(neonColor, 2));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setPreferredSize(new Dimension(160, 45));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBorder(BorderFactory.createLineBorder(neonColor.brighter(), 3));
                btn.setForeground(neonColor.brighter());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBorder(BorderFactory.createLineBorder(neonColor, 2));
                btn.setForeground(neonColor);
            }
        });
    }
}
