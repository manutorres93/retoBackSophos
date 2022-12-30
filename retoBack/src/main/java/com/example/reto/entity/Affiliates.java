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
 *Clase que representa las entidades de afiliados
 */


@Data
@Entity
@Table (name= "affiliates")
public class Affiliates {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idAffiliate")
	private int idAffiliate;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "age")
	private int age;
	
	@Column(name= "mail")
	private String mail;

	public Affiliates() {
		super();
	}

	public Affiliates(int idAffiliate, String name, int age, String mail) {
		super();
		this.idAffiliate = idAffiliate;
		this.name = name;
		this.age = age;
		this.mail = mail;
	}

	public int getIdAffiliate() {
		return idAffiliate;
	}

	public void setIdAffiliate(int idAffiliate) {
		this.idAffiliate = idAffiliate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
	
	
	
	
	
	
	
}