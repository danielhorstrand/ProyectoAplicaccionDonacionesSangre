package Vista;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import Controlador.Main;
import Modelo.ControladoraBBDD;
import Modelo.Donacion;
import Modelo.Donantes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
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
	private Button btnBorrar;
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
	private TextField txtFecha;
	
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
		
	ObservableList<String> datos2 = FXCollections.observableArrayList("-------","SANGRE","AFERESIS");
	ObservableList<Donacion> datos = FXCollections.observableArrayList();
	
	private boolean edicion;
	private int indiceedicion;
	
	public void initialize (int numero) throws SQLException{
				
		LocalDate now = LocalDate.now();
		int año = now.getYear();
		int mes = now.getMonthValue();
		int dia = now.getDayOfMonth();
		String fechaActual = ""+dia+"/"+mes+"/"+año+"";
		
		ControladoraBBDD conDonaciones = new ControladoraBBDD();

		datos = conDonaciones.ConsultaDonaciones();
    	String numero2= ""+numero+"";
    	
    	txtNum_donante.setText(numero2);
    	Tipo_donacion.setItems(datos2);
    	Tipo_donacion.setValue("-------");
    	txtNum_donacion.setText("0");
    	txtCod_colecta.setText("0");
    	txtPulso.setText("0");
    	txtTa_sist.setText("0");
    	txtTa_diast.setText("0");
    	txtHb_cap.setText("0");
    	txtHb_ven.setText("0");
    	txtVolumen.setText("0");
    	txtFecha.setText(fechaActual);

  	
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
		
		edicion = false;
		indiceedicion = 0;

	}
	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }
	public void closeWindow(){
		this.ProgramaPrincipal.mostrarVentanaPrincipal();
		this.ventana.close();
	}
	public void Guardar() throws SQLException, FileNotFoundException{
		
		
		ControladoraBBDD con = new ControladoraBBDD();
		int num_donacion = Integer.parseInt(txtNum_donacion.getText());
		int cod_colecta = Integer.parseInt(txtCod_colecta.getText());
		int pulso = Integer.parseInt(txtPulso.getText());
		int ta_sist = Integer.parseInt(txtTa_sist.getText());
		int ta_diast = Integer.parseInt(txtTa_diast.getText());
		int hb_cap = Integer.parseInt(txtHb_cap.getText());
		int hb_ven = Integer.parseInt(txtHb_ven.getText());
		int volumen = Integer.parseInt(txtVolumen.getText());
		String tipoDonacion = (String) Tipo_donacion.getValue();
		int num_donante = Integer.parseInt(txtNum_donante.getText());
		
		DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
		String fecha1 = txtFecha.getText();


		
		if(cod_colecta==0 || pulso==0 || ta_sist==0 || ta_diast==0 || hb_cap==0 || hb_ven==0 || volumen==0 || Tipo_donacion.getValue().equals("-------")==true){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error!!!");
			alert.setHeaderText("Observa que hayas introducido todos los datos");
			alert.setContentText("¡No se pueden grabar campos vacíos!");
			alert.showAndWait();
		}
		else{
	    			    			
    		if(edicion == true){
    				
				Donacion nueva = new Donacion(num_donacion,cod_colecta,tipoDonacion,pulso,ta_sist,ta_diast,hb_cap,hb_ven,volumen,fecha1);
    				
				int res =0;
				
				res = con.modificarDonacion(nueva);
		
    			switch (res){

				case 0:
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("OK!");
					alert.setHeaderText("Modificación OK!");
					alert.setContentText("¡Donante modificado con éxito!");
					alert.showAndWait();

					datos = con.ConsultaDonaciones();
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
    				

    				Donacion nueva = new Donacion(num_donacion,cod_colecta,tipoDonacion,pulso,ta_sist,ta_diast,hb_cap,hb_ven,volumen,fecha1);

    				int res =0;
    				
    				res = con.guardarDonacion(nueva);
					
					switch (res){

					case 0:
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("OK!");
						alert.setHeaderText("Inserción OK!");
						alert.setContentText("¡Donacion insertada con éxito!");
						alert.showAndWait();
						con.guardarRellena(num_donante, num_donacion);

						datos = con.ConsultaDonaciones();
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
		
		txtNum_donacion.setText("0");
		txtCod_colecta.setText("0");
		txtPulso.setText("0");
		txtTa_sist.setText("0");
		txtTa_diast.setText("0");
		txtHb_cap.setText("0");
		txtHb_ven.setText("");
		txtVolumen.setText("0");		
	    this.Tipo_donacion.setValue("-------");


		edicion = false;
		indiceedicion = 0;
	}
	public void Editar() throws SQLException{

	
	}
}
