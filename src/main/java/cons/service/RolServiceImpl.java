package cons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cons.dataAccess.IRolRepo;
import cons.dataAccess.IUsuarioRepo;
import cons.entities.Rol;


@Service
public class RolServiceImpl implements RolService{

	
	private final IRolRepo rolRepositorio ;
	  @Autowired
	    public RolServiceImpl(IRolRepo rolRepositorio) {
	        this.rolRepositorio = rolRepositorio;
	    }
	

	

	@Override
	public List<Rol> listarRoles() {
		// TODO Auto-generated method stub
		return rolRepositorio.findAll();
	}

	@Override
	public Rol findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Rol findAll() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<Rol> getAll() {
		return rolRepositorio.findAll();
		
	}

}
