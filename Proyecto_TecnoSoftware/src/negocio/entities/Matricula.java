package negocio.entities;

import java.util.Date;

public class Matricula {

	public Estudiante estudiante;
	public CursoPropio titulo;
	ModoPago tipoPago;
	private Date fecha;
	private boolean pagado;
	private int attribute;
	private int idMatricula;
	String idEstudiante;
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
	public String getIdTitulo() {
		return idTitulo;
	}
	public void setIdTitulo(String idTitulo) {
		this.idTitulo = idTitulo;
	}
	String idTitulo;
	
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public CursoPropio getTitulo() {
		return titulo;
	}
	public void setTitulo(CursoPropio titulo) {
		this.titulo = titulo;
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
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	public int getAttribute() {
		return attribute;
	}
	public void setAttribute(int attribute) {
		this.attribute = attribute;
	}

}