package construccion4.construccion4.Controladores;

import construccion4.construccion4.Modelo.Autorizado;

public interface ControladorAutorizadoBusiness {
	
  	public String crearAutorizado( String nombreAutorizado, int cedulaAutorizado,int cedulaDelSocioPrincipal); 
  	
  	 Autorizado buscarAutorizado(int cedula) throws Exception;

    public String eliminar(Autorizado autorizado);
    public void validadorCedulaAutorizado(int cedula) throws Exception; //Valida si existe la persona

    

}