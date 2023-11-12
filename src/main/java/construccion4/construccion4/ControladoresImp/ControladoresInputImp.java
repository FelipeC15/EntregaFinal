package construccion4.construccion4.ControladoresImp;

import org.springframework.stereotype.Service;

import construccion4.construccion4.Controladores.ControladorAutorizadoInput;
import construccion4.construccion4.Controladores.ControladorFacturaInput;
import construccion4.construccion4.Controladores.ControladorSocioInput;

@Service()


public class ControladoresInputImp  extends ControladorInput implements ControladorAutorizadoInput,ControladorSocioInput, ControladorFacturaInput {

	@Override
	public String validarNombreAutorizado(String nombre) throws Exception {
		super.stringVacio(nombre, "nombre persona");
		return nombre;
	}

	@Override
	public int validarCedulaAutorizado(String cedula) throws Exception {
		return super.numeroValido(cedula, "cedula persona");
	}

	@Override
	public int cedulaDelSocioPrincipal(String cedulaDelSocioPrincipal) throws Exception {
		 
		return super.numeroValido(cedulaDelSocioPrincipal, "cedul Autorizado");

		}

	@Override
	public String validarTipSuscripcion(String tipSuscripcion) throws Exception {
		super.stringVacio(tipSuscripcion, "tipo Suscripcion");
		if(! tipSuscripcion.equals("Regular") || tipSuscripcion.equals("Vip"))
			throw new Exception("el rol debe ser administrativo, profesor o estudiante");
		return tipSuscripcion;
	}

	@Override
	public String validarNombre(String nombre) throws Exception {
		super.stringVacio(nombre, "nombre persona");
		return nombre;
	}

	@Override
	public int validarCedula(String cedula) throws Exception {
		return super.numeroValido(cedula, "cedul Autorizado");
	}

	@Override
	public double validarFondos(String fondos) throws Exception {
		return super.numeroValido(fondos, "Cantidad Fondos");
	}

	@Override
	public String validarNombreFactura(String validarNombreFactura) throws Exception {
		super.stringVacio(validarNombreFactura, "validar Nombre Factura");
		return validarNombreFactura;
	}

	

	@Override
	public int validarCantidad(String validarCantidad) throws Exception {
		return super.numeroValido(validarCantidad, "cantidad factura");
	}

	
	
	
	
	public Long validarLongIdentificador(String facturaId) throws Exception {
		return super.numeroLongValido(facturaId, "validar Identificador");
	}

	
	
	
	
	
	
	
}
	
	
	
	

	
	
	
	
	
	
	

