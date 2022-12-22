/**
 * 
 */
package com.example.reto.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.reto.entity.Affiliates;



/**
 * @author Lenovo
 *Interface que contiene el CRUD con Spring JPA para la tabla de afiliados
 */
public interface AffiliatesRepository extends CrudRepository<Affiliates, Integer> {

}
