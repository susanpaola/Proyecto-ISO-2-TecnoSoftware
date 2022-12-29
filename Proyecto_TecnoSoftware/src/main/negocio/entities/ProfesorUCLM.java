package main.negocio.entities;

public class ProfesorUCLM extends Profesor {

	Centro centroAdscripcion;
	CategoriaProfesor categoria;
	private String nombre;
	private String apellidos;
	private String dni;
	
	public ProfesorUCLM(String dni, String nombre, String apellidos, boolean doctor, Centro centroAdscripcion,
			CategoriaProfesor categoria, String nombre2, String apellidos2, String dni2) {
		super(dni, nombre, apellidos, doctor);
		this.centroAdscripcion = centroAdscripcion;
		this.categoria = categoria;
		nombre = nombre2;
		apellidos = apellidos2;
		dni = dni2;
	}
	public Centro getCentroAdscripcion() {
		return centroAdscripcion;
	}
	public void setCentroAdscripcion(Centro centroAdscripcion) {
		this.centroAdscripcion = centroAdscripcion;
	}
	public CategoriaProfesor getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaProfesor categoria) {
		this.categoria = categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	

}