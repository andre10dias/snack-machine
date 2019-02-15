package com.arquitetura.orientada.servicos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arquitetura.orientada.servicos.domain.Maquina;
import com.arquitetura.orientada.servicos.domain.Produto;
import com.arquitetura.orientada.servicos.repositories.MaquinaRepository;
import com.arquitetura.orientada.servicos.repositories.ProdutoRepository;

@SpringBootApplication
public class SnackMachineApplication implements CommandLineRunner {

	@Autowired
	private MaquinaRepository maquinaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
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
		
		Produto p1 = new Produto(null, "Sanduíche Natural", 6.00);
		Produto p2 = new Produto(null, "Coockies", 4.00);
		Produto p3 = new Produto(null, "Água Mineral com Gás", 2.50);
		Produto p4 = new Produto(null, "Água Mineral", 2.00);
		Produto p5 = new Produto(null, "Barra de Cereal", 1.50);
		
		maq1.getProdutos().addAll(Arrays.asList(p1, p1, p1, p1, p1, p2, p2, p3, p4, p4, p5, p5, p5));
		maq2.getProdutos().addAll(Arrays.asList(p1, p2, p2, p3, p3, p3, p3, p3, p5, p5));
		maq3.getProdutos().addAll(Arrays.asList(p2, p2, p2, p2, p3, p4, p5));
		maq4.getProdutos().addAll(Arrays.asList(p3, p3, p3, p3, p3, p3, p3, p3, p4, p4, p4, p4, p4));
		maq5.getProdutos().addAll(Arrays.asList(p1, p1, p1, p1, p1));
		
		p1.getMaquinas().addAll(Arrays.asList(maq1, maq2, maq5));
		p2.getMaquinas().addAll(Arrays.asList(maq1, maq2, maq3));
		p3.getMaquinas().addAll(Arrays.asList(maq1, maq2, maq3, maq4));
		p4.getMaquinas().addAll(Arrays.asList(maq1, maq3, maq4));
		p5.getMaquinas().addAll(Arrays.asList(maq1, maq2, maq3));
		
		maquinaRepository.saveAll(Arrays.asList(maq1, maq2, maq3, maq4, maq5));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}

}

