package Vista;

import java.sql.SQLException;

import Modelo.ControladoraBBDD;
import Modelo.Donantes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PantallaDonaciones {
	
	@FXML
	private Button btnContinuar;
	@FXML
	private Button btnVolver;
	
	private Stage ventana;
	
	@FXML
	RadioButton pregunta1_1;
	@FXML
	RadioButton pregunta2_1;	
	@FXML
	ToggleGroup uno;
	@FXML
	RadioButton pregunta1_2;
	@FXML
	RadioButton pregunta2_2;
	@FXML
	ToggleGroup dos;
	@FXML
	RadioButton pregunta1_3;
	@FXML
	RadioButton pregunta2_3;
	@FXML
	ToggleGroup tres;
	@FXML
	RadioButton pregunta1_4;
	@FXML
	RadioButton pregunta2_4;
	@FXML
	ToggleGroup cuatro;
	@FXML
	RadioButton pregunta1_5;
	@FXML
	RadioButton pregunta2_5;
	@FXML
	ToggleGroup cinco;
	@FXML
	RadioButton pregunta1_6;
	@FXML
	RadioButton pregunta2_6;
	@FXML
	ToggleGroup seis;
	@FXML
	RadioButton pregunta1_7;
	@FXML
	RadioButton pregunta2_7;
	@FXML
	ToggleGroup siete;
	@FXML
	RadioButton pregunta1_8;
	@FXML
	RadioButton pregunta2_8;
	@FXML
	ToggleGroup ocho;
	@FXML
	RadioButton pregunta1_9;
	@FXML
	RadioButton pregunta2_9;
	@FXML
	ToggleGroup nueve;
	@FXML
	RadioButton pregunta1_10;
	@FXML
	RadioButton pregunta2_10;
	@FXML
	ToggleGroup diez;
	@FXML
	RadioButton pregunta1_11;
	@FXML
	RadioButton pregunta2_11;
	@FXML
	ToggleGroup once;
	@FXML
	RadioButton pregunta1_12;
	@FXML
	RadioButton pregunta2_12;
	@FXML
	ToggleGroup doce;
	@FXML
	RadioButton pregunta1_13;
	@FXML
	RadioButton pregunta2_13;
	@FXML
	ToggleGroup trece;
	@FXML
	RadioButton pregunta1_14;
	@FXML
	RadioButton pregunta2_14;
	@FXML
	ToggleGroup catorce;
	@FXML
	RadioButton pregunta1_15;
	@FXML
	RadioButton pregunta2_15;
	@FXML
	ToggleGroup quince;
	@FXML
	RadioButton pregunta1_16;
	@FXML
	RadioButton pregunta2_16;
	@FXML
	ToggleGroup dieciseis;
	@FXML
	RadioButton pregunta1_17;
	@FXML
	RadioButton pregunta2_17;
	@FXML
	ToggleGroup diecisiete;
	@FXML
	RadioButton pregunta1_18;
	@FXML
	RadioButton pregunta2_18;
	@FXML
	ToggleGroup dieciocho;
	@FXML
	RadioButton pregunta1_19;
	@FXML
	RadioButton pregunta2_19;
	@FXML
	ToggleGroup diecinueve;
	@FXML
	RadioButton pregunta1_20;
	@FXML
	RadioButton pregunta2_20;
	@FXML
	ToggleGroup veinte;
	@FXML
	RadioButton pregunta1_21;
	@FXML
	RadioButton pregunta2_21;
	@FXML
	ToggleGroup veintiuno;
	@FXML
	RadioButton pregunta1_22;
	@FXML
	RadioButton pregunta2_22;
	@FXML
	ToggleGroup veintidos;
	@FXML
	RadioButton pregunta1_23;
	@FXML
	RadioButton pregunta2_23;
	@FXML
	ToggleGroup veintitres;
	@FXML
    RadioButton pregunta1_24;
	@FXML
	RadioButton pregunta2_24;
	@FXML
	ToggleGroup veinticuatro;
	@FXML
	RadioButton pregunta1_25;
	@FXML
	RadioButton pregunta2_25;
	@FXML
	ToggleGroup veinticinco;
	@FXML
	RadioButton pregunta1_26;
	@FXML
	RadioButton pregunta2_26;
	@FXML
	ToggleGroup veintiseis;
	@FXML
	RadioButton pregunta1_27;
	@FXML
	RadioButton pregunta2_27;
	@FXML
	ToggleGroup veintisiete;
	@FXML
	RadioButton pregunta1_28;
	@FXML
	RadioButton pregunta2_28;
	@FXML
	ToggleGroup veintiocho;
	@FXML
	RadioButton pregunta1_29;
	@FXML
	RadioButton pregunta2_29;
	@FXML
	ToggleGroup veintinueve;
	@FXML
	RadioButton pregunta1_30;
	@FXML
	RadioButton pregunta2_30;
	@FXML
	ToggleGroup treinta;
	@FXML
	RadioButton pregunta1_31;
	@FXML
	RadioButton pregunta2_31;
	@FXML
	ToggleGroup treintayuno;
	@FXML
	RadioButton pregunta1_32;
	@FXML
	RadioButton pregunta2_32;
	@FXML
	ToggleGroup treintaydos;
	@FXML
	RadioButton preguntaExclusion1_1;
	@FXML
	RadioButton preguntaExclusion2_1;
	@FXML
	ToggleGroup exclusionuno;
	@FXML
	RadioButton preguntaExclusion1_2;
	@FXML
	RadioButton preguntaExclusion2_2;
	@FXML
	ToggleGroup exclusiondos;
	@FXML
    RadioButton preguntaExclusion1_3;
	@FXML
	RadioButton preguntaExclusion2_3;
	@FXML
	ToggleGroup exclusiontres;
	
	@FXML
	private ChoiceBox num_donante;
	@FXML
	private TextField txtNum_Formulario;
	
	@FXML
	private DatePicker fecha;
	
	@FXML
	private TableView<Donantes> tabla;
	@FXML
	private TableColumn<Donantes,Integer> col_num_donante;
	@FXML
	private TableColumn<Donantes,String> col_nombre;
	                                   
	ObservableList<Integer> datos = FXCollections.observableArrayList();
	ObservableList<Donantes> datos2 = FXCollections.observableArrayList();
	
	ControladoraBBDD con;
	
    public void initialize () throws SQLException{   	

    	datos = con.ConsultaNumDonantes();
    	datos2 = con.ConsultaDonantes();
    	
    	num_donante.setItems(datos);
    	
		tabla.setItems(datos2);
		
		col_num_donante.setCellValueFactory(new PropertyValueFactory<Donantes,Integer>("num_donante"));
		col_nombre.setCellValueFactory(new PropertyValueFactory<Donantes,String>("nombre"));
   
	}  
    
	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		
		this.ventana = ventana;
	}
	public void closeWindow(){
		this.ventana.close();
	}
	 
}
