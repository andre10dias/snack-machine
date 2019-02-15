package com.arquitetura.orientada.servicos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitetura.orientada.servicos.domain.Maquina;
import com.arquitetura.orientada.servicos.repositories.MaquinaRepository;
import com.arquitetura.orientada.servicos.service.exceptions.ObjectNotFoundException;

@Service
public class MaquinaService {
	
	@Autowired
	private MaquinaRepository repo;
	
	public Maquina find(Integer id) {
		Optional<Maquina> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Maquina.class.getName()));
	}
}
