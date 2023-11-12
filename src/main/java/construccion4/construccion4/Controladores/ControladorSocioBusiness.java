package construccion4.construccion4.Controladores;

import construccion4.construccion4.Modelo.Socio;




public interface ControladorSocioBusiness {
  //creada  29-10
    
	public String crearCrearSocio(int cedula, String nombre, double fondos, String tipSuscripcion); 

    public Socio buscarSocio(int cedula) throws Exception;
    
    public void validadorCedula(int cedula) throws Exception; //Valida si existe la persona
    
    public String eliminar(Socio socio);
    
    
    
    
    
    
    public boolean agregarFondos(Socio socio, double cantidad) throws Exception; //agregar fondos
 //   public boolean procesarConsumo(Socio socio, double valor) throws Exception;  //realiza consumo 

  


}