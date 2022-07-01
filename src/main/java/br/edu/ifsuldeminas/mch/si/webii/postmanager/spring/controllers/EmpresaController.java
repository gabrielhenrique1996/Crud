package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Empresa;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.EmpresaRepository;

@Controller
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository empresaRepo;
	
	@GetMapping("/empresas")
	public String empresas(Model model) {
		List<Empresa> empresas = empresaRepo.findAll();
		
		model.addAttribute("empresas", empresas);
		
		return "index2";
	}
	
	@GetMapping("/empresas/form")
	public String empresaForm(@ModelAttribute("empresa") 
						   Empresa empresa) {
		return "empresa_form";
	}
	
	@PostMapping("/empresas/new")
	public String userNew(@ModelAttribute("empresa") 
	   					   Empresa empresa) {
		
		empresaRepo.save(empresa);
		
		return "redirect:/empresas";
	}
	
	@GetMapping("/empresas/{id}")
	public String empresaUpdate(@PathVariable("id") 
	                         Integer id, 
	                         Model model) {
		
		Optional<Empresa> empresaOpt = empresaRepo.findById(id);
		
		if (empresaOpt.isEmpty())
			throw new IllegalArgumentException("Empresa inválida!");
		
		Empresa empresa = empresaOpt.get();
		model.addAttribute("empresa", empresa);
		
		return "empresa_form";
	}
	
	@GetMapping("/empresas/delete/{id}")
	public String empresaDelete(@PathVariable("id") 
							 Integer id) {
		
		Optional<Empresa> empresaOpt = empresaRepo.findById(id);
		
		if (empresaOpt.isEmpty())
			throw new IllegalArgumentException("Empresa inválida!");
		
		Empresa empresa = empresaOpt.get();
		
		empresaRepo.delete(empresa);
		
		return "redirect:/empresas";
	}
}