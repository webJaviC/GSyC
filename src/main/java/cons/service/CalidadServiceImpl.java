package cons.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cons.dataAccess.ICalidadRepo;
import cons.entities.Calidad;
import cons.entities.Pallet;
import cons.exceptions.Exepcion;



	@Service
	public class CalidadServiceImpl implements CalidadService {

		
		@Autowired
		ICalidadRepo repo;

		@Override
		public List<Calidad> getAll() {
			
			return repo.findAll();
		}


		@Override
		@Deprecated
		public Calidad getById(Long idCalidad) {

			return repo.findById(idCalidad).get();
		}
		
	/*	@Override
		public List<Calidad> filter(CalidadBuscarForm filter) throws Exepcion
		{
			//ver https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
			if(filter.getNombre()==null && filter.getProvinciaSeleccionada()==null)
				//return repo.findAll();
				throw new Excepcion("Es necesario al menos un filtro");
			else
				return repo.findByNombreOrIdProvincia(filter.getNombre(),filter.getProvinciaSeleccionada());
					
		}
*/


		@Override
		public void deleteByid(Long id) {
			repo.deleteById(id);
			
		}



		@Override
		public void save(Calidad c) throws Exepcion {
			if(c.getId()==null && !repo.findByNombreAndId(c.getNombre(), c.getId()).isEmpty()) //estoy dando de alta una nueva ciudad y ya existe una igual?
				throw new Exepcion("Ya existe una ciudad con el mismo nombre, para la misma provincia");  
			else
				repo.save(c);
			
		}


	
}
