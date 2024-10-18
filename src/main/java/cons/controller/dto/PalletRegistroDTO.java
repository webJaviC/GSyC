package cons.controller.dto;

import cons.entities.Pallet;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;

public class PalletRegistroDTO {

	
	private Long id;
	
	private int codigo;
	
	@NotNull
	private String gramaje;
	
	@NotNull
	private Double kilosNeto;
	
	@NotNull
	private Double kilosBruto;
	
	@NotNull
	private Double ancho;
	
	@NotNull
	private Double largo;
	
	@Transient
	private Boolean editando = false;
	
	@NotNull
	private Long idCalidad;

	public PalletRegistroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PalletRegistroDTO(Pallet p) {
		super();
		this.codigo = p.getCodigo();
		this.gramaje = p.getGramaje();
		this.kilosNeto = p.getKilosNeto();
		this.kilosBruto = p.getKilosBruto();
		this.ancho = p.getAncho();
		this.largo = p.getLargo();
		this.idCalidad = p.getCalidad().getId();
		this.editando = true;//siempre que entre acá es porque estoy en modo edición
	}
	
	public Pallet toPojo() {
		Pallet p = new Pallet();
		if (this.editando) {
			p.setId(this.getId());
		}
			p.setCodigo(this.getCodigo());
			p.setGramaje(this.getGramaje());
			p.setKilosNeto(this.getKilosNeto());
			p.setKilosBruto(this.getKilosBruto());
			p.setAncho(this.getAncho());
			p.setLargo(this.getLargo());
			return p;
		}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public Double getKilosBruto() {
		return kilosBruto;
	}

	public void setKilosBruto(Double kilosBruto) {
		this.kilosBruto = kilosBruto;
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

	public Long getIdCalidad() {
		return idCalidad;
	}

	public void setIdCalidad(Long idCalidad) {
		this.idCalidad = idCalidad;
	}
	
	
	
}
