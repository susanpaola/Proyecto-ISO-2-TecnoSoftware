package presentacion;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.google.protobuf.TextFormat.ParseException;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import negocio.entities.CursoPropio;

import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class PantallaElegirFechas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaElegirFechas frame = new PantallaElegirFechas();
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
	public PantallaElegirFechas() {


		setTitle("UCLM\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\IconUCLM.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 618);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\ImagenUCLM.png"));
		lblNewJgoodiesLabel.setBounds(20, 10, 310, 99);
		contentPane.add(lblNewJgoodiesLabel);
		
		
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
		datePickerIni.setSize(200, 200);
		datePickerIni.setLocation(245, 195);
		datePickerIni.setBackground(new Color(255, 255, 255));
		datePickerIni.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		contentPane.add(datePickerIni);
		
		JDatePickerImpl datePickerFin = new JDatePickerImpl(datePanel,new DateLabelFormatter());
		datePickerFin.setBorder(null);
		datePickerFin.setSize(200, 200);
		datePickerFin.setLocation(245, 195);
		datePickerFin.hide();
		datePickerFin.setFont(new Font("Tahoma", Font.BOLD, 15));
		datePickerFin.getJFormattedTextField().setFont(new Font("Tahoma", Font.BOLD, 15));
		datePickerFin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		datePickerFin.getJFormattedTextField().setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 120, 215)));
		datePickerFin.setBackground(new Color(255, 255, 255));
		datePickerFin.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		contentPane.add(datePickerFin);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFinalizar.setBackground(SystemColor.textHighlight);
		btnFinalizar.setBounds(594, 490, 114, 49);
		btnFinalizar.hide();
		contentPane.add(btnFinalizar);

		
		JLabel label = new JLabel("Seleccione la fecha de inicio:");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(30, 115, 379, 42);
		contentPane.add(label);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBackground(SystemColor.textHighlight);
		btnVolver.setBounds(20, 490, 114, 49);
		contentPane.add(btnVolver);
		btnVolver.hide();
		btnVolver.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					presentacion.PantallaElegirFechas p = new presentacion.PantallaElegirFechas();
					p.setVisible(true);
					setVisible(false);
				}
		});
		
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSiguiente.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if (datePickerFin.getJFormattedTextField().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Introduzca los campos necesarios.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					datePickerFin.show();
					datePickerIni.hide();
					btnFinalizar.show();
					btnVolver.show();
				label.setText("Seleccione la fecha de fin:");
				datePickerFin.getJFormattedTextField().setText("");
				}
			}
		});
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSiguiente.setBackground(SystemColor.textHighlight);
		btnSiguiente.setBounds(594, 490, 114, 49);
		contentPane.add(btnSiguiente);
		btnFinalizar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (datePickerFin.getJFormattedTextField().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Introduzca los campos necesarios.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
				
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea enviar su propuesta de curso?", "ATENCIÓN", JOptionPane.OK_CANCEL_OPTION);
				if (respuesta == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(null, "Su propuesta ha sido enviada de manera correcta.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
					presentacion.PantallaDireccionCursos p = new presentacion.PantallaDireccionCursos();

					p.setVisible(true);
					//curso2 = new CursoPropio(Facultad.getText(),NombreProf.getText(),c,numRand(),NombreCurso.getText(),Integer.parseInt(NumCreditos.getText()),Double.parseDouble(textPrecio.getText()),Integer.parseInt(Edicion.getText()));
					// DateFormat dfDateMedium = DateFormat.getDateInstance(DateFormat.MEDIUM);
					 
					setVisible(false);
				}
				
				}}
			
		});
		
		
	
		
	}
}
