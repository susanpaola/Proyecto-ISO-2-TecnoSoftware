package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.border.CompoundBorder;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AccesoMenuPantalla extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccesoMenuPantalla frame = new AccesoMenuPantalla();
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
	public AccesoMenuPantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 307);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEstudiante = new JButton("MATRICULA");
		btnEstudiante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MatriculacionPantalla matricula = new MatriculacionPantalla();
				matricula.setVisible(true);
				dispose();
			}
		});
		btnEstudiante.setIcon(null);
		btnEstudiante.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEstudiante.setBounds(79, 157, 177, 60);
		contentPane.add(btnEstudiante);
		
		JButton btnVicerrector = new JButton("VICERRECTORADO");
		btnVicerrector.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmpleadosVicerrectoradoPantalla vicerrectorado = new EmpleadosVicerrectoradoPantalla();
				vicerrectorado.setVisible(true);
				dispose();
			}
		});
		
		btnVicerrector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVicerrector.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVicerrector.setBounds(79, 82, 177, 63);
		contentPane.add(btnVicerrector);
		
		JButton btnLogo = new JButton("");
		btnLogo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnLogo.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogo.setBorderPainted(false);
		btnLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLogo.setIcon(new ImageIcon("C:\\Users\\susan\\OneDrive\\Documentos\\git\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\ImagenUCLM.png"));
		btnLogo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogo.setBounds(-43, 0, 131, 60);
		contentPane.add(btnLogo);
		
		JButton btnDireccion = new JButton("DIRECCION CURSOS");
		btnDireccion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DireccionCursosPantalla dirCursos = new DireccionCursosPantalla();
				dirCursos.setVisible(true);
				dispose();
			}
		});
		btnDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDireccion.setBounds(278, 82, 177, 63);
		contentPane.add(btnDireccion);
		
		JLabel lblAcceso = new JLabel("Acceso a:");
		lblAcceso.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAcceso.setBounds(98, 31, 147, 29);
		contentPane.add(lblAcceso);
		
		JButton btnJefeVice = new JButton("JEFE VICERRECTORADO");
		btnJefeVice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JefeGabineteVicerrectoradoPantalla jefeVice = new JefeGabineteVicerrectoradoPantalla();
				jefeVice.setVisible(true);
				dispose();
			}
		});
		btnJefeVice.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnJefeVice.setBounds(278, 156, 177, 63);
		contentPane.add(btnJefeVice);
	}

}
