package cons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cons.dataAccess.IRemitoRepo;
import cons.entities.Remito;
import cons.exceptions.Exepcion;


@Service
public class RemitoServiceImpl implements RemitoService {
	
//	Logger LOG = LoggerFactory.getLogger(RemitoService.class);
//	
	@Autowired
	IRemitoRepo repo;

	@Override
	public List<Remito> getAll() {
		
		return repo.findAll();
	}



	@Override
	@Deprecated
	public Remito getById(Long idCiudad) {

		return repo.findById(idCiudad).get();
	}
	
	/*@Override
	public List<Remito> filter(RemitoBuscarForm filter) throws Exepcion
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
	public void save(Remito c) throws Exepcion {
		if(c.getId()==null && !repo.findByFechaOrIdRemito(c.getFecha(), c.getId()).isEmpty()) //estoy dando de alta un nuevo remito y ya existe una igual?
			throw new Exepcion("Ya existe un remito con el mismo nombre y nro");  
		else
			repo.save(c);
		
	}

}


