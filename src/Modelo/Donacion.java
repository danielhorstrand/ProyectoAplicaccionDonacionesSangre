package Modelo;

public class Donacion {

	private int num_donacion;
	private int codigo_colecta;
	private String tipo_donacion;
	private int pulso;
	private int ta_sist;
	private int ta_diast;
	private int hb_cap;
	private int hb_ven;
	private int volumen;
	private String fecha;
	
	public Donacion(int num_donacion, int codigo_colecta, String tipo_donacion, int pulso, int ta_sist, int ta_diast,
			int hb_cap, int hb_ven, int volumen, String fecha) {
		super();
		this.num_donacion = num_donacion;
		this.codigo_colecta = codigo_colecta;
		this.tipo_donacion = tipo_donacion;
		this.pulso = pulso;
		this.ta_sist = ta_sist;
		this.ta_diast = ta_diast;
		this.hb_cap = hb_cap;
		this.hb_ven = hb_ven;
		this.volumen = volumen;
		this.fecha = fecha;
	}

	public int getNum_donacion() {
		return num_donacion;
	}

	public void setNum_donacion(int num_donacion) {
		this.num_donacion = num_donacion;
	}

	public int getCodigo_colecta() {
		return codigo_colecta;
	}

	public void setCodigo_colecta(int codigo_colecta) {
		this.codigo_colecta = codigo_colecta;
	}

	public String getTipo_donacion() {
		return tipo_donacion;
	}

	public void setTipo_donacion(String tipo_donacion) {
		this.tipo_donacion = tipo_donacion;
	}

	public int getPulso() {
		return pulso;
	}

	public void setPulso(int pulso) {
		this.pulso = pulso;
	}

	public int getTa_sist() {
		return ta_sist;
	}

	public void setTa_sist(int ta_sist) {
		this.ta_sist = ta_sist;
	}

	public int getTa_diast() {
		return ta_diast;
	}

	public void setTa_diast(int ta_diast) {
		this.ta_diast = ta_diast;
	}

	public int getHb_cap() {
		return hb_cap;
	}

	public void setHb_cap(int hb_cap) {
		this.hb_cap = hb_cap;
	}

	public int getHb_ven() {
		return hb_ven;
	}

	public void setHb_ven(int hb_ven) {
		this.hb_ven = hb_ven;
	}

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
