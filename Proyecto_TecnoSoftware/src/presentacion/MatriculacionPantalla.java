package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class MatriculacionPantalla extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textIdentificacion;
	private JTextField textEspecificacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatriculacionPantalla frame = new MatriculacionPantalla();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MatriculacionPantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 521);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(41, 244, 61, 32);
		contentPane.add(lblNombre);
		
		JLabel lblTitulo = new JLabel("Realizacion de Matricula");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(174, 10, 231, 31);
		contentPane.add(lblTitulo);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//Bloquear el boton realizar matricula
				//if (e.getSource() == list) {
					//btnRealizarMatricula.setEnabled(false);					

				//}
			}
		});
		list.setBounds(41, 52, 517, 181);
		contentPane.add(list);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(40, 287, 61, 24);
		contentPane.add(lblApellido);
		
		JLabel lblIdentificacion = new JLabel("Identificacion (DNI)");
		lblIdentificacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdentificacion.setBounds(41, 414, 123, 30);
		contentPane.add(lblIdentificacion);
		
		JLabel lblTitulacion = new JLabel("Titulacion");
		lblTitulacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitulacion.setBounds(39, 329, 73, 32);
		contentPane.add(lblTitulacion);
		
		JLabel lblEspecificacion = new JLabel("Especificacion");
		lblEspecificacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEspecificacion.setBounds(41, 372, 100, 32);
		contentPane.add(lblEspecificacion);
		
		textNombre = new JTextField();
		textNombre.setBounds(112, 251, 231, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setText("");
		textApellido.setBounds(112, 290, 231, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textIdentificacion = new JTextField();
		textIdentificacion.setText("");
		textIdentificacion.setBounds(174, 420, 169, 20);
		contentPane.add(textIdentificacion);
		textIdentificacion.setColumns(10);
		
		textEspecificacion = new JTextField();
		textEspecificacion.setBounds(135, 379, 208, 20);
		contentPane.add(textEspecificacion);
		textEspecificacion.setColumns(10);
		
		JButton btnRealizarMatricula = new JButton("Realizar Matricula");
		btnRealizarMatricula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textNombre.getText().isEmpty() || textApellido.getText().isEmpty() || 
						textEspecificacion.getText().isEmpty() || textIdentificacion.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea realizar la Matricula?", "ATENCION", JOptionPane.OK_CANCEL_OPTION);
					if (respuesta == JOptionPane.OK_OPTION) {
						presentacion.RealizarPagoPantalla p = new presentacion.RealizarPagoPantalla();
						p.setVisible(true);
						setVisible(false);
					}
				}
			}
		});
		btnRealizarMatricula.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRealizarMatricula.setBounds(373, 374, 185, 66);
		contentPane.add(btnRealizarMatricula);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Master", "Experto", "Especialista", "Formacion avanzada", "Formacion continua", "Microcredenciales", "Corta duracion", "Cursos de verano", "Formacion de mayores"}));
		comboBox.setBounds(112, 335, 231, 22);
		contentPane.add(comboBox);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == btnLimpiar) {
					textNombre.setText("");
					textApellido.setText("");
					textEspecificacion.setText("");
					textIdentificacion.setText("");
				}
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpiar.setBounds(373, 295, 185, 66);
		contentPane.add(btnLimpiar);
	}

}
