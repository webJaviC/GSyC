package cons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import cons.controller.dto.UsuarioRegistroDTO;
import cons.entities.Rol;
import cons.entities.Usuario;


public interface UsuarioService extends UserDetailsService{

	
public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
	Usuario findByEmail(String email);

	//Usuario guardar(UsuarioRegistroDTO registroDTO, List<String> roles);


}
