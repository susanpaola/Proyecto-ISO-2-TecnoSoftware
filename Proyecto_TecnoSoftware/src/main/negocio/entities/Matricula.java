package main.negocio.entities;

import java.util.Date;

public class Matricula {
	private static ModoPago tipoPago;
	private Date fecha;
	private boolean pagado;
	private String atributo;
	private int idMatricula;
	private int idTitulo;
	private String idEstudiante;
	
	public Matricula() {
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
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date date) {
		this.fecha = date;
	}
	
	public boolean isPagado() {
		return pagado;
	}
	
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
	public String getAtributo() {
		return atributo;
	}
	
	public void setAtributo(String string) {
		this.atributo = string;
	}
}