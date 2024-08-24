package cons.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cons.entities.Hr;


@Repository
public interface IHrRepo extends JpaRepository<Hr, Long> {
//	List<Hr> findByDescripcionOrId(String descripcion, Long id);

	@Query("SELECT h FROM Hr h WHERE h.descripcion like ?1 or h.id=?2")
	List<Hr> findByDescripcionOrId(String descripcion, Long id);
}
