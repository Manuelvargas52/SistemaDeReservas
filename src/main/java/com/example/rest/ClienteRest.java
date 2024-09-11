package com.example.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cliente;
import com.example.service.ClienteService;

@RestController
@RequestMapping ("/cliente/")
public class ClienteRest {
	
	@Autowired
	private  ClienteService clienteService;
	
	@GetMapping
	private ResponseEntity<List<Cliente>> getAllCliente(){
		return ResponseEntity.ok(clienteService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Cliente> saveCliente (@RequestBody Cliente cliente){
		try {
			Cliente clienteGuardado = clienteService.save(cliente);
		return ResponseEntity.created(new URI("/cliente/"+clienteGuardado.getId())).body(clienteGuardado);	
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(value = "delete/{id}")
	private ResponseEntity<Boolean> deleteCliente(@PathVariable ("id") Long id){
		clienteService.deleteById(id);
		return ResponseEntity.ok(!(clienteService.findById(id)!=null));	
	}
}
