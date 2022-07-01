package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Empresa;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.EmpresaRepository;

@Component
public class InitializeDataBase2 implements CommandLineRunner{
	
	@Autowired
	//private UserRepository uRepo;
	private EmpresaRepository rRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Empresa ifsuldeminas = new Empresa();
		ifsuldeminas.setCargo("Gerente");
		ifsuldeminas.setNome("If Sul de Minas");
		ifsuldeminas.setUsuario("Luiza Carvalho");
		
		rRepo.save(ifsuldeminas);
	}
}
