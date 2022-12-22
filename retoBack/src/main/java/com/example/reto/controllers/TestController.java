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

import com.example.reto.entity.Test;
import com.example.reto.service.TestService;

/**
 * @author Lenovo
 *Controlador que manipula el flujo de los servicios rest del microservicio de test
 */

@RestController
@RequestMapping ("/test")
public class TestController {
	
	@Autowired
	private TestService testServiceImpl;
	
	@GetMapping
	//@RequestMapping (value = "consultarTest", method = RequestMethod.GET)
	public ResponseEntity<?> consultarTest() {
		
		List<Test> testConsultados = this.testServiceImpl.consultarTest();
			if (testConsultados.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}else {
			
			return ResponseEntity.ok(testConsultados);
		} 
	}
	
	@PostMapping
	public ResponseEntity<?> guardarTest(@RequestBody Test test){
		try {
			Test testGuardado= this.testServiceImpl.guardarTest(test);
			return ResponseEntity.status(HttpStatus.CREATED).body(testGuardado);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
		}
	
	
	@PutMapping
	public ResponseEntity<?> actualizarTest(@RequestBody Test test){
		Test testActualizado= this.testServiceImpl.actualizarTest(test);
		return ResponseEntity.status(HttpStatus.CREATED).body(testActualizado);
		}
	
	
	
	
	//@DeleteMapping
	@RequestMapping (value ="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarTest(@PathVariable int id){
		//this.testServiceImpl.eliminarTest(id);
		//return ResponseEntity.ok().build();
			
		try {
			this.testServiceImpl.eliminarTest(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	}
	
	
	
	@RequestMapping (value ="{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarById(@PathVariable int id){
		/*
		 * Con el try se hace lo que quiero en el método, con el catch
		 * es sino se cumple o no lo encuentra, entonce sarroja error 404 not found
		 * */
		
		try {
			Test testById= this.testServiceImpl.consultarById(id);
			return ResponseEntity.status(HttpStatus.OK).body(testById);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
		
	}

}
