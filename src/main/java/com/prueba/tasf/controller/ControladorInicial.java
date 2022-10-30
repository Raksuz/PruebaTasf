package com.prueba.tasf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.prueba.tasf.entidades.Producto;
import com.prueba.tasf.services.IProductoService;

@Controller
public class ControladorInicial {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/")
	private String inicio(Model m) {
		List<Producto> productos = productoService.listarP();
		m.addAttribute("productos", productos);
		return "index";
	}
	
	@GetMapping("/agregar")
	private String agregar(Producto producto) {
		return "modificar";
	}
	
	@PostMapping("/guardar")
	private String guardar(@Valid Producto producto, Errors errores) {
		if(errores.hasErrors()) {
			return "modificar";
		}
		productoService.guardar(producto);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	private String editar(Producto producto, Model m) {
		producto = productoService.buscarP(producto);
		m.addAttribute("producto", producto);
		return "modificar";
	}
	
	@GetMapping("/eliminar")
	private String eliminar(Producto producto) {
		productoService.eliminar(producto);
		return "redirect:/";
	}
	
	
}
