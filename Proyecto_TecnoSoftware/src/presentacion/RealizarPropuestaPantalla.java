package presentacion;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import presentacion.PantallaElegirFechas.DateLabelFormatter;

import javax.swing.JLabel;
import java.awt.TextField;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;

public class RealizarPropuestaPantalla extends JFrame {

	private JPanel contentPane;
	private JTextField textSecretario;
	private JTextField textCentro;
	private JTextField textDirector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarPropuestaPantalla frame = new RealizarPropuestaPantalla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public class DateLabelFormatter extends AbstractFormatter {

	    private String datePattern = "yyyy-MM-dd";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws java.text.ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	}

	/**
	 * Create the frame.
	 */
	public RealizarPropuestaPantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 475);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreCurso = new JLabel("Nombre");
		lblNombreCurso.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreCurso.setBounds(34, 140, 55, 24);
		contentPane.add(lblNombreCurso);
		
		JLabel lblTipo = new JLabel("Tipo Curso");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(34, 197, 82, 24);
		contentPane.add(lblTipo);
		
		JLabel lblCreditos = new JLabel("ECTS");
		lblCreditos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCreditos.setBounds(445, 261, 37, 21);
		contentPane.add(lblCreditos);
		
		JLabel lblTasa = new JLabel("Tasa");
		lblTasa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTasa.setBounds(445, 218, 37, 24);
		contentPane.add(lblTasa);
		
		JLabel lblEdicion = new JLabel("Edicion");
		lblEdicion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEdicion.setBounds(225, 87, 59, 20);
		contentPane.add(lblEdicion);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaInicio.setBounds(225, 141, 86, 20);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaFin.setBounds(225, 200, 78, 20);
		contentPane.add(lblFechaFin);
		
		JLabel lblEstado = new JLabel("Estado Curso");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(34, 255, 86, 17);
		contentPane.add(lblEstado);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
		
		JDatePickerImpl datePickerIni = new JDatePickerImpl(datePanel,new DateLabelFormatter());
		datePickerIni.getJFormattedTextField().setEditable(true);
		datePickerIni.setFont(new Font("Tahoma", Font.BOLD, 15));
		datePickerIni.getJFormattedTextField().setFont(new Font("Tahoma", Font.BOLD, 15));
		datePickerIni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		datePickerIni.getJFormattedTextField().setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 120, 215)));
		datePickerIni.setSize(177, 24);
		datePickerIni.setLocation(225, 172);
		datePickerIni.setBackground(new Color(255, 255, 255));
		datePickerIni.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		contentPane.add(datePickerIni);
		
		JDatePickerImpl datePickerFin = new JDatePickerImpl(datePanel,new DateLabelFormatter());
		datePickerFin.getJFormattedTextField().setEditable(true);
		datePickerFin.setSize(177, 24);
		datePickerFin.setLocation(225, 231);
		datePickerFin.setFont(new Font("Tahoma", Font.BOLD, 15));
		datePickerFin.getJFormattedTextField().setFont(new Font("Tahoma", Font.BOLD, 15));
		datePickerFin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		datePickerFin.getJFormattedTextField().setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 120, 215)));
		datePickerFin.setBackground(new Color(255, 255, 255));
		datePickerFin.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		contentPane.add(datePickerFin);
		
		TextField textId = new TextField();
		textId.setBounds(34, 113, 82, 21);
		contentPane.add(textId);
		
		TextField textNombre = new TextField();
		textNombre.setBounds(34, 170, 165, 21);
		contentPane.add(textNombre);
		
		TextField textcreditos = new TextField();
		textcreditos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(Character.isLetter(validar)){
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Introduzca solo valores numericos", "ERROR", JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
		textcreditos.setBounds(498, 261, 122, 21);
		contentPane.add(textcreditos);
		
		TextField textTasa = new TextField();
		textTasa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar1 = e.getKeyChar();
				if(Character.isLetter(validar1)){
					getToolkit().beep();
					e.consume();
					
					JOptionPane.showMessageDialog(null, "Introduzca solo valores numericos", "ERROR", JOptionPane.ERROR_MESSAGE);					
				}
			}
		});
		textTasa.setBounds(500, 218, 122, 21);
		contentPane.add(textTasa);
		
		TextField textEdicion = new TextField();
		textEdicion.setBounds(225, 113, 177, 21);
		contentPane.add(textEdicion);
		
		TextField textEstado = new TextField();
		textEstado.setBounds(34, 278, 165, 21);
		contentPane.add(textEstado);
		
		JLabel lblcursoid = new JLabel("ID Curso");
		lblcursoid.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcursoid.setBounds(36, 88, 65, 24);
		contentPane.add(lblcursoid);
		
		JLabel lblCentro = new JLabel("Centro");
		lblCentro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCentro.setBounds(427, 90, 55, 24);
		contentPane.add(lblCentro);
		
		JLabel lblDirector = new JLabel("Director");
		lblDirector.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDirector.setBounds(427, 132, 57, 24);
		contentPane.add(lblDirector);
		
		JLabel lblSecretario = new JLabel("Secretario");
		lblSecretario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSecretario.setBounds(427, 176, 82, 18);
		contentPane.add(lblSecretario);
		
		textSecretario = new JTextField();
		textSecretario.setBounds(500, 171, 168, 25);
		contentPane.add(textSecretario);
		textSecretario.setColumns(10);
		
		textCentro = new JTextField();
		textCentro.setColumns(10);
		textCentro.setBounds(500, 90, 168, 24);
		contentPane.add(textCentro);
		
		textDirector = new JTextField();
		textDirector.setColumns(10);
		textDirector.setBounds(500, 133, 168, 24);
		contentPane.add(textDirector);
		
		JLabel lblTitulo = new JLabel("Realizar una propuesta de Curso");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(196, 21, 314, 61);
		contentPane.add(lblTitulo);
		
		JButton btnRealizarPropuesta = new JButton("Realizar Propuesta");
		btnRealizarPropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRealizarPropuesta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textId.getText().isEmpty() || textNombre.getText().isEmpty() || 
						textTasa.getText().isEmpty() || textcreditos.getText().isEmpty() || textEdicion.getText().isEmpty()
						|| textEstado.getText().isEmpty() || textCentro.getText().isEmpty() || textDirector.getText().isEmpty()
						|| textSecretario.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea realizar propuesta Curso?", "ATENCION", JOptionPane.OK_CANCEL_OPTION);
					if (respuesta == JOptionPane.OK_OPTION) {
						JOptionPane.showMessageDialog(null, "Su propuesta ha sido enviada de manera correcta.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
						presentacion.DireccionCursosPantalla p = new presentacion.DireccionCursosPantalla();
						p.setVisible(true);
						setVisible(false);
					}
				}
			}
		});
		btnRealizarPropuesta.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRealizarPropuesta.setBounds(266, 356, 168, 48);
		contentPane.add(btnRealizarPropuesta);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Master", "Experto", "Especialista", "Formacion avanzada", "Formacion continua", "Microcredenciales", "Corta duracion", "Cursos de verano", "Formacion de mayores"}));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
		comboBox.setBounds(34, 223, 165, 22);
		contentPane.add(comboBox);
	}
}
