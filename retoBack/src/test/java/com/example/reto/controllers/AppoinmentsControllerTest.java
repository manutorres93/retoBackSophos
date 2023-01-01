package com.example.reto.controllers;

import static org.hamcrest.Matchers.empty;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appoinments;
import com.example.reto.entity.TestLab;
import com.example.reto.repository.AppoinmentsRepository;
import com.example.reto.repository.TestRepository;
import com.example.reto.service.AppoinmentsService;
import com.example.reto.service.TestService;
import com.example.reto.service.impl.AppoinmentsServiceImpl;

@ExtendWith(MockitoExtension.class)
class AppoinmentsControllerTest {
	
	@Autowired
	TestLab test;
	
	@Autowired
	Affiliates affiliates;
		
	@Autowired
	Appoinments appoinmentsMock;

	@InjectMocks
	AppoinmentsController appoinmentsTest= new AppoinmentsController ();
	
	@Mock
	AppoinmentsService appoinmentServiceMock;
	AppoinmentsServiceImpl appoinmentServiceImplMock;
	AppoinmentsRepository appoinmentRepositoryMock;/* = Mockito.mock(AppoinmentsRepository.class);*/
	
	@Autowired
	AppoinmentsServiceImpl appoinmentsServiceImpl = new AppoinmentsServiceImpl();
	
//	@BeforeEach
//    void setUp() {
//		Appoinments appoinmentMock = new Appoinments();
//		appoinmentMock.setDate(null);
//		appoinmentMock.setHora(null);
//		appoinmentMock.setId(1);
//		appoinmentMock.setIdAffiliate(affiliates);
//		appoinmentMock.setIdTest(null);
//		
//		//when(appoinmentServiceMock.consultarCitas()).thenReturn (appoinmentMock);
//	}
//	
	
	
	@Test
	void testConsultarAppoinmentVacio() {
		//fail("Not yet implemented");
		when (appoinmentServiceMock.consultarCitas()).thenReturn (Collections.emptyList());
		var response = appoinmentsTest.consultarCitas();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	
	@Test
	void testConsultarAppoinment() {
		
		
		when (appoinmentServiceMock.consultarCitas()).thenReturn (Collections.singletonList(null));		
		var response = appoinmentsTest.consultarCitas();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testGuardarAppoinment() {
//		Appoinments appoinment = new Appoinments();
//		appoinment.setDate(null);
//		appoinment.setHora(null);
//		appoinment.setId(1);
//		appoinment.setIdAffiliate(affiliates);
//		appoinment.setIdTest(null);
		Appoinments appoinment= new Appoinments();
		when (appoinmentServiceMock.guardarCita(appoinment)).thenReturn(appoinment);		
		var response = appoinmentsTest.guardarCita(appoinment);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testGuardarAppoinmentExcepcion() {

		Appoinments appoinment= new Appoinments();
		when (appoinmentServiceMock.guardarCita(appoinment)).thenReturn(appoinment);		
		var response = appoinmentsTest.guardarCita(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testActualizarAppoinment() {

		Appoinments appoinment= new Appoinments();
		when (appoinmentServiceMock.actualizarCita(appoinment)).thenReturn(appoinment);		
		var response = appoinmentsTest.actualizarCita(appoinment);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testActualizarAppoinmentExcepcion() {

		Appoinments appoinment= new Appoinments();
		when (appoinmentServiceMock.actualizarCita(appoinment)).thenReturn(appoinment);		
		var response = appoinmentsTest.actualizarCita(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testConsultarPorId() {

		Appoinments appoinment= new Appoinments();
		when (appoinmentServiceMock.consultarPorId(anyInt())).thenReturn(appoinment);		
		var response = appoinmentsTest.consultarPorId(anyInt());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testConsultarPorIdNotFound() {

		int numero=1;
		when (appoinmentServiceMock.consultarPorId(numero)).thenReturn(null);		
		var response = appoinmentsTest.consultarPorId(anyInt());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testfindByIdAffiliate() {
		
		when (appoinmentServiceMock.findByIdAffiliate(affiliates)).thenReturn 
		(Collections.singletonList(null));		
		
		var response = appoinmentsTest.listarrAfiliadoById(affiliates);
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
//	@Test
//	void testfindByIdAffiliateNotFound() {
//		
//		when (appoinmentServiceMock.findByIdAffiliate(affiliates)).thenReturn (Collections.emptyList());		
//		
//		var response = appoinmentsTest.listarrAfiliadoById(null);
//		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//	}
	
	@Test
	void findByDateOrderByIdAffiliateAsc()  {
		
		when (appoinmentServiceMock.findByDateOrderByIdAffiliateAsc(anyString())).thenReturn 
		(Collections.singletonList(null));		
		
		var response = appoinmentsTest.listarPorFecha(anyString());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
//	@Test
//	void findByDateOrderByIdAffiliateAscExcepcion() {
//		
//		when (appoinmentServiceMock.findByDateOrderByIdAffiliateAsc(null)).thenReturn 
//		(Collections.emptyList());		
//		
//		var response = appoinmentsTest.listarPorFecha(null);
//		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());}
		
		
	
	
	@Test
	void testEliminarCita() {

		doNothing().when(appoinmentServiceMock).eliminarCita(anyInt());		
		var response = appoinmentsTest.eliminarCita(anyInt());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testEliminarCitaNoRealizada() {
		
		int numero=1;

		doNothing().when(appoinmentServiceMock).eliminarCita(numero);		
		var response = appoinmentsTest.eliminarCita(anyInt());
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	

}
