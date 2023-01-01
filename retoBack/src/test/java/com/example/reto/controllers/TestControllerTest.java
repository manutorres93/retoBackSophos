package com.example.reto.controllers;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.example.reto.entity.TestLab;
import com.example.reto.repository.TestRepository;
import com.example.reto.service.TestService;
import com.example.reto.service.impl.TestServiceImpl;



@ExtendWith(MockitoExtension.class)
class TestControllerTest {
	
	@Autowired
	TestLab test;

	//crear el objeto
	
	@InjectMocks
	TestController testTest= new TestController ();
			
	@Mock
	TestService testServiceMock;
	TestRepository testRepositoryMock; /*= Mockito.mock(TestRepository.class);*/
	
	@Autowired
	TestServiceImpl testServiceImpl = new TestServiceImpl();
	
		
	@Test
	void testConsultarTestVacio() {
		
		when (testServiceMock.consultarTest()).thenReturn (Collections.emptyList());
		
		var response = testTest.consultarTest();
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}
	

	@Test
	void testConsultarTest() {
	
		when (testServiceMock.consultarTest()).thenReturn (Collections.singletonList(null));		
		var response = testTest.consultarTest();
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testGuardarTest() {
		
		TestLab test= new TestLab();
		
		when(testServiceMock.guardarTest(test)).thenReturn(test);
		
		var response = testTest.guardarTest(test);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testGuardarTestExcepcion() {
		//fail("Not yet implemented");
		TestLab test= new TestLab();
		
		when(testServiceMock.guardarTest(test)).thenReturn(test);
		
		var response = testTest.guardarTest(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testActualizarTest() {
		//fail("Not yet implemented");
		TestLab test= new TestLab();
		
		when(testServiceMock.actualizarTest(test)).thenReturn(test);
		
		var response = testTest.actualizarTest(test);
		Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	void testActualizarTestExcepcion() {
		
		TestLab test= new TestLab();
		
		when(testServiceMock.actualizarTest(test)).thenReturn(test);
		
		var response = testTest.actualizarTest(null);
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testConsultarById() {
		
		TestLab test= new TestLab();
				
		when(testServiceMock.consultarById(anyInt())).thenReturn(test);
		
		var response = testTest.consultarById(anyInt());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testConsultarByIdNotFound() {
		
		TestLab test= new TestLab();
		int numero=1;
				
		when(testServiceMock.consultarById(numero)).thenReturn(test);
		
		var response = testTest.consultarById(anyInt());
		Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
	
	@Test
	void testEliminarTest() {

		doNothing().when(testServiceMock).eliminarTest(anyInt());		
		var response = testTest.eliminarTest(anyInt());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testEliminarTestNotFound() {
		
		int numero=1;

		doNothing().when(testServiceMock).eliminarTest(numero);		
		var response = testTest.eliminarTest(anyInt());
		Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
	}


}
