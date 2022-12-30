/**
 * 
 */
package com.example.reto.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Lenovo
 *Clase que representa entidades de test
 */

@Data
@Entity
@Table (name= "test")

public class Test {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "idTest")
	private int id;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "description")
	private String description;

	public Test() {
		super();
	}

	public Test(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
	
	

}