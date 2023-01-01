package com.example.reto.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.reto.entity.Affiliates;
import com.example.reto.entity.TestLab;
import com.example.reto.repository.AffiliatesRepository;
import com.example.reto.repository.TestRepository;
import com.example.reto.service.AffiliatesService;
import com.example.reto.service.TestService;
import com.example.reto.service.impl.AffiliatesServicesImpl;
import com.example.reto.service.impl.TestServiceImpl;

@ExtendWith(MockitoExtension.class)
class AffiliatesControllerTest {
	
	@Autowired
	Affiliates affiliates;
	
	@InjectMocks
	AffiliatesController affiliatesTest= new AffiliatesController();
	
	@Mock
	AffiliatesService affiliatesServiceMock;
	AffiliatesRepository affiliatesRepositoryMock;
	
	@Autowired
	AffiliatesServicesImpl AffiliatesServiceImpl = new AffiliatesServicesImpl ();

	@Test
	void testConsultarAffiliates() {
		
		when (affiliatesServiceMock.consultarAfiliados()).thenReturn (Collections.singletonList(null));		
		var response = affiliatesTest.consultarAfiliados();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testConsultarAffiliatesVacio() {
		
		when (affiliatesServiceMock.consultarAfiliados()).thenReturn (Collections.emptyList());		
		var response = affiliatesTest.consultarAfiliados();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test
	void testGuardarAffiliate() {
		
		Affiliates affiliates= new Affiliates();
		
		when(affiliatesServiceMock.guardarAfiliado(affiliates)).thenReturn(affiliates);
		
		var response = affiliatesTest.guardarAfiliado(affiliates);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testGuardarAffiliateExcepcion() {
		
		Affiliates affiliates= new Affiliates();
		
		when(affiliatesServiceMock.guardarAfiliado(affiliates)).thenReturn(affiliates);
		
		var response = affiliatesTest.guardarAfiliado(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testActualizarAffiliate() {
		
		Affiliates affiliates= new Affiliates();
		
		when(affiliatesServiceMock.actualizarAfiliado(affiliates)).thenReturn(affiliates);
		
		var response = affiliatesTest.actualizarAfiliado(affiliates);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testActualizarAffiliateExcepcion() {
		
		Affiliates affiliates= new Affiliates();
		
		when(affiliatesServiceMock.actualizarAfiliado(affiliates)).thenReturn(affiliates);
		
		var response = affiliatesTest.actualizarAfiliado(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testConsultarPorId() {
		
		Affiliates affiliates= new Affiliates();
		
		when(affiliatesServiceMock.consultarPorId(anyInt())).thenReturn(affiliates);
		
		var response = affiliatesTest.consultarPorId(anyInt());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testConsultarPorIdNotFound() {
		
		Affiliates affiliates= new Affiliates();
		int numero=1;
		
		when(affiliatesServiceMock.consultarPorId(numero)).thenReturn(affiliates);
		
		var response = affiliatesTest.consultarPorId(anyInt());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}


}
