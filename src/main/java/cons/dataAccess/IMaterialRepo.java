package cons.dataAccess;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import cons.entities.Calidad;
import cons.entities.Material;

public interface IMaterialRepo extends JpaRepository<Material, Long>{

	
	// El SQL Like se utiliza cuando se desea devolver la fila,
	// si una cadena de caracteres específica coincide con un patrón específico.
	// El patrón puede ser una combinación de caracteres
	// regulares al igual que caracteres de comodín (*,%, ¿, etc.).


	    @Query(value = "SELECT * FROM productos WHERE productos.categoria LIKE %?1%", nativeQuery = true)
	    //Vamos a buscar por una palabra clave
	    Page<Material> findAll(Pageable pageable, String palabraClave);
}
