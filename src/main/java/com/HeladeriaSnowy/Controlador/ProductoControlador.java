package com.HeladeriaSnowy.Controlador;

import com.HeladeriaSnowy.Interfaces.Service.IProductoService;
import com.HeladeriaSnowy.Model.ProductoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;



@Controller
@RequestMapping
public class ProductoControlador {
	
	@Autowired
	private IProductoService serviceProducto;
	
	@GetMapping("/listarProducto")
	public String listarProducto(Model model)
	{
		model.addAttribute("productos",serviceProducto.listarProductos());
		return "productos.html";
	}
	
		
	@PostMapping("/saveProducto")
	public String saveProducto (@Validated ProductoModel pr, Model model) {
		serviceProducto.saveProducto(pr);
		return "redirect:/listarProducto";
	}	
	
	@GetMapping("/newProducto")
	public String agregarProducto (Model model) {
		model.addAttribute("producto", new ProductoModel());
		return "formProductos.html";
	}
	
	@GetMapping ("/editarProducto/{Codigo}")
	public String editarProducto (@PathVariable String Codigo, Model model)
	{
		Optional <ProductoModel> producto =serviceProducto.listarIdProducto(Codigo);
		model.addAttribute("producto", producto);
		return "formProductos.html";
	}
	
	@GetMapping ("eliminarProducto/{Codigo}")
	public String deleteProducto (@PathVariable String Codigo, Model model)
	{
		serviceProducto.deleteProducto(Codigo);
		return "redirect:/listarProducto";
	}
}
