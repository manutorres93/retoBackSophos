/**
 * 
 */
package com.example.reto.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.reto.entity.Affiliates;
import com.example.reto.entity.Appoinments;


/**
 * @author Lenovo
 *Interface que contiene el CRUD con Spring JPA para la tabla de citas
 */
public interface AppoinmentsRepository extends JpaRepository<Appoinments, Integer> {
	List<Appoinments> findByIdAffiliate(Affiliates idAffiliate);
    List<Appoinments> findByDateOrderByIdAffiliateAsc(LocalDate date);
    

}