package construccion4.construccion4.ControladoresRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import construccion4.construccion4.Controladores.ControladorAutorizadoBusiness;
import construccion4.construccion4.Controladores.ControladorAutorizadoInput;
import construccion4.construccion4.Controladores.ControladorFacturaBusiness;
import construccion4.construccion4.Controladores.ControladorFacturaInput;
import construccion4.construccion4.Controladores.ControladorSocioBusiness;
import construccion4.construccion4.Controladores.ControladorSocioInput;
import construccion4.construccion4.Modelo.Autorizado;
import construccion4.construccion4.Modelo.Socio;

@RestController
public class ControladorRest {

	

		@Autowired()
		private ControladorSocioBusiness controladorSocioBusiness;
		@Autowired()
		private ControladorFacturaBusiness controladorFacturaBusiness;
		@Autowired()

		private ControladorAutorizadoBusiness controladorAutorizadoBusiness;
		@Autowired()
		private ControladorAutorizadoInput controladorAutorizadoInput;
		@Autowired()
		private ControladorSocioInput controladorSocioInput;

		@Autowired()
		private ControladorFacturaInput controladorFacturaInput;

		@GetMapping("/")
			public String vive() {
				return "Funcionando";
			
		
		}

		@PostMapping("/socio")
		public ResponseEntity<String> registrarSocio(@RequestBody RegistroSocioRequest request) {
			try {
				String nombre = controladorSocioInput.validarNombre(request.getNombre());
				int cedula = controladorSocioInput.validarCedula(request.getCedula());
				double fondos = controladorSocioInput.validarFondos(request.getFondos());
				String tipSuscripcion = controladorSocioInput.validarTipSuscripcion(request.getTipSuscripcion());
				
				controladorSocioBusiness.validadorCedula(cedula);
				
				String response = controladorSocioBusiness.crearCrearSocio(cedula, nombre, fondos, tipSuscripcion);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
		
		@PostMapping("/autorizado")
		public ResponseEntity<String> registrarAutorizado(@RequestBody RegistroSocioRequest request) {
			try {
				String nombreAutorizado = controladorAutorizadoInput.validarNombreAutorizado(request.getNombre());
				int cedulaAutorizado = controladorAutorizadoInput.validarCedulaAutorizado(request.getCedula());
				int cedulaDelSocioPrincipal = controladorAutorizadoInput.cedulaDelSocioPrincipal(request.getCedula());

				controladorAutorizadoBusiness.validadorCedulaAutorizado(cedulaAutorizado);
				
				String response = controladorAutorizadoBusiness.crearAutorizado(nombreAutorizado, cedulaAutorizado, cedulaDelSocioPrincipal);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
		
		
		@DeleteMapping("/socio")
		public ResponseEntity<String> eliminarSocio(@RequestParam String id) {
			try {
				int cedula = controladorSocioInput.validarCedula(id);
				Socio socio = controladorSocioBusiness.buscarSocio(cedula);
				String response = controladorSocioBusiness.eliminar(socio);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
		
		@DeleteMapping("/autorizado")
		public ResponseEntity<String> eliminarPersona(@RequestParam String id) {
			try {
				int cedula = controladorAutorizadoInput.validarCedulaAutorizado(id);
				Autorizado autorizado = controladorAutorizadoBusiness.buscarAutorizado(cedula);
				String response = controladorAutorizadoBusiness.eliminar(autorizado);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}

		
	/*
		
		@PostMapping("/factura")
		public ResponseEntity<String>  registrarFactura(@RequestBody RegistroFacturaRequest request) {
		    try {
		        Long id = controladorFacturaInput.validarLongIdentificador(request.getId());
		        int cedula = controladorSocioInput.validarCedula(request.getCedula());
		        String concepto = request.getConcepto();
		        double monto =  request.getMonto();

		        String response = controladorFacturaBusiness.crearFactura(id, cedula, concepto, monto);
		        return new ResponseEntity<>(response, HttpStatus.OK);
		    } catch (Exception e) {
		        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		    }
		}

		
		@DeleteMapping("/factura")
		public ResponseEntity<String> eliminarFactura(@RequestParam Long facturaId,@RequestParam int cedula ) {
		    try {
		        facturaId = controladorFacturaInput.validarLongIdentificador(facturaId);
		        cedula = controladorSocioInput.validarCedula(cedula);  //validar si es numerica 

		        // Lógica para pagar la factura
				String response =   controladorFacturaBusiness.pagarFactura(facturaId, cedula);
				return new ResponseEntity<>(response, HttpStatus.OK);

		    } catch (Exception e) {
		        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		    }
		} */
		
		
	
		  
	}