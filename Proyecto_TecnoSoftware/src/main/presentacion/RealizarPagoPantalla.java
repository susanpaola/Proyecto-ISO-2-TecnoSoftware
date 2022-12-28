package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RealizarPagoPantalla extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textNumero;
	private JTextField textCVV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarPagoPantalla frame = new RealizarPagoPantalla();
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
	public RealizarPagoPantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 392);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnTarjeta = new JRadioButton("Pago con Tarjeta");
		rdbtnTarjeta.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnTarjeta.setBounds(17, 125, 151, 34);
		contentPane.add(rdbtnTarjeta);
		
		JRadioButton rdbtnEfectivo = new JRadioButton("Pago en Efectivo");
		rdbtnEfectivo.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnEfectivo.setBounds(17, 18, 151, 34);
		contentPane.add(rdbtnEfectivo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(17, 176, 54, 22);
		contentPane.add(lblNombre);
		
		JLabel lblNumero = new JLabel("Numero tarjeta");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumero.setBounds(17, 209, 90, 22);
		contentPane.add(lblNumero);
		
		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCvv.setBounds(17, 242, 49, 14);
		contentPane.add(lblCvv);
		
		textNombre = new JTextField();
		textNombre.setBounds(113, 178, 240, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textNumero = new JTextField();
		textNumero.setBounds(113, 211, 240, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		textCVV = new JTextField();
		textCVV.setBounds(113, 240, 112, 20);
		contentPane.add(textCVV);
		textCVV.setColumns(10);
		
		JButton btnPagar = new JButton("Realizar Pago");
		btnPagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Hay que indicar en que radiobutton se realiza la funcion
				if(textNombre.getText().isEmpty() || textNumero.getText().isEmpty() || textCVV.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Procesandose pago", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		btnPagar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPagar.setBounds(157, 278, 128, 39);
		contentPane.add(btnPagar);
		
		JLabel lblanuncio = new JLabel("El pago se realizara de forma presencial en la administracion\r\n");
		lblanuncio.setBounds(30, 59, 385, 34);
		contentPane.add(lblanuncio);
		
		JLabel lblNewLabel = new JLabel("de la Universidad");
		lblNewLabel.setBounds(30, 84, 119, 22);
		contentPane.add(lblNewLabel);
	}
}
