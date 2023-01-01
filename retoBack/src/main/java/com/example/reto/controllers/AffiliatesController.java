/**
 * 
 */
package com.example.reto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.reto.entity.Affiliates;
import com.example.reto.service.AffiliatesService;

/**
 * @author Lenovo
 *Controlador que manipula el flujo de los servicios rest del microservicio de Afiliados
 */

@RestController
@RequestMapping ("/affiliates")
public class AffiliatesController {
	
	@Autowired
	private AffiliatesService affiliatesServiceImlp;
	
	
	@GetMapping
	public ResponseEntity<?> consultarAfiliados() {
		
			List<Affiliates> afiliadosConsultados = this.affiliatesServiceImlp.consultarAfiliados();
			
			if (afiliadosConsultados.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}else {
				return ResponseEntity.ok(afiliadosConsultados);}
	}
	
	
	
	@PostMapping
	public ResponseEntity<?> guardarAfiliado(@RequestBody Affiliates affiliates) {
		
		try {
			Affiliates afiliadoGuardado= this.affiliatesServiceImlp.guardarAfiliado(affiliates);
			return ResponseEntity.status(HttpStatus.CREATED).body(afiliadoGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	
	@PutMapping
	public ResponseEntity<?> actualizarAfiliado(@RequestBody Affiliates affiliates){
		
		try {
			Affiliates afiliadoActualizado= this.affiliatesServiceImlp.actualizarAfiliado(affiliates);
			return ResponseEntity.status(HttpStatus.CREATED).body(afiliadoActualizado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		}
	
	//@DeleteMapping
	@RequestMapping (value ="{idAffiliate}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarAfiliado(@PathVariable int idAffiliate){
		
		try {
			this.affiliatesServiceImlp.eliminarAfiliado(idAffiliate);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		}
		}
	
	@RequestMapping (value ="{idAffiliate}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarPorId(@PathVariable int idAffiliate){
		/*
		 * Con el try se hace lo que quiero en el método, con el catch
		 * es sino se cumple o no lo encuentra, entonce sarroja error 404 not found*/
		
		try {
			Affiliates afiliadoPorId= this.affiliatesServiceImlp.consultarPorId(idAffiliate);
			return ResponseEntity.status(HttpStatus.OK).body(afiliadoPorId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
		
	}

}
