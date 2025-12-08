package app.view;

import javax.swing.*;
import java.awt.*;

// GUI de resgistro
public class RegisterView extends JFrame {

    public JTextField txtName = new JTextField(20);
    // botones
    public JButton btnSave = new JButton("Guardar");
    public JButton btnBack = new JButton("Volver");

    public RegisterView() {

        // configuración de ventana
        setTitle("Registro de Jugador");
        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // panel de fondo
        JPanel bg = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(
                        0, 0, new Color(20, 0, 60),
                        0, getHeight(), new Color(100, 0, 160)
                );

                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        bg.setLayout(new BorderLayout());
        add(bg);

        // titulo
        JLabel title = new JLabel("REGISTRO DE JUGADOR", SwingConstants.CENTER);
        title.setFont(new Font("Consolas", Font.BOLD, 28));
        title.setForeground(new Color(255, 0, 150));
        title.setBorder(BorderFactory.createEmptyBorder(30, 0, 15, 0));

        bg.add(title, BorderLayout.NORTH);

        // panel central del formulario
        JPanel formCard = new JPanel();
        formCard.setLayout(new BoxLayout(formCard, BoxLayout.Y_AXIS));
        formCard.setBackground(new Color(0, 0, 0, 60));
        formCard.setBorder(BorderFactory.createEmptyBorder(40, 140, 40, 140));

        JLabel lblName = new JLabel("Ingrese su nombre:");
        lblName.setFont(new Font("Consolas", Font.BOLD, 18));
        lblName.setForeground(new Color(0, 255, 255));
        lblName.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Estilo del campo de texto
        txtName.setFont(new Font("Consolas", Font.PLAIN, 18));
        txtName.setBackground(new Color(10, 10, 25));
        txtName.setForeground(new Color(0, 255, 255));
        txtName.setCaretColor(new Color(255, 0, 255));
        txtName.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 255), 2));
        txtName.setMaximumSize(new Dimension(300, 40));

        // Efecto glow cuando el usuario entra al campo
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                txtName.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 255).brighter(), 3));
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                txtName.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 255), 2));
            }
        });

        formCard.add(lblName);
        formCard.add(Box.createVerticalStrut(10));
        formCard.add(txtName);

        bg.add(formCard, BorderLayout.CENTER);

        // botones inferiores
        JPanel footer = new JPanel();
        footer.setBackground(new Color(0, 0, 0, 0));
        footer.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        footer.setLayout(new GridLayout(1, 2, 20, 0));

        styleNeonButton(btnSave, new Color(0, 255, 255));  // Cian
        styleNeonButton(btnBack, new Color(255, 0, 255));  // Magenta

        footer.add(btnSave);
        footer.add(btnBack);

        bg.add(footer, BorderLayout.SOUTH);
    }

    // método que estila los botones
    private void styleNeonButton(JButton btn, Color neonColor) {

        btn.setFocusPainted(false);
        btn.setFont(new Font("Consolas", Font.BOLD, 18));
        btn.setForeground(neonColor);
        btn.setBackground(new Color(0, 0, 0, 0));
        btn.setBorder(BorderFactory.createLineBorder(neonColor, 2));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btn.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                btn.setBorder(BorderFactory.createLineBorder(neonColor.brighter(), 3));
                btn.setForeground(neonColor.brighter());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                btn.setBorder(BorderFactory.createLineBorder(neonColor, 2));
                btn.setForeground(neonColor);
            }
        });
    }
}
