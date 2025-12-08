package app.view;

import javax.swing.*;
import java.awt.*;

// GUI de juego completado
public class GameWonView extends JFrame {

    // botón de regresar
    public JButton btnBackToMenu = new JButton("Volver al Inicio");

    // constructor
    public GameWonView() {

        setTitle("¡Juego Completado!");
        setSize(600, 400);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // panel de fondo
        JPanel bg = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(
                        0, 0, new Color(20, 0, 50),
                        0, getHeight(), new Color(140, 0, 230)
                );
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bg.setLayout(new BorderLayout());
        add(bg);

        JLabel title = new JLabel("¡HAS COMPLETADO LOS 3 NIVELES!", SwingConstants.CENTER);
        title.setFont(new Font("Consolas", Font.BOLD, 28));
        title.setForeground(new Color(255, 0, 200));
        title.setBorder(BorderFactory.createEmptyBorder(40, 0, 20, 0));
        bg.add(title, BorderLayout.NORTH);

        JLabel subtitle = new JLabel("¡Eres un verdadero maestro de Preguntados!", SwingConstants.CENTER);
        subtitle.setFont(new Font("Consolas", Font.PLAIN, 18));
        subtitle.setForeground(Color.CYAN);
        bg.add(subtitle, BorderLayout.CENTER);

        styleButton(btnBackToMenu, new Color(255, 80, 255));

        JPanel south = new JPanel();
        south.setOpaque(false);
        south.add(btnBackToMenu);
        bg.add(south, BorderLayout.SOUTH);
    }

    // método que estiliza los botones
    private void styleButton(JButton btn, Color neon) {
        btn.setForeground(neon);
        btn.setFont(new Font("Consolas", Font.BOLD, 20));
        btn.setBackground(new Color(0,0,0,0));
        btn.setBorder(BorderFactory.createLineBorder(neon, 2));
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(260, 50));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setForeground(neon.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setForeground(neon);
            }
        });
    }
}
