package main.presentacion2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JLabel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;

import main.negocio.controllers.GestorPropuestasCursos;
import main.negocio.entities.CursoPropio;
import main.negocio.entities.EstadoCurso;
import main.negocio.entities.TipoCurso;
import main.persistencia.CursoPropioDAO;
import main.persistencia.GestorBD;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Panel;

public class PantallaRealizarPropuesta extends JFrame implements FocusListener{

	protected JPanel contentPane;
	protected JTextField NombreCurso;
	protected JTextField CategoriaProf;
	protected JTextField NombreProf;
	protected JTextField Edicion;
	protected JTextField Facultad; 
	protected JTextField NumCreditos;
	protected JTextField textPrecio;
	protected JButton btnNewButton;
	protected JButton btnFinalizar;
	protected JButton btnSiguiente;
	protected JButton btnNext;
	protected JDatePickerImpl datePickerFin;
	protected JDatePickerImpl datePickerIni;
	protected JLabel label;
	protected JLabel lblNewLabel;
	protected JLabel lblPrecio;
	protected JLabel lblNombreDelProfesor;
	protected JLabel lblNombreDelCurso;
	protected JLabel lblNmeroDeCrditos;
	protected JLabel lblFacultadDondeSe;
	protected JLabel lblTitulacinDelProfesor;
	protected JLabel lblDuracinDelCurso;
	protected JComboBox comboBox;
	main.presentacion2.PantallaDireccionCursos p = new main.presentacion2.PantallaDireccionCursos();
	CursoPropio curso;
	private String tipoLetra= "Tahoma";
	private String ERROR= "ERROR";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRealizarPropuesta frame = new PantallaRealizarPropuesta();
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
	 String c="";
	String Num;
	
	public PantallaRealizarPropuesta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\IconUCLM.png"));
		setTitle("UCLM\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 618);
		contentPane = new JPanel();
		contentPane.setFont(new Font(tipoLetra, Font.BOLD, 15));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
		//lblNewJgoodiesLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\ImagenUCLM.png"));
		//lblNewJgoodiesLabel.setBounds(20, 10, 310, 99);
		//contentPane.add(lblNewJgoodiesLabel);
		
		NombreCurso = new JTextField();
		NombreCurso.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 120, 215)));
		NombreCurso.setFont(new Font(tipoLetra, Font.BOLD, 13));
		NombreCurso.setBounds(454, 142, 259, 39);
		contentPane.add(NombreCurso);
		NombreCurso.setColumns(10);
		
		btnNewButton = new JButton("Volver");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font(tipoLetra, Font.BOLD, 15));
		btnNewButton.setBounds(20, 496, 114, 49);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					p.setVisible(true);
					p.TipoUsuario.setText(CategoriaProf.getText());
					p.NombreUsu.setText(NombreProf.getText());
					setVisible(false);
				}
		});
		
		NumCreditos  = new JTextField ();
		NumCreditos.setBorder(new MatteBorder(0, 0, 1, 0, SystemColor.textHighlight));
		NumCreditos.setFont(new Font(tipoLetra, Font.BOLD, 13));
		NumCreditos.setColumns(10);
		NumCreditos.setBounds(454, 220, 259, 39);
		NumCreditos.addFocusListener(this);
		contentPane.add(NumCreditos);
		
		
		

		
		
		Facultad = new JTextField();
		Facultad.setBorder(new MatteBorder(0, 0, 1, 0,  SystemColor.textHighlight));
		Facultad.setFont(new Font(tipoLetra, Font.BOLD, 13));
		Facultad.setColumns(10);
		Facultad.setBounds(454, 298, 259, 39);
		contentPane.add(Facultad);
		
		Edicion = new JTextField();
		Edicion.setBorder(new MatteBorder(0, 0, 1, 0,  SystemColor.textHighlight));
		Edicion.setFont(new Font(tipoLetra, Font.BOLD, 13));
		Edicion.setColumns(10);
		Edicion.setBounds(454, 376, 259, 39);
		contentPane.add(Edicion);
		
		NombreProf = new JTextField();
		NombreProf.setBorder(new MatteBorder(0, 0, 1, 0,  new Color(0, 120, 215)));
		NombreProf.setFont(new Font(tipoLetra, Font.BOLD, 13));
		NombreProf.setColumns(10);
		NombreProf.setBounds(71, 259, 259, 39);
		contentPane.add(NombreProf);
		
		UtilDateModel model = new UtilDateModel();
		Properties pr = new Properties();
		pr.put("text.today", "Today");
		pr.put("text.month", "Month");
		pr.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model,pr);
		
		CategoriaProf = new JTextField();
		CategoriaProf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		CategoriaProf.setFont(new Font(tipoLetra, Font.BOLD, 13));
		CategoriaProf.setColumns(10);
		CategoriaProf.setBounds(71, 337, 259, 39);
		contentPane.add(CategoriaProf);
		
		datePickerFin = new JDatePickerImpl(datePanel,new DateLabelFormatter());
		datePickerFin.setBorder(null);
		datePickerFin.setSize(200, 200);
		datePickerFin.setLocation(245, 195);
		datePickerFin.hide();
		datePickerFin.setFont(new Font(tipoLetra, Font.BOLD, 15));
		datePickerFin.getJFormattedTextField().setFont(new Font(tipoLetra, Font.BOLD, 15));
		datePickerFin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		datePickerFin.getJFormattedTextField().setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 120, 215)));
		datePickerFin.setBackground(new Color(255, 255, 255));
		datePickerFin.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		contentPane.add(datePickerFin);
		
		

		
		datePickerIni = new JDatePickerImpl(datePanel,new DateLabelFormatter());
		datePickerIni.getJFormattedTextField().setEditable(true);
		datePickerIni.hide();
		datePickerIni.setFont(new Font(tipoLetra, Font.BOLD, 15));
		datePickerIni.getJFormattedTextField().setFont(new Font(tipoLetra, Font.BOLD, 15));
		datePickerIni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		datePickerIni.getJFormattedTextField().setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 120, 215)));
		datePickerIni.setSize(200, 200);
		datePickerIni.setLocation(245, 195);
		datePickerIni.setBackground(new Color(255, 255, 255));
		datePickerIni.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		contentPane.add(datePickerIni);
		
		label = new JLabel("Seleccione la fecha de inicio:");
		label.hide();
		label.setFont(new Font(tipoLetra, Font.BOLD, 20));
		label.setBounds(30, 115, 379, 42);
		contentPane.add(label);
		
		
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setFont(new Font(tipoLetra, Font.BOLD, 15));
		btnFinalizar.setBackground(SystemColor.textHighlight);
		btnFinalizar.setBounds(594, 490, 114, 49);
		btnFinalizar.hide();
		contentPane.add(btnFinalizar);
		
		btnFinalizar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (datePickerFin.getJFormattedTextField().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Introduzca los campos necesarios.", ERROR, JOptionPane.ERROR_MESSAGE);
				}
				else {
					
				
				int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea enviar su propuesta de curso?", "ATENCIÓN", JOptionPane.OK_CANCEL_OPTION);
				if (respuesta == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(null, "Su propuesta ha sido enviada de manera correcta.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);

					p.setVisible(true);
					p.TipoUsuario.setText(CategoriaProf.getText());
					p.NombreUsu.setText(NombreProf.getText());
					setVisible(false);
					try {
						EstadoCurso estado= EstadoCurso.PROPUESTO;
						TipoCurso tipo = null;
						switch(c) {
						case "Master de Formación Permanente":
							tipo = TipoCurso.MASTER;
							break;
						case "Diploma de Experto":
							tipo = TipoCurso.EXPERTO;
							break;
						case "Especialización":
							tipo = TipoCurso.ESPECIALISTA;
							break;
						case "Curso de Formacion Avanzada":
							tipo = TipoCurso.FORMACION_AVANZADA;
							break;
						case "Curso de Formacion Continua":
							tipo = TipoCurso.FORMACION_CONTINUA;
							break;
						case "Microcredenciales":
							tipo = TipoCurso.MICROCREDENCIALES;
							break;
						case "Actividades de Corta Duración":
							tipo = TipoCurso.CORTA_DURACION;
							break;
					}
						
					curso = new CursoPropio(numRand(), NombreCurso.getText(), Integer.parseInt(NumCreditos.getText()), datePickerFin.getJFormattedTextField().getText(), datePickerFin.getJFormattedTextField().getText(), Double.parseDouble(textPrecio.getText()), Integer.parseInt(Edicion.getText()), Facultad.getText(), NombreProf.getText(), CategoriaProf.getText(), estado, tipo);
					GestorPropuestasCursos gestorCursos = new GestorPropuestasCursos();
					gestorCursos.realizarPropuestaCurso(curso);
						 } catch (NumberFormatException e1) {
						e1.printStackTrace();
					}
				
				}
				
				}}
			
		});
		


		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setBackground(SystemColor.textHighlight);
		btnSiguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSiguiente.setFont(new Font(tipoLetra, Font.BOLD, 15));
		btnSiguiente.setBounds(594, 490, 114, 49);
		contentPane.add(btnSiguiente);
		btnSiguiente.addActionListener(new ActionListener() {
	

			public void actionPerformed(ActionEvent e) {
				
				Num=NumCreditos.getText();
				
					if (!textoVacio(Facultad)||!textoVacio(Edicion) || !textoVacio(NombreCurso) || !textoVacio(NombreProf)||!textoVacio(CategoriaProf) ) {
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos para realizar la propuesta.", ERROR, JOptionPane.ERROR_MESSAGE);}
					else {
				if (NumCreditos.getText().isEmpty()|| !isNumeric(NumCreditos.getText()))
					JOptionPane.showMessageDialog(null, "Introduzca los créditos de manera correcta.", ERROR, JOptionPane.ERROR_MESSAGE);
				else {
				compruebaCreditos(c);
			
				
				}}}});
		
		comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 comboBox.addItem("Master de Formación Permanente");
		 comboBox.addItem("Especialización");
		 comboBox.addItem("Diploma de Experto");
		 comboBox.addItem("Curso de Formacion Avanzada");
		 comboBox.addItem("Curso de Formacion Continua");
		 comboBox.addItem("Microcredenciales");
		 comboBox.addItem("Actividades de Corta Duración");
		 comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				c= comboBox.getSelectedItem().toString();

					}
					
			});
		comboBox.setFont(new Font(tipoLetra, Font.BOLD, 13));
		comboBox.setBounds(71, 181, 259, 39);
		contentPane.add(comboBox);
		
		lblNewLabel = new JLabel("Tipo de curso:");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font(tipoLetra, Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(71, 142, 259, 39);
		contentPane.add(lblNewLabel);
		
		lblNombreDelProfesor = new JLabel("DNI del profesor");
		lblNombreDelProfesor.setForeground(SystemColor.textHighlight);
		lblNombreDelProfesor.setFont(new Font(tipoLetra, Font.BOLD | Font.ITALIC, 13));
		lblNombreDelProfesor.setBounds(71, 230, 259, 39);
		contentPane.add(lblNombreDelProfesor);
		
		lblNombreDelCurso = new JLabel("Nombre del Curso:");
		lblNombreDelCurso.setForeground(SystemColor.textHighlight);
		lblNombreDelCurso.setFont(new Font(tipoLetra, Font.BOLD | Font.ITALIC, 13));
		lblNombreDelCurso.setBounds(454, 113, 259, 39);
		contentPane.add(lblNombreDelCurso);
		
		lblNmeroDeCrditos = new JLabel("N\u00FAmero de cr\u00E9ditos:");
		lblNmeroDeCrditos.setForeground(SystemColor.textHighlight);
		lblNmeroDeCrditos.setFont(new Font(tipoLetra, Font.BOLD | Font.ITALIC, 13));
		lblNmeroDeCrditos.setBounds(454, 191, 259, 39);
		contentPane.add(lblNmeroDeCrditos);
		
		lblFacultadDondeSe = new JLabel("Facultad donde se imparte:");
		lblFacultadDondeSe.setForeground(SystemColor.textHighlight);
		lblFacultadDondeSe.setFont(new Font(tipoLetra, Font.BOLD | Font.ITALIC, 13));
		lblFacultadDondeSe.setBounds(454, 269, 259, 39);
		contentPane.add(lblFacultadDondeSe);
		
		lblTitulacinDelProfesor = new JLabel("Introduzca el DNI del secretario:");
		lblTitulacinDelProfesor.setForeground(SystemColor.textHighlight);
		lblTitulacinDelProfesor.setFont(new Font(tipoLetra, Font.BOLD | Font.ITALIC, 13));
		lblTitulacinDelProfesor.setBounds(71, 308, 259, 39);
		contentPane.add(lblTitulacinDelProfesor);
		
		lblDuracinDelCurso = new JLabel("Edici\u00F3n del curso:");
		lblDuracinDelCurso.setForeground(SystemColor.textHighlight);
		lblDuracinDelCurso.setFont(new Font(tipoLetra, Font.BOLD | Font.ITALIC, 13));
		lblDuracinDelCurso.setBounds(454, 347, 259, 39);
		contentPane.add(lblDuracinDelCurso);
		
		textPrecio = new JTextField();
		textPrecio.setEditable(false);
		textPrecio.setFont(new Font(tipoLetra, Font.BOLD, 13));
		textPrecio.setColumns(10);
		textPrecio.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 120, 215)));
		textPrecio.setBounds(232, 502, 259, 39);
		contentPane.add(textPrecio);
		
		
		lblPrecio = new JLabel("Precio de la matr\u00EDcula:");
		lblPrecio.setForeground(SystemColor.textHighlight);
		lblPrecio.setFont(new Font(tipoLetra, Font.BOLD | Font.ITALIC, 13));
		lblPrecio.setBounds(232, 453, 259, 39);
		contentPane.add(lblPrecio);
		
		
		btnNext = new JButton("Siguiente");
		btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if (datePickerIni.getJFormattedTextField().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Introduzca los campos necesarios.", ERROR, JOptionPane.ERROR_MESSAGE);
				}
				else {
					datePickerFin.show();
					datePickerIni.hide();
					btnFinalizar.show();
				label.setText("Seleccione la fecha de fin:");
				datePickerFin.getJFormattedTextField().setText("");
				}
			}
		});
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font(tipoLetra, Font.BOLD, 15));
		btnNext.setBackground(SystemColor.textHighlight);
		btnNext.setBounds(594, 490, 114, 49);
		contentPane.add(btnNext);
	}
    public void mostrarFechas() {
    	NombreCurso.hide();
    	CategoriaProf.hide();
    	NombreProf.hide();
    	Edicion.hide();
    	Facultad.hide();
    	NumCreditos.hide();
    	textPrecio.hide();
    	btnNewButton.hide();
    	btnFinalizar.hide();
    	btnSiguiente.hide();
    	btnNext.show();
    	label.show();;
    	lblNewLabel.hide();
    	lblPrecio.hide();
    	lblNombreDelProfesor.hide();
    	lblNombreDelCurso.hide();
    	lblNmeroDeCrditos.hide();
    	lblFacultadDondeSe.hide();
    	lblTitulacinDelProfesor.hide();
    	lblDuracinDelCurso.hide();
    	datePickerIni.show();
    	comboBox.hide();
    	
    	
    }
	public void compruebaCreditos (String c) {
		int num = Integer.parseInt(Num);
		String err="Introduzca los créditos adecuados para la modalidad elegida.";
		switch (c) { 
	    case "Master de Formación Permanente":
	    
	    	if (num ==60 || num ==90 || num ==120) {

mostrarFechas();
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, err, ERROR, JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    	
	    case "Especialización":
	    	if (num >29 && num<60) {
	    		mostrarFechas();
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, err , ERROR, JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    case "Diploma de Experto":
	    	if (num >14 && num<30) {
	    		mostrarFechas();
	   
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, err, ERROR, JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    case "Microcredenciales":
	    	if (num >1 && num<15) {
	    		
	    		mostrarFechas();
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, err, ERROR, JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    case "Curso de Formacion Avanzada":
	    	if (num >14 && num<31) {
	    	
	    		mostrarFechas();
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, err, ERROR, JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    case "Curso de Formacion Continua":
	    	if (num >2 && num<15) {
	    		mostrarFechas();
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, err, ERROR, JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    case "Actividades de Corta Duración":
	    	if (num >0 && num<2) {
	    		mostrarFechas();
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, err, ERROR, JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	  }
		
	}
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	public static boolean textoVacio (JTextField cuadro){
		boolean vacio=true;
		if(cuadro.getText().equals(""))
			vacio=false;
		return vacio;
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()== NumCreditos) {
			Num=NumCreditos.getText();
			String a= String.valueOf((Double.parseDouble(Num))*18.87);
			textPrecio.setText(a);
		}
	
		// TODO Auto-generated method stub
		
	}
	public int numRand() {
		int numero = (int)(Math.random()*100+1);
		return numero;
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
}