package cons.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;


@Entity
public class Remito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate fecha;
	
	/**
	 * propiedad utilizada por la capa de presentacion para saber si es una entidad ya persistida (la estoy actualizando) o es nueva, ya que si id es ingresado por el usuario, no puede ser usado como criterio para saber si fue persistida o no.
	 */
	@Transient
	private Boolean editando=false;
	
	@OneToMany(mappedBy = "remito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pallet> pallets;
	
	//getters and setters//

	public List<Pallet> getPallets() {
		return pallets;
	}

	public void setPallets(List<Pallet> pallets) {
		this.pallets = pallets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}
	
	

}
