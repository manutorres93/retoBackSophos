/**
 * 
 */
package com.example.reto.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appoinments;
import com.example.reto.service.AppoinmentsService;

/**
 * Controlador que manipula el flujo de los servicios rest del microservicio de Citas
 *
 */

@RestController
@RequestMapping ("/appoinments")
public class AppoinmentsController {
	
	@Autowired
	private AppoinmentsService appoinmentsServiceImpl;
	
	
	
	@GetMapping
	public ResponseEntity<?> consultarCitas() {
		
			List<Appoinments> citasConsultadas = this.appoinmentsServiceImpl.consultarCitas();
			
			if (citasConsultadas.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}else {
			
			return ResponseEntity.ok(citasConsultadas);
			}
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<?> guardarCita(@RequestBody Appoinments citas) {
		
		try {
			Appoinments citaGuardada= this.appoinmentsServiceImpl.guardarCita(citas);
			return ResponseEntity.status(HttpStatus.CREATED).body(citaGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
	}
	
	
	
	@PutMapping
	public ResponseEntity<?> actualizarCita(@RequestBody Appoinments citas){
		
		try {
			Appoinments citaActualizada= this.appoinmentsServiceImpl.actualizarCita(citas);
			return ResponseEntity.status(HttpStatus.CREATED).body(citaActualizada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	//@DeleteMapping
	@RequestMapping (value ="{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminarCita(@PathVariable int id){
		//this.appoinmentsServiceImpl.eliminarCita(id);
		//return ResponseEntity.ok().build();
		
	
	try {
		this.appoinmentsServiceImpl.eliminarCita(id);
		return ResponseEntity.ok().build();
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	}
	
	@RequestMapping (value=  "/idAffiliate/{idAffiliates}"/*,"/{idAffiliates}"}*/, method = RequestMethod.GET)
	public ResponseEntity<?>listarrAfiliadoById (@PathVariable ("idAffiliates")Affiliates idAffiliates){
//		try {
			List<Appoinments> citasPorAfiliado= this.appoinmentsServiceImpl.findByIdAffiliate(idAffiliates);
			return ResponseEntity.ok(citasPorAfiliado);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		List<Appoinments> citasPorAfiliado= this.appoinmentsServiceImpl.findByIdAffiliate(idAffiliates);
//		if (citasPorAfiliado.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}else {
//		
//		return ResponseEntity.ok(citasPorAfiliado);
//		}
//		
	}
	
	
	@RequestMapping (value ="{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarPorId(@PathVariable int id){
		
		try {
			Appoinments citaPorId= this.appoinmentsServiceImpl.consultarPorId(id);
			return ResponseEntity.status(HttpStatus.OK).body(citaPorId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
		
	}

	
	
	
	
	@RequestMapping (value ="/listadoporfecha/{date}", method = RequestMethod.GET)
	
	public ResponseEntity<?>listarPorFecha (@PathVariable String date)
	
	{
       // try {
        	List<Appoinments> citasPorFecha = this.appoinmentsServiceImpl.findByDateOrderByIdAffiliateAsc(date);
            
            return ResponseEntity.ok(citasPorFecha);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		
        
    }
		
	
	


}
