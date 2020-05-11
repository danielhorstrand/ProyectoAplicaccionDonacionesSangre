package Vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Optional;

import com.itextpdf.text.DocumentException;

import Modelo.ControladoraBBDD;
import Modelo.Donantes;
import Modelo.ImprimeArchivo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class pantallaDonantes {

	@FXML
	private Button btnVolver;
	@FXML
	private Button btnGuardar;
	@FXML
	private Button btnBorrar;
	@FXML
	private Button btnEliminar;
	@FXML
	private Button btnBuscar;
	@FXML
	private Button btnImprimirPDF;
	@FXML
	private Button btnSeleccionar_Imagen;
	
	private Stage ventana;
	
	@FXML
	private TextField txtNum_donante;
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApellido1;
	@FXML
	private TextField txtApellido2;
	@FXML
	private TextField txtIdentificacion;
	@FXML
	private TextField txtIdentificacionBusqueda;
	@FXML
	private TextField txtFecha_nacimiento;
	@FXML
	private TextField txtDireccion;
	@FXML
	private TextField txtPoblacion;
	@FXML
	private TextField txtCod_postal;
	@FXML
	private TextField txtTelefono1;
	@FXML
	private TextField txtTelefono2;
	@FXML
	private TextField txtf_ruta;
	@FXML
	private ImageView foto;
	@FXML
	private ChoiceBox Ciclo;
	@FXML
	private ChoiceBox CicloBusqueda;
	@FXML
	private TextField txtCorreo;
	@FXML
	private ChoiceBox Grupo_Sanguineo;
	@FXML
	private ChoiceBox Grupo_SanguineoBusqueda;
	@FXML
	private ChoiceBox Pais_nacimiento;
	@FXML
	private ChoiceBox Sexo;
	
	private File file;

	@FXML
	private TableView<Donantes> tabla;
	@FXML
	private TableColumn<Donantes,Integer> col_num_donante;
	@FXML
	private TableColumn<Donantes,String> col_nombre;
	@FXML
	private TableColumn<Donantes,String> col_apellido1;
	@FXML
	private TableColumn<Donantes,String> col_apellido2;
	@FXML
	private TableColumn<Donantes,String> col_identificacion;
	@FXML
	private TableColumn<Donantes,String> col_fecha_nacimiento;
	@FXML
	private TableColumn<Donantes,String> col_pais_nacimiento;
	@FXML
	private TableColumn<Donantes,String> col_direccion;
	@FXML
	private TableColumn<Donantes,String> col_poblacion;
	@FXML
	private TableColumn<Donantes,String> col_cod_postal;
	@FXML
	private TableColumn<Donantes,Integer> col_telefono1;
	@FXML
	private TableColumn<Donantes,Integer> col_telefono2;
	@FXML
	private TableColumn<Donantes,String> col_ciclo;
	@FXML
	private TableColumn<Donantes,String> col_correo;
	@FXML
	private TableColumn<Donantes,String> col_sexo;
	@FXML
	private TableColumn<Donantes,String> col_grupo_sanguineo;
	
	ObservableList<String> ciclos = FXCollections.observableArrayList("-------","Informatica y comunicaciones","Servicios Administrativos","Servicios Comerciales","TEAS","SMR","Gestion Administrativa","Emergencias Sanitarias","Farmacia y parafarmacia","Anatomía Patológica","DAW","TEAS","Educacion Infantil");
	ObservableList<String> paises = FXCollections.observableArrayList("-------","ESPAÑA","ITALIA","FRANCIA","PORTUGAL","ALEMANIA","SUECIA","NORUEGA","UK","EEUU");
	ObservableList<String> sexos = FXCollections.observableArrayList("-------","H","M");
	ObservableList<String> tipos_sanguineos = FXCollections.observableArrayList("-------","AB+","AB-","A+","A-","B+","B-","0+","0-");
	ObservableList<Donantes> datos = FXCollections.observableArrayList();
	ObservableList<Donantes> datos2 = FXCollections.observableArrayList();
	
	private boolean edicion;
	private int indiceedicion;

	ControladoraBBDD con;

	public void initialize () throws SQLException{
		
		Ciclo.setItems(ciclos);
		CicloBusqueda.setItems(ciclos);
		Pais_nacimiento.setItems(paises);
		Sexo.setItems(sexos);
		Grupo_Sanguineo.setItems(tipos_sanguineos);
		Grupo_SanguineoBusqueda.setItems(tipos_sanguineos);
		Ciclo.setValue("-------");
		CicloBusqueda.setValue("-------");
        Grupo_Sanguineo.setValue("-------");
        Grupo_SanguineoBusqueda.setValue("-------");
		Sexo.setValue("-------");
		Pais_nacimiento.setValue("-------");
		con = new ControladoraBBDD ();
		
		datos = con.ConsultaDonantes();
	
		tabla.setItems(datos);
		
		col_num_donante.setCellValueFactory(new PropertyValueFactory<Donantes,Integer>("num_donante"));
		col_nombre.setCellValueFactory(new PropertyValueFactory<Donantes,String>("nombre"));
		col_apellido1.setCellValueFactory(new PropertyValueFactory<Donantes,String>("apellido1"));
		col_apellido2.setCellValueFactory(new PropertyValueFactory<Donantes,String>("apellido2"));
		col_identificacion.setCellValueFactory(new PropertyValueFactory<Donantes,String>("identificacion"));
		col_fecha_nacimiento.setCellValueFactory(new PropertyValueFactory<Donantes,String>("fecha_nacimiento"));
		col_pais_nacimiento.setCellValueFactory(new PropertyValueFactory<Donantes,String>("pais_nacimiento"));
		col_direccion.setCellValueFactory(new PropertyValueFactory<Donantes,String>("direccion"));
		col_poblacion.setCellValueFactory(new PropertyValueFactory<Donantes,String>("poblacion"));
		col_cod_postal.setCellValueFactory(new PropertyValueFactory<Donantes,String>("codigo_postal"));
		col_telefono1.setCellValueFactory(new PropertyValueFactory<Donantes,Integer>("telefono1"));
		col_ciclo.setCellValueFactory(new PropertyValueFactory<Donantes,String>("ciclo"));
		col_sexo.setCellValueFactory(new PropertyValueFactory<Donantes,String>("sexo"));
		col_grupo_sanguineo.setCellValueFactory(new PropertyValueFactory<Donantes,String>("grupo_sanguineo"));

		// Al arrancar la vista se pone edicion a false
		edicion = false;
		indiceedicion = 0;

	}
	
	public void setStagePrincipal (Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	public void closeWindow (){
		this.ventana.close();
	}

	public void seleccionarimagen() throws SQLException{


		// muestra el cuadro de diálogo de archivos, para que el usuario pueda elegir el archivo a abrir
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar Imagen");

		// Agregar filtros para facilitar la busqueda
		fileChooser.getExtensionFilters().addAll(
		                new FileChooser.ExtensionFilter("JPG", "*.jpeg"),
		                new FileChooser.ExtensionFilter("PNG", "*.png"),
		                new FileChooser.ExtensionFilter("Todos los archivos", "*.*")
		 );

		 Window stage = null;

		 // Obtener el archivo seleccionado
		 file = fileChooser.showOpenDialog(stage);
		 
		 txtf_ruta.setText(file.getPath());


	}
	public void Guardar() throws SQLException{
	
			int num_donante =  Integer.parseInt(txtNum_donante.getText());
			int telefono1 = Integer.parseInt(txtTelefono1.getText());
			int telefono2 = Integer.parseInt(txtTelefono2.getText());
			int cod_postal = Integer.parseInt(txtCod_postal.getText());		
			String ciclo1 = (String) Ciclo.getValue();
			String sexo = (String) Sexo.getValue();
			String sangre = (String) Grupo_Sanguineo.getValue();
			String pais = (String) Pais_nacimiento.getValue();
			
			if(txtNum_donante.getText().length()==0 || txtNombre.getText().length()==0 || txtApellido1.getText().length()==0 || txtApellido2.getText().length()==0 || txtIdentificacion.getText().length()==0 || txtFecha_nacimiento.getText().length()==0 || pais.equals("-------")==true || txtDireccion.getText().length()==0 || txtPoblacion.getText().length()==0 || txtCod_postal.getText().length()==0 || txtTelefono1.getText().length()==0 || txtTelefono2.getText().length()==0 || ciclo1.equals("-------")==true || txtCorreo.getText().length()==0 || sexo.equals("-------")==true || sangre.equals("-------")==true){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error!!!");
				alert.setHeaderText("Observa que hayas introducido todos los datos");
				alert.setContentText("¡No se pueden grabar campos vacíos!");
				alert.showAndWait();
			}
			else{
		    			    			
	    		if(edicion == true){
	    				
	    			ControladoraBBDD con = new ControladoraBBDD();
					Donantes donantecambio = new Donantes (num_donante,txtNombre.getText(),txtApellido1.getText(),txtApellido2.getText(),txtIdentificacion.getText(),txtFecha_nacimiento.getText(),pais,txtDireccion.getText(),txtPoblacion.getText(),cod_postal,telefono1,telefono2,ciclo1,txtCorreo.getText(),sexo,sangre);
	    				
	    			int res = con.modificarDonante(donantecambio);
	    				
	    			switch (res){

					case 0:
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("OK!");
						alert.setHeaderText("Modificación OK!");
						alert.setContentText("¡Donante modificado con éxito!");
						alert.showAndWait();
						// Actualizo los datos de la tabla
						datos = con.ConsultaDonantes();
						tabla.setItems(datos);
						break;

					default:
							alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error!");
							alert.setHeaderText("Modificación ERROR!");
							alert.setContentText("¡Ha habido un problema al realizar el update!");
							alert.showAndWait();
							break;

						}    				
	    			}
	    			else{
	    				

	    				Donantes nuevo = new Donantes(num_donante,txtNombre.getText(),txtApellido1.getText(),txtApellido2.getText(),txtIdentificacion.getText(),txtFecha_nacimiento.getText(),pais,txtDireccion.getText(),txtPoblacion.getText(),cod_postal,telefono1,telefono2,ciclo1,txtCorreo.getText(),sexo,sangre);

    					int res = con.guardarDonante(nuevo);
    					
    					switch (res){

    					case 0:
    						Alert alert = new Alert(AlertType.INFORMATION);
    						alert.setTitle("OK!");
    						alert.setHeaderText("Inserción OK!");
    						alert.setContentText("¡Donante insertado con éxito!");
    						alert.showAndWait();

    						// Actualizo los datos de la tabla
    						datos = con.ConsultaDonantes();
    						tabla.setItems(datos);
    						break;

    					case 1:
    						alert = new Alert(AlertType.WARNING);
    						alert.setTitle("Aviso!");
    						alert.setHeaderText("Inserción ERROR!");
    						alert.setContentText("¡Ya existe un Donante con ese num_donante!");
    						alert.showAndWait();
    						break;

    					default:
    						alert = new Alert(AlertType.ERROR);
    						alert.setTitle("Error!");
    						alert.setHeaderText("Inserción NOK!");
    						alert.setContentText("¡Ha habido un problema al realizar la inserción!");
    						alert.showAndWait();
    						break;

    					}
	    			}
			}
		
	}
	public void Borrar(){
		txtNum_donante.setText("");
		txtNombre.setText("");
		txtApellido1.setText("");
		txtApellido2.setText("");
		txtIdentificacion.setText("");
		txtFecha_nacimiento.setText("");
		Pais_nacimiento.setValue("-------");
		txtDireccion.setText("");
		txtPoblacion.setText("");
		txtCod_postal.setText("");
		txtTelefono1.setText("");
		txtTelefono2.setText("");
		Ciclo.setValue("-------");
		txtCorreo.setText("");
        Grupo_Sanguineo.setValue("-------");
		Sexo.setValue("-------");

		edicion = false;
		indiceedicion = 0;
	}
	public void Editar() throws SQLException{

		int index = tabla.getSelectionModel().getSelectedIndex();


		if( index >= 0){

			// Activo la "funcionalidad" de editar para luego que el botón guardar sepa a qué PErsona estoy "editando"
			edicion = true;
			indiceedicion = index;

			Donantes seleccionado = tabla.getSelectionModel().getSelectedItem();

			int num_donante =  seleccionado.getNum_donante();
			int telefono1 = seleccionado.getTelefono1();
			int telefono2 = seleccionado.getTelefono2();
			int cod_postal = seleccionado.getCodigo_postal();


			txtNum_donante.setText(""+num_donante+"");
			txtNombre.setText(seleccionado.getNombre());
			txtApellido1.setText(seleccionado.getApellido1());
			txtApellido2.setText(seleccionado.getApellido2());
			txtIdentificacion.setText(seleccionado.getIdentificacion());
			txtFecha_nacimiento.setText(seleccionado.getFecha_nacimiento());
			Pais_nacimiento.setValue(seleccionado.getPais_nacimiento());
			txtDireccion.setText(seleccionado.getDireccion());
			txtPoblacion.setText(seleccionado.getPoblacion());
			txtCod_postal.setText(""+cod_postal+"");
			txtTelefono1.setText(""+telefono1+"");
			txtTelefono2.setText(""+telefono2+"");
			Ciclo.setValue(seleccionado.getCiclo());
	        Grupo_Sanguineo.setValue(seleccionado.getGrupo_sanguineo());
	        txtCorreo.setText(seleccionado.getCorreo());
			Sexo.setValue(seleccionado.getSexo());
		}
	}
	public void Eliminar() throws SQLException{
		
		int index = tabla.getSelectionModel().getSelectedIndex();
		if( index >= 0){

			Donantes seleccionado = tabla.getSelectionModel().getSelectedItem();

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Conformación!!!");
			alert.setHeaderText("Por favor confirme el borrado");
			alert.setContentText("Dese borrar al Donante "+ seleccionado.getNombre() + " " +seleccionado.getApellido1() +" ?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){

				ControladoraBBDD con = new ControladoraBBDD();
				int res = con.BorrarDonante(seleccionado.getNum_donante());
				switch(res){
					case 0:
						alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("OK!");
						alert.setHeaderText("Borrado OK!");
						alert.setContentText("¡Donante eliminado con éxito!");
						alert.showAndWait();

						// Actualizo los datos de la tabla
						datos = con.ConsultaDonantes();
						tabla.setItems(datos);
						break;

					default:
						alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error!");
						alert.setHeaderText("Inserción ERROR!");
						alert.setContentText("¡Ha habido un problema al realizar la inserción!");
						alert.showAndWait();
						break;
				}

				Borrar();
			}

		}else{

			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error en selección de datos");
			alert.setContentText("NO HAY NINGUN ELEMENTO SELECCIONADO!");
			alert.showAndWait();

		}
	}
	public void BuscarDonante() throws SQLException{
		
		String buscarIdentificacion = txtIdentificacionBusqueda.getText();
		String buscarCiclo = (String) CicloBusqueda.getValue();
		String buscarSangre = (String) Grupo_SanguineoBusqueda.getValue();

		ControladoraBBDD con = new ControladoraBBDD();
		datos = con.BuscarDonantes(buscarIdentificacion,buscarCiclo,buscarSangre);

		tabla.setItems(datos);
	}
	public void imprime() throws FileNotFoundException, DocumentException{

		String sangre = (String) Grupo_Sanguineo.getValue();
		ImprimeArchivo imprime = new ImprimeArchivo("archivo","C:\\Users\\danie\\Downloads\\");
		imprime.generarArchivoPDF(txtNombre.getText(),txtApellido1.getText(),txtApellido2.getText(),sangre,txtIdentificacion.getText());

	}

}
