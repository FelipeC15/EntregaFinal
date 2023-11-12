package construccion4.construccion4.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import construccion4.construccion4.Modelo.Autorizado;
@Repository
public interface AutorizadoRepository extends JpaRepository<Autorizado, Long>{

	public Autorizado findBycedula(int cedula);  
	public boolean existsBycedula(int cedula);	
	
}