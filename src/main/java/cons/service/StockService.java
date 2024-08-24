package cons.service;

import java.util.List;

import cons.entities.Stock;
import cons.exceptions.Exepcion;

public interface StockService {


	List<Stock> getAll();

	//List<Stock> filter(StockBuscarForm filter) throws Exepcion;

	
	void save(Stock stock) throws Exepcion;

	
	Stock getStockById(Long idStock) throws Exepcion;

	void deleteStockByid(Long id);

	
}
