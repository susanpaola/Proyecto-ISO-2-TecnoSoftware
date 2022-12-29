package negocio.entities;

import java.time.LocalDate;
import java.util.Date;

public class Matricula {
	String titulo;
	String tipoPago;
	private LocalDate fecha;
	private int pagado;
	private int attribute;
	String estudiante;
	public Matricula(String estudiante, String titulo, String tipoPago, LocalDate miFecha, int pagado) {
		super();
		this.estudiante = estudiante;
		this.titulo = titulo;
		this.tipoPago = tipoPago;
		this.fecha = miFecha;
		this.pagado = pagado;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int isPagado() {
		return pagado;
	}
	public void setPagado(int pagado) {
		this.pagado = pagado;
	}
	public String getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}
	@Override
	public String toString() {
		return "Matricula [titulo=" + titulo + ", tipoPago=" + tipoPago + ", fecha=" + fecha + ", pagado=" + pagado
				+ ", estudiante=" + estudiante + "]";
	}
	

}