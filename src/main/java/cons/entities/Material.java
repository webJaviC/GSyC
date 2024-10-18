package cons.entities;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "material")
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private int codigo;

	private String gramaje;

	private Double kilosNeto;

	private Double kilosBruto;

	private Double ancho;

	private Double largo;

	@Transient
	private Boolean editando = false;

	@ManyToOne
	@JoinColumn(name = "calidad_id") // Add this annotation
	private Calidad calidad;

	  @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	    @JoinTable(name = "remito_has_material", joinColumns = @JoinColumn(name = "marerial_id", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(name = "remito_id", referencedColumnName = "id"))
	Set<Remito> proveedorSet;
	
	// constructor//
	
	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Material(Long id, @NotNull int codigo, String gramaje, Double kilosNeto, Double kilosBruto, Double ancho,
			Double largo, Boolean editando, Calidad calidad, Remito remito) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.gramaje = gramaje;
		this.kilosNeto = kilosNeto;
		this.kilosBruto = kilosBruto;
		this.ancho = ancho;
		this.largo = largo;
		this.editando = editando;
		this.calidad = calidad;
		proveedorSet = new HashSet<>();
	}

	// getters and setters//

	 public Set<Remito> getProveedorSet() {
	        return proveedorSet;
	    }

	    public void setProveedorSet(Set<Remito> proveedorSet) {
	        this.proveedorSet = proveedorSet;
	    }

	    public void agregarProveedor(Remito remito){
	        proveedorSet.add(remito);
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

