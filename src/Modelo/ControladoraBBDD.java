package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	public int InsertarFoto(File archivofoto) throws SQLException{


		//ejecuto la sentencia
		try{
			// Preparo la sentencia SQL
			String insertsql = "INSERT INTO "+usr+".DONANTE (FOTO) VALUES (?)";
			// Prepoparo la sentencia para ejecutar en la base de datos
			PreparedStatement pstmt = conexion.prepareStatement (insertsql);

			FileInputStream convertir_imagen = new FileInputStream (archivofoto);
			pstmt.setBlob(1, convertir_imagen, archivofoto.length());

			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la inserción " + resultado);
			else
				System.out.println("Persona insertada con éxito!!!");


		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe una persona con  ese email!!");
				return 1;
			}
			else{
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
				return 2;
			}

		}catch(FileNotFoundException FnfEx){
			System.out.println("Fichero no existe");
			return 3;
		}

		return 0;
	}
	public void guardarDonante (Donantes donante)  throws SQLException, FileNotFoundException{
		
		String rutafoto = donante.getFile().getPath();
		Statement stm = conexion.createStatement();
		File archivofoto = new File(rutafoto);
		
		try{
			String insertsql = "INSERT INTO "+usr+".DONANTE VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conexion.prepareStatement (insertsql);
			pstmt.setInt(1, donante.getNum_donante());
			pstmt.setString(2, donante.getNombre());
			pstmt.setString(3, donante.getApellido1());
			pstmt.setString(4, donante.getApellido2());
			pstmt.setString(5, donante.getIdentificacion());
			pstmt.setString(6, donante.getFecha_nacimiento());
			pstmt.setString(7, donante.getPais_nacimiento());
			pstmt.setString(8, donante.getDireccion());
			pstmt.setString(9, donante.getPoblacion());
			pstmt.setInt(10, donante.getCodigo_postal());
			pstmt.setInt(11, donante.getTelefono1());
			pstmt.setInt(12, donante.getTelefono2());
			
			FileInputStream convertir_imagen = new FileInputStream (archivofoto);
			
			pstmt.setBlob(13, convertir_imagen, archivofoto.length());
			pstmt.setString(14, donante.getCiclo());
			pstmt.setString(15, donante.getCorreo());
			pstmt.setString(16, donante.getSexo());
			pstmt.setString(17, donante.getGrupo_sanguineo());

			
			int resultado = pstmt.executeUpdate();

			if(resultado != 1){
				System.out.println("Error en la inserción " + resultado);
		}else{
				System.out.println("Persona insertada con éxito!!!");
		}
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);
			System.out.println(codeErrorSQL);

			if(codeErrorSQL.equals("ORA-00001") )
				System.out.println("ERROR.La persona que intentas introducir ya existe, o su clave 'Email' ya esta inscrita!");
			else
				System.out.println("Ha habido algún problema con  Oracle al hacer la creación de tabla");
		}

	}

    public void modificarDonante (Donantes donante1,Donantes donante2)  throws SQLException, FileNotFoundException{		
		
		Statement stm = conexion.createStatement();
		
    	String rutafoto = donante2.getFile().getPath();
		File archivofoto = new File(rutafoto);

		try{
			String insertsql = "UPDATE "+usr+".DONANTE SET NUM_DONANTE=?, NOMBRE=?, APELLIDO1=?, APELLIDO2=?, IDENTIFICACION=?, FECHA_NACIMIENTO=?, PAIS_NACIMIENTO=?, DIRECCION=?, POBLACION=?, CODIGO_POSTAL=?, TELEFONO=?, TELEFONO2=?,  CICLO=?, CORREO_ELECTRONICO=?, SEXO=?, GRUPO_SANGUINEO=? WHERE NUM_DONANTE=?";

			PreparedStatement pstmt = conexion.prepareStatement (insertsql);
			pstmt.setInt(1, donante2.getNum_donante());
			pstmt.setString(2, donante2.getNombre());
			pstmt.setString(3, donante2.getApellido1());
			pstmt.setString(4, donante2.getApellido2());
			pstmt.setString(5, donante2.getIdentificacion());
			pstmt.setString(6, donante2.getFecha_nacimiento());
			pstmt.setString(7, donante2.getPais_nacimiento());
			pstmt.setString(8, donante2.getDireccion());
			pstmt.setString(9, donante2.getPoblacion());
			pstmt.setInt(10, donante2.getCodigo_postal());
			pstmt.setInt(11, donante2.getTelefono1());
			pstmt.setInt(12, donante2.getTelefono2());
			
			FileInputStream convertir_imagen = new FileInputStream (archivofoto);
			
			pstmt.setBlob(13, convertir_imagen, archivofoto.length());
			pstmt.setString(14, donante2.getCiclo());
			pstmt.setString(15, donante2.getCorreo());
			pstmt.setString(16, donante2.getSexo());
			pstmt.setString(17, donante2.getGrupo_sanguineo());
			pstmt.setInt(18, donante1.getNum_donante());
			int resultado = pstmt.executeUpdate();

			System.out.println(resultado);
			if(resultado != 1){
				System.out.println("Error en la modificacion " + resultado);
		}else{
				System.out.println("Persona actualizada con éxito!!!");
		}
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}
	
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
