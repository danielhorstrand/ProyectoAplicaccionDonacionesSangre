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
	public ObservableList<Donantes>  ConsultaDonantes() throws SQLException{
		//Preparo la conexión para ejecutar sentencias SQL de tipo update

		ObservableList<Donantes> listaDonantes =  FXCollections.observableArrayList();
		
		Statement stm = conexion.createStatement();
		String selectsql = "SELECT NUM_DONANTE, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION,TO_CHAR(FECHA_NACIMIENTO,'DD/MM/YYYY'), PAIS_NACIMIENTO, DIRECCION, POBLACION, CODIGO_POSTAL, TELEFONO, TELEFONO2,  CICLO, CORREO_ELECTRONICO, SEXO, GRUPO_SANGUINEO FROM "+usr+".DONANTE";

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
	public ObservableList<Formulario>  ConsultaFormularios() throws SQLException{
		//Preparo la conexión para ejecutar sentencias SQL de tipo update

		ObservableList<Formulario> listaFormulario =  FXCollections.observableArrayList();
		
		Statement stm = conexion.createStatement();
		String selectsql = "SELECT CODIGO FROM "+usr+".FORMULARIO";

		ResultSet resultado = stm.executeQuery(selectsql);
	
		try{
			while (resultado.next()) {
				int num_donante = resultado.getInt(1);

				Formulario n = new Formulario (num_donante);
				listaFormulario.add(n);
			}
			
		}catch(SQLException sqle){
			
			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}
		return listaFormulario;
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
	public int guardarDonante (Donantes donante)  throws SQLException{
		
			String insertsql = "INSERT INTO "+usr+".DONANTE (NUM_DONANTE,NOMBRE,APELLIDO1,APELLIDO2,IDENTIFICACION,FECHA_NACIMIENTO,PAIS_NACIMIENTO,DIRECCION,POBLACION,CODIGO_POSTAL,TELEFONO,TELEFONO2,CICLO,CORREO_ELECTRONICO,SEXO,GRUPO_SANGUINEO)VALUES (?,?,?,?,?,TO_DATE( ? , 'DD/MM/YYYY' ),?,?,?,?,?,?,?,?,?,?)";

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
			pstmt.setString(13, donante.getCiclo());
			pstmt.setString(14, donante.getCorreo());
			pstmt.setString(15, donante.getSexo());
			pstmt.setString(16, donante.getGrupo_sanguineo());

		
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la inserción " + resultado);
		    else
				System.out.println("Persona insertada con éxito!!!");
		
			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);
			System.out.println(codeErrorSQL);

			if(codeErrorSQL.equals("ORA-00001")){
				System.out.println("ERROR.La persona que intentas introducir ya existe, o su clave 'Email' ya esta inscrita!");
			    return 1;
			}
			else{
				System.out.println("Ha habido algún problema con  Oracle al hacer la creación de tabla");
			    return 2;
			}
		}

	}

    public int modificarDonante (Donantes donante)  throws SQLException{		
		
		Statement stm = conexion.createStatement();
		
			String insertsql = "UPDATE "+usr+".DONANTE SET NOMBRE=?, APELLIDO1=?, APELLIDO2=?, IDENTIFICACION=?, FECHA_NACIMIENTO=?, PAIS_NACIMIENTO=?, DIRECCION=?, POBLACION=?, CODIGO_POSTAL=?, TELEFONO=?, TELEFONO2=?,  CICLO=?, CORREO_ELECTRONICO=?, SEXO=?, GRUPO_SANGUINEO=? WHERE NUM_DONANTE=?";

			PreparedStatement pstmt = conexion.prepareStatement (insertsql);
			pstmt.setString(1, donante.getNombre());
			pstmt.setString(2, donante.getApellido1());
			pstmt.setString(3, donante.getApellido2());
			pstmt.setString(4, donante.getIdentificacion());
			pstmt.setString(5, donante.getFecha_nacimiento());
			pstmt.setString(6, donante.getPais_nacimiento());
			pstmt.setString(7, donante.getDireccion());
			pstmt.setString(8, donante.getPoblacion());
			pstmt.setInt(9, donante.getCodigo_postal());
			pstmt.setInt(10, donante.getTelefono1());
			pstmt.setInt(11, donante.getTelefono2());
			pstmt.setString(12, donante.getCiclo());
			pstmt.setString(13, donante.getCorreo());
			pstmt.setString(14, donante.getSexo());
			pstmt.setString(15, donante.getGrupo_sanguineo());
			pstmt.setInt(16, donante.getNum_donante());

			try{
				int resultado = pstmt.executeUpdate();
				if(resultado != 1)
					System.out.println("Error en la modificacion " + resultado);
			    else
					System.out.println("Donante actualizado con éxito!!!");

				return 0;
			}catch(SQLException sqle){
				
				int pos = sqle.getMessage().indexOf(":");
				String codeErrorSQL = sqle.getMessage().substring(0,pos);

				if(codeErrorSQL.equals("ORA-00001") ){
					System.out.println("Ya existe una Donante con  ese Numero!!");
					return 1;
				}
				else{
					System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
					return 2;
				}
		}
	
	}
    
    public int BorrarDonante(int num_donante) throws SQLException{

		String deletesql = "DELETE " + usr +".DONANTE WHERE NUM_DONANTE=?";
		PreparedStatement pstmt = conexion.prepareStatement (deletesql);
		pstmt.setInt(1, num_donante);

		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en el borrado " + resultado);
			else
				System.out.println("Donante borrado con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println("Ha habido algún problema con  Oracle al hacer el borrado: " + codeErrorSQL);
			return 2;
		}

	}
    public int BorrarFormulario(int num_formulario) throws SQLException{

		String deletesql = "DELETE " + usr +".FORMULARIO WHERE CODIGO=?";
		PreparedStatement pstmt = conexion.prepareStatement (deletesql);
		pstmt.setInt(1, num_formulario);

		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en el borrado " + resultado);
			else
				System.out.println("Formulario borrado con éxito!!!");

			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println("Ha habido algún problema con  Oracle al hacer el borrado: " + codeErrorSQL);
			return 2;
		}

	}
	public ObservableList<Donantes> BuscarDonantes(String Identificacion,String ciclo,String grupo_sanguineo) throws SQLException{

		ObservableList<Donantes> listaDonantes = FXCollections.observableArrayList();
		PreparedStatement pstmt;

		String selectsql = "";
		if(Identificacion.equals("") && ciclo.equals("-------") && grupo_sanguineo.equals("-------")){
			selectsql = "SELECT NUM_DONANTE, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION,TO_CHAR(FECHA_NACIMIENTO,'DD/MM/YYYY'), PAIS_NACIMIENTO, DIRECCION, POBLACION, CODIGO_POSTAL, TELEFONO, TELEFONO2,  CICLO, CORREO_ELECTRONICO, SEXO, GRUPO_SANGUINEO FROM " + usr +".DONANTE";
			pstmt = conexion.prepareStatement (selectsql);
		}
		else{
			if(Identificacion.equals("") && ciclo.equals("-------")){
				selectsql = "SELECT NUM_DONANTE, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION,TO_CHAR(FECHA_NACIMIENTO,'DD/MM/YYYY'), PAIS_NACIMIENTO, DIRECCION, POBLACION, CODIGO_POSTAL, TELEFONO, TELEFONO2,  CICLO, CORREO_ELECTRONICO, SEXO, GRUPO_SANGUINEO FROM " + usr +".DONANTE WHERE GRUPO_SANGUINEO LIKE ? ";
				pstmt = conexion.prepareStatement (selectsql);

				pstmt.setString(1, grupo_sanguineo+"%");
			}else{
				if (Identificacion.equals("") && grupo_sanguineo.equals("-------")){
					selectsql = "SELECT NUM_DONANTE, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION,TO_CHAR(FECHA_NACIMIENTO,'DD/MM/YYYY'), PAIS_NACIMIENTO, DIRECCION, POBLACION, CODIGO_POSTAL, TELEFONO, TELEFONO2,  CICLO, CORREO_ELECTRONICO, SEXO, GRUPO_SANGUINEO FROM " + usr +".DONANTE WHERE CICLO LIKE ? ";
					pstmt = conexion.prepareStatement (selectsql);

					pstmt.setString(1, ciclo+"%");
				}else{
					if (ciclo.equals("-------") && grupo_sanguineo.equals("-------")){
						selectsql = "SELECT NUM_DONANTE, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION,TO_CHAR(FECHA_NACIMIENTO,'DD/MM/YYYY'), PAIS_NACIMIENTO, DIRECCION, POBLACION, CODIGO_POSTAL, TELEFONO, TELEFONO2,  CICLO, CORREO_ELECTRONICO, SEXO, GRUPO_SANGUINEO FROM " + usr +".DONANTE WHERE IDENTIFICACION LIKE ? ";
						pstmt = conexion.prepareStatement (selectsql);

						pstmt.setString(1, Identificacion+"%");
					}else{
						if (Identificacion.equals("")){
							selectsql = "SELECT NUM_DONANTE, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION,TO_CHAR(FECHA_NACIMIENTO,'DD/MM/YYYY'), PAIS_NACIMIENTO, DIRECCION, POBLACION, CODIGO_POSTAL, TELEFONO, TELEFONO2,  CICLO, CORREO_ELECTRONICO, SEXO, GRUPO_SANGUINEO FROM " + usr +".DONANTE WHERE CICLO LIKE ?  AND GRUPO_SANGUINEO LIKE ?";
							pstmt = conexion.prepareStatement (selectsql);

							pstmt.setString(1, ciclo+"%");
							pstmt.setString(2, grupo_sanguineo+"%");
						}else{
							if (ciclo.equals("-------")){
								selectsql = "SELECT NUM_DONANTE, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION,TO_CHAR(FECHA_NACIMIENTO,'DD/MM/YYYY'), PAIS_NACIMIENTO, DIRECCION, POBLACION, CODIGO_POSTAL, TELEFONO, TELEFONO2,  CICLO, CORREO_ELECTRONICO, SEXO, GRUPO_SANGUINEO FROM " + usr +".DONANTE WHERE IDENTIFICACION LIKE ?  AND GRUPO_SANGUINEO LIKE ?";
								pstmt = conexion.prepareStatement (selectsql);

								pstmt.setString(1, Identificacion+"%");
								pstmt.setString(2, grupo_sanguineo+"%");
							}else{
								if (grupo_sanguineo.equals("-------")){
									selectsql = "SELECT NUM_DONANTE, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION,TO_CHAR(FECHA_NACIMIENTO,'DD/MM/YYYY'), PAIS_NACIMIENTO, DIRECCION, POBLACION, CODIGO_POSTAL, TELEFONO, TELEFONO2,  CICLO, CORREO_ELECTRONICO, SEXO, GRUPO_SANGUINEO FROM " + usr +".DONANTE WHERE IDENTIFICACION LIKE ?  AND CICLO LIKE ?";
									pstmt = conexion.prepareStatement (selectsql);

									pstmt.setString(1, Identificacion+"%");
									pstmt.setString(2, ciclo+"%");
								}else{
									selectsql = "SELECT NUM_DONANTE, NOMBRE, APELLIDO1, APELLIDO2, IDENTIFICACION,TO_CHAR(FECHA_NACIMIENTO,'DD/MM/YYYY'), PAIS_NACIMIENTO, DIRECCION, POBLACION, CODIGO_POSTAL, TELEFONO, TELEFONO2,  CICLO, CORREO_ELECTRONICO, SEXO, GRUPO_SANGUINEO FROM " + usr +".DONANTE WHERE (IDENTIFICACION LIKE ? ) AND (CICLO LIKE ? ) AND (GRUPO_SANGUINEO LIKE ? )";
									pstmt = conexion.prepareStatement (selectsql);

									pstmt.setString(1, Identificacion+"%");
									pstmt.setString(2, ciclo);
									pstmt.setString(3, grupo_sanguineo);
								}
							}
						}
					}
				}
			}

		}

		try{
			ResultSet resultado = pstmt.executeQuery();

			int contador = 0;
			while(resultado.next()){
				contador++;
				
				int num_donante = resultado.getInt(1);
				String nombre = resultado.getString(2);
				String apellido1 = resultado.getString(3);
				String apellido2 = resultado.getString(4);
				String identificacion2 = resultado.getString(5);
				String fecha_nacimiento = resultado.getString(6);
				String pais_nacimiento = resultado.getString(7);
				String direccion = resultado.getString(8);
				String poblacion = resultado.getString(9);
				int cod_postal = resultado.getInt(10);
				int telefono1 = resultado.getInt(11);
				int telefono2 = resultado.getInt(12);
				String ciclo2 = resultado.getString(13);
				String correo = resultado.getString(14);
				String sexo = resultado.getString(15);
				String grupo_sanguineo2 = resultado.getString(16);

				Donantes a = new Donantes (num_donante,nombre,apellido1,apellido2,identificacion2,fecha_nacimiento,pais_nacimiento,direccion,poblacion,cod_postal,telefono1,telefono2,ciclo2,correo,sexo,grupo_sanguineo2);
				listaDonantes.add(a);
			}

			if(contador==0)
				System.out.println("no data found");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}

		return listaDonantes;
	}
	public ObservableList<Integer>  ConsultaNumDonantes() throws SQLException{
		//Preparo la conexión para ejecutar sentencias SQL de tipo update

		ObservableList<Integer> listaDonantes =  FXCollections.observableArrayList();
		
		Statement stm = conexion.createStatement();
		String selectsql = "SELECT NUM_DONANTE FROM "+usr+".DONANTE";

		ResultSet resultado = stm.executeQuery(selectsql);
	
		try{
			while (resultado.next()) {
				int num_donante = resultado.getInt(1);

				listaDonantes.add(num_donante);
			}
			
		}catch(SQLException sqle){
			
			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}
		return listaDonantes;
	}
	public int guardarFormulario(int num_formulario2, String pregunta1, String pregunta2, String pregunta3,
			String pregunta4, String pregunta5, String pregunta6, String pregunta7, String pregunta8, String pregunta9,
			String pregunta10, String pregunta11, String pregunta12, String pregunta13, String pregunta14,
			String pregunta15, String pregunta16, String pregunta17, String pregunta18, String pregunta19,
			String pregunta20, String pregunta21, String pregunta22, String pregunta23, String pregunta24,
			String pregunta25, String pregunta26, String pregunta27, String pregunta28, String pregunta29,
			String pregunta30, String pregunta31, String pregunta32, String preguntaEX1, String preguntaEX2,
			String preguntaEX3, String apto, String fecha1, String estado_donacion, String fecha_exclusion,int numDonante) throws SQLException{
		String insertsql = "INSERT INTO "+usr+".FORMULARIO VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		pstmt.setInt(1, num_formulario2);
		pstmt.setString(2, pregunta1);
		pstmt.setString(3, pregunta2);
		pstmt.setString(4, pregunta3);
		pstmt.setString(5, pregunta4);
		pstmt.setString(6, pregunta5);
		pstmt.setString(7, pregunta6);
		pstmt.setString(8, pregunta7);
		pstmt.setString(9, pregunta8);
		pstmt.setString(10, pregunta9);
		pstmt.setString(11, pregunta10);
		pstmt.setString(12, pregunta11);
		pstmt.setString(13, pregunta12);
		pstmt.setString(14, pregunta13);
		pstmt.setString(15, pregunta14);
		pstmt.setString(16, pregunta15);
		pstmt.setString(17, pregunta16);
		pstmt.setString(18, pregunta17);
		pstmt.setString(19, pregunta18);
		pstmt.setString(20, pregunta19);
		pstmt.setString(21, pregunta20);
		pstmt.setString(22, pregunta21);
		pstmt.setString(23, pregunta22);
		pstmt.setString(24, pregunta23);
		pstmt.setString(25, pregunta24);
		pstmt.setString(26, pregunta25);
		pstmt.setString(27, pregunta26);
		pstmt.setString(28, pregunta27);
		pstmt.setString(29, pregunta28);
		pstmt.setString(30, pregunta29);
		pstmt.setString(31, pregunta30);
		pstmt.setString(32, pregunta31);
		pstmt.setString(33, pregunta32);
		pstmt.setString(34, preguntaEX1);
		pstmt.setString(35, preguntaEX2);
		pstmt.setString(36, preguntaEX3);
		pstmt.setString(37, apto);
		pstmt.setString(38, fecha1);
		pstmt.setString(39, estado_donacion);
		pstmt.setString(40, fecha_exclusion);
		
	try{
		int resultado = pstmt.executeUpdate();

		if(resultado != 1)
			System.out.println("Error en la inserción " + resultado);
	    else
			System.out.println("Formulario insertado con éxito!!!");
		
		return 0;
	}catch(SQLException sqle){

		int pos = sqle.getMessage().indexOf(":");
		String codeErrorSQL = sqle.getMessage().substring(0,pos);
		System.out.println(codeErrorSQL);

		if(codeErrorSQL.equals("ORA-00001")){
			System.out.println("ERROR.El formulario que intentas introducir ya existe, o su clave ya esta inscrita!");
		    return 1;
		}
		else{
			System.out.println("Ha habido algún problema con  Oracle al hacer la creación de tabla");
		    return 2;
		}
	}
	}
	public int guardarRellena(int numFormulario,int donante) throws SQLException{
		
		String insertsql = "INSERT INTO "+usr+".RELLENA VALUES (?,?)";
		PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		pstmt.setInt(1, donante);
		pstmt.setInt(2, numFormulario);
		
		
	try{
		int resultado = pstmt.executeUpdate();

		if(resultado != 1)
			System.out.println("Error en la inserción " + resultado);
	    else
			System.out.println("Relacion creada con éxito!!!");
		
		return 0;
	}catch(SQLException sqle){

		int pos = sqle.getMessage().indexOf(":");
		String codeErrorSQL = sqle.getMessage().substring(0,pos);
		System.out.println(codeErrorSQL);

		if(codeErrorSQL.equals("ORA-00001")){
			System.out.println("ERROR.El formulario que intentas introducir ya existe, o su clave ya esta inscrita!");
		    return 1;
		}
		else{
			System.out.println("Ha habido algún problema con  Oracle al hacer la creación de tabla");
		    return 2;
		}
	}
		
	}
	public void guardarDonacion(Donacion formulario) throws SQLException{
		
	}
	public void informeDonantes() throws SQLException{
		
	}
	public void informeDonaciones() throws SQLException{
		
	}
}
