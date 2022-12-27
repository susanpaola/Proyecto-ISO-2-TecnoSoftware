package presentacion;

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
import java.awt.Color;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import negocio.entities.CursoPropio;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Panel;

public class PantallaRealizarPropuesta extends JFrame implements FocusListener{

	public JPanel contentPane;
	public JTextField NombreCurso;
	public JTextField NumCreditos;
	public JTextField Facultad;
	public JTextField Edicion;
	public JTextField NombreProf;
	public JTextField CategoriaProf;
	//public JComboBox<String> comboBox ;
	public JTextField textPrecio;
	CursoPropio curso;

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
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\ImagenUCLM.png"));
		lblNewJgoodiesLabel.setBounds(20, 10, 310, 99);
		contentPane.add(lblNewJgoodiesLabel);
		
		NombreCurso = new JTextField();
		NombreCurso.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 120, 215)));
		NombreCurso.setFont(new Font("Tahoma", Font.BOLD, 13));
		NombreCurso.setBounds(454, 142, 259, 39);
		contentPane.add(NombreCurso);
		NombreCurso.setColumns(10);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(20, 496, 114, 49);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					presentacion.PantallaDireccionCursos p = new presentacion.PantallaDireccionCursos();
					p.setVisible(true);
					setVisible(false);
				}
		});
		
		NumCreditos  = new JTextField ();
		NumCreditos.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		NumCreditos.setFont(new Font("Tahoma", Font.BOLD, 13));
		NumCreditos.setColumns(10);
		NumCreditos.setBounds(454, 220, 259, 39);
		NumCreditos.addFocusListener(this);
		contentPane.add(NumCreditos);
		
		
		

		
		
		Facultad = new JTextField();
		Facultad.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		Facultad.setFont(new Font("Tahoma", Font.BOLD, 13));
		Facultad.setColumns(10);
		Facultad.setBounds(454, 298, 259, 39);
		contentPane.add(Facultad);
		
		Edicion = new JTextField();
		Edicion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		Edicion.setFont(new Font("Tahoma", Font.BOLD, 13));
		Edicion.setColumns(10);
		Edicion.setBounds(454, 376, 259, 39);
		contentPane.add(Edicion);
		
		NombreProf = new JTextField();
		NombreProf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 120, 215)));
		NombreProf.setFont(new Font("Tahoma", Font.BOLD, 13));
		NombreProf.setText("AUTO\r\n");
		NombreProf.setColumns(10);
		NombreProf.setBounds(71, 259, 259, 39);
		contentPane.add(NombreProf);
		
		CategoriaProf = new JTextField();
		CategoriaProf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textHighlight));
		CategoriaProf.setFont(new Font("Tahoma", Font.BOLD, 13));
		CategoriaProf.setText("AUTO");
		CategoriaProf.setColumns(10);
		CategoriaProf.setBounds(71, 337, 259, 39);
		contentPane.add(CategoriaProf);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setBackground(SystemColor.textHighlight);
		btnSiguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSiguiente.setBounds(599, 496, 114, 49);
		contentPane.add(btnSiguiente);
		btnSiguiente.addActionListener((ActionListener) new ActionListener() {
	

			public void actionPerformed(ActionEvent e) {
				
				Num=NumCreditos.getText();
				
					if (!textoVacio(Facultad)||!textoVacio(Edicion) || !textoVacio(NombreCurso) || !textoVacio(NombreProf)||!textoVacio(CategoriaProf) ) {
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos para realizar la propuesta.", "ERROR", JOptionPane.ERROR_MESSAGE);}
					else {
				if (NumCreditos.getText().isEmpty()|| !isNumeric(NumCreditos.getText()))
					JOptionPane.showMessageDialog(null, "Introduzca los créditos de manera correcta.", "ERROR", JOptionPane.ERROR_MESSAGE);
				else {
				compruebaCreditos(c);
			System.out.println(curso.toString());
				
				}}}});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 comboBox.addItem("Master de Formación Permanente");
		 comboBox.addItem("Especialización");
		 comboBox.addItem("Diploma de Experto");
		 comboBox.addItem("Curso de Formacion Avanzada");
		 comboBox.addItem("Curso de Formacion Continua");
		 comboBox.addItem("Microcredenciales");
		 comboBox.addItem("Actividades de Corta Duración");
		 comboBox.addItem("Cursos de Verano");
		 comboBox.addItem("Extensión de Mayores");
		 comboBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
				c= comboBox.getSelectedItem().toString();
					

					}
					
			});
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBounds(71, 181, 259, 39);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Tipo de curso:");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(71, 142, 259, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombreDelProfesor = new JLabel("Nombre del profesor:");
		lblNombreDelProfesor.setForeground(SystemColor.textHighlight);
		lblNombreDelProfesor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNombreDelProfesor.setBounds(71, 230, 259, 39);
		contentPane.add(lblNombreDelProfesor);
		
		JLabel lblNombreDelCurso = new JLabel("Nombre del Curso:");
		lblNombreDelCurso.setForeground(SystemColor.textHighlight);
		lblNombreDelCurso.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNombreDelCurso.setBounds(454, 113, 259, 39);
		contentPane.add(lblNombreDelCurso);
		
		JLabel lblNmeroDeCrditos = new JLabel("N\u00FAmero de cr\u00E9ditos:");
		lblNmeroDeCrditos.setForeground(SystemColor.textHighlight);
		lblNmeroDeCrditos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNmeroDeCrditos.setBounds(454, 191, 259, 39);
		contentPane.add(lblNmeroDeCrditos);
		
		JLabel lblFacultadDondeSe = new JLabel("Facultad donde se imparte:");
		lblFacultadDondeSe.setForeground(SystemColor.textHighlight);
		lblFacultadDondeSe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblFacultadDondeSe.setBounds(454, 269, 259, 39);
		contentPane.add(lblFacultadDondeSe);
		
		JLabel lblTitulacinDelProfesor = new JLabel("Titulaci\u00F3n del profesor:");
		lblTitulacinDelProfesor.setForeground(SystemColor.textHighlight);
		lblTitulacinDelProfesor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTitulacinDelProfesor.setBounds(71, 308, 259, 39);
		contentPane.add(lblTitulacinDelProfesor);
		
		JLabel lblDuracinDelCurso = new JLabel("Edici\u00F3n del curso:");
		lblDuracinDelCurso.setForeground(SystemColor.textHighlight);
		lblDuracinDelCurso.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblDuracinDelCurso.setBounds(454, 347, 259, 39);
		contentPane.add(lblDuracinDelCurso);
		
		textPrecio = new JTextField();
		textPrecio.setEditable(false);
		textPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPrecio.setColumns(10);
		textPrecio.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 120, 215)));
		textPrecio.setBounds(232, 502, 259, 39);
		contentPane.add(textPrecio);
		
		
		JLabel lblPrecio = new JLabel("Precio de la matr\u00EDcula:");
		lblPrecio.setForeground(SystemColor.textHighlight);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPrecio.setBounds(232, 453, 259, 39);
		contentPane.add(lblPrecio);
		System.out.println();
	}
	public void compruebaCreditos (String c) {
		int num = Integer.parseInt(Num);
		presentacion.PantallaElegirFechas p = new presentacion.PantallaElegirFechas();
		switch (c) { 
	    case "Master de Formación Permanente":
	    
	    	if (num ==60 || num ==90 || num ==120) {
	    	curso = new CursoPropio(Facultad.getText(),NombreProf.getText(),c,numRand(),NombreCurso.getText(),Integer.parseInt(NumCreditos.getText()),Double.parseDouble(textPrecio.getText()),Integer.parseInt(Edicion.getText()));
				p.setVisible(true);
				setVisible(false);
				new String ();
				
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, "Introduzca los créditos adecuados para la modalidad elegida.", "ERROR", JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    	
	    case "Especialización":
	    	if (num >29 && num<60) {
	    		curso = new CursoPropio(Facultad.getText(),NombreProf.getText(),c,numRand(),NombreCurso.getText(),Integer.parseInt(NumCreditos.getText()),Double.parseDouble(textPrecio.getText()),Integer.parseInt(Edicion.getText()));
				p.setVisible(true);
				setVisible(false);
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, "Introduzca los créditos adecuados para la modalidad elegida.", "ERROR", JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    case "Diploma de Experto":
	    	if (num >14 && num<30) {
	    		 curso = new CursoPropio(Facultad.getText(),NombreProf.getText(),c,numRand(),NombreCurso.getText(),Integer.parseInt(NumCreditos.getText()),Double.parseDouble(textPrecio.getText()),Integer.parseInt(Edicion.getText()));
				p.setVisible(true);
				setVisible(false);
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, "Introduzca los créditos adecuados para la modalidad elegida.", "ERROR", JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    case "Microcredenciales":
	    	if (num >1 && num<15) {
	    		 curso = new CursoPropio(Facultad.getText(),NombreProf.getText(),c,numRand(),NombreCurso.getText(),Integer.parseInt(NumCreditos.getText()),Double.parseDouble(textPrecio.getText()),Integer.parseInt(Edicion.getText()));
				p.setVisible(true);
				setVisible(false);
			
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, "Introduzca los créditos adecuados para la modalidad elegida.", "ERROR", JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    case "Curso de Formacion Avanzada":
	    	if (num >14 && num<31) {
	    	 curso = new CursoPropio(Facultad.getText(),NombreProf.getText(),c,numRand(),NombreCurso.getText(),Integer.parseInt(NumCreditos.getText()),Double.parseDouble(textPrecio.getText()),Integer.parseInt(Edicion.getText()));
				p.setVisible(true);
				setVisible(false);
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, "Introduzca los créditos adecuados para la modalidad elegida.", "ERROR", JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    case "Curso de Formacion Continua":
	    	if (num >2 && num<15) {
	    		 curso = new CursoPropio(Facultad.getText(),NombreProf.getText(),c,numRand(),NombreCurso.getText(),Integer.parseInt(NumCreditos.getText()),Double.parseDouble(textPrecio.getText()),Integer.parseInt(Edicion.getText()));
				p.setVisible(true);
				setVisible(false);
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, "Introduzca los créditos adecuados para la modalidad elegida.", "ERROR", JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    case "Actividades de Corta Duración":
	    	if (num >0 && num<2) {
	    		 curso = new CursoPropio(Facultad.getText(),NombreProf.getText(),c,numRand(),NombreCurso.getText(),Integer.parseInt(NumCreditos.getText()),Double.parseDouble(textPrecio.getText()),Integer.parseInt(Edicion.getText()));
				p.setVisible(true);
				setVisible(false);
	    	}
	    	else {
	    		JOptionPane.showMessageDialog(null, "Introduzca los créditos adecuados para la modalidad elegida.", "ERROR", JOptionPane.ERROR_MESSAGE);

	    	} 
	    	break;
	    case "Cursos de Verano":
	    	 curso = new CursoPropio(Facultad.getText(),NombreProf.getText(),c,numRand(),NombreCurso.getText(),Integer.parseInt(NumCreditos.getText()),Double.parseDouble(textPrecio.getText()),Integer.parseInt(Edicion.getText()));
				p.setVisible(true);
				setVisible(false);
				break;
	    case "Extensión de Mayores":
	    	 curso = new CursoPropio(Facultad.getText(),NombreProf.getText(),c,numRand(),NombreCurso.getText(),Integer.parseInt(NumCreditos.getText()),Double.parseDouble(textPrecio.getText()),Integer.parseInt(Edicion.getText()));
				p.setVisible(true);
				setVisible(false);
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
}
