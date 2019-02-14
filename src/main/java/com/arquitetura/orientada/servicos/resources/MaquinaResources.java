package com.arquitetura.orientada.servicos.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arquitetura.orientada.servicos.domain.Maquina;
import com.arquitetura.orientada.servicos.service.MaquinaService;

@RestController
@RequestMapping(value="/maquinas")
public class MaquinaResources {
	
	@Autowired
	private MaquinaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Maquina obj = service.find(id);
		return ResponseEntity.ok().body(obj);	
	}
}
