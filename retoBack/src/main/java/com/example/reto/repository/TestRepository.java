/**
 * 
 */
package com.example.reto.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.reto.entity.Test;

/**
 * @author Lenovo
 *Interface que contiene el CRUD con Spring JPA para la tabla de test
 */
public interface TestRepository extends CrudRepository<Test, Integer> {

}