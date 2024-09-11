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
import com.example.model.Reserva;
import com.example.service.ReservaService;

@RestController
@RequestMapping ("/reserva/")
public class ReservaRest {
	
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping
	private ResponseEntity<List<Reserva>> getAllReserva(){
		return ResponseEntity.ok(reservaService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Reserva> saveReserva (@RequestBody Reserva reserva){
		try {
			Reserva reservaGuardado = reservaService.save(reserva);
		return ResponseEntity.created(new URI("/reserva/"+reservaGuardado.getId())).body(reservaGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		}

		@DeleteMapping(value = "delete/{id}")
		private ResponseEntity<Boolean> deleteReserva(@PathVariable ("id") Long id){
			reservaService.deleteById(id);
			return ResponseEntity.ok(!(reservaService.findById(id)!=null));	
		}
	}
