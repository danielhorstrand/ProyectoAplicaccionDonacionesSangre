package Vista;

import java.sql.SQLException;

import Modelo.ControladoraBBDD;
import Modelo.Donantes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class pantallaDonantes {

	@FXML
	private Button btnVolver;
	
	private Stage ventana;

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
	
	ObservableList<Donantes> datos = FXCollections.observableArrayList();
	
	private boolean edicion;
	private int indiceedicion;

	ControladoraBBDD con;

	public void initialize() throws SQLException{
		
		
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
		col_telefono1.setCellValueFactory(new PropertyValueFactory<Donantes,Integer>("telefono1"));
		col_telefono2.setCellValueFactory(new PropertyValueFactory<Donantes,Integer>("telefono2"));
		col_ciclo.setCellValueFactory(new PropertyValueFactory<Donantes,String>("ciclo"));
		col_sexo.setCellValueFactory(new PropertyValueFactory<Donantes,String>("sexo"));
		col_grupo_sanguineo.setCellValueFactory(new PropertyValueFactory<Donantes,String>("grupo_sanguineo"));

		// Al arrancar la vista se pone edicion a false
		edicion = false;
		indiceedicion = 0;

	}
	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	public void closeWindow(){
		this.ventana.close();
	}

}
