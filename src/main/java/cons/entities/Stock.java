package cons.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Stock {

	@Id
	private Long id;
	

	
	private Double kgNetosTotales;

	

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Double getKgNetosTotales() {
		return kgNetosTotales;
	}

	public void setKgNetosTotales(Double kgNetosTotales) {
		this.kgNetosTotales = kgNetosTotales;
	}
	
}