package cons.entities;

import java.time.LocalDate;
import java.util.ArrayList;
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
    private Long id;

    private LocalDate fecha;

    @Transient
    private Boolean editando = false;

    @OneToMany(mappedBy = "remito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pallet> pallets = new ArrayList<>();

    // Getters and Setters

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

    public List<Pallet> getPallets() {
        return pallets;
    }

    public void setPallets(List<Pallet> pallets) {
        this.pallets = pallets;
    }

    public void addPallet(Pallet pallet) {
        pallet.setRemito(this);
        this.pallets.add(pallet);
    }

    public void removePallet(Pallet pallet) {
        pallet.setRemito(null);
        this.pallets.remove(pallet);
    }
}
