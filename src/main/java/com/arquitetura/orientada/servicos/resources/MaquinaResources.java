package com.arquitetura.orientada.servicos.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arquitetura.orientada.servicos.domain.Maquina;

@RestController
@RequestMapping(value="/maquinas")
public class MaquinaResources {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Maquina> listar() {
		Maquina maq1 = new Maquina(1, "Maquina-1");
		Maquina maq2 = new Maquina(2, "Maquina-2");
		Maquina maq3 = new Maquina(3, "Maquina-3");
		
		List<Maquina> lista = new ArrayList<>();
		lista.add(maq1);
		lista.add(maq2);
		lista.add(maq3);
		
		return lista;
	}
}
