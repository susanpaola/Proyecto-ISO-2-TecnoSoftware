package negocio.controllers;

import java.text.*;
import java.time.*;
import java.util.*;
import negocio.entities.*;

public class GestorPropuestasCursos {

	public CursoPropio realizarPropuestaCurso() {
		// TODO - implement GestorPropuestasCursos.realizarPropuestaCurso
		//throw new UnsupportedOperationException();
		System.out.print("Propuesta de curso realizada");
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
			System.out.print("Inserta parámetro que desea editar:\n"
					+ "	1.- (String) id\n"
					+ " 2.- (String) nombre\n"
					+ " 3.- (int= ECTS\n"
					+ " 4.- (Date) fechaInicio\n"
					+ " 5.- (Date) fechaFin\n"
					+ " 6.- (double) tasaMatricula\n"
					+ " 7.- (int) edicion\n"
			);
			
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
				System.out.println("Introduce la tasa de matrícula que desee: ");
				entradaTeclado = entradaEscaner.nextLine ();
				curso.setTasaMatricula(Double.parseDouble(entradaTeclado));
				seguir = preguntaContinuacion();
			} else if (entradaTeclado.equals("edicion")) {
				System.out.println("Introduce la edición que desee: ");
				entradaTeclado = entradaEscaner.nextLine ();
				curso.setEdicion(Integer.parseInt(entradaTeclado)); 
				seguir = preguntaContinuacion();
			} else {
				System.out.println("Opción no válida, introduce una que no lo sea");
			}
		}
	}

	/**
	 * 
	 * @param curso
	 */
	public EstadoCurso evaluarPropuesta(CursoPropio curso) {
		// TODO - implement GestorPropuestasCursos.evaluarPropuesta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param curso
	 */
	public void altaCursoAprobado(CursoPropio curso) {
		// TODO - implement GestorPropuestasCursos.altaCursoAprobado
		throw new UnsupportedOperationException();
	}
	
	public boolean preguntaContinuacion() {
		boolean pregunta = false;
		System.out.println("¿Desea editar más valores? (Introduzca S para sí | N para no)");
		Scanner entradaEscaner = new Scanner (System.in);
		String entradaTeclado = entradaEscaner.nextLine();
		
		if (entradaTeclado.equals("S")) {
			pregunta = true;
		}
		return pregunta;
	}
}