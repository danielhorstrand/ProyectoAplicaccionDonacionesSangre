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
