package com.HeladeriaSnowy.Controlador;

import com.HeladeriaSnowy.Interfaces.Service.IClienteService;
import com.HeladeriaSnowy.Model.ClienteModel;
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
public class ClienteControlador {

	
	@Autowired
	private IClienteService serviceCliente;
	
	@GetMapping("/listarCliente")
	public String listarCliente(Model model)
	{
		model.addAttribute("clientes",serviceCliente.listarClientes());
		return "clientes.html";
	}
	
		
	@PostMapping("/saveCliente")
	public String saveCliente (@Validated ClienteModel c, Model model) {
		serviceCliente.saveCliente(c);
		return "redirect:/listarCliente";
	}	
	
	@GetMapping("/newCliente")
	public String agregarCliente (Model model) {
		model.addAttribute("cliente", new ClienteModel());
		return "formClientes.html";
	}
	
	@GetMapping ("/editarCliente/{Cedula}")
	public String editarCliente (@PathVariable String Cedula, Model model)
	{
		Optional <ClienteModel> cliente =serviceCliente.listarIdCliente(Cedula);
		model.addAttribute("cliente", cliente);
		return "formClientes.html";
	}
	
	@GetMapping ("eliminarCliente/{Cedula}")
	public String deleteCliente (@PathVariable String Cedula, Model model)
	{
		serviceCliente.deleteCliente(Cedula);
		return "redirect:/listarCliente";
	}
}
