package main.presentacion2;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import main.negocio.controllers.GestorConsultas;

//import com.jgoodies.forms.factories.DefaultComponentFactory;

import main.persistencia.CursoPropioDAO;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;

public class PantallaPropuestasPendientes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPropuestasPendientes frame = new PantallaPropuestasPendientes();
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
	public PantallaPropuestasPendientes() throws Exception {
		setTitle("UCLM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\IconUCLM.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 520);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnVolver.setBackground(SystemColor.textHighlight);
		btnVolver.setBounds(633, 394, 114, 49);
       	btnVolver.addActionListener((ActionListener) new ActionListener() {
    			public void actionPerformed(ActionEvent e) {			
     
        	main.presentacion2.PantallaDireccionCursos p = new main.presentacion2.PantallaDireccionCursos();
        	
        	p.setVisible(true);
        	setVisible(false);
        	}
        	});
		contentPane.add(btnVolver);

		
		//JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
		//lblNewJgoodiesLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\ImagenUCLM.png"));
		//lblNewJgoodiesLabel.setBounds(20, 10, 310, 99);
		//contentPane.add(lblNewJgoodiesLabel);
		GestorConsultas gestor = new GestorConsultas();
		
		DefaultListModel listModel;
		listModel = new DefaultListModel();
		JList list = new JList(listModel);
		
		for (int b=0; b<gestor.estadoPendiente().size();b++) {
			listModel.addElement(gestor.estadoPendiente().get(b).toString().replace("[", "").replace("]", ""));		
		}

		list.setBounds(30, 119, 574, 324);
		contentPane.add(list);

      
 
	}

}
