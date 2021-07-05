package com.example.projetogrupowl.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.projetogrupowl.interfaceService.IFuncionarioService;
import com.example.projetogrupowl.modelo.Funcionario;

@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private IFuncionarioService service;

	@GetMapping("/listar")
	public String listar(Model model) {
		List<Funcionario> funcionarios = service.listar();
		model.addAttribute("funcionarios", funcionarios);
		return "index";
	}

	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("funcionario", new Funcionario(0, null, null, null, null, null));
		return "form";
	}

	@PostMapping("/save")
	public String save(@Validated Funcionario f, Model model) {
		service.save(f);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Funcionario> funcionario = service.listarId(id);
		model.addAttribute("funcionario", funcionario);
		return "form";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";

	}

}
