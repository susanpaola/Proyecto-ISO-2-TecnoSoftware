package negocio.entities;

import java.util.*;
import persistencia.*;

public class CursoPropio {

<<<<<<< HEAD
	Collection<Matricula> matriculas;
	String centro;
	String director;
	String estado;
	String tipo;
	CursoPropioDAO cursoPropioDao;
=======
	private Collection<Matricula> matriculas;
	private String centro;
	private String director;
	private String secretario;
	private Collection<Materia> materias;
	private EstadoCurso estado;
	private TipoCurso tipo;
>>>>>>> refs/heads/Feature-GestorConsultas
	private int id;
	private String nombre;
	private int ECTS;
<<<<<<< HEAD
	private String fechaInicio;
=======
	private String fechaIni;
>>>>>>> refs/heads/Feature-GestorConsultas
	private String fechaFin;
	private double tasaMatricula;
	private int edicion;
	
<<<<<<< HEAD
	
	public CursoPropio(String centro,String director, String tipo, int id, String nombre, int eCTS, String fechaInicio, String fechaFin,
			double tasaMatricula, int edicion,String estado ) {
		super();
		this.director = director;
		this.tipo = tipo;
		this.centro = centro;
		this.id = id;
		this.nombre = nombre;
		this.ECTS = eCTS;
		this.estado=estado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tasaMatricula = tasaMatricula;
		this.edicion = edicion;
	}


	public String getCentro() {
		return centro;
	}


	public void setCentro(String centro) {
		this.centro = centro;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

=======
	public CursoPropio(int id, String nombre, int ECTS, String fechaIni, String fechaFin, double tasa, int edicion, String centro, String director, String secretario, EstadoCurso estado, TipoCurso tipo) {
		this.id = id;
		this.nombre = nombre,
		this.ECTS = ECTS;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.tasaMatricula = tasa;
		this.edicion = edicion;
		this.centro = centro;
		this.director = director;
		this.secretario = secretario;
		this.estado = estado;
		this.tipo = tipo;
	}
	
>>>>>>> refs/heads/Feature-GestorConsultas
	public int getId() {
		return id;
	}
<<<<<<< HEAD

=======
	
>>>>>>> refs/heads/Feature-GestorConsultas
	public void setId(int id) {
		this.id = id;
	}
<<<<<<< HEAD

=======
	
>>>>>>> refs/heads/Feature-GestorConsultas
	public String getNombre() {
		return nombre;
	}
<<<<<<< HEAD

=======
	
>>>>>>> refs/heads/Feature-GestorConsultas
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
<<<<<<< HEAD

=======
	
>>>>>>> refs/heads/Feature-GestorConsultas
	public int getECTS() {
		return ECTS;
	}
<<<<<<< HEAD

=======
	
>>>>>>> refs/heads/Feature-GestorConsultas
	public void setECTS(int eCTS) {
		this.ECTS = eCTS;
	}
<<<<<<< HEAD



	public String getFechaInicio() {
		return fechaInicio;
=======
	
	public String getFechaInicio() {
		return fechaIni;
>>>>>>> refs/heads/Feature-GestorConsultas
	}
<<<<<<< HEAD


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
=======
	
	public void setFechaInicio(String fechaInicio) {
		this.fechaIni = fechaInicio;
>>>>>>> refs/heads/Feature-GestorConsultas
	}
<<<<<<< HEAD


=======
	
>>>>>>> refs/heads/Feature-GestorConsultas
	public String getFechaFin() {
		return fechaFin;
	}
<<<<<<< HEAD


=======
	
>>>>>>> refs/heads/Feature-GestorConsultas
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
<<<<<<< HEAD


=======
	
>>>>>>> refs/heads/Feature-GestorConsultas
	public double getTasaMatricula() {
		return tasaMatricula;
	}
<<<<<<< HEAD

=======
	
>>>>>>> refs/heads/Feature-GestorConsultas
	public void setTasaMatricula(double tasaMatricula) {
		this.tasaMatricula = tasaMatricula;
	}
<<<<<<< HEAD

=======
	
>>>>>>> refs/heads/Feature-GestorConsultas
	public int getEdicion() {
		return edicion;
	}
<<<<<<< HEAD

=======
	
>>>>>>> refs/heads/Feature-GestorConsultas
	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}
<<<<<<< HEAD


	@Override
	public String toString() {
		return "CursoPropio [centro=" + centro + ", director=" + director + ", estado=" + estado + ", tipo=" + tipo
				+ ", id=" + id + ", nombre=" + nombre + ", ECTS=" + ECTS + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", tasaMatricula=" + tasaMatricula + ", edicion=" + edicion + "]";
	}




}
=======
	
	public String getCentro() {
		return centro;
	}
	
	public void setCentro(String centro) {
		this.centro = centro;
	}
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public String getSecretario() {
		return secretario;
	}
	
	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}
	
	public EstadoCurso getEstadoCurso() {
		return estado;
	}
	
	public void setEstadoCurso(EstadoCurso estado) {
		this.estado = estado;
	}
	
	public TipoCurso getTipoCurso() {
		return tipo;
	}
	
	public void setTipoCurso(TipoCurso tipo) {
		this.tipo = tipo;
	}
}
>>>>>>> refs/heads/Feature-GestorConsultas
