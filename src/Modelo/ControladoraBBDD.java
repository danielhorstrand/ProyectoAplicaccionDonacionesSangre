package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControladoraBBDD {
	private String url= "";
	private String user = "";
	private String pwd = "";
	private String usr = "";
	private Connection conexion;
	
	public ControladoraBBDD()  {

		Properties propiedades = new Properties();
		InputStream entrada = null;
		
		try {
			File miFichero = new File("src/Modelo/datos.ini");
			if (miFichero.exists()){
				System.out.println("entra");
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url=propiedades.getProperty("url");
				user=propiedades.getProperty("user");
				pwd=propiedades.getProperty("pwd");
				usr=propiedades.getProperty("usr");
			}

			else
				System.out.println("Fichero no encontrado");
		} catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, user, pwd);

			if(conexion.isClosed())
				System.out.println("Fallo en Conexión con la Base de Datos");


		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");
			e.printStackTrace();
		}
	}
	public ObservableList<Donantes>  ConsultaPersonas() throws SQLException{
		//Preparo la conexión para ejecutar sentencias SQL de tipo update

		ObservableList<Donantes> listaDonantes =  FXCollections.observableArrayList();
		
		Statement stm = conexion.createStatement();
		String selectsql = "SELECT NUM_DONANTE, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION, FECHA_NACIMIENTO, PAIS_NACIMIENTO, DIRECCION, POBLACION, CODIGO_POSTAL, TELEFONO, TELEFONO2,  CICLO, CORREO_ELECTRONICO, SEXO, GRUPO_SANGUINEO FROM "+usr+".DONANTE";

		ResultSet resultado = stm.executeQuery(selectsql);
	
		try{
			while (resultado.next()) {
				int num_donante = resultado.getInt(1);
				String nombre = resultado.getString(2);
				String apellido1 = resultado.getString(3);
				String apellido2 = resultado.getString(4);
				String identificacion = resultado.getString(5);
				String fecha_nacimiento = resultado.getString(6);
				String pais_nacimiento = resultado.getString(7);
				String direccion = resultado.getString(8);
				String poblacion = resultado.getString(9);
				int cod_postal = resultado.getInt(10);
				int telefono1 = resultado.getInt(11);
				int telefono2 = resultado.getInt(12);
				String ciclo = resultado.getString(13);
				String correo = resultado.getString(14);
				String sexo = resultado.getString(15);
				String grupo_sanguineo = resultado.getString(16);

				Donantes a = new Donantes (num_donante,nombre,apellido1,apellido2,identificacion,fecha_nacimiento,pais_nacimiento,direccion,poblacion,cod_postal,telefono1,telefono2,ciclo,correo,sexo,grupo_sanguineo);
				listaDonantes.add(a);
			}
			
		}catch(SQLException sqle){
			
			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}
		return listaDonantes;
	}
	public void guardarDonante(Donantes donante) throws SQLException{
		
	}
	public void modificarDonante(Donantes donante) throws SQLException{
		
	}
	public void eliminarDonante(Donantes donante) throws SQLException{
		
	}
	public void buscarDonante(Donantes donante) throws SQLException{
		
	}
	public void guardarFormulario(Formulario formulario) throws SQLException{
		
	}
	public void guardarDonacion(Donacion formulario) throws SQLException{
		
	}
	public void informeDonantes() throws SQLException{
		
	}
	public void informeDonaciones() throws SQLException{
		
	}
}
