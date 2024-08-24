package cons.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cons.entities.Rol;
import cons.entities.Usuario;

@Repository
public interface IRolRepo extends JpaRepository<Rol, Long>{

	public Rol findByNombre(String nombre);
	
}
