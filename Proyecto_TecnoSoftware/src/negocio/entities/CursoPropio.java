package negocio.entities;

import java.util.*;
import persistencia.*;

public class CursoPropio {

	Collection<Matricula> matriculas;
	String centro;
	String director;
	EstadoCurso estado;
	String tipo;
	CursoPropioDAO cursoPropioDao;
	private int id;
	private String nombre;
	private int ECTS;
	private Date fechaInicio;
	private Date fechaFin;
	private double tasaMatricula;
	private int edicion;
	
	
	
	public CursoPropio(String centro, String director, String tipo, int id, String nombre,int ects, double tasaMatricula, int edicion) {
		this.centro = centro;
		this.director = director;
		this.tipo = tipo;
		this.id = id;
		this.nombre = nombre;
		this.ECTS= ects;
		this.tasaMatricula = tasaMatricula;
		this.edicion = edicion;
	}

	
	public CursoPropio(String director, String tipo, int id, String nombre, int eCTS, Date fechaInicio, Date fechaFin,
			double tasaMatricula, int edicion) {
		super();
		this.director = director;
		this.tipo = tipo;
		this.id = id;
		this.nombre = nombre;
		ECTS = eCTS;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tasaMatricula = tasaMatricula;
		this.edicion = edicion;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getECTS() {
		return ECTS;
	}

	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getTasaMatricula() {
		return tasaMatricula;
	}

	public void setTasaMatricula(double tasaMatricula) {
		this.tasaMatricula = tasaMatricula;
	}

	public int getEdicion() {
		return edicion;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	@Override
	public String toString() {
		return "CursoPropio [director=" + director + ", tipo=" + tipo + ", id=" + id
				+ ", nombre=" + nombre + ", ECTS=" + ECTS + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", tasaMatricula=" + tasaMatricula + ", edicion=" + edicion + "]";
	}
}