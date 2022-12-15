package negocio.controllers;

import java.awt.*;
import java.text.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import negocio.entities.*;

public class GestorPropuestasCursos extends JFrame{

	// Terminado
	public CursoPropio realizarPropuestaCurso() {
		// TODO - implement GestorPropuestasCursos.realizarPropuestaCurso
		//throw new UnsupportedOperationException();
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Propuesta de curso realizada");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(60, 112, 581, 75);
		contentPanel.add(lblNewLabel);
		CursoPropio propuesta = new CursoPropio();
		return propuesta;
	}

	/**
	 * 
	 * @param curso
	 */
	public void editarPropuestaCurso(CursoPropio curso) {
		// TODO - implement GestorPropuestasCursos.editarPropuestaCurso
		//throw new UnsupportedOperationException();
		Scanner entradaEscaner = new Scanner (System.in);
		String entradaTeclado = "";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		boolean seguir = true;
		while (seguir) {
			
			//Método Menu
			entradaTeclado = entradaEscaner.nextLine ();
			
			if (entradaTeclado.equals("id")) {
				System.out.println("Introduzca el id que desee: ");
				entradaTeclado = entradaEscaner.nextLine ();
				curso.setId(entradaTeclado);
				seguir = preguntaContinuacion();
			} else if (entradaTeclado.equals("nombre")) {
				System.out.println("Introduzca el nombre que desee: ");
				entradaTeclado = entradaEscaner.nextLine ();
				curso.setNombre(entradaTeclado);
				seguir = preguntaContinuacion();
			} else if (entradaTeclado.equals("ECTS")) {
				System.out.println("Introduzca el ECTS que desee: ");
				entradaTeclado = entradaEscaner.nextLine ();
				curso.setECTS(Integer.parseInt(entradaTeclado));
				seguir = preguntaContinuacion();
			} else if (entradaTeclado.equals("fechaInicio")) {
				System.out.println("Introduzca la fecha de inicio que desee: ");
				entradaTeclado = entradaEscaner.nextLine ();
				try {
					fecha = formato.parse(entradaTeclado);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				curso.setFechaInicio(fecha);
				seguir = preguntaContinuacion();
			} else if (entradaTeclado.equals("fechaFin")) {
				System.out.println("Introduzca la fecha de fin que desee: ");
				entradaTeclado = entradaEscaner.nextLine ();
				try {
					fecha = formato.parse(entradaTeclado);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				curso.setFechaFin(fecha);
				seguir = preguntaContinuacion();
			} else if (entradaTeclado.equals("tasaMatricula")) {
				System.out.println("Introduce la tasa de matr�cula que desee: ");
				entradaTeclado = entradaEscaner.nextLine ();
				curso.setTasaMatricula(Double.parseDouble(entradaTeclado));
				seguir = preguntaContinuacion();
			} else if (entradaTeclado.equals("edicion")) {
				System.out.println("Introduce la edici�n que desee: ");
				entradaTeclado = entradaEscaner.nextLine ();
				curso.setEdicion(Integer.parseInt(entradaTeclado)); 
				seguir = preguntaContinuacion();
			} else {
				//Método invalid option
			}
		}
	}

	/**
	 * 
	 * @param curso
	 */
	public EstadoCurso evaluarPropuesta(CursoPropio curso) {
		// TODO - implement GestorPropuestasCursos.evaluarPropuesta
		//throw new UnsupportedOperationException();
		return null;
	}

	/**
	 * 
	 * @param curso
	 */
	public void altaCursoAprobado(CursoPropio curso) {
		// TODO - implement GestorPropuestasCursos.altaCursoAprobado
		// throw new UnsupportedOperationException();
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Curso dado de alta");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setBounds(60, 112, 581, 75);
		contentPanel.add(lblNewLabel);
		// Insertar curso de la base de datos (PENDIENTE)
	}
	
	public boolean preguntaContinuacion() {
		boolean pregunta = false;
		System.out.println("¿Desea editar mas valores? (Introduzca S para si | N para no)");
		Scanner entradaEscaner = new Scanner (System.in);
		String entradaTeclado = entradaEscaner.nextLine();
		
		if (entradaTeclado.equals("S")) {
			pregunta = true;
		}
		return pregunta;
	}
}