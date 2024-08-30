package cons.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cons.controller.dto.PalletRegistroDTO;
import cons.entities.Calidad;
import cons.entities.Pallet;
import cons.exceptions.Exepcion;
import cons.service.CalidadService;
import cons.service.PalletService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/palletEditar")
public class PalletEditarController {
	@Autowired
    private PalletService service;
	@Autowired
    private CalidadService serviceCalidad;
     
    @RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id) throws Exception {
    	if (id.isPresent()) {
    		Pallet entity = service.getById(id.get());
    		PalletRegistroDTO form = new PalletRegistroDTO(entity);
    		modelo.addAttribute("formBean", form);
		} else {
		   modelo.addAttribute("formBean",new PalletRegistroDTO());
		}
       return "palletEditar";
    }
     
    @ModelAttribute("allCalidad")
    public List<Calidad> getAllCalidad() {
        return this.serviceCalidad.getAll();
    }
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deletePersonaById(Model model, @PathVariable("id") Long id) 
	{
		service.deleteByid(id);
		return "redirect:/palletBuscar";
	}
 
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid PalletRegistroDTO formBean,BindingResult result, ModelMap modelo,@RequestParam String action) throws Exception  {
    	
    	
    	if(action.equals("Aceptar"))
    	{
    		//para poner errores personalizados asociados a
//            FieldError error2 = new FieldError("formBean","dni","este es otro error.");
//            result.addError(error2);
//    		ObjectError error = new ObjectError("globalError", "aplicacion en modo demo, no puede continuar");
//            result.addError(error);
            
    		if(result.hasErrors())
    		{
    			
                
    			modelo.addAttribute("formBean",formBean);
    			 return "palletEditar";
    		}
    		else
    		{
    			Pallet p=formBean.toPojo();
    			p.setCalidad(serviceCalidad.getById(formBean.getIdCalidad()));
    			try {
    				service.save(p);
					
					return "redirect:/palletBuscar";
				} catch (Exepcion e) {
					if(e.getAtributo()==null) //si la excepcion estuviera referida a un atributo del objeto, entonces mostrarlo al lado del compornente (ej. dni)
					{
						ObjectError error = new ObjectError("globalError", e.getMessage());
			            result.addError(error);
					}
					else
					{
			    		FieldError error1 = new FieldError("formBean",e.getAtributo(),e.getMessage());
			            result.addError(error1);

					}
		            
		            
		            modelo.addAttribute("formBean",formBean);
	    			return "palletEditar";//Como existe un error me quedo en la misma pantalla
				}
    		}

    		
        	
        	
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/palletBuscar";
    	}
    		
    	return "redirect:/";
    	
    	
    }


 
}

