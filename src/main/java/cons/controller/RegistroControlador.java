package cons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cons.service.UsuarioService;


	@Controller
	public class RegistroControlador {

		@Autowired
		private UsuarioService servicio;
		

		@GetMapping("/login")
		public String iniciarSesion() {
			return "login";
		}
		
		@GetMapping("/")
		public String verPaginaDeInicio(Model modelo) {
			modelo.addAttribute("usuarios", servicio.listarUsuarios());
			return "index";
	}

}
	
	
	
	