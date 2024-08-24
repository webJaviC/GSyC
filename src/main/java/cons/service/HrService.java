package cons.service;

import java.util.List;

import cons.controller.dto.HrBuscarDTO;
import cons.entities.Hr;
import cons.exceptions.Exepcion;


public interface HrService {



	List<Hr> getAll();

	List<Hr> filter(HrBuscarDTO filter) throws Exception;

	/**
	 * Si la persona existe la actualizará, sino la creará en BD
	 * @param persona
	 * @throws Exception 
	 */
	void save(Hr Hr) throws Exception;

	/**
	 * permite obtener una persona determinada 
	 * @param idPersona identificador de la persona buscada
	 * @return persona encontrada o null si no encontr{o la persona
	 * @throws Exception ante un error
	 */
	Hr getHrById(Long idHr) throws Exception;

	void deleteHrByid(Long id);
	
}
