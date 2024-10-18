package cons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cons.controller.dto.PalletBuscarDTO;
import cons.dataAccess.IPalletRepo;
import cons.entities.Pallet;
import cons.exceptions.Exepcion;
import jakarta.validation.Valid;


@Service
public class PalletServiceImpl implements PalletService{
	
//	Logger LOG = LoggerFactory.getLogger(CiudadService.class);
//	
	@Autowired
	IPalletRepo repo;

	@Override
	public List<Pallet> getAll() {
		
		return repo.findAll();
	}



	@Override
	@Deprecated
	public Pallet getById(Long idPallet) {

		return repo.findById(idPallet).get();
	}
	
/*	@Override
	public List<Pallet> filter(PalletBuscarForm filter) throws Exepcion
	{
		//ver https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
		if(filter.getNombre()==null && filter.getProvinciaSeleccionada()==null)
			//return repo.findAll();
			throw new Exepcion("Es necesario al menos un filtro");
		else
			return repo.findByNombreOrIdProvincia(filter.getNombre(),filter.getProvinciaSeleccionada());
				
	}
*/


	@Override
	public void deleteByid(Long id) {
		repo.deleteById(id);
		
	}



	@Override
	public void save(Pallet c) throws Exepcion {
	    if (c.getId() != null) {
	        // Check if a pallet with the same gramaje and id already exists
	        List<Pallet> existingPallets = repo.findPalletsByGramajeAndId(c.getGramaje(), c.getId());
	        if (!existingPallets.isEmpty()) {
	            throw new Exepcion("Ya existe un pallet con el mismo gramaje y id");
	        }
	    }
	    repo.save(c);
	}

/*	@Override
	public Pallet getById(List<Long> idPallet) {
		// TODO Auto-generated method stub
		return null;
	}*/



	@Override
	public List<Pallet> filter(@Valid PalletBuscarDTO formBean) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Pallet getById(Pallet id) {
	    
	    return null;
	}

	public List<Pallet> getByIds(List<Long> ids) {
        return repo.findAllById(ids);
    }
	


}
