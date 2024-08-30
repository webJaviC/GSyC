package cons.dataAccess;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cons.entities.Remito;


public interface IRemitoRepo extends JpaRepository<Remito, Long> {


	 @Query("SELECT c FROM Remito c WHERE c.fecha = ?1 or c.id = ?2")
	 List<Remito> findByFechaOrIdRemito(LocalDate localDate, Long idRemito);

	List<Remito> findByIdOrFecha(Long id, LocalDate fecha);
	
	
}
