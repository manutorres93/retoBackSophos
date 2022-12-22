/**
 * 
 */
package com.example.reto.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto.entity.Affiliates;

import com.example.reto.repository.AffiliatesRepository;

import com.example.reto.service.AffiliatesService;

/**
 * @author Lenovo
 * Clase que implementa los metodos de logica de negocio de la interface de AffiliatesServices
 *
 */

@Service
public class AffiliatesServicesImpl implements AffiliatesService {

	@Autowired
	private AffiliatesRepository affiliatesRepository;
	
	@Override
	public List<Affiliates> consultarAfiliados() {
		List <Affiliates> affiliatesDataSource = StreamSupport.stream(
				this.affiliatesRepository.findAll().spliterator(), false).collect(Collectors.toList());
		
		return affiliatesDataSource;
	}
	
	@Override
	public Affiliates guardarAfiliado(Affiliates affiliate) {
		return this.affiliatesRepository.save(affiliate);
	}
	
	@Override
	public Affiliates actualizarAfiliado(Affiliates affiliate) {
		return this.affiliatesRepository.save(affiliate);
	}
	
	@Override
	public void eliminarAfiliado(int idAffiliate) {
		this.affiliatesRepository.deleteById(idAffiliate);
		
	}

	@Override
	public Affiliates consultarPorId(int idAffiliate) {
		
		return this.affiliatesRepository.findById(idAffiliate).get();
	}

	
		
	

	

}
