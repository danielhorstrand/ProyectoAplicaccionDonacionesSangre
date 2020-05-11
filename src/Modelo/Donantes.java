package Modelo;

import java.io.File;
import java.time.LocalDate;

public class Donantes {

	private int num_donante;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String identificacion;
	private String fecha_nacimiento;
	private String pais_nacimiento;
	private String direccion;
	private String poblacion;
	private int codigo_postal;
	private int telefono1;
	private int telefono2;
	private File file;
	private String ciclo;
	private String correo;
	private String sexo;
	private String grupo_sanguineo;
		
	public Donantes(int num_donante) {
		super();
		this.num_donante = num_donante;
	}

	public Donantes(int num_donante, String nombre, String apellido1, String apellido2, String identificacion,
			String fecha_nacimiento, String pais_nacimiento, String direccion, String poblacion, int codigo_postal,
			int telefono1, int telefono2, String ciclo, String correo, String sexo, String grupo_sanguineo) {
		super();
		this.num_donante = num_donante;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.identificacion = identificacion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.pais_nacimiento = pais_nacimiento;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codigo_postal = codigo_postal;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.ciclo = ciclo;
		this.correo = correo;
		this.sexo = sexo;
		this.grupo_sanguineo = grupo_sanguineo;
	}

	public Donantes(int num_donante, String nombre, String apellido1, String apellido2, String identificacion,
			String fecha_nacimiento,String pais_nacimiento, String direccion, String poblacion, int codigo_postal, int telefono1,
			int telefono2,File file, String ciclo, String correo, String sexo, String grupo_sanguineo) {
		super();
		this.num_donante = num_donante;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.identificacion = identificacion;
		this.fecha_nacimiento = fecha_nacimiento;
		this.pais_nacimiento = pais_nacimiento;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codigo_postal = codigo_postal;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.file = file;
		this.ciclo = ciclo;
		this.correo = correo;
		this.sexo = sexo;
		this.grupo_sanguineo = grupo_sanguineo;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getNum_donante() {
		return num_donante;
	}

	public void setNum_donante(int num_donante) {
		this.num_donante = num_donante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getPais_nacimiento() {
		return pais_nacimiento;
	}

	public void setPais_nacimiento(String pais_nacimiento) {
		this.pais_nacimiento = pais_nacimiento;
	}
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(int codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public int getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(int telefono1) {
		this.telefono1 = telefono1;
	}

	public int getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(int telefono2) {
		this.telefono2 = telefono2;
	}
	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getGrupo_sanguineo() {
		return grupo_sanguineo;
	}

	public void setGrupo_sanguineo(String grupo_sanguineo) {
		this.grupo_sanguineo = grupo_sanguineo;
	}
	
	
	
}
