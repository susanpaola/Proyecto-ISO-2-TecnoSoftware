package main.presentacion2;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import main.negocio.controllers.GestorConsultas;
import main.negocio.controllers.GestorMatriculacion;

//import com.jgoodies.forms.factories.DefaultComponentFactory;

import main.negocio.entities.Matricula;
import main.negocio.entities.ModoPago;
import main.persistencia.GestorBD;
import main.persistencia.MatriculaDAO;
import main.persistencia.CursoPropioDAO;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Cursor;

public class PantallaMatricula extends JFrame {

	private JPanel contentPane;
	MatriculaDAO mDAO = new MatriculaDAO ();
	CursoPropioDAO cDAO = new CursoPropioDAO ();
	main.presentacion2.PantallaRealizarPropuesta p = new main.presentacion2.PantallaRealizarPropuesta();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaMatricula frame = new PantallaMatricula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public PantallaMatricula() throws Exception {
		setTitle("UCLM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\IconUCLM.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTar = new JButton("Pago con Tarjeta");
		btnTar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTar.setForeground(Color.WHITE);
		btnTar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTar.setBackground(SystemColor.textHighlight);
		btnTar.setBounds(56, 380, 226, 75);
		btnTar.hide();
		contentPane.add(btnTar);
		
		JButton btnTrans = new JButton("Pago por transferencia");
		btnTrans.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTrans.setForeground(Color.WHITE);
		btnTrans.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTrans.setBackground(SystemColor.textHighlight);
		btnTrans.setBounds(449, 380, 226, 75);
		btnTrans.hide();
		contentPane.add(btnTrans);

		
		//JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
		//lblNewJgoodiesLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\ImagenUCLM.png"));
		//lblNewJgoodiesLabel.setBounds(20, 10, 310, 99);
		//contentPane.add(lblNewJgoodiesLabel);
		
		GestorConsultas gestorConsultas = new GestorConsultas();
		
		Vector<Object> a = gestorConsultas.consultarCusos("SELECT id,nombre,ECTS,centro,director,tipo,tasa FROM CursoPropio WHERE `estado`= 'VALIDADO'");
		DefaultListModel listModel;
		listModel = new DefaultListModel();
		JList list = new JList(listModel);
	
		list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
        
                	btnTar.addActionListener((ActionListener) new ActionListener() {
            			public void actionPerformed(ActionEvent e) { 
            				Date date = Date.valueOf(LocalDate.now());
            				String miFechaCad = date.toString();
            				PantallaDireccionCursos d = new PantallaDireccionCursos();
            				ModoPago tipoPago = ModoPago.TARJETA_CREDITO;
            			
            			String charsToRemove = "[] ";
            			String idTitulo = a.get(list.getSelectedIndex()).toString().split(",")[0];
            			
        		       	for (char c : charsToRemove.toCharArray()) {
        		       		idTitulo = idTitulo.replace(String.valueOf(c), "");
        		       	}
        		       
        		        int idTit = Integer.parseInt(idTitulo);
            			
            			Matricula m= new Matricula(numRand(), miFechaCad, true, 0, tipoPago, idTit, d.devolverDNI("Samuel", 1));
            			
            			GestorMatriculacion gestorMatriculacion = new GestorMatriculacion();
            			int res = gestorMatriculacion.realizarMatriculacion(m);
            				
            			
        				if (res==1) {
        					JOptionPane.showMessageDialog(null, "Se ha matriculado en el curso de forma correcta.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        					PantallaEstudiante est = new PantallaEstudiante();
        					est.setVisible(true);
        					setVisible(false);
        				}
            				
                	}});
                	btnTrans.addActionListener((ActionListener) new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				Date date = Date.valueOf(LocalDate.now());
            				String miFechaCad = date.toString();
            				PantallaDireccionCursos d = new PantallaDireccionCursos();
            				ModoPago tipoPago = ModoPago.TRANSFERENCIA;
            			
            				String charsToRemove = "[] ";
            				String idTitulo = a.get(list.getSelectedIndex()).toString().split(",")[0];
            			
            				for (char c : charsToRemove.toCharArray()) {
            					idTitulo = idTitulo.replace(String.valueOf(c), "");
            				}
        		       
            				int idTit = Integer.parseInt(idTitulo);
            			
            				Matricula m= new Matricula(numRand(), miFechaCad, true, 0, tipoPago, idTit, d.devolverDNI("Samuel", 1));
            			
            				GestorMatriculacion gestorMatriculacion = new GestorMatriculacion();
            				int res = gestorMatriculacion.realizarMatriculacion(m);
            				
            			
            				if (res==1) {
            					JOptionPane.showMessageDialog(null, "Se ha matriculado en el curso de forma correcta.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            					PantallaEstudiante est = new PantallaEstudiante();
            					est.setVisible(true);
            					setVisible(false);
            				}
            		}});
                	
                	btnTar.show();
                	btnTrans.show();
                if (listModel.size()==0) {
                	main.presentacion2.PantallaEmpleadosVicerrectorado p = new main.presentacion2.PantallaEmpleadosVicerrectorado();
                	p.setVisible(true);
                	setVisible(false);
                }
                	}
            }
        });

		
		for (int b=0; b<a.size();b++) {
			listModel.addElement(a.get(b).toString().replace("[", "").replace("]", ""));		
		}
		

		list.setBounds(30, 119, 686, 234);
		contentPane.add(list);
	}
	
	public int numRand() {
		int numero = (int)(Math.random()*100+1);
		return numero;
	}

}
