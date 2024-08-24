package cons.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cons.entities.Calidad;
import cons.entities.Stock;


@Repository
public interface IStockRepo extends JpaRepository<Stock, Long> {
	
	 @Query("SELECT s FROM Stock s WHERE s.ancho = :ancho AND s.largo = :largo AND s.gramaje = :gramaje AND s.calidad = :calidad")
	    List<Stock> findByDimensionsAndGramaje( Double ancho, Double largo,String gramaje, Calidad calidad);


	@Query("SELECT s FROM Stock s WHERE s.gramaje like ?1 or s.id=?2")
	List<Stock> findByGramajeOrId(String gramaje, Long id);
	
	@Query("SELECT s FROM Stock s WHERE s.gramaje like ?1 and s.id=?2")
	List<Stock> findByGramajeAndId(String gramaje, Long id);
	

}
