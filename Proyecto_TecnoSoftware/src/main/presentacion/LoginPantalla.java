package main.presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class LoginPantalla extends JFrame {

	protected static final String PasswordField = null;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPantalla frame = new LoginPantalla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 387);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblusuario = new JLabel("Usuario:");
		lblusuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblusuario.setBounds(51, 111, 121, 25);
		contentPane.add(lblusuario);
		
		JLabel lblpassword = new JLabel("Contraseña:");
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblpassword.setBackground(new Color(240, 240, 240));
		lblpassword.setBounds(51, 165, 121, 33);
		contentPane.add(lblpassword);
		
		TextField usuarioField = new TextField();
		usuarioField.setFont(new Font("Dialog", Font.PLAIN, 17));
		usuarioField.setBounds(201, 103, 226, 33);
		contentPane.add(usuarioField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		passwordField.setBounds(201, 165, 226, 30);
		contentPane.add(passwordField);
		
		JButton btnAcceso = new JButton("Entrar");
		btnAcceso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String usuario = "tecnosoftware";
				String contrasena = "iso2";
				
				String password = new String(passwordField.getPassword());
				
				if(usuarioField.getText().equals(usuario) && password.equals(contrasena)) {
					
					//llamo al fomrulario al que despues va ha acceder
					AccesoMenuPantalla access = new AccesoMenuPantalla();
					access.setVisible(true);
					dispose();
					
				}else {
					JOptionPane.showMessageDialog(null, "usuario o contraseña incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAcceso.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAcceso.setBounds(366, 226, 104, 40);
		contentPane.add(btnAcceso);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setForeground(new Color(0, 0, 0));
		btnSalir.setBackground(new Color(178, 34, 34));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalir.setBounds(430, 11, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnLogo = new JButton("");
		btnLogo.setIcon(new ImageIcon("C:\\Users\\susan\\OneDrive\\Documentos\\git\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\ImagenUCLM.png"));
		btnLogo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnLogo.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogo.setBorderPainted(false);
		btnLogo.setAlignmentX(0.5f);
		btnLogo.setBounds(-44, 0, 131, 60);
		contentPane.add(btnLogo);
	}
}
