package cons.service;

import java.util.List;

import cons.entities.Calidad;
import cons.exceptions.Exepcion;




public interface CalidadService {



	/**
	 * Obtiene la lista completa de ciudades
	 * @return Todas las ciudades
	 */
	List<Calidad> getAll();
	
	/**
	 * Obtiene una ciudad determinada
	 * @param idCiudad Identificador de la ciudad buscada
	 * @return Ciudad encontrada
	 */
	Calidad getById(Long idCalidad) ;
	
	//List<Calidad> filter(CalidadBuscarForm filter) throws Excepcion;

	void deleteByid(Long id);

	void save(Calidad c) throws Exepcion;
	
}
