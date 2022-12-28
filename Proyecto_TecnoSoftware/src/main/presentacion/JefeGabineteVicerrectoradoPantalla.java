package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings({ "serial", "unused" })
public class JefeGabineteVicerrectoradoPantalla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	@SuppressWarnings("unused")
	private Date fechaInicio;
	@SuppressWarnings("unused")
	private Date fechaFin;
	
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JefeGabineteVicerrectoradoPantalla frame = new JefeGabineteVicerrectoradoPantalla();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JefeGabineteVicerrectoradoPantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 611);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoCurso = new JLabel("Tipo Curso");
		lblTipoCurso.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoCurso.setBounds(25, 41, 78, 25);
		contentPane.add(lblTipoCurso);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Master", "Experto", "Especialista", "Formacion avanzada", "Formacion continua", "Microcredenciales", "Corta duracion", "Cursos de verano", "Formacion de mayores"}));
		comboBox.setBounds(25, 66, 308, 33);
		contentPane.add(comboBox);
		
		JLabel lblEstadoCurso = new JLabel("Estado Curso");
		lblEstadoCurso.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstadoCurso.setBounds(386, 44, 105, 19);
		contentPane.add(lblEstadoCurso);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Propuesto", "Validado", "Propuesta rechazada", "En matriculacion", "En imparticion", "Terminado"}));
		comboBox_1.setBounds(386, 66, 308, 33);
		contentPane.add(comboBox_1);
		
		//Fecha Inicio
		Label labelFechaIni = new Label("Fecha Inicio");
		labelFechaIni.setFont(new Font("Dialog", Font.BOLD, 10));
		labelFechaIni.setBounds(25, 105, 105, 25);
		contentPane.add(labelFechaIni);
		
		UtilDateModel fInicio1 = new UtilDateModel();
		Properties pInicio1 = new Properties();
		pInicio1.put("text.today", "Hoy");
		pInicio1.put("text.month", "Mes");
		pInicio1.put("text.year", "Año");
		
		JPanel PanelFechaInicio = new JPanel();
		PanelFechaInicio.setBounds(25,136,212,33);
		contentPane.add(PanelFechaInicio);
		JDatePanelImpl panelfechainicio = new JDatePanelImpl(fInicio1, pInicio1);
		JDatePickerImpl pickerFechaInicio = new JDatePickerImpl(panelfechainicio, null );
		PanelFechaInicio.add(pickerFechaInicio);
		
		
		//Fecha Fin
		Label labelFechaFin = new Label("Fecha Fin");
		labelFechaFin.setFont(new Font("Dialog", Font.BOLD, 10));
		labelFechaFin.setBounds(386, 107, 105, 25);
		contentPane.add(labelFechaFin);
		
		UtilDateModel fFin1 = new UtilDateModel();
		Properties pFin1 = new Properties();
		pFin1.put("text.today", "Hoy");
		pFin1.put("text.month", "Mes");
		pFin1.put("text.year", "Año");
		
		JPanel PanelFechaFin = new JPanel();
		PanelFechaFin.setBounds(391,136,212,33);
		contentPane.add(PanelFechaFin);
		//JDatePickerImpl pickerFechaFin1 = new JDatePickerImpl(panelfechafin, null);
		JDatePanelImpl panelfechafin = new JDatePanelImpl(fFin1, pFin1); 
		JDatePickerImpl pickerFechaFin = new JDatePickerImpl(panelfechafin, null);
		PanelFechaFin.add(pickerFechaFin);
		
		JButton btnIngresos = new JButton("Consultar");
		btnIngresos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIngresos.setBounds(25, 192, 165, 46);
		contentPane.add(btnIngresos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 249, 789, 272);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel (new Object[][] {{null, null, null}, {null, null, null}, {null, null, null},
			{null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}}, 
				new String [] {"Id Curso", "Nombre Curso", "Ingresos", "Edicion", "ECT"}));
		scrollPane.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Id Curso");
		model.addColumn("Nombre Curso");
		model.addColumn("Ingresos");
		model.addColumn("Edicion");
		model.addColumn("ECT");
	}
}
