/**
 * 
 */
package com.example.reto.service;

import java.util.List;

import com.example.reto.entity.Test;

/**
 * @author Lenovo
 *Interface que contiene los metodos de logica de negocio para los test
 */
public interface TestService {
	
	/*Método que permite consultar listado de test
	 * @return listado de test
	*/
	List<Test> consultarTest();
	
	//Método que permite guardar un test	
	
	Test guardarTest(Test test);
	
	//Método que permite actualizar un test
	Test actualizarTest (Test test);
	
	
	//Método que permite eliminar un test
	void eliminarTest (int id);
	
	//Método que permite consultar un test por id
	Test consultarById (int id);
}
