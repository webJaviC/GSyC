package cons.service;

import java.util.List;

import cons.controller.dto.RemitoBuscarDTO;
import cons.entities.Remito;
import cons.exceptions.Exepcion;




public interface RemitoService {
	


	/**
	 * Obtiene la lista completa de ciudades
	 * @return Todas las ciudades
	 */
	List<Remito> getAll();
	
	/**
	 * Obtiene una ciudad determinada
	 * @param idCiudad Identificador de la ciudad buscada
	 * @return Ciudad encontrada
	 */
	Remito getById(Long idRemito) ;
	
	List<Remito> filter(RemitoBuscarDTO filter) throws Exepcion;

	void deleteByid(Long id);

	void save(Remito r) throws Exepcion;

}
