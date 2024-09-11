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


import com.example.model.Servicio;
import com.example.service.ServicioService;

@RestController
@RequestMapping ("/servicio/")
public class ServicioRest {
	
	@Autowired
	private ServicioService servicioService;
	
	@GetMapping
	private ResponseEntity<List<Servicio>> getAllServicio(){
		return ResponseEntity.ok(servicioService.findAll());	
	}
	
	@PostMapping
	private ResponseEntity<Servicio> saveServicio (@RequestBody Servicio servicio){
		try {
			Servicio servicioGuardado = servicioService.save(servicio);
		return ResponseEntity.created(new URI("/servicio/"+servicioGuardado.getId())).body(servicioGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@DeleteMapping(value = "delete/{id}")
	private ResponseEntity<Boolean> deleteServicio(@PathVariable ("id") Long id){
		servicioService.deleteById(id);
		return ResponseEntity.ok(!(servicioService.findById(id)!=null));
		
		
	}
}

