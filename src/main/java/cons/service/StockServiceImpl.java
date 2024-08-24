package cons.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cons.dataAccess.IStockRepo;
import cons.entities.Stock;
import cons.exceptions.Exepcion;



@Service
public class StockServiceImpl implements StockService{


//	Logger LOG = LoggerFactory.getLogger(StockService.class);

	
	@Autowired
	IStockRepo repo;

	@Override
	public List<Stock> getAll() {
		
		return repo.findAll();
	}

/*	@Override
	public List<Stock> filter(StockBuscarForm filter) throws Exepcion {
		
//		//ver https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
		if(filter.getNombre()==null && filter.getDni()==null && filter.getIdCiudadSeleccionada()==null)
			throw new Exepcion("Es necesario al menos un filtro");
		else
			return repo.findByNombreOrIdCiudad(filter.getNombre(),filter.getDni(),filter.getIdCiudadSeleccionada());
		
		
		
	}*/

	@Override
	public void save(Stock stock) throws Exepcion {
		
	
			repo.save(stock);
		
	}

	@Override
	public Stock getStockById(Long idStock) throws Exepcion {

		Optional<Stock> p = repo.findById(idStock);
		
		if(p!=null) {
			return p.get();
		} else {
			throw new Exepcion("No existe la persona con el id="+idStock);
		}
	}

	@Override
	public void deleteStockByid(Long id) {
		repo.deleteById(id);
		
	}

	
	
}
