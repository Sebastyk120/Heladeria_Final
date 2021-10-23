package com.HeladeriaSnowy.Controlador;


import com.HeladeriaSnowy.Interfaces.Service.IReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class ReportesControlador {

	@Autowired
	private IReporteService serviceReportes;

	@GetMapping("/reportes")
	public String mostrarReportes(Model model) {
		return "reportes";
	}

	@GetMapping ("/listarVentasClientes")
	public String listarVentasCientes(Model model) {
		model.addAttribute("reporteVentasClientes", serviceReportes.listarVentasClientes());
		return "reportes2.html";
	}

}
