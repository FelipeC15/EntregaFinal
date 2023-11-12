package construccion4.construccion4.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import construccion4.construccion4.Modelo.Socio;
@Repository
public interface SocioRepository extends JpaRepository<Socio, Long>{
	public Socio findBycedula(int cedula); 
	public boolean existsBycedula(int cedula);
}