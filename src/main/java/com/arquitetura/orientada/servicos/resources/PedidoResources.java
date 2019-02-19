package com.arquitetura.orientada.servicos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arquitetura.orientada.servicos.domain.Pedido;
import com.arquitetura.orientada.servicos.service.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResources {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);	
	}
}
