package cons.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cons.entities.Usuario;



@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {
	//List<Usuario> findByNombreOrDni( String nombre, Long dni);

	//@Query("SELECT p FROM Usuario p WHERE p.nombre like ?1 or p.dni=?2")
	//List<Usuario> findByNombreOrDni1(String nombre, Long dni);
	
	public Usuario findByEmail(String email);
}
