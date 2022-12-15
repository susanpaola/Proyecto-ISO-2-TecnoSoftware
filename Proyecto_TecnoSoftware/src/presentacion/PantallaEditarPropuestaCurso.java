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
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Label;

import javax.accessibility.AccessibleContext;
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

public class PantallaEditarPropuestaCurso {
	
	public PantallaEditarPropuestaCurso() {
	}
	
	private static JTextField option_Menu;
	//private static JTextField user;
	
	public void login() {
		// TODO - implement PantallaLogin.login
		throw new UnsupportedOperationException();
	}

	public void logout() {
		// TODO - implement PantallaLogin.logout
		throw new UnsupportedOperationException();
	}

	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);
	
	}

		/**
		 * @return 
		 * @wbp.parser.entryPoint
		 */
	public static String Menu() {
		JFrame frmUclm = new JFrame("Demo application");
		frmUclm.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Im\u00E1genes\\IconUCLM.png"));
		frmUclm.setTitle("UCLM");
		frmUclm.setSize(625, 428);
		frmUclm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmUclm.getContentPane().add(panel);
		placeComponents(panel);
		
		option_Menu = new JTextField();
		option_Menu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		option_Menu.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(180, 180, 180)));
		option_Menu.setName("");
		option_Menu.setToolTipText("Inserta el numero del parametro que desea editar:\\n\"\r\n"
				+ "					+ \"	1.- (String) id\\n\"\r\n"
				+ "					+ \"	2.- (String) nombre\\n\"\r\n"
				+ "					+ \" 	3.- (int) ECTS\\n\"\r\n"
				+ "					+ \" 	4.- (Date) fechaInicio\\n\"\r\n"
				+ "					+ \" 	5.- (Date) fechaFin\\n\"\r\n"
				+ "					+ \" 	6.- (double) tasaMatricula\\n\"\r\n"
				+ "					+ \" 	7.- (int) edicion\\n\"");
		option_Menu.setBounds(79, 192, 434, 42);
		panel.add(option_Menu);
		option_Menu.setColumns(10);
		
		String option_Selected = option_Menu.getText();
		
		return option_Selected;
	}
	
	public static void invalid_Option() {
		JPanel contentPanel = new JPanel();
		JLabel lblNewLabel = new JLabel("Opcion no valida, introduce una que no lo sea");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(60, 112, 581, 75);
		contentPanel.add(lblNewLabel);
	}
	
	public static void obtain_Id() {
		System.out.println("Introduzca el id que desee: ");
	}
	
	public static void obtain_Name() {
		System.out.println("Introduzca el nombre que desee: ");
	}

	public static void obtain_ECTS() {
		System.out.println("Introduzca el ECTS que desee: ");
		
	}

	public static void obtain_Init_Date() {
		System.out.println("Introduzca la fecha de inicio que desee: ");
	}
	
	public static void obtain_End_Date() {
		System.out.println("Introduzca la fecha de fin que desee: ");
	}
	
	public static void obtain_Matriculation_Value() {
		System.out.println("Introduce la tasa de matricula que desee: ");
	}
	
	public static void obtain_Edition() {
		System.out.println("Introduce la edicion que desee: ");
	}
	
}
