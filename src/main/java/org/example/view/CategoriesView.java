package app.view;

import javax.swing.*;
import java.awt.*;

// Vista de selección de categoría
public class CategoriesView extends JFrame {

    public JComboBox<String> cbCategories;
    // botones
    public JButton btnStart = new JButton("Iniciar Ronda");
    public JButton btnBack = new JButton("Volver");

    // constructor
    public CategoriesView(String[] categories) {

        setTitle("Seleccionar Categoría");
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Panel de fondo con color degradado
        JPanel bg = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;

                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(20, 0, 40),
                        0, getHeight(), new Color(90, 0, 140)
                );

                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bg.setLayout(new BorderLayout());
        add(bg);


        // titulo de la ventana
        JLabel title = new JLabel("SELECCIONA UNA CATEGORÍA", SwingConstants.CENTER);
        title.setFont(new Font("Consolas", Font.BOLD, 30));
        title.setForeground(new Color(255, 0, 150));
        title.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));

        bg.add(title, BorderLayout.NORTH);


        // Panel central
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(0, 0, 0, 80)); // translúcido
        card.setBorder(BorderFactory.createEmptyBorder(60, 150, 60, 150));

        bg.add(card, BorderLayout.CENTER);

        // Estilos de las categorias
        cbCategories = new JComboBox<>(categories);
        styleCombo(cbCategories);
        cbCategories.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(cbCategories);
        card.add(Box.createVerticalStrut(30));

        // Botón Iniciar
        styleNeonButton(btnStart, new Color(0, 255, 255)); // cyan
        btnStart.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Botón Volver
        styleNeonButton(btnBack, new Color(255, 0, 255)); // fucsia
        btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(btnStart);
        card.add(Box.createVerticalStrut(20));
        card.add(btnBack);


        // footer
        bg.add(createFooter(), BorderLayout.SOUTH);
    }


    // método getter de la categoria
    public String getSelectedCategory() {
        return (String) cbCategories.getSelectedItem();
    }


    // estilos de la caja
    private void styleCombo(JComboBox<String> combo) {
        combo.setBackground(new Color(20, 0, 40));
        combo.setForeground(new Color(0, 255, 255));
        combo.setFont(new Font("Consolas", Font.BOLD, 18));

        combo.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 255), 2));
        combo.setPreferredSize(new Dimension(260, 40));
        combo.setMaximumSize(combo.getPreferredSize());

        combo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }


    // método que estila los botones
    private void styleNeonButton(JButton btn, Color neonColor) {

        btn.setFocusPainted(false);
        btn.setForeground(neonColor);
        btn.setFont(new Font("Consolas", Font.BOLD, 20));
        btn.setBackground(new Color(0, 0, 0, 0));
        btn.setBorder(BorderFactory.createLineBorder(neonColor, 2));
        btn.setPreferredSize(new Dimension(200, 50));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Efecto hover sobre el botón
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


    // footer
    private JPanel createFooter() {

        JPanel footer = new JPanel();
        footer.setPreferredSize(new Dimension(600, 140));
        footer.setBackground(new Color(15, 0, 45));
        footer.setLayout(new BoxLayout(footer, BoxLayout.Y_AXIS));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lbl1 = new JLabel("Categorías del Juego", SwingConstants.CENTER);
        JLabel lbl2 = new JLabel("Proyecto Programación Orientada a Eventos", SwingConstants.CENTER);
        JLabel lbl3 = new JLabel("Preguntados", SwingConstants.CENTER);

        styleFooterLabel(lbl1, new Color(0, 255, 255), true);
        styleFooterLabel(lbl2, new Color(255, 0, 255), false);
        styleFooterLabel(lbl3, new Color(255, 255, 0), false);

        lbl1.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);
        lbl3.setAlignmentX(Component.CENTER_ALIGNMENT);

        footer.add(lbl1);
        footer.add(Box.createVerticalStrut(8));
        footer.add(lbl2);
        footer.add(Box.createVerticalStrut(8));
        footer.add(lbl3);

        return footer;
    }


    // estilos de las etiquetas del footer
    private void styleFooterLabel(JLabel lbl, Color color, boolean bold) {
        lbl.setForeground(color);
        lbl.setFont(new Font("Consolas", bold ? Font.BOLD : Font.PLAIN, 14));
    }
}
