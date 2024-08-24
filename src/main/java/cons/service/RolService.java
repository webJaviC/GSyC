package cons.service;

import java.util.List;

import cons.entities.Rol;




public interface RolService  {

	Rol findAll();

	List<Rol> getAll();
	public List<Rol> listarRoles();
	
	Rol findByNombre(String nombre);

}
