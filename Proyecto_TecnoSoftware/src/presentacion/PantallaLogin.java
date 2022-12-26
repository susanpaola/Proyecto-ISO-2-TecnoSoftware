package presentacion;

import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Label;
import javax.swing.DropMode;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JEditorPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import persistencia.GestorBD;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.UIManager;
import java.awt.Canvas;
import java.awt.Toolkit;

public class PantallaLogin  {

	public PantallaLogin() {
	}
	private static JTextField UsuarioText;
	private static JTextField user;
	

	public void login() {
		// TODO - implement PantallaLogin.login
		throw new UnsupportedOperationException();
	}

	public void logout() {
		// TODO - implement PantallaLogin.logout
		throw new UnsupportedOperationException();
	}

	private static void placeComponents(JPanel panel) {
	
	}

		/**
		 * @wbp.parser.entryPoint
		 */
		public static void mostrar() {
			JFrame frmUclm = new JFrame("Demo application");
			frmUclm.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\IconUCLM.png"));
			frmUclm.setTitle("UCLM");
			frmUclm.setSize(655, 467);
			frmUclm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			frmUclm.getContentPane().add(panel);
			placeComponents(panel);
			
			JButton loginButton = new JButton("Iniciar secion");
			loginButton.setBounds(406, 316, 168, 48);
			loginButton.hide();
			panel.setLayout(null);
			loginButton.setForeground(new Color(0, 0, 0));
			loginButton.setBackground(SystemColor.textHighlight);
			loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			loginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			panel.add(loginButton);
			
			JPasswordField ContrasenaText = new JPasswordField(20);
			ContrasenaText.setBounds(79, 226, 434, 7);
			ContrasenaText.setToolTipText("Introduzca su contraseña");
			ContrasenaText.setFont(new Font("Tahoma", Font.PLAIN, 15));
			ContrasenaText.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
			
			ContrasenaText.setActionCommand("");
			ContrasenaText.hide();
			panel.add(ContrasenaText);
			
			UsuarioText = new JTextField();
			UsuarioText.setBounds(79, 192, 434, 42);
			UsuarioText.setFont(new Font("Tahoma", Font.PLAIN, 15));
			UsuarioText.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(180, 180, 180)));
			UsuarioText.setName("");
			UsuarioText.setToolTipText("Introduzca su correo electronico");
			panel.add(UsuarioText);
			UsuarioText.setColumns(10);	
			
		
			JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
			lblNewJgoodiesLabel.setBounds(228, 144, 246, 36);
			lblNewJgoodiesLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\ImagenUCLM.png"));
			panel.add(lblNewJgoodiesLabel);
			
			JButton btnRecuperar = new JButton("He olvidado mi contraseña");
			btnRecuperar.setBounds(80, 257, 200, 21);
			btnRecuperar.hide();
			btnRecuperar.setHorizontalAlignment(SwingConstants.LEFT);
			btnRecuperar.setForeground(SystemColor.textHighlight);
			btnRecuperar.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnRecuperar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnRecuperar.setBackground(Color.WHITE);
			btnRecuperar.setBorder(null);
			panel.add(btnRecuperar);

			frmUclm.setVisible(true);
			JButton btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setBounds(406, 316, 168, 48);
			btnSiguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnSiguiente.setForeground(Color.WHITE);
			btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnSiguiente.setBackground(SystemColor.textHighlight);
			panel.add(btnSiguiente);
			
			JLabel userLabel = new JLabel("Iniciar secion");
			userLabel.setBounds(25, 11, 148, 25);
			userLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			userLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			panel.add(userLabel);

			JLabel passwordLabel = new JLabel("Contraseña");
			passwordLabel.setBounds(79, 144, 215, 42);
			passwordLabel.hide();
			passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			panel.add(passwordLabel);
			
			user = new JTextField();
			user.setBounds(79, 109, 252, 19);
			user.setFont(new Font("Tahoma", Font.BOLD, 10));
			user.setBackground(Color.WHITE);
			user.setBorder(null);
			user.setEditable(false);
			user.hide();
			panel.add(user);
			user.setColumns(10);
			
			JButton btnNoAcceder = new JButton("\u00BFNo puede acceder a su cuenta?");
			btnNoAcceder.setBounds(79, 258, 216, 21);
			btnNoAcceder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNoAcceder.setHorizontalAlignment(SwingConstants.LEFT);
			btnNoAcceder.setForeground(SystemColor.textHighlight);
			btnNoAcceder.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNoAcceder.setBorder(null);
			btnNoAcceder.setBackground(Color.WHITE);
			panel.add(btnNoAcceder);
			
			JButton btnNewButton = new JButton("Volver");
			btnNewButton.setBounds(44, 316, 114, 49);
			btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton.setBackground(SystemColor.textHighlight);
			panel.add(btnNewButton);
			
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblUsuario.setBounds(79, 71, 181, 42);
			panel.add(lblUsuario);
			btnNewButton.hide();
			btnNewButton.addActionListener((ActionListener) new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						presentacion.PantallaLogin p = new presentacion.PantallaLogin();
						p.mostrar();
						
						frmUclm.dispose();
						
					}
			});
			
			

			

			btnSiguiente.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usu=UsuarioText.getText();
			if (usu.length()==0) {
				JOptionPane.showMessageDialog(null, "Debe introducir su usuario.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				btnRecuperar.show();
				btnSiguiente.hide();
				UsuarioText.hide();
				ContrasenaText.show();
				loginButton.show();
				userLabel.hide();
				passwordLabel.show();
				btnNoAcceder.hide();
				btnNewButton.show();
				user.show();
				user.setText(" Usuario: "+ UsuarioText.getText());	
				
				loginButton.addActionListener((ActionListener) new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String pass =ContrasenaText.getText();
						if (pass.length()==0) {
							JOptionPane.showMessageDialog(null, "Debe introducir su contraseña.", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
						else {
									 try {
										 GestorBD.conectar();
										 String user= "SELECT usuario FROM login WHERE usuario = '"+usu+"'";
										 Vector<Object> usuario,contra;
										usuario = GestorBD.getAgente().select(user);
										
										 String passw= "SELECT contrase�a FROM login WHERE contrase�a = '"+pass+"'";
										 contra = GestorBD.getAgente().select(passw);
										 
										 if (usuario.isEmpty()==false && contra.isEmpty()==false) {
											 JOptionPane.showMessageDialog(null, "Bienvenido.", "UCLM", JOptionPane.INFORMATION_MESSAGE);
											 presentacion.PantallaDireccionCursos pa = new presentacion.PantallaDireccionCursos();
											 pa.show();
											 frmUclm.dispose();
											 
	
										 }
										 else {
											 JOptionPane.showMessageDialog(null, "El usuario o la contrase�a son incorrectos. Por favor, introduzca correctamente los datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
											 frmUclm.dispose();
											 PantallaLogin.mostrar();
											
											
										 }
										 
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
						}
					}
					});
		
				}
				}
			});
		
		}
}
		

	