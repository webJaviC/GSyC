package cons.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import cons.controller.dto.HrBuscarDTO;
import cons.dataAccess.IHrRepo;
import cons.dataAccess.IPalletRepo;
import cons.entities.Hr;
import cons.entities.Pallet;
import cons.exceptions.Exepcion;


public class HrServiceImpl implements HrService{
	
//	Logger LOG = LoggerFactory.getLogger(CiudadService.class);
//	
	@Autowired
	IHrRepo repo;

	@Override
	public List<Hr> getAll() {
		
		return repo.findAll();
	}


	@Override
	public List<Hr> filter(HrBuscarDTO filter) throws Exception {
		
//		//ver https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
		if(filter.getDescripcion()==null && filter.getId()==null)
			throw new Exception("Es necesario al menos un filtro");
		else
			return repo.findByDescripcionOrId(filter.getDescripcion(),filter.getId());
		
		
		
	}

	@Override
	public void save(Hr hr) throws Exception {
		
		GregorianCalendar gc =new GregorianCalendar();
		gc.set(Calendar.YEAR, 2000);
		gc.set(Calendar.DATE, 1);
		gc.set(Calendar.MONTH, 1);
		
		
		if(!hr.getEditando() && repo.existsById(hr.getId()))
			throw new Exception("El id ya se encuentra asociado a otra Hr");  //error asociado al campo dni
		else
			repo.save(hr);
		
	}

	@Override
	public Hr getHrById(Long idHr) throws Exception {

		Optional<Hr> p = repo.findById(idHr);
		
		if(p!=null) {
			return p.get();
		} else {
			throw new Exception("No existe la persona con el id="+idHr);
		}
	}

	@Override
	public void deleteHrByid(Long id) {
		repo.deleteById(id);
		
	}

}