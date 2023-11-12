package construccion4.construccion4.ControladoresRequest;

public class RegistroSocioRequest {

	private String nombre;
	private String cedula;
	
	private String tipSuscripcion;
	private String fondos;
	
	
	
	public String getTipSuscripcion() {
		return tipSuscripcion;
	}
	public void setTipSuscripcion(String tipSuscripcion) {
		this.tipSuscripcion = tipSuscripcion;
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