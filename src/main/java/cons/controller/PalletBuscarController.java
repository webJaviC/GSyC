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

import cons.controller.dto.PalletBuscarDTO;
import cons.entities.Calidad;
import cons.entities.Pallet;
import cons.service.CalidadService;
import cons.service.PalletService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/palletBuscar")
public class PalletBuscarController {
	@Autowired
    private PalletService service;
	@Autowired
    private CalidadService serviceCiudad;
     
    @RequestMapping(method=RequestMethod.GET)
    public String preparaForm(Model modelo) {
    	PalletBuscarDTO form =  new PalletBuscarDTO();
    	form.setIdCalidadSeleccionada(1L); //Esto es por ejemplo, si quisiera setear un valor por defecto en el filtro de ciudad 
//    	 form.setCiudades(serviceCiudad.getAll());    //  en lugar de esto hacemos @ModelAttribute("allCiudades")
       modelo.addAttribute("formBean",form);
       return "palletBuscar";
    }
     
    
    @ModelAttribute("allCiudades")
    public List<Calidad> getAllCiudades() {
        return this.serviceCiudad.getAll();
    }
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit( @ModelAttribute("formBean")  @Valid  PalletBuscarDTO formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
         	
    	
    	if(action.equals("Buscar"))
    	{
    		
    		
    		try {
    			List<Pallet> pallet = service.filter(formBean);
            	modelo.addAttribute("resultados",pallet);
			} catch (Exception e) {
				ObjectError error = new ObjectError("globalError", e.getMessage());
	            result.addError(error);
			}
        	modelo.addAttribute("formBean",formBean);
        	return "palletBuscar";
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/";
    	}
    	
    	if(action.equals("Registrar"))
    	{
    		modelo.clear();
    		return "redirect:/palletEditar";
    	}
    		
    	return "redirect:/";
    	
    	
    }

 
}

