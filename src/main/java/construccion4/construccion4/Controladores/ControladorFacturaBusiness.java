package construccion4.construccion4.Controladores;

import java.util.List;

import construccion4.construccion4.Modelo.Factura;

public interface ControladorFacturaBusiness {
	


		public String crearFactura(Long id, int cedula, String concepto,double monto )throws Exception;

	    public List<Factura> buscarFactura(int cedula) throws Exception;



		public void pagarFactura(Long facturaId, int cedula) throws Exception;

	}