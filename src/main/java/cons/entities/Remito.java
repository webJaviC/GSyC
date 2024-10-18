package cons.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    List<Pallet> listProduc;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "remito_has_material", joinColumns = @JoinColumn(name = "remito_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "material_id", referencedColumnName = "id"))
     Set<Material> listProductos;
    
    // Constructor

      public Remito(Long id, LocalDate fecha, Boolean editando, List<Pallet> pallets, Set<Material> listProductos) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.editando = editando;
		this.listProduc = listProduc;
		this.listProductos = listProductos;
	}
      
public Remito() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    // Getters and Setters

    



	public void addProductos(Material producto){
        listProductos.add(producto);
    }
   
	
  

	public Set<Material> getListProductos() {
		return listProductos;
	}


	public void setListProductos(Set<Material> listProductos) {
		this.listProductos = listProductos;
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
    
    public List<Pallet> getListProduc() {
        return listProduc;
    }

    public void setListProduc(List<Pallet> listProduc) {
        this.listProduc = listProduc;
    }

    public void addProduct(Pallet producto){
        listProduc.add(producto);
    }

	public void setPallets(List<Pallet> pallets) {
		// TODO Auto-generated method stub
		
	}

  /*  public List<Pallet> getPallets() {
        return getPallets();
    }

    public void setPallets(List<Pallet> pallets) {
        this.pallets = pallets;
    }

    public void addPallet(Pallet pallet) {
        pallet.setRemitoSet(this);
        this.pallets.add(pallet);
    }
    

    public void removePallet(Pallet pallet) {
        pallet.setRemitoSet(null);
        this.pallets.remove(pallet);
    }*/
}
