/**
 * 
 */
package com.example.reto.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appoinments;
import com.example.reto.repository.AppoinmentsRepository;
import com.example.reto.service.AppoinmentsService;

/**
  *Clase que implementa los metodos de logica de negocio de la inteface de AppoinmentsService
 */

@Service
public class AppoinmentsServiceImpl implements AppoinmentsService {
	
	@Autowired
	private AppoinmentsRepository appoinmentsRepository;

	@Override
	public List<Appoinments> consultarCitas() {
		List <Appoinments> citasDataSource = StreamSupport.stream(
				this.appoinmentsRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return citasDataSource;
	}

	@Override
	public Appoinments guardarCita(Appoinments cita) {
		return this.appoinmentsRepository.save(cita);
		
	}

	@Override
	public Appoinments actualizarCita(Appoinments cita) {		
		return this.appoinmentsRepository.save(cita);
	}

	@Override
	public void eliminarCita(int id) {
		this.appoinmentsRepository.deleteById(id);

	}

	@Override
	public Appoinments consultarPorId(int id) {
		return this.appoinmentsRepository.findById(id).get();
	}

	@Override
	public List<Appoinments> findByIdAffiliate(Affiliates idAffiliate) {
		return this.appoinmentsRepository.findByIdAffiliate(idAffiliate);
	}

	@Override
	public List<Appoinments> findByDateOrderByIdAffiliateAsc(String date) {
		LocalDate horaCita = LocalDate.parse(date);
		return this.appoinmentsRepository.findByDateOrderByIdAffiliateAsc(horaCita);
	}

	
	



//	@Override
//	public List<Appoinments> getAppoinmentsByDate(LocalDate date) {
//		List <Appoinments> citasByDate = StreamSupport.stream(
//				this.appoinmentsRepository.findByDateOrderByIdAffiliateAsc(date).spliterator(), false).collect(Collectors.toList());
//		return citasByDate;
		
	
	}

	

