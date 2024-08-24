package cons.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cons.controller.dto.UsuarioRegistroDTO;
import cons.dataAccess.IUsuarioRepo;
import cons.entities.Rol;
import cons.entities.Usuario;



@Service
public class UsuarioServiceImpl implements UsuarioService {


	private final IUsuarioRepo usuarioRepositorio;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(IUsuarioRepo usuarioRepositorio, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

		@Override
		public Usuario guardar(UsuarioRegistroDTO registroDTO) {
			Usuario usuario = new Usuario(registroDTO.getNombre(), 
					registroDTO.getApellido(),registroDTO.getEmail(),
					passwordEncoder.encode(registroDTO.getPassword()),Arrays.asList(new Rol("ROLE_USER")));
			return usuarioRepositorio.save(usuario);
		}


		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Usuario usuario = usuarioRepositorio.findByEmail(username);
			if(usuario == null) {
				throw new UsernameNotFoundException("Usuario o password inválidos");
			}
			return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
		}


		private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
			return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
		}
		
		@Override
		public List<Usuario> listarUsuarios() {
			return usuarioRepositorio.findAll();
		}
		 @Override
		    public Usuario findByEmail(String email) {
		        return usuarioRepositorio.findByEmail(email);
		    }

	}
