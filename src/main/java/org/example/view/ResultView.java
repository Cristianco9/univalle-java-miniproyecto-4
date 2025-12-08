package app.view;

import javax.swing.*;
import java.awt.*;

// GUI de resultados
public class ResultView extends JFrame {

    public JLabel lblResult = new JLabel("Resultado", SwingConstants.CENTER);
    public JButton btnReplay = new JButton("Reintentar");
    public JButton btnNextLevel = new JButton("Siguiente Nivel");
    public JButton btnExit = new JButton("Salir");

    public ResultView() {

        setTitle("Resultados");
        setSize(520, 430);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel de fondo
        JPanel bg = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(15, 0, 30),
                        0, getHeight(), new Color(100, 0, 130)
                );

                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        bg.setLayout(new BorderLayout());
        add(bg);

        // Panel central
        JPanel card = new JPanel(new BorderLayout());
        card.setOpaque(false);
        card.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Panel semi-transparente
        JPanel glass = new JPanel(new BorderLayout());
        glass.setBackground(new Color(0, 0, 0, 120));
        glass.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 255, 255), 2),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        // texto de resultados
        lblResult.setFont(new Font("Consolas", Font.BOLD, 22));
        lblResult.setForeground(new Color(0, 255, 255));
        lblResult.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));

        glass.add(lblResult, BorderLayout.NORTH);

        // panel de botones
        JPanel buttonsPanel = new JPanel(new GridLayout(3, 1, 15, 15));
        buttonsPanel.setOpaque(false);

        styleButton(btnReplay, new Color(255, 0, 255));
        styleButton(btnNextLevel, new Color(255, 150, 0));
        styleButton(btnExit, new Color(0, 255, 255));

        buttonsPanel.add(btnReplay);
        buttonsPanel.add(btnNextLevel);
        buttonsPanel.add(btnExit);

        glass.add(buttonsPanel, BorderLayout.CENTER);

        card.add(glass, BorderLayout.CENTER);
        bg.add(card, BorderLayout.CENTER);
    }

    // método que estiliza los botones
    private void styleButton(JButton btn, Color neonColor) {

        btn.setFocusPainted(false);
        btn.setForeground(neonColor);
        btn.setFont(new Font("Consolas", Font.BOLD, 18));
        btn.setBackground(new Color(0, 0, 0, 140));
        btn.setBorder(BorderFactory.createLineBorder(neonColor, 2));
        btn.setPreferredSize(new Dimension(200, 45));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setOpaque(true);

        // Efecto hover
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setForeground(neonColor.brighter());
                btn.setBorder(BorderFactory.createLineBorder(neonColor.brighter(), 2));
                btn.setBackground(new Color(20, 20, 20, 180));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setForeground(neonColor);
                btn.setBorder(BorderFactory.createLineBorder(neonColor, 2));
                btn.setBackground(new Color(0, 0, 0, 140));
            }
        });
    }

    public void setNextLevelButtonText(int nextLevel) {
        btnNextLevel.setText("Ir al Nivel " + nextLevel);
    }
}
