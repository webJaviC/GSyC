package cons.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;


@Entity
public class Pallet {

	@Id
	private Long id;
	
	private String gramaje;
	
	private Double kilosNeto;
	
	private Double kilosBruto;
	
	private Double ancho;
	
	private Double largo;
	
	@Transient
	private Boolean editando=false;
	
	 @ManyToOne
	    @JoinColumn(name = "calidad_id") // Add this annotation
	    private Calidad calidad;
	
	//getters and setters//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGramaje() {
		return gramaje;
	}

	public void setGramaje(String gramaje) {
		this.gramaje = gramaje;
	}

	public Double getKilosNeto() {
		return kilosNeto;
	}

	public void setKilosNeto(Double kilosNeto) {
		this.kilosNeto = kilosNeto;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Double getLargo() {
		return largo;
	}

	public void setLargo(Double largo) {
		this.largo = largo;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}


	public Double getKilosBruto() {
		return kilosBruto;
	}

	public void setKilosBruto(Double kilosBruto) {
		this.kilosBruto = kilosBruto;
	}

	public Calidad getCalidad() {
		return calidad;
	}

	public void setCalidad(Calidad calidad) {
		this.calidad = calidad;
	}
	
}
