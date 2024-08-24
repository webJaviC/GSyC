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

import cons.controller.dto.HrRegistroDTO;
import cons.entities.Calidad;
import cons.entities.Hr;
import cons.exceptions.Exepcion;
import cons.service.CalidadService;
import cons.service.HrService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/hrEditar")
public class HrEditarController {
	@Autowired
    private HrService service;
	@Autowired
    private CalidadService serviceCalidad;
     
    @RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id) throws Exception {
    	if (id.isPresent()) {
    		Hr entity = service.getHrById(id.get());
    		HrRegistroDTO form = new HrRegistroDTO(entity);
    		modelo.addAttribute("formBean", form);
		} else {
		   modelo.addAttribute("formBean",new HrRegistroDTO
				   ());
		}
       return "hrEditar";
    }
     
    @ModelAttribute("allCalidad")
    public List<Calidad> getAllCalidad() {
        return this.serviceCalidad.getAll();
    }
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteHrById(Model model, @PathVariable("id") Long id) 
	{
		service.deleteHrByid(id);
		return "redirect:/HrBuscar";
	}
 
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid HrRegistroDTO formBean,BindingResult result, ModelMap modelo,@RequestParam String action) throws Exception  {
    	
    	
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
    			 return "HrEditar";
    		}
    		else
    		{
    			Hr p=formBean.toPojo();
    			p.setCalidad(serviceCalidad.getById(formBean.getIdCalidad()));
    			try {
    				service.save(p);
					
					return "redirect:/hrBuscar";
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
	    			return "Editar";//Como existe un error me quedo en la misma pantalla
				}
    		}

    		
        	
        	
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/hrBuscar";
    	}
    		
    	return "redirect:/";
    	
    }
    }

