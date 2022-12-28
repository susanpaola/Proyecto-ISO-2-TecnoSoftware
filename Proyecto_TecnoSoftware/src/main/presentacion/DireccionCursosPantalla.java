package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

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
import javax.swing.JComboBox;

public class DireccionCursosPantalla extends JFrame {
	
	//private JDatePicker FechaInicio;
	//private JDatePicker FechaFin;
	
	private JPanel contentPane;
	
	DefaultTableModel modelo;

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
		//initComponents();
		modelo = new DefaultTableModel();
		modelo.addColumn("Id Cuurso");
		modelo.addColumn("Nombre");
		modelo.addColumn("Tipo Curso");
		modelo.addColumn("ETC");
		modelo.addColumn("Tasa");
		modelo.addColumn("Edicion");
		modelo.addColumn("Estado");
		modelo.addColumn("Fecha Inicio");
		modelo.addColumn("Fecha Fin");
		
		modelo.addColumn("Centro");
		modelo.addColumn("Director");
		modelo.addColumn("Secretario");
		
		
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
				RealizarPropuestaPantalla nuevocurso = new RealizarPropuestaPantalla();
				nuevocurso.setVisible(true);
				dispose();
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
		textTipo.setBounds(99, 152, 137, 21);
		contentPane.add(textTipo);
		
		TextField textcreditos = new TextField();
		textcreditos.setBounds(326, 78, 127, 21);
		contentPane.add(textcreditos);
		
		TextField textTasa = new TextField();
		textTasa.setBounds(326, 117, 127, 21);
		contentPane.add(textTasa);
		
		TextField textEdicion = new TextField();
		textEdicion.setBounds(326, 152, 127, 21);
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
		
		JButton btnEditar = new JButton("Editar Curso");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 modelo.addTableModelListener((TableModelListener) textId.getCursor());
				 modelo.addTableModelListener((TableModelListener) textNombre.getCursor());
				 modelo.addTableModelListener((TableModelListener) textcreditos.getCursor());
				 modelo.addTableModelListener((TableModelListener) textTipo.getCursor());
				 modelo.addTableModelListener((TableModelListener) textTasa.getCursor());
				 modelo.addTableModelListener((TableModelListener) textEdicion.getCursor());
				 modelo.addTableModelListener((TableModelListener) textFechaIni.getCursor());
				 modelo.addTableModelListener((TableModelListener) textFechaFin.getCursor());
			}
		});
		btnEditar.setBounds(206, 11, 115, 40);
		contentPane.add(btnEditar);
		
		List list = new List();
		list.setBounds(148, 232, 294, 198);
		contentPane.add(list);
		
		Label labellistcursos = new Label("Lista Cursos");
		labellistcursos.setFont(new Font("Dialog", Font.BOLD, 13));
		labellistcursos.setBounds(20, 289, 122, 48);
		contentPane.add(labellistcursos);
		
		JButton btnLimpieza = new JButton("Borrar Datos");
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
					btnEditar.setEnabled(false);
					btnEditar.setEnabled(false);
					

				}
			}
		});
		
		btnLimpieza.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpieza.setBounds(506, 289, 138, 58);
		contentPane.add(btnLimpieza);
		
		JLabel lblCentro = new JLabel("Centro");
		lblCentro.setBounds(21, 192, 49, 14);
		contentPane.add(lblCentro);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setBounds(258, 192, 49, 14);
		contentPane.add(lblDirector);
		
		JComboBox comboBoxDirector = new JComboBox();
		comboBoxDirector.setBounds(326, 188, 127, 22);
		contentPane.add(comboBoxDirector);
		
		JComboBox comboBoxCentro = new JComboBox();
		comboBoxCentro.setBounds(99, 188, 137, 22);
		contentPane.add(comboBoxCentro);
		
		JLabel lblSecretario = new JLabel("Secretario");
		lblSecretario.setBounds(472, 192, 77, 14);
		contentPane.add(lblSecretario);
		
		JComboBox comboBoxSecretario = new JComboBox();
		comboBoxSecretario.setBounds(559, 188, 144, 22);
		contentPane.add(comboBoxSecretario);
		
		
	}
}
