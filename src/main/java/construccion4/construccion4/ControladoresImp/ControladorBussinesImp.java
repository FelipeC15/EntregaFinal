	package construccion4.construccion4.ControladoresImp;
	
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import construccion4.construccion4.Controladores.ControladorAutorizadoBusiness;
import construccion4.construccion4.Controladores.ControladorFacturaBusiness;
import construccion4.construccion4.Controladores.ControladorSocioBusiness;
import construccion4.construccion4.Modelo.Autorizado;
import construccion4.construccion4.Modelo.Factura;
import construccion4.construccion4.Modelo.Socio;
import construccion4.construccion4.Repositories.AutorizadoRepository;
import construccion4.construccion4.Repositories.FacturaRepository;
import construccion4.construccion4.Repositories.SocioRepository;
	
	
	@Service()
	public class ControladorBussinesImp implements ControladorSocioBusiness, ControladorFacturaBusiness, ControladorAutorizadoBusiness{
		
		
		@Autowired
		private SocioRepository socioRepository;
	
		@Autowired
		private FacturaRepository facturaRepository;
	
		@Autowired
		private AutorizadoRepository autorizadoRepository;
		
		
	
		@Override
		public String crearCrearSocio(int cedula, String nombre, double fondos, String tipSuscripcion) {
			Socio socio = new Socio();
		    socio.setCedula(cedula);
		    socio.setNombre(nombre);
		    socio.setFondos(fondos);
		    socio.setTipSuscripcion(tipSuscripcion);
		    socioRepository.save(socio);
			return "se agrega persona con datos: " + socio.mostrarDatos();

		}
		
		
		
		
		
		
	
		@Override
		public Socio buscarSocio(int cedula) throws Exception {
			Socio encontrado = socioRepository.findBycedula(cedula);
			if (encontrado != null) {
				return encontrado;
			}
			throw new Exception("no existe socio con esa cedula registrada");
			
		}
	
		@Override
		public void validadorCedula(int cedula) throws Exception {
			boolean existe = socioRepository.existsBycedula(cedula);
			if (existe)
				throw new Exception("ya existe socio con esa cedula registrada");
			
		}
	
		@Override
		public String eliminar(Socio socio) {
			socioRepository.delete(socio);
			return "se elimino a la persona " + socio.mostrarDatos();

		}
	
		@Override
		public boolean agregarFondos(Socio socio, double cantidad) throws Exception {
			
			 if (socio != null) {
			        // 1. Busca al socio en la base de datos (puedes usar la función buscarSocio).
			        // Socio socioEncontrado = buscarSocio(socio.getCedula());

			        // 2. Actualiza el saldo de fondos del socio.
			        double saldoActual = socio.getFondos();
			        double nuevoSaldo = saldoActual + cantidad;
			        socio.setFondos(nuevoSaldo);

			        // 3. Guarda el socio actualizado en la base de datos.
			        socioRepository.save(socio);

			        System.out.println("Se agregaron " + cantidad + " fondos al socio con cédula " + socio.getCedula());
			        return true;
			    } else {
			        throw new Exception("No se puede agregar fondos a un socio nulo.");
			    }
			}

		@Override
		public List<Factura> buscarFactura(int cedula) throws Exception {
		
			    Socio socio = null;
			    Autorizado autorizado = null;
			    try {
			        socio = buscarSocio(cedula);
			        if (socio != null) {
			            return facturaRepository.findByCedula(cedula);
			        } else {
			            autorizado = buscarAutorizado(cedula);
			            if (autorizado != null) {
			              return facturaRepository.findByCedula(cedula);
			            } else {
			                throw new Exception("No se encontró una factura con la cedula " + cedula);
			            }
			        }
			    } catch (Exception e) {
			        throw new Exception("Error al buscar la factura: " + e.getMessage());
			    }
			}

			
		public void pagarFactura(Long facturaId, int cedula) throws Exception {
		    Socio socio = buscarSocio(cedula);
		    Autorizado autorizado = buscarAutorizado(cedula);

		    if (socio == null && autorizado == null) {
		        throw new Exception("No se puede encontrar la factura, persona no encontrada");
		    }

		    Factura factura = null;

		    if (socio != null) {
		        List<Factura> facturasSocio = facturaRepository.findByCedula(cedula);
		        for (Factura f : facturasSocio) {
		            if (f.getId() == facturaId) {
		                factura = f;
		                break;
		            }
		        }
		    } else if (autorizado != null) {
		        List<Factura> facturasAutorizado = facturaRepository.findByCedula(cedula);
		        for (Factura f : facturasAutorizado) {
		            if (f.getId() == facturaId) {
		                factura = f;
		                break;
		            }
		        }
		    }

		    if (factura != null) {
		        double monto = factura.getMonto();
		        if (socio.getFondos() >= monto) {
		            facturaRepository.delete(factura);
		            System.out.println("Se pagó la factura con id " + facturaId);
		            double fondosRestantes = socio.getFondos() - monto;
		            socio.setFondos(fondosRestantes);
		            socioRepository.save(socio);
		            System.out.println("Se descontó el valor de la factura de los fondos del socio.");
		        } else {
		            throw new Exception("El socio no tiene fondos suficientes para pagar la factura.");
		        }
		    } else {
		        throw new Exception("No se encontró la factura con el identificador especificado.");
		    }
		}

		@Override
		public String crearAutorizado(String nombreAutorizado, int cedulaAutorizado, int cedulaDelSocioPrincipal) {
		
				Autorizado autorizado = new Autorizado();
				autorizado.setNombre(nombreAutorizado);
			    autorizado.setCedula(cedulaAutorizado);
			    autorizado.setSocioPrincipal(cedulaDelSocioPrincipal);
			    socioRepository.save(autorizado);
				return "se agrega autorizado con datos: " + autorizado.mostrarDatos();

			}

		@Override
		public Autorizado buscarAutorizado(int cedula) throws Exception {
	
		
			Autorizado encontrado = autorizadoRepository.findBycedula(cedula);
				if (encontrado != null) {
					return encontrado;
				}
				throw new Exception("no existe socio con esa cedula registrada");
				
			}
			    
			
	

		@Override
		public String eliminar(Autorizado autorizado) {
			autorizadoRepository.delete(autorizado);
			return "se elimino a la persona " + autorizado.mostrarDatos();

		}
		//agregar a la interfaz
		public void registrarSocio(String nombre, int cedula, String tipoSuscripcion, double fondos) throws Exception {
			this.validadorCedula(cedula);
			this.crearCrearSocio(cedula, nombre, fondos, tipoSuscripcion);
			
		}
		//agregar a la interfaz
		public void registrarAutorizado(String nombre, int cedula, int cedulaSocio) throws Exception {
			this.validadorCedula(cedula);
			this.buscarSocio(cedulaSocio);
			this.crearAutorizado(nombre, cedula, cedulaSocio);
			
		}
		@Override
		public String crearFactura(Long id, int cedula, String concepto, double monto) throws Exception {
		    Socio socio = buscarSocio(cedula);
		    Autorizado autorizado = buscarAutorizado(cedula);

		    if (socio == null && autorizado == null) {
		        throw new Exception("No se puede agregar factura, persona no encontrada");
		    }

		    Factura factura = new Factura();
		    factura.setId(id);
		    factura.setCedula(cedula);
		    factura.setConcepto(concepto);
		    factura.setMonto(monto);

		    if (socio != null) {
		        List<Factura> facturasSocio = facturaRepository.findByCedula(cedula);
		        if (socio.getFondos() >= monto) {
		            if (facturasSocio.size() >= 20) {
		                throw new Exception("El socio ha alcanzado el máximo de facturas sin pagar");
		            }
		            double fondosRestantes = socio.getFondos() - monto;
		            socio.setFondos(fondosRestantes);
		            socioRepository.save(socio);
		        } else {
		            throw new Exception("El socio no tiene fondos suficientes para realizar el consumo.");
		        }
		    } else if (autorizado != null) {
		        List<Factura> facturasAutorizado = facturaRepository.findByCedula(cedula);
		        if (autorizado.getFondos() >= monto) {
		            if (facturasAutorizado.size() >= 10) {
		                throw new Exception("El autorizado ha alcanzado el máximo de facturas sin pagar");
		            }
		            double fondosRestantes = autorizado.getFondos() - monto;
		            autorizado.setFondos(fondosRestantes);
		            autorizadoRepository.save(autorizado);
		        } else {
		            throw new Exception("El autorizado no tiene fondos suficientes para realizar el consumo.");
		        }
		    }

		    facturaRepository.save(factura);
			return "Se agrega factura con datos: " + factura.mostrarDatos();

		}
		/*@Override
		public void crearFactura(Long id, int cedula, String concepto, double monto) {
			Socio socio = buscarSocio(cedula);
			Autorizado autorizado = buscarAutorizado(cedula);
			
			List<Factura> facturas = facturaRepository.findByPersona(socio);
			if (facturas.size() == socio.getLimiteFacturas() ||facturas.size() == autorizado.getLimiteFacturas() ) {
				throw new Exception("esta persona no puede tener mas facturas");
			} 
			if (socio == null || autorizado == null  ) {
		            throw new Exception("No se puede agregar factura, persona no encontrada");
		        }
			  
		       
		        	  Factura factura = new Factura();
		        		factura.setId(id);
		    			factura.setCedula(cedula);
		    			factura.setConcepto(concepto);
		    			factura.setMonto(monto);
		    			  
		    			facturaRepository.save(factura);
		    			
	
		            
		            facturaRepository.save(factura); 
					System.out.println("se agrega socio con datos: " + factura.mostrarDatos());

		}*/







		@Override
		public void validadorCedulaAutorizado(int cedula) throws Exception {
			boolean existe = autorizadoRepository.existsBycedula(cedula);
			if (existe)
				throw new Exception("ya existe autorizado con esa cedula registrada");
			
			
		}





	
		}