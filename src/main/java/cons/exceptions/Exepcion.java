package cons.exceptions;

public class Exepcion extends Exception{

	
	/*
	 * Atributo al que está asociado el error
	 */
	private  String atributo;
	
	public Exepcion() {
		super();
		
	}

	public Exepcion(String mensaje) {
		super(mensaje);
	}

	public Exepcion(String mensaje, String atributo) {
		super(mensaje);
		this.atributo=atributo;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
}