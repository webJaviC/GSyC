package cons.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import cons.controller.dto.RemitoRegistroDTO;
import cons.entities.Pallet;
import cons.entities.Remito;
import cons.exceptions.Exepcion;
import cons.service.PalletService;
import cons.service.RemitoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/remitoEditar")
public class RemitoEditarController {
	
	@Autowired
	private RemitoService servicioRemito;
	
	@Autowired
	private PalletService servicioPallet;
	
	 @RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
	    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> id) throws Exception {
	    	if (id.isPresent()) {
	    		Remito entity = servicioRemito.getById(id.get());
	    		RemitoRegistroDTO form = new RemitoRegistroDTO(entity);
				modelo.addAttribute("formBean", form);
			} else {
	 
		       modelo.addAttribute("formBean",new RemitoRegistroDTO());
			}
	       return "remitoEditar";
	    }
	 
	 @ModelAttribute("allPallet")
	    public List<Pallet> getAllPallet() {
	        return this.servicioPallet.getAll();
	    }
	 
	 @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
		public String deleteById(Model model, @PathVariable("id") Long id) 
		{
			servicioRemito.deleteByid(id);
			return "redirect:/remitoBuscar";
		}


		 @RequestMapping(method = RequestMethod.POST)
		 public String submit(@ModelAttribute("formBean") @Valid RemitoRegistroDTO formBean, BindingResult result, ModelMap modelo, @RequestParam String action) {

		     if (action.equals("Aceptar")) {
		         if (result.hasErrors()) {
		             modelo.addAttribute("formBean", formBean);
		             return "remitoEditar";
		         } else {
		             try {
		                 Remito remito = formBean.toPojo();
		                 
		                 // Convertir la lista de IDs a una lista de objetos Pallet
		                 List<Pallet> pallets = formBean.getPallets().stream()
		                         .map(id -> servicioPallet.getById(id))  // Asume que servicioPallet.getById(id) devuelve un objeto Pallet
		                         .collect(Collectors.toList());

		                 // Asignar la lista de Pallets al Remito
		                 remito.setPallets(pallets);
		                 
		                 // Guardar el remito con los pallets asociados
		                 servicioRemito.save(remito);

		                 return "redirect:/remitoBuscar";
	             } catch (Exepcion e) {
	                 if (e.getAtributo() == null) {
	                     ObjectError error = new ObjectError("globalError", e.getMessage());
	                     result.addError(error);
	                 } else {
	                     FieldError error1 = new FieldError("formBean", e.getAtributo(), e.getMessage());
	                     result.addError(error1);
	                 }
	                 modelo.addAttribute("formBean", formBean);
	                 return "remitoEditar";
	             }
	         }
	     }

	     if (action.equals("Cancelar")) {
	         modelo.clear();
	         return "redirect:/remitoBuscar";
	     }

	     return "redirect:/";
	 }

	 
}
