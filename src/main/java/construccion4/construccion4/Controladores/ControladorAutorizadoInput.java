package construccion4.construccion4.Controladores;

public interface ControladorAutorizadoInput {
	
	public String validarNombreAutorizado(String nombre) throws Exception;
	public int validarCedulaAutorizado(String cedula) throws Exception;
	public int cedulaDelSocioPrincipal(String cedulaDelSocioPrincipal) throws Exception;
	
}
	
	

