/**
 * 
 */
package com.example.reto.service;

import java.util.List;

import com.example.reto.entity.TestLab;


/**
 * @author Lenovo
 *Interface que contiene los metodos de logica de negocio para los test
 */
public interface TestService {
	
	/*Método que permite consultar listado de test
	 * @return listado de test
	*/
	List<TestLab> consultarTest();
	
	//Método que permite guardar un test	
	
	TestLab guardarTest(TestLab test);
	
	//Método que permite actualizar un test
	TestLab actualizarTest (TestLab test);
	
	
	//Método que permite eliminar un test
	void eliminarTest (int id);
	
	//Método que permite consultar un test por id
	TestLab consultarById (int id);
}