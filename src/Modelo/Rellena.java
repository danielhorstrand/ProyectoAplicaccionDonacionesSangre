package Modelo;

public class Rellena {
	
	private int num_donante;
	private int cod_formulario;
	
	public Rellena(int num_donante, int cod_formulario) {
		super();
		this.num_donante = num_donante;
		this.cod_formulario = cod_formulario;
	}
	
	
	public int getNum_donante() {
		return num_donante;
	}

	public void setNum_donante(int num_donante) {
		this.num_donante = num_donante;
	}

	public int getCod_formulario() {
		return cod_formulario;
	}

	public void setCod_formulario(int cod_formulario) {
		this.cod_formulario = cod_formulario;
	}

}
