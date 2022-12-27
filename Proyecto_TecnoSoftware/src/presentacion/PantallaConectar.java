package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import persistencia.GestorBD;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Cursor;

public class PantallaConectar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaConectar frame = new PantallaConectar();
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
	public PantallaConectar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\IconUCLM.png"));
		setTitle("UCLM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 385);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\ImagenUCLM.png"));
		lblNewJgoodiesLabel.setBounds(10, 10, 310, 99);
		contentPane.add(lblNewJgoodiesLabel);
		
		
		
		JButton conectBtn = new JButton("ENTRAR");
		conectBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		conectBtn.setForeground(Color.WHITE);
		conectBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		conectBtn.setBackground(SystemColor.textHighlight);
		conectBtn.setBounds(141, 172, 274, 113);
		contentPane.add(conectBtn);
	conectBtn.addActionListener((ActionListener) new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			try {
				GestorBD.connect();
				presentacion.PantallaLogin p = new presentacion.PantallaLogin();
				p.mostrar();
				setVisible(false);
				
			} catch (Exception ea) {
				JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos. Revise sus datos de conexión", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
}
});
	}
}
