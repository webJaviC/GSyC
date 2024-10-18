package cons.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cons.entities.Material;



public interface MaterialService {

	
	 Page<Material> findAll(Pageable pageable, String palabraClave);
	    void guardarProducto(Material producto);

	    public void eliminarProducto(Long id);

	    public Material editarProducto(Long id);
}
