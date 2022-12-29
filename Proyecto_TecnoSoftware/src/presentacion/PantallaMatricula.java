package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import negocio.entities.Matricula;
import persistencia.GestorBD;
import persistencia.MatriculaDAO;
import persistencia.CursoPropioDAO;

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
	PantallaRealizarPropuesta p = new PantallaRealizarPropuesta();

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

		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
		lblNewJgoodiesLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\git\\PROYECTOS_GIT\\TecnoSoftware\\Proyecto-ISO-2-TecnoSoftware\\Proyecto_TecnoSoftware\\Imagenes\\ImagenUCLM.png"));
		lblNewJgoodiesLabel.setBounds(20, 10, 310, 99);
		contentPane.add(lblNewJgoodiesLabel);
		
		Vector<Object> a = cDAO.seleccionarCursos("SELECT id,nombre,ECTS,centro,director,tipo,tasa FROM CursoPropio WHERE `estado`= 'VALIDADO'");
		DefaultListModel listModel;
		listModel = new DefaultListModel();
		JList list = new JList(listModel);
	
		list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
        
                	btnTar.addActionListener((ActionListener) new ActionListener() {
            			public void actionPerformed(ActionEvent e) { 
            				LocalDate miFecha = LocalDate.now();
            				PantallaDireccionCursos d = new PantallaDireccionCursos();
            			
        Matricula m= new Matricula(d.devolverDNI("Samuel") ,a.get(0).toString().split(",")[1] , "TARJETA_CREDITO", miFecha, 0);
            				
        String insert = "INSERT INTO Matricula"
        			                + "(id, tipoPago, titulo, estudiante, pagado, fecha ) VALUES"
        			                + "('"+p.numRand()+"','"+m.getTipoPago()+"','"+m.getTitulo()+"','"+m.getEstudiante()+"','"+m.isPagado()+"','"+m.getFecha()+"')";
        					if (mDAO.insertMatricula(insert)==1) {
        						JOptionPane.showMessageDialog(null, "Se ha matriculado en el curso de forma correcta.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        					PantallaEstudiante est = new PantallaEstudiante();
        					est.setVisible(true);
        					setVisible(false);
        					}
            				
                	}});
                	btnTrans.addActionListener((ActionListener) new ActionListener() {
            			public void actionPerformed(ActionEvent e) {
            				LocalDate miFecha = LocalDate.now();
            				PantallaDireccionCursos d = new PantallaDireccionCursos();
                			
            		        Matricula m= new Matricula(d.devolverDNI("Samuel") ,a.get(0).toString().split(",")[1] , "TRANSFERENCIA", miFecha, 0);
            		            				
            		        String insert = "INSERT INTO Matricula"
            		        			                + "(id, tipoPago, titulo, estudiante, pagado, fecha ) VALUES"
            		        			                + "('"+p.numRand()+"','"+m.getTipoPago()+"','"+m.getTitulo()+"','"+m.getEstudiante()+"','"+m.isPagado()+"','"+m.getFecha()+"')";
            		        					if (mDAO.insertMatricula(insert)==1) {
            		        						JOptionPane.showMessageDialog(null, "Se ha matriculado en el curso de forma correcta.", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            		        					PantallaEstudiante est = new PantallaEstudiante();
            		        					est.setVisible(true);
            		        					setVisible(false);
            		        					}
            				}});
                	
                	btnTar.show();
                	btnTrans.show();
                if (listModel.size()==0) {
                	presentacion.PantallaEmpleadosVicerrectorado p = new presentacion.PantallaEmpleadosVicerrectorado();
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

}
