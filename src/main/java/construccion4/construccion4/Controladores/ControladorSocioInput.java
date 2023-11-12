package construccion4.construccion4.Controladores;

public interface ControladorSocioInput {

	   public String validarTipSuscripcion(String tipSuscripcion) throws Exception;
	    public String validarNombre(String nombre) throws Exception;

	    public int validarCedula(String cedula) throws Exception;

	    public double validarFondos(String fondos) throws Exception;

	}