package main.negocio.entities;

import java.time.LocalDate;
import java.util.Date;

public class Materia {

	Profesor responsable;
	String responsable2;
	private String nombre;
	private double horas;
	private String fechaInicio;
	private String fechaFin;
	private int curso;
	
	public Materia(Profesor responsable, String nombre, double horas, String fechaInicio, String fechaFin, int curso) {
		super();
		this.responsable = responsable;
		this.nombre = nombre;
		this.horas = horas;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.curso = curso;
	}
	
	public Materia(String responsable, String nombre, int horas, LocalDate of, LocalDate of2, int curso) {
		// TODO Auto-generated constructor stub
		super();
		this.responsable2 = responsable;
		this.nombre = nombre;
		this.horas = horas;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.curso = curso;
	}

	public Profesor getResponsable() {
		return responsable;
	}
	
	public void setResponsable(Profesor responsable) {
		this.responsable = responsable;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getHoras() {
		return horas;
	}
	
	public void setHoras(double horas) {
		this.horas = horas;
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public String getFechaFin() {
		return fechaFin;
	}
	
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public int getCurso() {
		return curso;
	}
	
	public void setCurso(int curso) {
		this.curso = curso;
	}
}