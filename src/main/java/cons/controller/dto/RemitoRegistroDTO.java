package cons.controller.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import cons.entities.Pallet;
import cons.entities.Remito;
import cons.service.PalletService;
import jakarta.persistence.Transient;

public class RemitoRegistroDTO {
	
	@NotNull
	private Long id;
	@NotNull
	private LocalDate fecha;
	 @NotNull
	 private List<Pallet> pallets;
	 
	 @Transient
		private Boolean editando = false;

	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}

	public RemitoRegistroDTO(Remito r) {
		super();
		this.id = r.getId();
		this.fecha = r.getFecha();
		this.pallets = new ArrayList<>();
	}

	public RemitoRegistroDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<Pallet> getPallets() {
        return pallets;
    }
    
    public void addPallet(Pallet pallet) {
        this.pallets.add(pallet);
    }
    
    public void setIdPallets(List<Pallet> pallets) {
        this.pallets = pallets;
    }

	/* public Remito toPojo(PalletService palletService) {
	        Remito r = new Remito();
	        r.setId(this.id);
	        r.setFecha(this.fecha);
	        // Convertir IDs a Pallets
	        List<Pallet> pallets = (List<Pallet>) palletService.getById(this.idPallet);
	        r.setPallets(pallets);
	        this.editando = true;
	        return r;
	    } */
    public Remito toPojo() {
        Remito r = new Remito();
        r.setId(this.id);
        r.setFecha(this.fecha);
        r.setPallets(this.pallets);
        this.editando = true;
        return r;
    }
	
}
