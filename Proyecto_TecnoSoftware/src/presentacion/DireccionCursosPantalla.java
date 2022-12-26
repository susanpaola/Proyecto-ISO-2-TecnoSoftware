package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.JDatePicker;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.List;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DireccionCursosPantalla extends JFrame {
	
	//private JDatePicker FechaInicio;
	//private JDatePicker FechaFin;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DireccionCursosPantalla frame = new DireccionCursosPantalla();
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
	public DireccionCursosPantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 477);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNuevo = new JButton("Nuevo Curso");
		btnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNuevo.setBounds(353, 11, 115, 40);
		contentPane.add(btnNuevo);
		
		JLabel lblcursoid = new JLabel("ID Curso");
		lblcursoid.setBounds(21, 78, 49, 14);
		contentPane.add(lblcursoid);
		
		JLabel lblNombreCurso = new JLabel("Nombre");
		lblNombreCurso.setBounds(21, 117, 71, 14);
		contentPane.add(lblNombreCurso);
		
		JLabel lblTipo = new JLabel("Tipo Curso");
		lblTipo.setBounds(21, 152, 53, 14);
		contentPane.add(lblTipo);
		
		JLabel lblCreditos = new JLabel("ECTS");
		lblCreditos.setBounds(258, 78, 62, 14);
		contentPane.add(lblCreditos);
		
		JLabel lblTasa = new JLabel("Tasa");
		lblTasa.setBounds(258, 117, 29, 14);
		contentPane.add(lblTasa);
		
		JLabel lblEdicion = new JLabel("Edicion");
		lblEdicion.setBounds(258, 152, 68, 14);
		contentPane.add(lblEdicion);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(472, 78, 68, 14);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(472, 117, 62, 14);
		contentPane.add(lblFechaFin);
		
		JLabel lblEstado = new JLabel("Estado Curso");
		lblEstado.setBounds(471, 152, 68, 14);
		contentPane.add(lblEstado);
		
		TextField textId = new TextField();
		textId.setBounds(99, 78, 137, 21);
		contentPane.add(textId);
		
		TextField textNombre = new TextField();
		textNombre.setBounds(98, 117, 138, 21);
		contentPane.add(textNombre);
		
		TextField textTipo = new TextField();
		textTipo.setBounds(95, 152, 141, 21);
		contentPane.add(textTipo);
		
		TextField textcreditos = new TextField();
		textcreditos.setBounds(326, 78, 127, 21);
		contentPane.add(textcreditos);
		
		TextField textTasa = new TextField();
		textTasa.setBounds(329, 117, 127, 21);
		contentPane.add(textTasa);
		
		TextField textEdicion = new TextField();
		textEdicion.setBounds(329, 152, 127, 21);
		contentPane.add(textEdicion);
		
		TextField textEstado = new TextField();
		textEstado.setBounds(559, 145, 144, 21);
		contentPane.add(textEstado);
		
		TextField textFechaIni = new TextField();
		textFechaIni.setBounds(559, 78, 144, 21);
		contentPane.add(textFechaIni);
		
		TextField textFechaFin = new TextField();
		textFechaFin.setBounds(559, 110, 144, 21);
		contentPane.add(textFechaFin);
		
		JButton btnEditar_1 = new JButton("Editar Curso");
		btnEditar_1.setBounds(206, 11, 115, 40);
		contentPane.add(btnEditar_1);
		
		List list = new List();
		list.setBounds(102, 232, 294, 198);
		contentPane.add(list);
		
		Label labellistcursos = new Label("Lista Cursos");
		labellistcursos.setFont(new Font("Dialog", Font.BOLD, 10));
		labellistcursos.setBounds(107, 191, 99, 29);
		contentPane.add(labellistcursos);
		
		JButton btnLimpieza = new JButton("Limpieza Datos");
		btnLimpieza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btnLimpieza) {
					textId.setEditable(true);
					textId.setText("");
					textNombre.setText("");
					textTipo.setText("");
					textcreditos.setText("");
					textTasa.setText("");
					textEdicion.setText("");
					textEstado.setText("");
					textFechaIni.setText("");
					textFechaFin.setText("");

				}
			}
		});
		btnLimpieza.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpieza.setBounds(448, 290, 138, 58);
		contentPane.add(btnLimpieza);
		
		
	}
}
