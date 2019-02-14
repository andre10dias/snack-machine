package com.arquitetura.orientada.servicos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arquitetura.orientada.servicos.domain.Maquina;
import com.arquitetura.orientada.servicos.repositories.MaquinaRepository;

@SpringBootApplication
public class SnackMachineApplication implements CommandLineRunner {

	@Autowired
	private MaquinaRepository maquinaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SnackMachineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Maquina maq1 = new Maquina(null, "Maquina 1");
		Maquina maq2 = new Maquina(null, "Maquina 2");
		Maquina maq3 = new Maquina(null, "Maquina 3");
		Maquina maq4 = new Maquina(null, "Maquina 4");
		Maquina maq5 = new Maquina(null, "Maquina 5");
		
		maquinaRepository.saveAll(Arrays.asList(maq1, maq2, maq3, maq4, maq5));
	}

}

