package main.presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;

public class EmpleadosVicerrectoradoPantalla extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpleadosVicerrectoradoPantalla frame = new EmpleadosVicerrectoradoPantalla();
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
	public EmpleadosVicerrectoradoPantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 480);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEvaluar = new JLabel("Evaluar Propuesta");
		lblEvaluar.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEvaluar.setBounds(25, 22, 174, 31);
		contentPane.add(lblEvaluar);
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"Propuesto", "Validado", "Propuesta rechazada", "En matriculacion", "En imparticion", "Terminado"}));
		comboBoxEstado.setBounds(39, 97, 229, 31);
		contentPane.add(comboBoxEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstado.setBounds(39, 68, 82, 30);
		contentPane.add(lblEstado);		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 162, 639, 258);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel (new Object[][] {{null, null, null}, {null, null, null}, {null, null, null},
			{null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}}, 
				new String [] {"Id Curso", "Nombre Curso", "Estado Curso", "Edicion", "ECT"}));
		scrollPane.setViewportView(table);
		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Id Curso");
		model.addColumn("Nombre Curso");
		model.addColumn("Estado Curso");
		model.addColumn("Edicion");
		model.addColumn("ECT");
	}
}
