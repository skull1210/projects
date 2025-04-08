package Salesmanager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Users extends JPanel{
    public int ancho, altura;
    
    Users(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension tamanio= tk.getScreenSize();
        double anchos, alturas;
        anchos= tamanio.getWidth(); alturas=tamanio.getHeight();
        ancho=(int) anchos; altura=(int) alturas -30;
        StartComponents();
        
    }
    
    private void StartComponents(){
        this.setBounds(400, 0, ancho-400, altura);
        this.setBackground(Color.red);
        this.setLayout(null);
        
        StartLabels();
        StartButons();
        StartTextBox();
    }
    
    private void StartLabels(){
        JLabel Copropers = new JLabel ("Copropietarios");
        Copropers.setBounds(110, 70, 200, 30);
        Copropers.setForeground(Color.white);
        Copropers.setFont(new Font ("ALGERIAN",3,15));
        this.add(Copropers);
        
        JLabel Cousers = new JLabel ("Usuarios");
        Cousers.setBounds(330, 70, 200, 30);
        Cousers.setForeground(Color.white);
        Cousers.setFont(new Font ("ALGERIAN",3,15));
        this.add(Cousers);
        
        JLabel Activeuser = new JLabel ("Usuario activo");
        Activeuser.setBounds(550, 70, 200, 30);
        Activeuser.setForeground(Color.white);
        Activeuser.setFont(new Font ("ALGERIAN",3,15));
        this.add(Activeuser);
        
        JLabel Uknown = new JLabel ("Uknown");
        Uknown.setBounds(550, 100, 200, 30);
        Uknown.setForeground(Color.black);
        Uknown.setFont(new Font ("ALGERIAN",3,30));
        this.add(Uknown);
        
    
    }
    private void StartButons(){
        JButton Changeuser = new JButton ("Cambiar usuario activo");
        Changeuser.setBounds(110, 530, 200, 30);
        this.add(Changeuser);
        
        Changeuser.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(Users.this);
        CambiarUsuario dialog = new CambiarUsuario(parentFrame);
        dialog.setVisible(true);

        String usuario = dialog.getUsuarioActivo();
        if (usuario != null) {
            System.out.println("Usuario activo: " + usuario);
            // Aquí puedes actualizar tu JLabel de "Usuario activo", por ejemplo:
            // activeone.setText(usuario);
                }
            }
        });
        
        JButton Adduser = new JButton ("Agregar nuevo usuario");
        Adduser.setBounds(330, 530, 200, 30);
        this.add(Adduser);
        
        Adduser.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(Users.this);
        AgregarUsuario dialog = new AgregarUsuario(parentFrame);
        dialog.setVisible(true);
        
            }
        });
        
        JButton Deleteuser = new JButton ("Eliminar usuario");
        Deleteuser.setBounds(550, 530, 200, 30);
        
        Deleteuser.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(Users.this);
        EliminarUsuario dialog = new EliminarUsuario(parentFrame);
        dialog.setVisible(true);
        
            }
        });
        this.add(Deleteuser);
        
        
        
    
    }
    private void StartTextBox(){
        JTextArea Copropers = new JTextArea();
        Copropers.setBounds(110, 100, 200, 400);
        this.add(Copropers);
        
        JTextArea Cousers = new JTextArea ();
        Cousers.setBounds(330, 100, 200, 400);
        this.add(Cousers);
    }
    
}









class CambiarUsuario extends JDialog {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private String usuarioActivo = null;

    public CambiarUsuario(JFrame parent) {
        super(parent, "Cambiar Usuario", true);
        setSize(400, 250);
        setLocationRelativeTo(parent);
        setResizable(false);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(33, 33, 33)); // Gris oscuro moderno
        add(panel);

        initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        JLabel usernameLabel = new JLabel("Usuario:");
        usernameLabel.setBounds(40, 30, 100, 25);
        usernameLabel.setForeground(Color.WHITE);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 30, 200, 30);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(40, 80, 100, 25);
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 80, 200, 30);
        panel.add(passwordField);

        JLabel forgot = new JLabel("<HTML><U>¿Olvidaste tu contraseña?</U></HTML>");
        forgot.setBounds(150, 115, 200, 20);
        forgot.setForeground(Color.CYAN);
        forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(forgot);

        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.setBounds(150, 150, 200, 35);
        loginButton.setBackground(new Color(66, 165, 245)); // Azul material
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(loginButton);

        // Acción del botón
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            if (!username.isEmpty()) {
                usuarioActivo = username;
                dispose(); // Cierra el diálogo
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa un nombre de usuario.");
            }
        });
    }

    public String getUsuarioActivo() {
        return usuarioActivo;
    }
}


class AgregarUsuario extends JDialog {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField passwordConfirmField;
    private JButton loginButton;
    private JLabel errorLabel;
    private String usuarioActivo = null;

    public AgregarUsuario(JFrame parent) {
        super(parent, "Agregar Usuario", true);
        setSize(400, 350);
        setLocationRelativeTo(parent);
        setResizable(false);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(33, 33, 33)); // Gris oscuro moderno
        add(panel);

        initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        JLabel usernameLabel = new JLabel("Usuario:");
        usernameLabel.setBounds(40, 30, 100, 25);
        usernameLabel.setForeground(Color.WHITE);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 30, 200, 30);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(40, 80, 100, 25);
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 80, 200, 30);
        panel.add(passwordField);

        JLabel confirmLabel = new JLabel("Confirmar contraseña:");
        confirmLabel.setBounds(40, 130, 150, 25);
        confirmLabel.setForeground(Color.WHITE);
        panel.add(confirmLabel);

        passwordConfirmField = new JPasswordField();
        passwordConfirmField.setBounds(150, 130, 200, 30);
        panel.add(passwordConfirmField);

        JLabel tipo = new JLabel("Tipo de usuario:");
        tipo.setBounds(40, 180, 120, 25);
        tipo.setForeground(Color.WHITE);
        panel.add(tipo);

        String[] tipos = {"Usuario", "Copropietario"};
        JComboBox<String> tiposus = new JComboBox<>(tipos);
        tiposus.setBounds(150, 180, 200, 30);
        panel.add(tiposus);

        JLabel forgot = new JLabel("<HTML><U>¿Olvidaste tu contraseña?</U></HTML>");
        forgot.setBounds(150, 215, 200, 20);
        forgot.setForeground(Color.CYAN);
        forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(forgot);

        errorLabel = new JLabel("Las contraseñas deben coincidir");
        errorLabel.setBounds(150, 240, 250, 20);
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);
        panel.add(errorLabel);

        loginButton = new JButton("Agregar usuario");
        loginButton.setBounds(150, 270, 200, 35);
        loginButton.setBackground(new Color(66, 165, 245));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setFocusPainted(false);
        loginButton.setEnabled(false);
        panel.add(loginButton);

        // Verificación en tiempo real de las contraseñas
        DocumentListener passwordListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { checkPasswords(); }
            public void removeUpdate(DocumentEvent e) { checkPasswords(); }
            public void changedUpdate(DocumentEvent e) { checkPasswords(); }
        };

        passwordField.getDocument().addDocumentListener(passwordListener);
        passwordConfirmField.getDocument().addDocumentListener(passwordListener);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            if (!username.isEmpty()) {
                usuarioActivo = username;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa un nombre de usuario.");
            }
        });
    }

    private void checkPasswords() {
        String pass1 = new String(passwordField.getPassword());
        String pass2 = new String(passwordConfirmField.getPassword());

        if (pass1.equals(pass2) && !pass1.isEmpty()) {
            loginButton.setEnabled(true);
            errorLabel.setVisible(false);
        } else {
            loginButton.setEnabled(false);
            errorLabel.setVisible(true);
        }
    }

    public String getUsuarioActivo() {
        return usuarioActivo;
    }
}



class EliminarUsuario extends JDialog {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private String usuarioActivo = null;
    private JTextField UserDelete;

    public EliminarUsuario(JFrame parent) {
        super(parent, "Cambiar Usuario", true);
        setSize(400, 280);
        setLocationRelativeTo(parent);
        setResizable(false);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(33, 33, 33)); // Gris oscuro moderno
        add(panel);

        initComponents(panel);
    }

    private void initComponents(JPanel panel) {
        JLabel usernameLabel = new JLabel("Usuario:");
        usernameLabel.setBounds(40, 30, 100, 25);
        usernameLabel.setForeground(Color.WHITE);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 30, 200, 30);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(40, 80, 100, 25);
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 80, 200, 30);
        panel.add(passwordField);
        
        
        JLabel DeleteUser = new JLabel("Usuario a borrar:");
        DeleteUser.setBounds(40, 130, 100, 25);
        DeleteUser.setForeground(Color.WHITE);
        panel.add(DeleteUser);

        UserDelete = new JTextField();
        UserDelete.setBounds(150, 130, 200, 30);
        panel.add(UserDelete);

        JLabel forgot = new JLabel("<HTML><U>¿Olvidaste tu contraseña?</U></HTML>");
        forgot.setBounds(150, 155, 200, 20);
        forgot.setForeground(Color.CYAN);
        forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(forgot);

        JButton loginButton = new JButton("Borrar Usuario");
        loginButton.setBounds(150, 185, 200, 35);
        loginButton.setBackground(new Color(66, 165, 245)); // Azul material
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(loginButton);

        // Acción del botón
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            if (!username.isEmpty()) {
                usuarioActivo = username;
                dispose(); // Cierra el diálogo
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa un nombre de usuario.");
            }
        });
        
        loginButton.addActionListener(e -> {
            String username = UserDelete.getText();
            if (!username.isEmpty()) {
                dispose(); // Cierra el diálogo
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa un nombre de usuario.");
            }
        });
        
        loginButton.addActionListener(e -> {
        int confirm = JOptionPane.showConfirmDialog(
        null,
        "¿Estás seguro que quieres eliminar este usuario?\nEsta acción no se puede deshacer.",
        "Confirmar eliminación",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE
    );

    if (confirm == JOptionPane.YES_OPTION) {
        // Aquí va el código para eliminar el usuario
        System.out.println("Usuario eliminado");
        } else {
        System.out.println("Cancelado");
        }
    });
    }

}
