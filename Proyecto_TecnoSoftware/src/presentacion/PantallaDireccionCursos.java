package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import persistencia.GestorBD;

import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;
import javax.swing.JTextField;

public class PantallaDireccionCursos extends JFrame {

		public void altaCurso() {
			// TODO - implement PantallaDireccionCursos.altaCurso
			throw new UnsupportedOperationException();
		}

		public void edicionCurso() {
			// TODO - implement PantallaDireccionCursos.edicionCurso
			throw new UnsupportedOperationException();
		}


	private JPanel contentPane;
	private JTextField NombreUsu;
	private JTextField TipoUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDireccionCursos frame = new PantallaDireccionCursos();
					
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
	public PantallaDireccionCursos() {
		setTitle("UCLM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Im\u00E1genes\\IconUCLM.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMostrarPendientes = new JButton("Propuestas pendientes");
		btnMostrarPendientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMostrarPendientes.setForeground(Color.WHITE);
		btnMostrarPendientes.setBackground(SystemColor.textHighlight);
		btnMostrarPendientes.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMostrarPendientes.setBounds(103, 330, 228, 99);
		contentPane.add(btnMostrarPendientes);
		btnMostrarPendientes.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					//presentacion.PantallaLogin p = new presentacion.PantallaLogin();
					//p.mostrar();
					setVisible(false);
				}
		});
		
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Im\u00E1genes\\ImagenUCLM.png"));
		lblNewJgoodiesLabel.setBounds(20, 10, 310, 99);
		contentPane.add(lblNewJgoodiesLabel);
		
		JButton btnRealizarPropuesta = new JButton("Realizar propuesta");
		btnRealizarPropuesta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRealizarPropuesta.setForeground(Color.WHITE);
		btnRealizarPropuesta.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRealizarPropuesta.setBackground(SystemColor.textHighlight);
		btnRealizarPropuesta.setBounds(461, 330, 228, 99);
		contentPane.add(btnRealizarPropuesta);
		btnRealizarPropuesta.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					//presentacion.PantallaLogin p = new presentacion.PantallaLogin();
					//p.mostrar();
					setVisible(false);
				}
		});
		
		
		NombreUsu = new JTextField();
		NombreUsu.setFont(new Font("Tahoma", Font.BOLD, 15));
		NombreUsu.setText("NOMBRE");
		NombreUsu.setEditable(false);
		NombreUsu.setColumns(10);
		NombreUsu.setBorder(null);
		NombreUsu.setBackground(Color.WHITE);
		NombreUsu.setBounds(461, 128, 252, 19);
		contentPane.add(NombreUsu);
		
		TipoUsuario = new JTextField();
		TipoUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		TipoUsuario.setText("TIPO USUARIO\r\n");
		TipoUsuario.setEditable(false);
		TipoUsuario.setColumns(10);
		TipoUsuario.setBorder(null);
		TipoUsuario.setBackground(Color.WHITE);
		TipoUsuario.setBounds(461, 173, 252, 19);
		contentPane.add(TipoUsuario);
	}
}
