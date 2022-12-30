/**
 * 
 */
package com.example.reto.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto.entity.Test;
import com.example.reto.repository.TestRepository;
import com.example.reto.service.TestService;

/**
 * @author Lenovo
 *Clase que implementa los metodos de logica de negocio de la interface de TestService
 *manuela
 */


@Service
public class TestServiceImpl implements TestService {
	
	/*
	 * Bean Repository de spring inyectado para ejecutar el CRUD
	 * */

	@Autowired
	private TestRepository testRepository;
	
	@Override
	public List<Test> consultarTest() {
		
		List <Test> testDataSource = StreamSupport.stream(
				this.testRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return testDataSource;
	}

	@Override
	public Test guardarTest(Test test) {
		return this.testRepository.save(test);
	}

	@Override
	public Test actualizarTest(Test test) {
		
		return this.testRepository.save(test);
	}

	@Override
	public void eliminarTest(int id) {
		this.testRepository.deleteById(id);
		
	}

	
	@Override
	public Test consultarById(int id) {
		
		return this.testRepository.findById(id).get();
				
	
	}



}