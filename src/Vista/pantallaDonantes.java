package Vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import Modelo.ControladoraBBDD;
import Modelo.Donantes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
	private TextField txtCorreo;
	@FXML
	private ChoiceBox Grupo_Sanguineo;
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
		Pais_nacimiento.setItems(paises);
		Sexo.setItems(sexos);
		Grupo_Sanguineo.setItems(tipos_sanguineos);
		Ciclo.setValue("-------");
        Grupo_Sanguineo.setValue("-------");
		Sexo.setValue("-------");
		Pais_nacimiento.setValue("-------");
		con = new ControladoraBBDD ();
		
		datos = con.ConsultaPersonas();
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
	public void Guardar() throws SQLException, FileNotFoundException{

		con = new ControladoraBBDD ();
		
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
				
			
					Donantes nuevo = new Donantes (num_donante,txtNombre.getText(),txtApellido1.getText(),txtApellido2.getText(),txtIdentificacion.getText(),txtFecha_nacimiento.getText(),pais,txtDireccion.getText(),txtPoblacion.getText(),cod_postal,telefono1,telefono2,file,ciclo1,txtCorreo.getText(),sexo,sangre);
	    			datos2.add(nuevo);	    		
	    			
	    			if(edicion == true){
	    				
	    				Donantes editada = datos.get(indiceedicion);
	    				editada.setNum_donante(Integer.parseInt(txtNum_donante.getText()));
	    				editada.setNombre(txtNombre.getText());
	    				editada.setApellido1(txtApellido1.getText());
	    				editada.setApellido2(txtApellido2.getText());
	    				editada.setIdentificacion(txtIdentificacion.getText());
	    				editada.setFecha_nacimiento(txtFecha_nacimiento.getText());
	    				editada.setPais_nacimiento(pais);
	    				editada.setDireccion(txtDireccion.getText());
	    				editada.setPoblacion(txtPoblacion.getText());
	    				editada.setCodigo_postal(Integer.parseInt(txtCod_postal.getText()));
	    				editada.setTelefono1(Integer.parseInt(txtTelefono1.getText()));
	    				editada.setTelefono2(Integer.parseInt(txtTelefono2.getText()));
	    				editada.setCiclo(ciclo1);
	    				editada.setCorreo(txtCorreo.getText());
	    				editada.setSexo(sexo);
	    				editada.setGrupo_sanguineo(sangre);
	    				
	    				datos.set(indiceedicion, editada);
	    				
	    				if(datos.contains(txtNum_donante.getText())==true){
	   	      	 	     Alert alert = new Alert (Alert.AlertType.ERROR);
	   	      	 	     alert.setTitle("ERROR.Persona existente.");
	   	      	 		 alert.setHeaderText(null);
	   	      	 		 alert.setContentText("Esta persona ya existe, o la clave 'Email' ya existe para otra persona.");
	   	      	 		 alert.showAndWait();
	   				     }else {
	   				    	con.modificarDonante(datos2.get(0),editada);
						}
	    				
	    			}
	    			else{
	    				
    					try{
    	    				Donantes nuevo2 = new Donantes(num_donante,txtNombre.getText(),txtApellido1.getText(),txtApellido2.getText(),txtIdentificacion.getText(),txtFecha_nacimiento.getText(),pais,txtDireccion.getText(),txtPoblacion.getText(),cod_postal,telefono1,telefono2,file,ciclo1,txtCorreo.getText(),sexo,sangre);
    	    				
    	    				boolean num_donante_test = false;
    	    				for(int i=0;i<datos.size();i++){
    	    					if(datos.get(i).getNum_donante()==nuevo.getNum_donante()){
    	    						num_donante_test = true;
    	    					}
    	    				}
    	    				if(num_donante_test==true){
    	      	      	 	     Alert alert = new Alert (Alert.AlertType.ERROR);
    	       	      	 	     alert.setTitle("ERROR.Persona existente.");
    	       	      	 		 alert.setHeaderText(null);
    	       	      	 		 alert.setContentText("Esta persona ya existe, o la clave 'Email' ya existe para otra persona.");
    	       	      	 		 alert.showAndWait();
    	    				}else {
    		        			con.guardarDonante (nuevo2);
    		        			if(txtf_ruta.getText()!=""){
    		        				con.InsertarFoto(file);
    		        			}
    		        			datos.add(nuevo);
    					}
    					}catch (NumberFormatException e){
    						  Alert alert = new Alert (Alert.AlertType.ERROR);
    						  alert.setContentText("Introduce numeros");
    						  alert.showAndWait();
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

			Donantes seleccionada = tabla.getSelectionModel().getSelectedItem();

			int num_donante =  seleccionada.getNum_donante();
			int telefono1 = seleccionada.getTelefono1();
			int telefono2 = seleccionada.getTelefono2();
			int cod_postal = seleccionada.getCodigo_postal();


			txtNum_donante.setText(""+num_donante+"");
			txtNombre.setText(seleccionada.getNombre());
			txtApellido1.setText(seleccionada.getApellido1());
			txtApellido2.setText(seleccionada.getApellido2());
			txtIdentificacion.setText(seleccionada.getIdentificacion());
			txtFecha_nacimiento.setText(seleccionada.getFecha_nacimiento());
			Pais_nacimiento.setValue(seleccionada.getPais_nacimiento());
			txtDireccion.setText(seleccionada.getDireccion());
			txtPoblacion.setText(seleccionada.getPoblacion());
			txtCod_postal.setText(""+cod_postal+"");
			txtTelefono1.setText(""+telefono1+"");
			txtTelefono2.setText(""+telefono2+"");
			Ciclo.setValue(seleccionada.getCiclo());
	        Grupo_Sanguineo.setValue(seleccionada.getGrupo_sanguineo());
	        txtCorreo.setText(seleccionada.getCorreo());
			Sexo.setValue(seleccionada.getSexo());
		}
	}

}
