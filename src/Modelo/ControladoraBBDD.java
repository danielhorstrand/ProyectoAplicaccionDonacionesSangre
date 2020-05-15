package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
		String selectsql = "SELECT * FROM "+usr+".FORMULARIO";

		ResultSet resultado = stm.executeQuery(selectsql);
	
		try{
			while (resultado.next()) {
				int num_donante = resultado.getInt(1);
				String pregunta1 = resultado.getString(2);
				String pregunta2 = resultado.getString(3);
				String pregunta3 = resultado.getString(4);
				String pregunta4 = resultado.getString(5);
				String pregunta5 = resultado.getString(6);
				String pregunta6 = resultado.getString(7);
				String pregunta7 = resultado.getString(8);
				String pregunta8 = resultado.getString(9);
				String pregunta9 = resultado.getString(10);
				String pregunta10 = resultado.getString(11);
				String pregunta11 = resultado.getString(12);
				String pregunta12 = resultado.getString(13);
				String pregunta13 = resultado.getString(14);
				String pregunta14 = resultado.getString(15);
				String pregunta15 = resultado.getString(16);
				String pregunta16 = resultado.getString(17);
				String pregunta17 = resultado.getString(18);
				String pregunta18 = resultado.getString(19);
				String pregunta19 = resultado.getString(20);
				String pregunta20 = resultado.getString(21);
				String pregunta21 = resultado.getString(22);
				String pregunta22 = resultado.getString(23);
				String pregunta23 = resultado.getString(24);
				String pregunta24 = resultado.getString(25);
				String pregunta25 = resultado.getString(26);
				String pregunta26 = resultado.getString(27);
				String pregunta27 = resultado.getString(28);
				String pregunta28 = resultado.getString(29);
				String pregunta29 = resultado.getString(30);
				String pregunta30 = resultado.getString(31);
				String pregunta31 = resultado.getString(32);
				String pregunta32 = resultado.getString(33);
				String pregunta33 = resultado.getString(34);
				String pregunta34 = resultado.getString(35);
				String pregunta35 = resultado.getString(36);
				String apto = resultado.getString(37);
				String fecha = resultado.getString(38);
				String estado = resultado.getString(39);
				String fecha_exclusion = resultado.getString(40);
				

				Formulario n = new Formulario (num_donante,pregunta1,pregunta2,pregunta3,pregunta4,pregunta5,pregunta6,pregunta7,pregunta8,pregunta9,pregunta10,pregunta11,pregunta12,pregunta13,pregunta14,pregunta15,pregunta16,pregunta17,pregunta18,pregunta19,pregunta20,pregunta21,pregunta22,pregunta23,pregunta24,pregunta25,pregunta26,pregunta27,pregunta28,pregunta29,pregunta30,pregunta31,pregunta32,pregunta33,pregunta34,pregunta35,apto,fecha,estado,fecha_exclusion);
				listaFormulario.add(n);
			}
			
		}catch(SQLException sqle){
			
			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}
		return listaFormulario;
	}
	public ObservableList<Donacion>  ConsultaDonaciones() throws SQLException{
		//Preparo la conexión para ejecutar sentencias SQL de tipo update

		ObservableList<Donacion> listaFormulario =  FXCollections.observableArrayList();
		
		Statement stm = conexion.createStatement();
		String selectsql = "SELECT NUM_DONACION,COD_COLECTA,TIPO_DONACION,PULSO,TA_SIST,TA_DIAST,HB_CAP,HB_VEN,VOLUMEN,TO_CHAR(FECHA,'DD/MM/YYYY') FROM "+usr+".DONACION";

		ResultSet resultado = stm.executeQuery(selectsql);
	
		try{
			while (resultado.next()) {
				int num_donacion = resultado.getInt(1);
				int codigo = resultado.getInt(2);
				String tipo_donacion = resultado.getString(3);
				int pulso = resultado.getInt(4);
				int ta_sist = resultado.getInt(5);
				int ta_diast = resultado.getInt(6);
				int hb_cap = resultado.getInt(7);
				int hb_ven = resultado.getInt(8);
				int volumen = resultado.getInt(9);
				String fecha = resultado.getString(10);
				

				Donacion n = new Donacion (num_donacion, codigo, tipo_donacion, pulso, ta_sist, ta_diast, hb_cap, hb_ven, volumen, fecha);
				listaFormulario.add(n);
			}
			
		}catch(SQLException sqle){
			
			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}
		return listaFormulario;
	}
	public ObservableList<String> consultarAñoDonante (int numDonante) throws SQLException{
		
		ObservableList<String> listaAñoDonantes =  FXCollections.observableArrayList();
		
		Statement stm = conexion.createStatement();
		String selectsql = "SELECT TO_CHAR(FECHA_NACIMIENTO,'YYYY') FROM "+usr+".DONANTE WHERE NUM_DONANTE=?";

		PreparedStatement pstmt = conexion.prepareStatement (selectsql);
		pstmt.setInt(1, numDonante);
		
		ResultSet resultado = pstmt.executeQuery();
		
		try{
			while (resultado.next()) {
				String fechaDonante = resultado.getString(1);

				listaAñoDonantes.add(fechaDonante);
			}
			
		}catch(SQLException sqle){
			
			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			System.out.println(codeErrorSQL);
		}
		return listaAñoDonantes;
		
	}
	public int InsertarFoto(File archivofoto) throws SQLException{

		try{
			String insertsql = "INSERT INTO "+usr+".DONANTE (FOTO) VALUES (?)";

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
	public int guardarDonante (Donantes donante,File archivoFoto)  throws SQLException, FileNotFoundException{
		
			String insertsql = "INSERT INTO "+usr+".DONANTE (NUM_DONANTE,NOMBRE,APELLIDO1,APELLIDO2,IDENTIFICACION,FECHA_NACIMIENTO,PAIS_NACIMIENTO,DIRECCION,POBLACION,CODIGO_POSTAL,TELEFONO,TELEFONO2,FOTO,CICLO,CORREO_ELECTRONICO,SEXO,GRUPO_SANGUINEO)VALUES (?,?,?,?,?,TO_DATE( ? , 'DD/MM/YYYY' ),?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conexion.prepareStatement (insertsql);
			FileInputStream convertir_imagen = new FileInputStream (archivoFoto);
			
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
			pstmt.setBlob(13, convertir_imagen, archivoFoto.length());
			pstmt.setString(14, donante.getCiclo());
			pstmt.setString(15, donante.getCorreo());
			pstmt.setString(16, donante.getSexo());
			pstmt.setString(17, donante.getGrupo_sanguineo());
		
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
	public int guardarDonacion (Donacion donacion) throws SQLException{
		
		String insertsql = "INSERT INTO "+usr+".DONACION VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		
		pstmt.setInt(1, donacion.getNum_donacion());
		pstmt.setInt(2, donacion.getCodigo_colecta());
		pstmt.setString(3, donacion.getTipo_donacion());
		pstmt.setInt(4, donacion.getPulso());
		pstmt.setInt(5, donacion.getTa_sist());
		pstmt.setInt(6, donacion.getTa_diast());
		pstmt.setInt(7, donacion.getHb_cap());
		pstmt.setInt(8, donacion.getHb_ven());
		pstmt.setInt(9, donacion.getVolumen());
		pstmt.setString(10, donacion.getFecha());
	
		try{
			int resultado = pstmt.executeUpdate();

			if(resultado != 1)
				System.out.println("Error en la inserción " + resultado);
		    else
				System.out.println("Donacion realizada con éxito!!!");
		
			return 0;
		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);
			System.out.println(codeErrorSQL);

			if(codeErrorSQL.equals("ORA-00001")){
				System.out.println("ERROR.La Donacion que intentas introducir ya existe, o su clave 'Num_Donacion' ya esta inscrita!");
			    return 1;
			}
			else{
				System.out.println("Ha habido algún problema con  Oracle al hacer la creación de tabla");
			    return 2;
			}
		}
	}
	public int modificarDonacion (Donacion donacion)  throws SQLException, FileNotFoundException{
		Statement stm = conexion.createStatement();
		
		String insertsql = "UPDATE "+usr+".DONACION SET COD_COLECTA=?, TIPO_DONACION=?, PULSO=?, TA_SIST=?, TA_DIAST=?, HB_CAP=?, HB_VEN=?, VOLUMEN=?, FECHA=? WHERE NUM_DONACION=?";
		
		PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		pstmt.setInt(1, donacion.getCodigo_colecta());
		pstmt.setString(2, donacion.getTipo_donacion());
		pstmt.setInt(3, donacion.getPulso());
		pstmt.setInt(4, donacion.getTa_sist());
		pstmt.setInt(5, donacion.getTa_diast());
		pstmt.setInt(6, donacion.getHb_cap());
		pstmt.setInt(7, donacion.getHb_ven());
		pstmt.setInt(8, donacion.getVolumen());
		pstmt.setString(9, donacion.getFecha());
		pstmt.setInt(10, donacion.getNum_donacion());

		try{
			int resultado = pstmt.executeUpdate();
			if(resultado != 1)
				System.out.println("Error en la modificacion " + resultado);
		    else
				System.out.println("Donacion actualizada con éxito!!!");

			return 0;
		}catch(SQLException sqle){
			
			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);

			if(codeErrorSQL.equals("ORA-00001") ){
				System.out.println("Ya existe una Donacion con  ese Numero!!");
				return 1;
			}
			else{
				System.out.println("Ha habido algún problema con  Oracle al hacer la insercion");
				return 2;
			}
	}
	}
	public byte[] LeerFoto(int num_donante) throws SQLException{

		byte[] byteImage = null;
		try{

			String insertsql = "SELECT FOTO FROM "+usr+".DONANTE WHERE NUM_DONANTE=?";

			PreparedStatement pstmt = conexion.prepareStatement (insertsql);
			pstmt.setInt(1, num_donante);
			ResultSet resultado = pstmt.executeQuery();

			int contador = 0;
			while(resultado.next()){
				contador++;

			    Blob blob = resultado.getBlob(1);
			    byteImage = blob.getBytes(1, (int) blob.length());

			}

			if(contador==0)
				System.out.println("no data found");

		}catch(SQLException sqle){

			int pos = sqle.getMessage().indexOf(":");
			String codeErrorSQL = sqle.getMessage().substring(0,pos);


				System.out.println( codeErrorSQL);
		}

		return byteImage;
	}
	
    public int modificarDonante (Donantes donante,File archivoFoto)  throws SQLException, FileNotFoundException{		
		
		Statement stm = conexion.createStatement();
		
			String insertsql = "UPDATE "+usr+".DONANTE SET NOMBRE=?, APELLIDO1=?, APELLIDO2=?, IDENTIFICACION=?, FECHA_NACIMIENTO=?, PAIS_NACIMIENTO=?, DIRECCION=?, POBLACION=?, CODIGO_POSTAL=?, TELEFONO=?, TELEFONO2=?, FOTO=?,  CICLO=?, CORREO_ELECTRONICO=?, SEXO=?, GRUPO_SANGUINEO=? WHERE NUM_DONANTE=?";

			FileInputStream convertir_imagen = new FileInputStream (archivoFoto);
			
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
			pstmt.setBlob(12, convertir_imagen, archivoFoto.length());
			pstmt.setString(13, donante.getCiclo());
			pstmt.setString(14, donante.getCorreo());
			pstmt.setString(15, donante.getSexo());
			pstmt.setString(16, donante.getGrupo_sanguineo());
			pstmt.setInt(17, donante.getNum_donante());

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
			System.out.println("ERROR.La relacion que intentas introducir ya existe, o su clave ya esta inscrita!");
		    return 1;
		}
		else{
			System.out.println("Ha habido algún problema con  Oracle al hacer la creación de tabla");
		    return 2;
		}
	}
		
	}
    public int guardarRealiza(int numDonante,int numDonacion) throws SQLException{
	 	
	    	String insertsql = "INSERT INTO "+usr+".REALIZA VALUES (?,?)";
		    PreparedStatement pstmt = conexion.prepareStatement (insertsql);
		    pstmt.setInt(1, numDonante);
		    pstmt.setInt(2, numDonacion);		
		
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
			   System.out.println("ERROR.La relacion que intentas introducir ya existe, o su clave ya esta inscrita!");
		       return 1;
		    }
		    else{
			   System.out.println("Ha habido algún problema con  Oracle al hacer la creación de tabla");
		       return 2;
		    }
	    }
		
	}
	public ObservableList<Integer> consultaRellena (int codigo) throws SQLException{
		
		ObservableList<Integer> listaDonantes =  FXCollections.observableArrayList();
		Statement stm = conexion.createStatement();
		
		String selectsql = "SELECT NUM_DONANTE FROM "+usr+".RELLENA WHERE CODIGO=?";

		PreparedStatement pstmt = conexion.prepareStatement (selectsql);
		pstmt.setInt(1, codigo);
		
		ResultSet resultado = pstmt.executeQuery();
	
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
	public void informeDonantes() throws SQLException{
		
	}
	public void informeDonaciones() throws SQLException{
		
	}

}
