package cons.controller.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cons.entities.Calidad;
import cons.entities.Hr;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;


public class HrRegistroDTO {

	@Id
	private Long id;
	
	@NotNull
	private String descripcion;
	
	@NotNull
	private String gramaje;
	
	@NotNull
	private Calidad idCalidad;
	
	@NotNull
	private Double kilos;
	
	@NotNull
	private Double largo;
	
	@NotNull
	private Double ancho;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fecha;
	
	@Transient
	private Boolean editando=false;
	
	//constructor
	
	
	public HrRegistroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HrRegistroDTO(Hr hr) {
		super();
	
		this.descripcion = hr.getDescripcion();
		this.gramaje = hr.getGramaje();
		this.idCalidad = hr.getCalidad();
		this.kilos = hr.getKilos();
		this.largo = hr.getLargo();
		this.ancho = hr.getAncho();
		this.fecha = hr.getFecha();
		this.editando = true;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getGramaje() {
		return gramaje;
	}

	public void setGramaje(String gramaje) {
		this.gramaje = gramaje;
	}

	public Calidad getIdCalidad() {
		return idCalidad;
	}

	public void setIdCalidad(Calidad idCalidad) {
		this.idCalidad = idCalidad;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public Hr toPojo()
	{
		Hr p = new Hr();
		if(!this.editando)
		{
			p.setId(this.getId());
		}
		p.setDescripcion(this.getDescripcion());
		p.setGramaje(this.getGramaje());
		p.setLargo(this.getLargo());
		p.setKilos(this.getKilos());
		p.setAncho(this.getAncho());
		p.setFecha(this.getFecha());
		p.setEditando(this.getEditando());
		
		return p;
	}
	
	
}
