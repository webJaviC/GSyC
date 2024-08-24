package cons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cons.controller.dto.HrBuscarDTO;
import cons.entities.Hr;
import cons.service.CalidadService;
import cons.service.HrService;
import jakarta.validation.Valid;

	@Controller
	@RequestMapping("/HrBuscar")
	public class HrBuscarController {
		
		@Autowired
	    private HrService service;
		
	
	     
	    @RequestMapping(method=RequestMethod.GET)
	    public String preparaForm(Model modelo) {
	    	HrBuscarDTO form =  new HrBuscarDTO();
	    	//form.setIdCiudadSeleccionada(1L); //Esto es por ejemplo, si quisiera setear un valor por defecto en el filtro de ciudad 
//	    	 form.setCiudades(serviceCiudad.getAll());    //  en lugar de esto hacemos @ModelAttribute("allCiudades")
	       modelo.addAttribute("formBean",form);
	       return "personasBuscar";
	    }
	   
	    @RequestMapping( method=RequestMethod.POST)
	    public String submit( @ModelAttribute("formBean")  @Valid  HrBuscarDTO formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
	         	
	    	
	    	if(action.equals("Buscar"))
	    	{
	    		
	    		
	    		try {
	    			List<Hr> hr = service.filter(formBean);
	            	modelo.addAttribute("resultados",hr);
				} catch (Exception e) {
					ObjectError error = new ObjectError("globalError", e.getMessage());
		            result.addError(error);
				}
	        	modelo.addAttribute("formBean",formBean);
	        	return "HojaDeRutaBuscar";
	    	}
	    
	    	
	    	if(action.equals("Cancelar"))
	    	{
	    		modelo.clear();
	    		return "redirect:/";
	    	}
	    	
	    	if(action.equals("Registrar"))
	    	{
	    		modelo.clear();
	    		return "redirect:/personasEditar";
	    	}
	    		
	    	return "redirect:/";
	    	
	    	
	    }
	
		}

	
