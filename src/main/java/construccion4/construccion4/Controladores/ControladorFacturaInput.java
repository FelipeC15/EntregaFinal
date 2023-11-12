package construccion4.construccion4.Controladores;




public interface ControladorFacturaInput {

	public String validarNombreFactura(String nombre) throws Exception;


	public int validarCantidad(String cantidad) throws Exception;

	public Long validarLongIdentificador(String facturaId) throws Exception ;

}