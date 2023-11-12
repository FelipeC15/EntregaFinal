package construccion4.construccion4.ControladoresImp;

import org.springframework.stereotype.Service;

@Service()
public class ControladorInput {

	protected int numeroValido(String string, String nombre) throws Exception {
		if(string==null || string.equals("")) {
			throw new Exception(nombre + " no puede ser vacio");
		}
		try {
			return Integer.parseInt(string);
		}catch(Exception e) {
			throw new Exception(nombre + " no es un numero valido");
		}
	}
	
	protected void stringVacio(String string, String nombre) throws Exception {
		if(string==null || string.equals("")) {
			throw new Exception(nombre + " no puede ser vacio");
		}
	}
	
	
	protected Long numeroLongValido(String string, String nombre) throws Exception {
	    if (string == null || string.equals("")) {
	        throw new Exception(nombre + " no puede ser vacio");
	    }
	    try {
	        return Long.parseLong(string);
	    } catch (Exception e) {
	        throw new Exception(nombre + " no es un número válido");
	    }
	}
}