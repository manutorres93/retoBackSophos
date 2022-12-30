/**
 * 
 */
package com.example.reto.service;


import java.time.LocalDate;
import java.util.List;
import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appoinments;

/**
 * @author Lenovo
 *Interface que contiene los metodos de logica de negocio para las citas
 *
 */
public interface AppoinmentsService {
	
	/*Método que permite consultar listado de citas
	 * @return listado de citas
	 * Getlist
	*/
	List<Appoinments> consultarCitas();
	
	//Método que permite guardar una cita nueva
	
	Appoinments guardarCita(Appoinments cita);
		
	//Método que permite actualizar una cita
	Appoinments actualizarCita (Appoinments cita);
		
		
	//Método que permite eliminar una cita
	void eliminarCita (int id);
	
	//Método que permite consultar una cita por id
	Appoinments consultarPorId (int id);
	
   //Método que permite consultar una cita por fecha
	List<Appoinments> findByDateOrderByIdAffiliateAsc(String date);
	
	
	//Método que permite consultar una cita por afiliado
	List<Appoinments> findByIdAffiliate(Affiliates idAffiliate);
}