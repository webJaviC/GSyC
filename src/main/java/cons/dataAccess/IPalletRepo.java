package cons.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cons.entities.Pallet;



@Repository
public interface IPalletRepo extends JpaRepository<Pallet, Long> {
	
	@Query("SELECT p FROM Pallet p WHERE p.gramaje like :gramaje or p.id=:id")
	List<Pallet> findPalletsByGramajeOrId( String gramaje, Long id);
	
	@Query("SELECT p FROM Pallet p WHERE p.gramaje like :gramaje and p.id=:id")
	List<Pallet> findPalletsByGramajeAndId(String gramaje, Long id);
}
