package Modelo;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Formulario {

	private int num_formulario;
	private String pregunta1;
	private String pregunta2;
	private String pregunta3;
	private String pregunta4;
	private String pregunta5;
	private String pregunta6;
	private String pregunta7;
	private String pregunta8;
	private String pregunta9;
	private String pregunta10;
	private String pregunta11;
	private String pregunta12;
	private String pregunta13;
	private String pregunta14;
	private String pregunta15;
	private String pregunta16;
	private String pregunta17;
	private String pregunta18;
	private String pregunta19;
	private String pregunta20;
	private String pregunta21;
	private String pregunta22;
	private String pregunta23;
	private String pregunta24;
	private String pregunta25;
	private String pregunta26;
	private String pregunta27;
	private String pregunta28;
	private String pregunta29;
	private String pregunta30;
	private String pregunta31;
	private String pregunta32;
	private String preguntaEX1;
	private String preguntaEX2;
	private String preguntaEX3;
	private String apto;
	private String fecha;
	private String estado_donacion;
	private String fecha_exclusion;

	
	public Formulario(int num_formulario, String pregunta1, String pregunta2, String pregunta3, String pregunta4,
			String pregunta5, String pregunta6, String pregunta7, String pregunta8, String pregunta9, String pregunta10,
			String pregunta11, String pregunta12, String pregunta13, String pregunta14, String pregunta15,
			String pregunta16, String pregunta17, String pregunta18, String pregunta19, String pregunta20,
			String pregunta21, String pregunta22, String pregunta23, String pregunta24, String pregunta25,
			String pregunta26, String pregunta27, String pregunta28, String pregunta29, String pregunta30,
			String pregunta31, String pregunta32, String preguntaEX1, String preguntaEX2, String preguntaEX3,
			String apto, String fecha, String estado_donacion, String fecha_exclusion) {
		super();
		this.num_formulario = num_formulario;
		this.pregunta1 = pregunta1;
		this.pregunta2 = pregunta2;
		this.pregunta3 = pregunta3;
		this.pregunta4 = pregunta4;
		this.pregunta5 = pregunta5;
		this.pregunta6 = pregunta6;
		this.pregunta7 = pregunta7;
		this.pregunta8 = pregunta8;
		this.pregunta9 = pregunta9;
		this.pregunta10 = pregunta10;
		this.pregunta11 = pregunta11;
		this.pregunta12 = pregunta12;
		this.pregunta13 = pregunta13;
		this.pregunta14 = pregunta14;
		this.pregunta15 = pregunta15;
		this.pregunta16 = pregunta16;
		this.pregunta17 = pregunta17;
		this.pregunta18 = pregunta18;
		this.pregunta19 = pregunta19;
		this.pregunta20 = pregunta20;
		this.pregunta21 = pregunta21;
		this.pregunta22 = pregunta22;
		this.pregunta23 = pregunta23;
		this.pregunta24 = pregunta24;
		this.pregunta25 = pregunta25;
		this.pregunta26 = pregunta26;
		this.pregunta27 = pregunta27;
		this.pregunta28 = pregunta28;
		this.pregunta29 = pregunta29;
		this.pregunta30 = pregunta30;
		this.pregunta31 = pregunta31;
		this.pregunta32 = pregunta32;
		this.preguntaEX1 = preguntaEX1;
		this.preguntaEX2 = preguntaEX2;
		this.preguntaEX3 = preguntaEX3;
		this.apto = apto;
		this.fecha = fecha;
		this.estado_donacion = estado_donacion;
		this.fecha_exclusion = fecha_exclusion;
	}
	public Formulario(int num_donante) {
		// TODO Auto-generated constructor stub
	}
	public int getNum_formulario() {
		return num_formulario;
	}
	public void setNum_formulario(int num_formulario) {
		this.num_formulario = num_formulario;
	}
	public String getPregunta1() {
		return pregunta1;
	}
	public void setPregunta1(String pregunta1) {
		this.pregunta1 = pregunta1;
	}
	public String getPregunta2() {
		return pregunta2;
	}
	public void setPregunta2(String pregunta2) {
		this.pregunta2 = pregunta2;
	}
	public String getPregunta3() {
		return pregunta3;
	}
	public void setPregunta3(String pregunta3) {
		this.pregunta3 = pregunta3;
	}
	public String getPregunta4() {
		return pregunta4;
	}
	public void setPregunta4(String pregunta4) {
		this.pregunta4 = pregunta4;
	}
	public String getPregunta5() {
		return pregunta5;
	}
	public void setPregunta5(String pregunta5) {
		this.pregunta5 = pregunta5;
	}
	public String getPregunta6() {
		return pregunta6;
	}
	public void setPregunta6(String pregunta6) {
		this.pregunta6 = pregunta6;
	}
	public String getPregunta7() {
		return pregunta7;
	}
	public void setPregunta7(String pregunta7) {
		this.pregunta7 = pregunta7;
	}
	public String getPregunta8() {
		return pregunta8;
	}
	public void setPregunta8(String pregunta8) {
		this.pregunta8 = pregunta8;
	}
	public String getPregunta9() {
		return pregunta9;
	}
	public void setPregunta9(String pregunta9) {
		this.pregunta9 = pregunta9;
	}
	public String getPregunta10() {
		return pregunta10;
	}
	public void setPregunta10(String pregunta10) {
		this.pregunta10 = pregunta10;
	}
	public String getPregunta11() {
		return pregunta11;
	}
	public void setPregunta11(String pregunta11) {
		this.pregunta11 = pregunta11;
	}
	public String getPregunta12() {
		return pregunta12;
	}
	public void setPregunta12(String pregunta12) {
		this.pregunta12 = pregunta12;
	}
	public String getPregunta13() {
		return pregunta13;
	}
	public void setPregunta13(String pregunta13) {
		this.pregunta13 = pregunta13;
	}
	public String getPregunta14() {
		return pregunta14;
	}
	public void setPregunta14(String pregunta14) {
		this.pregunta14 = pregunta14;
	}
	public String getPregunta15() {
		return pregunta15;
	}
	public void setPregunta15(String pregunta15) {
		this.pregunta15 = pregunta15;
	}
	public String getPregunta16() {
		return pregunta16;
	}
	public void setPregunta16(String pregunta16) {
		this.pregunta16 = pregunta16;
	}
	public String getPregunta17() {
		return pregunta17;
	}
	public void setPregunta17(String pregunta17) {
		this.pregunta17 = pregunta17;
	}
	public String getPregunta18() {
		return pregunta18;
	}
	public void setPregunta18(String pregunta18) {
		this.pregunta18 = pregunta18;
	}
	public String getPregunta19() {
		return pregunta19;
	}
	public void setPregunta19(String pregunta19) {
		this.pregunta19 = pregunta19;
	}
	public String getPregunta20() {
		return pregunta20;
	}
	public void setPregunta20(String pregunta20) {
		this.pregunta20 = pregunta20;
	}
	public String getPregunta21() {
		return pregunta21;
	}
	public void setPregunta21(String pregunta21) {
		this.pregunta21 = pregunta21;
	}
	public String getPregunta22() {
		return pregunta22;
	}
	public void setPregunta22(String pregunta22) {
		this.pregunta22 = pregunta22;
	}
	public String getPregunta23() {
		return pregunta23;
	}
	public void setPregunta23(String pregunta23) {
		this.pregunta23 = pregunta23;
	}
	public String getPregunta24() {
		return pregunta24;
	}
	public void setPregunta24(String pregunta24) {
		this.pregunta24 = pregunta24;
	}
	public String getPregunta25() {
		return pregunta25;
	}
	public void setPregunta25(String pregunta25) {
		this.pregunta25 = pregunta25;
	}
	public String getPregunta26() {
		return pregunta26;
	}
	public void setPregunta26(String pregunta26) {
		this.pregunta26 = pregunta26;
	}
	public String getPregunta27() {
		return pregunta27;
	}
	public void setPregunta27(String pregunta27) {
		this.pregunta27 = pregunta27;
	}
	public String getPregunta28() {
		return pregunta28;
	}
	public void setPregunta28(String pregunta28) {
		this.pregunta28 = pregunta28;
	}
	public String getPregunta29() {
		return pregunta29;
	}
	public void setPregunta29(String pregunta29) {
		this.pregunta29 = pregunta29;
	}
	public String getPregunta30() {
		return pregunta30;
	}
	public void setPregunta30(String pregunta30) {
		this.pregunta30 = pregunta30;
	}
	public String getPregunta31() {
		return pregunta31;
	}
	public void setPregunta31(String pregunta31) {
		this.pregunta31 = pregunta31;
	}
	public String getPregunta32() {
		return pregunta32;
	}
	public void setPregunta32(String pregunta32) {
		this.pregunta32 = pregunta32;
	}
	public String getPreguntaEX1() {
		return preguntaEX1;
	}
	public void setPreguntaEX1(String preguntaEX1) {
		this.preguntaEX1 = preguntaEX1;
	}
	public String getPreguntaEX2() {
		return preguntaEX2;
	}
	public void setPreguntaEX2(String preguntaEX2) {
		this.preguntaEX2 = preguntaEX2;
	}
	public String getPreguntaEX3() {
		return preguntaEX3;
	}
	public void setPreguntaEX3(String preguntaEX3) {
		this.preguntaEX3 = preguntaEX3;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getApto() {
		return apto;
	}
	public void setApto(String apto) {
		this.apto = apto;
	}
	public String getEstado_donacion() {
		return estado_donacion;
	}
	public void setEstado_donacion(String estado_donacion) {
		this.estado_donacion = estado_donacion;
	}
	public String getFecha_exclusion() {
		return fecha_exclusion;
	}
	public void setFecha_exclusion(String fecha_exclusion) {
		this.fecha_exclusion = fecha_exclusion;
	}
	
}
