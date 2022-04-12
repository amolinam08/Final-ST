package uniandes.isis2304.hotelandes.interfazApp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login_Register extends JFrame implements ActionListener{    
    private static final long serialVersionUID = 1L;
    JTextField txtUsuario;
    JTextField txtContrasena;
    public Login_Register()
    {
		try {
            setLayout(new BorderLayout());
            setSize(400, 400);
            JPanel panel = new JPanel();
            JPanel panel2 = new JPanel();
            String filePath = new File("").getAbsolutePath();
            System.out.println(filePath);
            BufferedImage myPicture = ImageIO.read(new File("./src/main/resources/config/hotel.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            panel2.add(picLabel);
            add(panel2, BorderLayout.NORTH);
            panel.setLayout(new FlowLayout());
            JButton btnLogin = new JButton("Login");
            btnLogin.setActionCommand("Login");
            btnLogin.addActionListener(this);
            panel.add(new JLabel("Usuario:"));
            txtUsuario = new JTextField(10);
            panel.add(txtUsuario);
            panel.add(new JLabel("Contraseña:"));
            txtContrasena = new JPasswordField(10);
            panel.add(txtContrasena);
            panel.add(btnLogin);
            add(panel, BorderLayout.CENTER);
            setTitle("Inicio de sesión");
            setSize(1000, 700);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    
	
    public static void main(String []args) { 
       // Programa principal
       // Ventana de inicio de sesión
       new Login_Register();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            User user = new User(txtUsuario.getText(), txtContrasena.getText());
            
            try {
                Login login = new Login(user);
                if (login.getRol().equals("GERENTE")) {
                    JOptionPane.showMessageDialog(null, "Bienvenido gerente");
                    new vistaGerente();
                } else if (login.getRol().equals("EMPEADO")) {
                    JOptionPane.showMessageDialog(null, "Bienvenido hotelero");
                    new vistaEmpleado();
                } else if (login.getRol().equals("CLIENTE")) {
                    JOptionPane.showMessageDialog(null, "Bienvenido cliente");
                    new vistaCliente();
                } else if (login.getRol().equals("RECEPCIONISTA")) {
                    JOptionPane.showMessageDialog(null, "Bienvenido recepcionista");
                    new vistaRecepcionista();
                } else if (login.getRol().equals("ADMINISTRADOR_DATOS")) {
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "Bienvenido administrador de datos");
                    new vistaAdminDatos();
                   
                }
                
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);                
            }
        }
    }
}
