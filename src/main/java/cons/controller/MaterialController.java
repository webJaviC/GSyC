package cons.controller;

import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cons.dataAccess.IMaterialRepo;
import cons.entities.Material;

import cons.paginator.PageRender;
import cons.service.MaterialService;



@Controller
@RequestMapping("")
public class MaterialController {

	 @Autowired
	   MaterialService productoServices;

	    @Autowired
	    IMaterialRepo productoDao;


	    @GetMapping("/productos")
	    public String listarProductos(@RequestParam(name="page", defaultValue= "0") int page , Model model,@Param("palabraClave") String palabraClave){
	        Pageable pageRequest =  PageRequest.of(page,4);
	        Page<Material> listProductos = productoServices.findAll(pageRequest, palabraClave);
	        PageRender pageRender = new PageRender<>("/productos", listProductos);

	        model.addAttribute("titulo", "SISTEMA INVENTARIO");


	        model.addAttribute("productos",listProductos);

	        model.addAttribute("page", pageRender);


	        model.addAttribute("palabraClave",palabraClave);
	       // model.addAttribute("productos", listProductos);
	        return "/productos";
	    }


	    @RequestMapping("/crearproducto")
	    public String crear(Map<String, Object> model){
	        Material producto = new Material();
	        model.put("producto", producto);
	        return "/crearproducto";
	    }
	    @PostMapping("/crearproducto")
	    public String crearProducto(Material producto){
	        productoServices.guardarProducto(producto);

	        return "redirect:/productos";
	    }

	   /* @RequestMapping("/productos")
	    public String importarExcel(Model model){
	        UserExcelImport excel = new UserExcelImport();
	        model.addAttribute("userexcelimport", excel);
	        return "/productos";
	    }

	    @PostMapping("/upload")
	    public String importExcel(@RequestParam("file") MultipartFile file, Model model, UserExcelImport excel) throws Exception {

	        HashSet<Material> listProductos = excel.excelImport(file);

	        productoDao.saveAll(listProductos);


	        model.addAttribute("productos", listProductos);

	        return "/productos";
	        }*/


	        @GetMapping("/eliminarprod/{id}")
	        public String eliminarProducto(@PathVariable(value = "id") Long id){
	        productoServices.eliminarProducto(id);
	        return "redirect:/productos";
	        }

	        @GetMapping("/crearproducto/{id}")
	        public String editarProducto(@PathVariable(value = "id") Long id, Model model){
	        Material producto2 = productoServices.editarProducto(id);

	        model.addAttribute("producto", producto2);
	        return "/editarproducto";
	        }
}
