package cons.service;

import java.util.List;

import cons.controller.dto.PalletBuscarDTO;
import cons.entities.Pallet;
import cons.exceptions.Exepcion;
import jakarta.validation.Valid;



public interface PalletService {


	/**
	 * Obtiene la lista completa de ciudades
	 * @return Todas las ciudades
	 */
	List<Pallet> getAll();
	
	/**
	 * Obtiene una ciudad determinada
	 * @param idCiudad Identificador de la ciudad buscada
	 * @return Ciudad encontrada
	 */
	Pallet getById(Pallet id) ;
	
//	List<Pallet> filter(PalletBuscarForm filter) throws Exepcion;

	void deleteByid(Long id);

	void save(Pallet p) throws Exepcion;

	Pallet getById(Long idPallet);

	List<Pallet> filter(@Valid PalletBuscarDTO formBean);

	
}
