/**
 * 
 */
package com.example.reto.service;

import java.util.List;

import com.example.reto.entity.Affiliates;




/**
 * @author Lenovo
 * Interface que contiene los metodos de logica de negocio para los afiliados
 *
 */
public interface AffiliatesService {
	
	/*Método que permite consultar listado de afiliados
	 * @return listado de afiliados
	*/
	List<Affiliates> consultarAfiliados();
	
	//Método que permite guardar un afiliado	
	
	Affiliates guardarAfiliado(Affiliates affiliate);
		
	//Método que permite actualizar un afiliado
	Affiliates actualizarAfiliado (Affiliates affiliate);
		
		
	//Método que permite eliminar un afiliado
	void eliminarAfiliado (int idAffiliate);
	
	//Método que permite consultar un test por id
	Affiliates consultarPorId (int idAffiliate);

}
