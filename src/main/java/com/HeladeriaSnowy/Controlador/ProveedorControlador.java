package com.HeladeriaSnowy.Controlador;

import com.HeladeriaSnowy.Interfaces.Service.IProveedorService;
import com.HeladeriaSnowy.Model.ProveedorModel;
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
public class ProveedorControlador {

	@Autowired
	private IProveedorService serviceProveedor;
	
	@GetMapping("/listarProveedor")
	public String listarProveedor(Model model)
	{
		model.addAttribute("proveedores",serviceProveedor.listarProveedores());
		return "proveedores.html";
	}
	
		
	@PostMapping("/saveProveedor")
	public String saveProveedor (@Validated ProveedorModel p, Model model) {
		serviceProveedor.saveProveedor(p);
		return "redirect:/listarProveedor";
	}	
	
	@GetMapping("/newProveedor")
	public String agregarProveedor (Model model) {
		model.addAttribute("proveedor", new ProveedorModel());
		return "formProveedores.html";
	}
	
	@GetMapping ("/editarProveedor/{nit}")
	public String editarProveedor (@PathVariable String nit, Model model)
	{
		Optional <ProveedorModel> proveedor =serviceProveedor.listarIdProveedor(nit);
		model.addAttribute("proveedor", proveedor);
		return "formProveedores.html";
	}
	
	@GetMapping ("eliminarProveedor/{nit}")
	public String deleteProveedor (@PathVariable String nit, Model model)
	{
		serviceProveedor.deleteProveedor(nit);
		return "redirect:/listarProveedor";
	}
	
}
