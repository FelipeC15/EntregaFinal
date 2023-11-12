package construccion4.construccion4.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import construccion4.construccion4.Modelo.Autorizado;
import construccion4.construccion4.Modelo.Factura;
import construccion4.construccion4.Modelo.Socio;
@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long>{
	public List<Factura> findByCedula(int cedula); 
	//public List<Factura> findByAutorizado(Autorizado autorizado);

	//public int existsByFactura(int cedula);
	//public Factura findByTop1BySocioAndFacturaOrderByIdAsc(Socio socio, Factura factura);
	
	
	
	
	
}