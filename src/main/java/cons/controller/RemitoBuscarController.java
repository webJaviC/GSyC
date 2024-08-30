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

import cons.controller.dto.RemitoBuscarDTO;
import cons.entities.Pallet;
import cons.entities.Remito;
import cons.exceptions.Exepcion;
import cons.service.PalletService;
import cons.service.RemitoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/remitoBuscar")
public class RemitoBuscarController {
	
	@Autowired
	private RemitoService servicioRemito;
	
	@Autowired
	private PalletService servicioPallet;
	
	  @RequestMapping(method=RequestMethod.GET)
	    public String preparaForm(Model modelo) {
	    	RemitoBuscarDTO form =  new RemitoBuscarDTO();
//	    	 form.setProvincias(servicioProvincia.getAll());    //  en lugar de esto hacemos @ModelAttribute("allProvincias")
	       modelo.addAttribute("formBean",form);
	       return "remitoBuscar";
	    }
	  
	  @ModelAttribute("allPallet")
	    public List<Pallet> getAllProvincias() {
	        return this.servicioPallet.getAll();
	    }
	     
	  @RequestMapping( method=RequestMethod.POST)
	    public String submit( @ModelAttribute("formBean") @Valid RemitoBuscarDTO  formBean,BindingResult result, ModelMap modelo,@RequestParam String action) throws Exepcion {
	    	
	    	
	    	if(action.equals("Buscar"))
	    	{
	    		
	    		try {
	    			List<Remito> remito = servicioRemito.filter(formBean);
	    			modelo.addAttribute("resultados",remito);
				} catch (Exception e) {
					ObjectError error = new ObjectError("globalError", e.getMessage());
		            result.addError(error);
				}
	    		
	    		modelo.addAttribute("formBean",formBean);
	        	return "remitoBuscar";
	    	}
	    
	    	
	    	if(action.equals("Cancelar"))
	    	{
	    		modelo.clear();
	    		return "redirect:/";
	    	}
	    	
	    	if(action.equals("Registrar"))
	    	{
	    		modelo.clear();
	    		return "redirect:/remitoEditar";
	    	}
	    		
	    	return "redirect:/";
	    	
	    	
	    }

}
