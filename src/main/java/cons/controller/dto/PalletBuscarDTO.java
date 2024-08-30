package cons.controller.dto;

public class PalletBuscarDTO {
	
	private Long id;
	private String gramaje;
	private Long idCalidadSeleccionada;
	
	public Long getId() {
		if(id!=null && id>0)
			return id;
		else
			return null;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGramaje() {
		if(gramaje!=null && gramaje.length()>0)
			return gramaje;
		else
			return null;
	}
	public void setGramaje(String gramaje) {
		this.gramaje = gramaje;
	}
	public Long getIdCalidadSeleccionada() {
		return idCalidadSeleccionada;
	}
	public void setIdCalidadSeleccionada(Long idCalidadSeleccionada) {
		this.idCalidadSeleccionada = idCalidadSeleccionada;
	}
	
	

}
