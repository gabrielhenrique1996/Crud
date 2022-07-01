package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.User;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.UserRepository;

@Component
public class InitializeDataBase implements CommandLineRunner{
	
	@Autowired
	private UserRepository uRepo;
	
	@Override
	public void run(String... args) throws Exception {
		User emerson = new User();
		emerson.setName("Emerson Assis");
		emerson.setEmail("assis@gmail.com");
		emerson.setGender("M");
		
		User luiza = new User();
		luiza.setName("Luiza Carvalho");
		luiza.setEmail("lu@mail.com");
		luiza.setGender("F");
		
		uRepo.save(emerson);
		uRepo.save(luiza);
	}
}
