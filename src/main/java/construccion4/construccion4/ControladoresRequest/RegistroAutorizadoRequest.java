package construccion4.construccion4.ControladoresRequest;

public class RegistroAutorizadoRequest {

	private int socioPrincipal;

	private String nombre;
	private String cedula;

	private String fondos;

	public int getSocioPrincipal() {
		return socioPrincipal;
	}

	public void setSocioPrincipal(int socioPrincipal) {
		this.socioPrincipal = socioPrincipal;
	}

	public String getFondos() {
		return fondos;
	}

	public void setFondos(String fondos) {
		this.fondos = fondos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}