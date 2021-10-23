package com.HeladeriaSnowy.Controlador;

import com.HeladeriaSnowy.Interfaces.Service.IUsuarioService;
import com.HeladeriaSnowy.Model.UsuarioModel;
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
public class UsuarioControlador {

	@Autowired
	private IUsuarioService serviceUsuario;

	@PostMapping("/validar")
	public String validar(Model model, UsuarioModel p) {
		boolean valido = serviceUsuario.validarUsuario(p.getUsuario(), p.getClave_Usuario());
		if (valido) {
			return "redirect:/Menu";
		} else {
						
			return "redirect:/index?error=true";
			
		}

	}	

	@GetMapping("/Menu")
	public String mostarMenu() {
		return "Menu";
	}
	
	@GetMapping("/index")
	public String mostarIndex() {
		return "index";
	}

	
	
	
	@GetMapping("/listarUsuario")
	public String listarUsuario(Model model)
	{
		model.addAttribute("usuarios",serviceUsuario.listarUsuarios());
		return "usuarios.html";
	}
	
		
	@PostMapping("/saveUsuario")
	public String saveUsuario (@Validated UsuarioModel u, Model model) {
		serviceUsuario.saveUsuario(u);
		return "redirect:/listarUsuario";
	}	
	
	@GetMapping("/newUsuario")
	public String agregarUsuario (Model model) {
		model.addAttribute("usuario", new UsuarioModel());
		return "formUsuarios.html";
	}
	
	@GetMapping ("/editarUsuario/{Cedula}")
	public String editarUsuario (@PathVariable String Cedula, Model model)
	{
		Optional <UsuarioModel> usuario =serviceUsuario.listarIdUsuario(Cedula);
		model.addAttribute("usuario", usuario);
		return "formUsuarios.html";
	}
	
	@GetMapping ("eliminarUsuario/{Cedula}")
	public String deleteUsuario (@PathVariable String Cedula, Model model)
	{
		serviceUsuario.deleteUsuario(Cedula);
		return "redirect:/listarUsuario";
	}

	
}
