package cons.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;


@Entity
public class Hr {

	@Id
	private Long id;
	
	private String descripcion;
	
	private String gramaje;
	
	@ManyToOne
	private Calidad calidad;
	
	private Double kilos;
	
	private Double largo;
	
	private Double ancho;
	
	private Date fecha;
	
	/**
	 * propiedad utilizada por la capa de presentacion para saber si es una entidad ya persistida (la estoy actualizando) o es nueva, ya que si id es ingresado por el usuario, no puede ser usado como criterio para saber si fue persistida o no.
	 */
	@Transient
	private Boolean editando=false;
	
	//geters and setters//
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

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

	public Calidad getCalidad() {
		return calidad;
	}

	public void setCalidad(Calidad calidad) {
		this.calidad = calidad;
	}


	public Double getKilos() {
		return kilos;
	}

	public void setKilos(Double kilos) {
		this.kilos = kilos;
	}

	public Double getLargo() {
		return largo;
	}

	public void setLargo(Double largo) {
		this.largo = largo;
	}

	public Double getAncho() {
		return ancho;
	}

	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
