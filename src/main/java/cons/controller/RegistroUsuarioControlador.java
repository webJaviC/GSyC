package cons.controller;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cons.controller.dto.UsuarioRegistroDTO;
import cons.entities.Rol;
import cons.service.RolService;
import cons.service.UsuarioService;



@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

	private UsuarioService usuarioServicio;

	public RegistroUsuarioControlador(UsuarioService usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}
	
	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	
	
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
		usuarioServicio.guardar(registroDTO);
		return "redirect:/registro?exito";
	}
	
	  @GetMapping("/user")
	    @Secured("ROLE_USER")
	    public String mostrarPerfilDeUsuario() {
	        return "user/user"; // devuelve la vista usuario/perfil.html
	    }

	    @GetMapping("/admin")
	    @Secured("ROLE_ADMIN")
	    public String mostrarPanelDeAdministracion() {
	        return "admin/administrador"; // devuelve la vista admin/panel.html
	    }

	    @GetMapping("/moderator")
	    @Secured("ROLE_MODERATOR")
	    public String mostrarPanelDeModeracion() {
	        return "moderator/mediator"; // devuelve la vista moderador/panel.html
	    }
	}



