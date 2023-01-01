/**
 * 
 */
package com.example.reto.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.reto.entity.TestLab;

/**
 * @author Lenovo
 *Interface que contiene el CRUD con Spring JPA para la tabla de test
 */
public interface TestRepository extends CrudRepository<TestLab, Integer> {

}