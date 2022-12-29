package main.negocio.entities;

import java.util.Date;

public class Matricula {
	private static ModoPago tipoPago;
	private String fecha;
	private boolean pagado;
	private int atributo;
	private int idMatricula;
	private int idTitulo;
	private String idEstudiante;
	
	public Matricula(int idMatricula, String fecha, boolean pagado, int atributo, ModoPago tipoPago, int idTitulo, String idEstudiante) {
		this.idEstudiante = idEstudiante;
		this.idTitulo = idTitulo;
		this.tipoPago = tipoPago;
		this.fecha = fecha;
		this.pagado = pagado;
		this.idMatricula = idMatricula;
		this.atributo = atributo;
	}
	
	public int getIdMatricula() {
		return idMatricula;
	}
	
	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}
	
	public String getIdEstudiante() {
		return idEstudiante;
	}
	
	public void setIdEstudiante(String idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
	public int getIdTitulo() {
		return idTitulo;
	}
	
	public void setIdTitulo(int idTitulo) {
		this.idTitulo = idTitulo;
	}
	
	public ModoPago getTipoPago() {
		return tipoPago;
	}
	
	public void setTipoPago(ModoPago tipoPago) {
		this.tipoPago = tipoPago;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public boolean isPagado() {
		return pagado;
	}
	
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
	public int getAtributo() {
		return atributo;
	}
	
	public void setAtributo(int atributo) {
		this.atributo = atributo;
	}
}