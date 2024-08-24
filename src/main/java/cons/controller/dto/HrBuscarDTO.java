package cons.controller.dto;

import jakarta.persistence.Id;

public class HrBuscarDTO {
	
	
	private Long id;
	
	private String descripcion;

	public Long getId() {
		if(id!=null && id>0)
			return id;
		else
			return null;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		if(descripcion!=null && descripcion.length()>0)
			return descripcion;
		else
			return null;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
