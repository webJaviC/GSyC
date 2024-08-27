package cons.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cons.entities.Calidad;



@Repository
public interface ICalidadRepo extends JpaRepository<Calidad, Long> {

	@Query("SELECT c FROM Calidad c WHERE c.nombre like ?1 and c.id=?2")
	List<Calidad> findByNombreAndId(String nombre, Long id);
	
	 @Query("SELECT c FROM Calidad c WHERE c.nombre = :nombre")
	    Calidad findByName(@Param("nombre") String nombre);
}
