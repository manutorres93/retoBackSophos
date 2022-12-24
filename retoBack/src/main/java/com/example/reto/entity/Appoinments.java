/**
 * 
 */
package com.example.reto.entity;


import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Lenovo
 *Clase que representa las entidades de las citas
 */


@Data
@Entity
@Table (name= "appoinments")
public class Appoinments {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name= "id")
	private int id;
	
	

	@JsonFormat(pattern = "dd/MM/yyyy") 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column (name="fecha_cita")
	private LocalDate date;
	

	@JsonFormat(pattern = "HH:mm") 
	@DateTimeFormat(pattern = "HH:mm")
	@Column (name="hora_cita")
	private LocalTime hora;
	
	@ManyToOne (fetch = FetchType.EAGER,  cascade = CascadeType.MERGE)
	@JoinColumn (name ="idTest")
	//@JsonIncludeProperties ({"hibernateLazyInitializer", "handler"})
	private Test idTest;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn (name="idAffiliate")
	//@JsonIncludeProperties ({"hibernateLazyInitializer", "handler"})
	private Affiliates idAffiliate;
	

	public Appoinments() {
		super();
	}

	public Appoinments(int id, LocalDate date, LocalTime hora, Test idTest, Affiliates idAffiliate) {
		super();
		this.id = id;
		this.date = date;
		this.hora = hora;
		this.idTest = idTest;
		this.idAffiliate = idAffiliate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Test getIdTest() {
		return idTest;
	}

	public void setIdTest(Test idTest) {
		this.idTest = idTest;
	}

	public Affiliates getIdAffiliate() {
		return idAffiliate;
	}

	public void setIdAffiliate(Affiliates idAffiliate) {
		this.idAffiliate = idAffiliate;
	}

	

	
	
	
	

}
