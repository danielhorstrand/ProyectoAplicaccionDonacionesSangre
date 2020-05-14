package Vista;

import java.sql.SQLException;

import Controlador.Main;
import Modelo.ControladoraBBDD;
import Modelo.Donacion;
import Modelo.Donantes;
import Modelo.Formulario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PantallaDonacionesDos {

	private  Main ProgramaPrincipal;	
	private Stage ventana;

	@FXML
	private ChoiceBox<String> Tipo_donacion;
	@FXML
	private Button btnContinuar;
	@FXML
	private Button btnVolver;
	@FXML
	private TextField txtNum_donante;
	@FXML
	private TextField txtNum_donacion;
	@FXML
	private TextField txtCod_colecta;
	@FXML
	private TextField txtPulso;
	@FXML
	private TextField txtTa_sist;
	@FXML
	private TextField txtTa_diast;
	@FXML
	private TextField txtHb_cap;
	@FXML
	private TextField txtHb_ven;
	@FXML
	private TextField txtVolumen;
	@FXML
	private DatePicker fecha;
	
	@FXML
	private ImageView borrar;
	
	@FXML
	private TableView<Donacion> tabla;
	@FXML
	private TableColumn<Donacion,Integer> col_num_donacion;
	@FXML
	private TableColumn<Donacion,Integer> col_colecta;
	@FXML
	private TableColumn<Donacion,String> col_tipo_donacion;
	@FXML
	private TableColumn<Donacion,Integer> col_pulso;
	@FXML
	private TableColumn<Donacion,Integer> col_ta_sist;
	@FXML
	private TableColumn<Donacion,Integer> col_ta_diast;
	@FXML
	private TableColumn<Donacion,Integer> col_hb_cap;
	@FXML
	private TableColumn<Donacion,Integer> col_hb_ven;
	@FXML
	private TableColumn<Donacion,Integer> col_volumen;
	@FXML
	private TableColumn<Donacion,String> col_fecha;
		
	ObservableList<String> datos2 = FXCollections.observableArrayList("SANGRE","AFERESIS");
	ObservableList<Donacion> datos = FXCollections.observableArrayList();
	
	private boolean edicion;
	private int indiceedicion;
	
	public void initialize (int numero) throws SQLException{
				
		ControladoraBBDD conDonaciones = new ControladoraBBDD();

		datos = conDonaciones.ConsultaDonaciones();
		
		tabla.setItems(datos);
		
		col_num_donacion.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("num_donacion"));
		col_colecta.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("codigo_colecta"));
		col_tipo_donacion.setCellValueFactory(new PropertyValueFactory<Donacion,String>("tipo_donacion"));
		col_pulso.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("pulso"));
		col_ta_sist.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("ta_sist"));
		col_ta_diast.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("ta_diast"));
		col_hb_cap.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("hb_cap"));
		col_hb_ven.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("hb_ven"));
		col_volumen.setCellValueFactory(new PropertyValueFactory<Donacion,Integer>("volumen"));
		col_fecha.setCellValueFactory(new PropertyValueFactory<Donacion,String>("fecha"));
		
    	String numero2= ""+numero+"";
    	
    	txtNum_donante.setText(numero2);
    	Tipo_donacion.setItems(datos2);

	}
	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

}
