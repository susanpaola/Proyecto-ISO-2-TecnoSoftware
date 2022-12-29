package main.presentacion2;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

//import com.jgoodies.forms.factories.DefaultComponentFactory;

import main.persistencia.GestorBD;
import main.negocio.controllers.GestorConsultas;
import main.negocio.controllers.GestorPropuestasCursos;
import main.negocio.entities.CursoPropio;
import main.negocio.entities.EstadoCurso;
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

public class PantallaAceptarCursos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaAceptarCursos frame = new PantallaAceptarCursos();
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
	public PantallaAceptarCursos() throws Exception {
		setTitle("UCLM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\IconUCLM.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAceptar.setBackground(Color.GREEN);
		btnAceptar.setBounds(633, 179, 114, 49);
		btnAceptar.hide();
		btnAceptar.addActionListener((ActionListener) new ActionListener() {
    		

			public void actionPerformed(ActionEvent e) {
				
				}});
		contentPane.add(btnAceptar);
		
		JButton btnDenegar = new JButton("Denegar");
		btnDenegar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDenegar.hide();
		btnDenegar.setForeground(Color.WHITE);
		btnDenegar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDenegar.setBackground(Color.RED);
		btnDenegar.setBounds(633, 317, 114, 49);

		contentPane.add(btnDenegar);

		
		//JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
		//lblNewJgoodiesLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\ImagenUCLM.png"));
		//lblNewJgoodiesLabel.setBounds(20, 10, 310, 99);
		//contentPane.add(lblNewJgoodiesLabel);
		
		GestorConsultas gestor = new GestorConsultas();
		Vector<Object> a = gestor.consultarCusos("SELECT id,nombre,ECTS,centro,director,tipo FROM CursoPropio WHERE `estado`= 'PROPUESTO'");
		DefaultListModel listModel;
		listModel = new DefaultListModel();
		JList list = new JList(listModel);
	
		list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                	btnDenegar.addActionListener((ActionListener) new ActionListener() {
                		

            			public void actionPerformed(ActionEvent e) {
            				try {
            					GestorPropuestasCursos gestorCursos= new GestorPropuestasCursos();
            					
            					String charsToRemove = "[] ";
            					
            					String b=a.get(list.getSelectedIndex()).toString().split(",")[0];
            					
            					for (char c : charsToRemove.toCharArray()) {
                		       		b = b.replace(String.valueOf(c), "");
                		       	}
                		       
                		        int idTit = Integer.parseInt(b);
                		        EstadoCurso estado = EstadoCurso.PROPUESTA_RECHAZADA;
                		        CursoPropio curso = new CursoPropio(idTit, estado);
            					
            					gestorCursos.editarPropuestaCurso(curso, 1);
            					JOptionPane.showInputDialog("Envie los motivos de la denegación del curso.");
            					listModel.remove(list.getSelectedIndex());
            					
            				} catch (Exception e1) {
            					e1.printStackTrace();
            				}
            			
            				
            				}});
                	btnAceptar.addActionListener((ActionListener) new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				try {
            					GestorPropuestasCursos gestorCursos= new GestorPropuestasCursos();
            					
            					String charsToRemove = "[] ";
            					
            					String b=a.get(list.getSelectedIndex()).toString().split(",")[0];
            					
            					for (char c : charsToRemove.toCharArray()) {
                		       		b = b.replace(String.valueOf(c), "");
                		       	}
                		       
                		        int idTit = Integer.parseInt(b);
                		        EstadoCurso estado = EstadoCurso.PROPUESTA_RECHAZADA;
                		        CursoPropio curso = new CursoPropio(idTit, estado);
            					
            					gestorCursos.editarPropuestaCurso(curso, 1);
            					
            					listModel.remove(list.getSelectedIndex());
            				} catch (Exception e1) {
            					e1.printStackTrace();
            				}
            				
            				}});
                	
                	btnAceptar.show();
                	btnDenegar.show();
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
		

		list.setBounds(30, 119, 574, 324);
		contentPane.add(list);
		


	}

}