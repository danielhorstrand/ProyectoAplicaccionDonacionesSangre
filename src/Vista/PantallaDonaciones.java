package Vista;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Controlador.Main;
import Modelo.ControladoraBBDD;
import Modelo.Formulario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PantallaDonaciones {
	
	private Main ProgramaPrincipal;
	
	private Stage ventana;
	
	@FXML
	private Button btnContinuar;
	@FXML
	private Button btnGuardar;
	@FXML
	private Button btnVolver;
	@FXML
	private Button btnEliminar;
	@FXML
	private Button btnBorrar;	
	@FXML
	private ImageView si;
	@FXML
	private ImageView no;
	
	@FXML
	RadioButton pregunta1_1;
	@FXML
	RadioButton pregunta2_1;	
	@FXML
	ToggleGroup g1;
	@FXML
	RadioButton pregunta1_2;
	@FXML
	RadioButton pregunta2_2;
	@FXML
	ToggleGroup g2;
	@FXML
	RadioButton pregunta1_3;
	@FXML
	RadioButton pregunta2_3;
	@FXML
	ToggleGroup g3;
	@FXML
	RadioButton pregunta1_4;
	@FXML
	RadioButton pregunta2_4;
	@FXML
	ToggleGroup g4;
	@FXML
	RadioButton pregunta1_5;
	@FXML
	RadioButton pregunta2_5;
	@FXML
	ToggleGroup g5;
	@FXML
	RadioButton pregunta1_6;
	@FXML
	RadioButton pregunta2_6;
	@FXML
	ToggleGroup g6;
	@FXML
	RadioButton pregunta1_7;
	@FXML
	RadioButton pregunta2_7;
	@FXML
	ToggleGroup g7;
	@FXML
	RadioButton pregunta1_8;
	@FXML
	RadioButton pregunta2_8;
	@FXML
	ToggleGroup g8;
	@FXML
	RadioButton pregunta1_9;
	@FXML
	RadioButton pregunta2_9;
	@FXML
	ToggleGroup g9;
	@FXML
	RadioButton pregunta1_10;
	@FXML
	RadioButton pregunta2_10;
	@FXML
	ToggleGroup g10;
	@FXML
	RadioButton pregunta1_11;
	@FXML
	RadioButton pregunta2_11;
	@FXML
	ToggleGroup g11;
	@FXML
	RadioButton pregunta1_12;
	@FXML
	RadioButton pregunta2_12;
	@FXML
	ToggleGroup g12;
	@FXML
	RadioButton pregunta1_13;
	@FXML
	RadioButton pregunta2_13;
	@FXML
	ToggleGroup g13;
	@FXML
	RadioButton pregunta1_14;
	@FXML
	RadioButton pregunta2_14;
	@FXML
	ToggleGroup g14;
	@FXML
	RadioButton pregunta1_15;
	@FXML
	RadioButton pregunta2_15;
	@FXML
	ToggleGroup g15;
	@FXML
	RadioButton pregunta1_16;
	@FXML
	RadioButton pregunta2_16;
	@FXML
	ToggleGroup g16;
	@FXML
	RadioButton pregunta1_17;
	@FXML
	RadioButton pregunta2_17;
	@FXML
	ToggleGroup g17;
	@FXML
	RadioButton pregunta1_18;
	@FXML
	RadioButton pregunta2_18;
	@FXML
	ToggleGroup g18;
	@FXML
	RadioButton pregunta1_19;
	@FXML
	RadioButton pregunta2_19;
	@FXML
	ToggleGroup g19;
	@FXML
	RadioButton pregunta1_20;
	@FXML
	RadioButton pregunta2_20;
	@FXML
	ToggleGroup g20;
	@FXML
	RadioButton pregunta1_21;
	@FXML
	RadioButton pregunta2_21;
	@FXML
	ToggleGroup g21;
	@FXML
	RadioButton pregunta1_22;
	@FXML
	RadioButton pregunta2_22;
	@FXML
	ToggleGroup g22;
	@FXML
	RadioButton pregunta1_23;
	@FXML
	RadioButton pregunta2_23;
	@FXML
	ToggleGroup g23;
	@FXML
    RadioButton pregunta1_24;
	@FXML
	RadioButton pregunta2_24;
	@FXML
	ToggleGroup g24;
	@FXML
	RadioButton pregunta1_25;
	@FXML
	RadioButton pregunta2_25;
	@FXML
	ToggleGroup g25;
	@FXML
	RadioButton pregunta1_26;
	@FXML
	RadioButton pregunta2_26;
	@FXML
	ToggleGroup g26;
	@FXML
	RadioButton pregunta1_27;
	@FXML
	RadioButton pregunta2_27;
	@FXML
	ToggleGroup g27;
	@FXML
	RadioButton pregunta1_28;
	@FXML
	RadioButton pregunta2_28;
	@FXML
	ToggleGroup g28;
	@FXML
	RadioButton pregunta1_29;
	@FXML
	RadioButton pregunta2_29;
	@FXML
	ToggleGroup g29;
	@FXML
	RadioButton pregunta1_30;
	@FXML
	RadioButton pregunta2_30;
	@FXML
	ToggleGroup g30;
	@FXML
	RadioButton pregunta1_31;
	@FXML
	RadioButton pregunta2_31;
	@FXML
	ToggleGroup g31;
	@FXML
	RadioButton pregunta1_32;
	@FXML
	RadioButton pregunta2_32;
	@FXML
	ToggleGroup g32;
	@FXML
	RadioButton preguntaExclusion1_1;
	@FXML
	RadioButton preguntaExclusion2_1;
	@FXML
	ToggleGroup g33;
	@FXML
	RadioButton preguntaExclusion1_2;
	@FXML
	RadioButton preguntaExclusion2_2;
	@FXML
	ToggleGroup g34;
	@FXML
    RadioButton preguntaExclusion1_3;
	@FXML
	RadioButton preguntaExclusion2_3;
	@FXML
	ToggleGroup g35;
	
	@FXML
	private ChoiceBox<Integer> num_donante;
	@FXML
	private TextField txtNum_Formulario;
	
	@FXML
	private TextField txtApto;
	
	@FXML
	private DatePicker fecha;
	
	@FXML
	private TableView<Formulario> tabla;
	@FXML
	private TableColumn<Formulario,Integer> col_num_formulario;
	                                   
	ObservableList<Integer> datos = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
	ObservableList<Integer> datos2 = FXCollections.observableArrayList();
	ObservableList<Formulario> datos3 = FXCollections.observableArrayList();
	
	private boolean edicion;
	private int indiceedicion;

    public void initialize () throws SQLException{  
    	
    	ControladoraBBDD conDonaciones3 = new ControladoraBBDD();
    	
    	datos2 = conDonaciones3.ConsultaNumDonantes();
    	
    	datos3 = conDonaciones3.ConsultaFormularios();
    	
    	tabla.setItems(datos3);
    	
    	col_num_formulario.setCellValueFactory(new PropertyValueFactory<Formulario,Integer>("num_formulario"));
    	
    	num_donante.setItems(datos2);
    	
		edicion = false;
		indiceedicion = 0;
		
		if (this.txtApto.equals("")==true){
			this.si.setVisible(false);
			this.no.setVisible(false);
		}

	}    
    public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }
	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	public void closeWindow(){
		this.ventana.close();
	}
	public void GuardarFormulario(ActionEvent event) throws SQLException{
		
		ControladoraBBDD conDonaciones = new ControladoraBBDD();
		

		String pregunta1;
		String pregunta2;
		String pregunta3;
		String pregunta4;
		String pregunta5;
		String pregunta6;
		String pregunta7;
		String pregunta8;
		String pregunta9;
		String pregunta10;
		String pregunta11;
		String pregunta12;
		String pregunta13;
		String pregunta14;
		String pregunta15;
	    String pregunta16;
		String pregunta17;
		String pregunta18;
		String pregunta19;
		String pregunta20;
		String pregunta21;
		String pregunta22;
		String pregunta23;
		String pregunta24;
		String pregunta25;
		String pregunta26;
		String pregunta27;
		String pregunta28;
		String pregunta29;
		String pregunta30;
		String pregunta31;
		String pregunta32;
		String preguntaEX1;
		String preguntaEX2;
		String preguntaEX3;

		if (this.g1.getSelectedToggle().equals(this.pregunta1_1)){
			pregunta1="SI";
		}else {
			pregunta1="NO";
		}
		if (this.g2.getSelectedToggle().equals(this.pregunta1_2)){
			pregunta2="SI";
		}else {
			pregunta2="NO";
		}
		if (this.g3.getSelectedToggle().equals(this.pregunta1_3)){
			pregunta3="SI";
		}else {
			pregunta3="NO";
		}
		if (this.g4.getSelectedToggle().equals(this.pregunta1_4)){
			pregunta4="SI";
		}else {
			pregunta4="NO";
		}
		if (this.g5.getSelectedToggle().equals(this.pregunta1_5)){
			pregunta5="SI";
		}else {
			pregunta5="NO";
		}
		if (this.g6.getSelectedToggle().equals(this.pregunta1_6)){
			pregunta6="SI";
		}else {
			pregunta6="NO";
		}
		if (this.g7.getSelectedToggle().equals(this.pregunta1_7)){
			pregunta7="SI";
		}else {
			pregunta7="NO";
		}
		if (this.g8.getSelectedToggle().equals(this.pregunta1_8)){
			pregunta8="SI";
		}else {
			pregunta8="NO";
		}
		if (this.g9.getSelectedToggle().equals(this.pregunta1_9)){
			pregunta9="SI";
		}else {
			pregunta9="NO";
		}
		if (this.g10.getSelectedToggle().equals(this.pregunta1_10)){
			pregunta10="SI";
		}else {
			pregunta10="NO";
		}
		if (this.g11.getSelectedToggle().equals(this.pregunta1_11)){
			pregunta11="SI";
		}else {
			pregunta11="NO";
		}
		if (this.g12.getSelectedToggle().equals(this.pregunta1_12)){
			pregunta12="SI";
		}else {
			pregunta12="NO";
		}
		if (this.g13.getSelectedToggle().equals(this.pregunta1_13)){
			pregunta13="SI";
		}else {
			pregunta13="NO";
		}
		if (this.g14.getSelectedToggle().equals(this.pregunta1_14)){
			pregunta14="SI";
		}else {
			pregunta14="NO";
		}
		if (this.g15.getSelectedToggle().equals(this.pregunta1_15)){
			pregunta15="SI";
		}else {
			pregunta15="NO";
		}
		if (this.g16.getSelectedToggle().equals(this.pregunta1_16)){
			pregunta16="SI";
		}else {
			pregunta16="NO";
		}
		if (this.g17.getSelectedToggle().equals(this.pregunta1_17)){
			pregunta17="SI";
		}else {
			pregunta17="NO";
		}
		if (this.g18.getSelectedToggle().equals(this.pregunta1_18)){
			pregunta18="SI";
		}else {
			pregunta18="NO";
		}
		if (this.g19.getSelectedToggle().equals(this.pregunta1_19)){
			pregunta19="SI";
		}else {
			pregunta19="NO";
		}
		if (this.g20.getSelectedToggle().equals(this.pregunta1_20)){
			pregunta20="SI";
		}else {
			pregunta20="NO";
		}
		if (this.g21.getSelectedToggle().equals(this.pregunta1_21)){
			pregunta21="SI";
		}else {
			pregunta21="NO";
		}
		if (this.g22.getSelectedToggle().equals(this.pregunta1_22)){
			pregunta22="SI";
		}else {
			pregunta22="NO";
		}
		if (this.g23.getSelectedToggle().equals(this.pregunta1_23)){
			pregunta23="SI";
		}else {
			pregunta23="NO";
		}
		if (this.g24.getSelectedToggle().equals(this.pregunta1_24)){
			pregunta24="SI";
		}else {
			pregunta24="NO";
		}
		if (this.g25.getSelectedToggle().equals(this.pregunta1_25)){
			pregunta25="SI";
		}else {
			pregunta25="NO";
		}
		if (this.g26.getSelectedToggle().equals(this.pregunta1_26)){
			pregunta26="SI";
		}else {
			pregunta26="NO";
		}
		if (this.g27.getSelectedToggle().equals(this.pregunta1_27)){
			pregunta27="SI";
		}else {
			pregunta27="NO";
		}
		if (this.g28.getSelectedToggle().equals(this.pregunta1_28)){
			pregunta28="SI";
		}else {
			pregunta28="NO";
		}
		if (this.g29.getSelectedToggle().equals(this.pregunta1_29)){
			pregunta29="SI";
		}else {
			pregunta29="NO";
		}
		if (this.g30.getSelectedToggle().equals(this.pregunta1_30)){
			pregunta30="SI";
		}else {
			pregunta30="NO";
		}
		if (this.g31.getSelectedToggle().equals(this.pregunta1_31)){
			pregunta31="SI";
		}else {
			pregunta31="NO";
		}
		if (this.g32.getSelectedToggle().equals(this.pregunta1_32)){
			pregunta32="SI";
		}else {
			pregunta32="NO";
		}
		if (this.g33.getSelectedToggle().equals(this.preguntaExclusion1_1)){
			preguntaEX1="SI";
		}else {
			preguntaEX1="NO";
		}
		if (this.g34.getSelectedToggle().equals(this.preguntaExclusion1_2)){
			preguntaEX2="SI";
		}else {
			preguntaEX2="NO";
		}
		if (this.g35.getSelectedToggle().equals(this.preguntaExclusion1_3)){
			preguntaEX3="SI";
		}else {
			preguntaEX3="NO";
		}
		
		txtApto.setText("");
		String estado_donacion="";
		
		DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
		String fecha1 = fecha.getValue().format(isoFecha);
		String fecha_exclusion = "";
		
		int num_formulario2 = Integer.parseInt(txtNum_Formulario.getText());
		int num_donante2 = (int) num_donante.getValue();
		
		ObservableList<String> listaAñoDonantes =  FXCollections.observableArrayList();
		
		listaAñoDonantes = conDonaciones.consultarAñoDonante(num_donante2);
		
		String fechaActual = fecha1.substring(0,4);
		
		boolean añosValidosDonante = añosValidos(listaAñoDonantes.get(0),fechaActual);
		
		if ( preguntaEX1.equals("SI") || preguntaEX2.equals("SI")  || preguntaEX3.equals("SI")){
			txtApto.setText("NO");
			estado_donacion="EXCLUIDO";
			fecha_exclusion = fecha.getValue().format(isoFecha);
			this.no.setVisible(true);
			this.si.setVisible(false);
		}else {
			if (pregunta1.equals("NO") || pregunta3.equals("NO") || pregunta12.equals("SI") || pregunta14.equals("SI") || pregunta16.equals("SI") || pregunta17.equals("SI")){
				txtApto.setText("NO");
				estado_donacion="EXCLUIDO TEMPORAL";
				fecha_exclusion = fecha.getValue().format(isoFecha);
				this.no.setVisible(true);
				this.si.setVisible(false);
			}else {
				if (añosValidosDonante==true){
					txtApto.setText("SI");
					estado_donacion="APTO";
					this.si.setVisible(true);
					this.no.setVisible(false);
				}else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Cuidado!");
					alert.setHeaderText("Error en la edad!");
					alert.setContentText("¡Tu edad no es permitida!");
					alert.showAndWait();
					txtApto.setText("NO");
					estado_donacion="EXCLUIDO TEMPORAL";
					fecha_exclusion = fecha.getValue().format(isoFecha);
					this.no.setVisible(true);
					this.si.setVisible(false);
				}
			}
		}
		
		int res =0;
		
		res = conDonaciones.guardarFormulario(num_formulario2, pregunta1,pregunta2,pregunta3,pregunta4,pregunta5,pregunta6,pregunta7,pregunta8,pregunta9,pregunta10,pregunta11,pregunta12,pregunta13,pregunta14,pregunta15,pregunta16,pregunta17,pregunta18,pregunta19,pregunta20,pregunta21,pregunta22,pregunta23,pregunta24,pregunta25,pregunta26,pregunta27,pregunta28,pregunta29,pregunta30,pregunta31,pregunta32,preguntaEX1,preguntaEX2,preguntaEX3,txtApto.getText(),fecha1,estado_donacion,fecha_exclusion,num_donante2);

		switch (res){

		case 0:
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("OK!");
			alert.setHeaderText("FORMULARIO OK!");
			alert.setContentText("¡Formulario guardado con éxito!");
			alert.showAndWait();
			conDonaciones.guardarRellena(num_formulario2, num_donante2);
			datos3 = conDonaciones.ConsultaFormularios();
			tabla.setItems(datos3);
			break;
		case 1:
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("Aviso!");
			alert.setHeaderText("Inserción ERROR!");
			alert.setContentText("¡Ya existe un Formulario y relacion con ese CODIGO!");
			alert.showAndWait();
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
	public boolean añosValidos(String nacimiento,String fechaActual){
		boolean añoValido = false;
		
		int año_nacimiento = Integer.parseInt(nacimiento);
		int año_Actual = Integer.parseInt(fechaActual);
		
		int años = año_Actual-año_nacimiento;
		
		if (años>65 || años<15){
			añoValido = false;
		}else {
			añoValido = true;
		}
		
		return añoValido;
	}
	public void eliminarFormulario () throws SQLException{
		
		ControladoraBBDD conDonaciones = new ControladoraBBDD();
		
		int num_formulario2 = Integer.parseInt(txtNum_Formulario.getText());
		conDonaciones.BorrarFormulario(num_formulario2);
		
    	datos3 = conDonaciones.ConsultaFormularios();
    	
    	tabla.setItems(datos3);
    	
    	col_num_formulario.setCellValueFactory(new PropertyValueFactory<Formulario,Integer>("num_formulario"));
		
		Borrar();
		
	}
	public void Borrar() throws SQLException{

			this.pregunta1_1.setSelected(false);
			this.pregunta2_1.setSelected(false);
			this.pregunta1_2.setSelected(false);
			this.pregunta2_2.setSelected(false);
			this.pregunta1_3.setSelected(false);
			this.pregunta2_3.setSelected(false);
			this.pregunta1_4.setSelected(false);
			this.pregunta2_4.setSelected(false);
			this.pregunta1_5.setSelected(false);
			this.pregunta2_5.setSelected(false);
			this.pregunta1_6.setSelected(false);
			this.pregunta2_6.setSelected(false);
			this.pregunta1_7.setSelected(false);
			this.pregunta2_7.setSelected(false);
			this.pregunta1_8.setSelected(false);
			this.pregunta2_8.setSelected(false);
			this.pregunta1_9.setSelected(false);
			this.pregunta2_9.setSelected(false);
			this.pregunta1_10.setSelected(false);
			this.pregunta2_10.setSelected(false);
			this.pregunta1_11.setSelected(false);
			this.pregunta2_11.setSelected(false);
			this.pregunta1_12.setSelected(false);
			this.pregunta2_12.setSelected(false);
			this.pregunta1_13.setSelected(false);
			this.pregunta2_13.setSelected(false);
			this.pregunta1_14.setSelected(false);
			this.pregunta2_14.setSelected(false);
			this.pregunta1_15.setSelected(false);
			this.pregunta2_15.setSelected(false);
			this.pregunta1_16.setSelected(false);
			this.pregunta2_16.setSelected(false);
			this.pregunta1_17.setSelected(false);
			this.pregunta2_17.setSelected(false);
			this.pregunta1_18.setSelected(false);
			this.pregunta2_18.setSelected(false);
			this.pregunta1_19.setSelected(false);
			this.pregunta2_19.setSelected(false);
			this.pregunta1_20.setSelected(false);
			this.pregunta2_20.setSelected(false);
			this.pregunta1_21.setSelected(false);
			this.pregunta2_21.setSelected(false);
			this.pregunta1_22.setSelected(false);
			this.pregunta2_22.setSelected(false);
			this.pregunta1_23.setSelected(false);
			this.pregunta2_23.setSelected(false);
			this.pregunta1_23.setSelected(false);
			this.pregunta2_23.setSelected(false);
			this.pregunta1_24.setSelected(false);
			this.pregunta2_24.setSelected(false);
			this.pregunta1_25.setSelected(false);
			this.pregunta2_25.setSelected(false);
			this.pregunta1_26.setSelected(false);
			this.pregunta2_26.setSelected(false);
			this.pregunta1_27.setSelected(false);
			this.pregunta2_27.setSelected(false);
			this.pregunta1_28.setSelected(false);
			this.pregunta2_28.setSelected(false);
			this.pregunta1_29.setSelected(false);
			this.pregunta2_29.setSelected(false);
			this.pregunta1_30.setSelected(false);
			this.pregunta2_30.setSelected(false);
			this.pregunta1_31.setSelected(false);
			this.pregunta2_31.setSelected(false);
			this.pregunta1_32.setSelected(false);
			this.pregunta2_32.setSelected(false);
			this.preguntaExclusion1_1.setSelected(false);
			this.preguntaExclusion2_1.setSelected(false);
			this.preguntaExclusion1_2.setSelected(false);
			this.preguntaExclusion2_2.setSelected(false);
			this.preguntaExclusion1_3.setSelected(false);
			this.preguntaExclusion2_3.setSelected(false);
			this.txtApto.setText("");
			this.si.setVisible(false);
			this.no.setVisible(false);
			this.txtNum_Formulario.setText("");
			initialize();
			

		
		edicion = false;
		indiceedicion = 0;
	}
	public void Editar() throws SQLException{

		int index = tabla.getSelectionModel().getSelectedIndex();

		ControladoraBBDD conDonaciones = new ControladoraBBDD();

		if( index >= 0){

			// Activo la "funcionalidad" de editar para luego que el botón guardar sepa a qué PErsona estoy "editando"
			edicion = true;
			indiceedicion = index;

			Formulario seleccionado = tabla.getSelectionModel().getSelectedItem();
			if (seleccionado.getPregunta1().equals("SI")==true){
				this.pregunta1_1.setSelected(true);
			}else {
				this.pregunta2_1.setSelected(true);
			}
			if (seleccionado.getPregunta2().equals("SI")==true){
				this.pregunta1_2.setSelected(true);
			}else {
				this.pregunta2_2.setSelected(true);
			}
			if (seleccionado.getPregunta3().equals("SI")==true){
				this.pregunta1_3.setSelected(true);
			}else {
				this.pregunta2_3.setSelected(true);
			}
			if (seleccionado.getPregunta4().equals("SI")==true){
				this.pregunta1_4.setSelected(true);
			}else {
				this.pregunta2_4.setSelected(true);
			}
			if (seleccionado.getPregunta5().equals("SI")==true){
				this.pregunta1_5.setSelected(true);
			}else {
				this.pregunta2_5.setSelected(true);
			}
			if (seleccionado.getPregunta6().equals("SI")==true){
				this.pregunta1_6.setSelected(true);
			}else {
				this.pregunta2_6.setSelected(true);
			}
			if (seleccionado.getPregunta7().equals("SI")==true){
				this.pregunta1_7.setSelected(true);
			}else {
				this.pregunta2_7.setSelected(true);
			}
			if (seleccionado.getPregunta8().equals("SI")==true){
				this.pregunta1_8.setSelected(true);
			}else {
				this.pregunta2_8.setSelected(true);
			}
			if (seleccionado.getPregunta9().equals("SI")==true){
				this.pregunta1_9.setSelected(true);
			}else {
				this.pregunta2_9.setSelected(true);
			}
			if (seleccionado.getPregunta10().equals("SI")==true){
				this.pregunta1_10.setSelected(true);
			}else {
				this.pregunta2_10.setSelected(true);
			}
			if (seleccionado.getPregunta11().equals("SI")==true){
				this.pregunta1_11.setSelected(true);
			}else {
				this.pregunta2_11.setSelected(true);
			}
			if (seleccionado.getPregunta12().equals("SI")==true){
				this.pregunta1_12.setSelected(true);
			}else {
				this.pregunta2_12.setSelected(true);
			}
			if (seleccionado.getPregunta13().equals("SI")==true){
				this.pregunta1_13.setSelected(true);
			}else {
				this.pregunta2_13.setSelected(true);
			}
			if (seleccionado.getPregunta14().equals("SI")==true){
				this.pregunta1_14.setSelected(true);
			}else {
				this.pregunta2_14.setSelected(true);
			}
			if (seleccionado.getPregunta15().equals("SI")==true){
				this.pregunta1_15.setSelected(true);
			}else {
				this.pregunta2_15.setSelected(true);
			}
			if (seleccionado.getPregunta16().equals("SI")==true){
				this.pregunta1_16.setSelected(true);
			}else {
				this.pregunta2_16.setSelected(true);
			}
			if (seleccionado.getPregunta17().equals("SI")==true){
				this.pregunta1_17.setSelected(true);
			}else {
				this.pregunta2_17.setSelected(true);
			}
			if (seleccionado.getPregunta18().equals("SI")==true){
				this.pregunta1_18.setSelected(true);
			}else {
				this.pregunta2_18.setSelected(true);
			}
			if (seleccionado.getPregunta19().equals("SI")==true){
				this.pregunta1_19.setSelected(true);
			}else {
				this.pregunta2_19.setSelected(true);
			}
			if (seleccionado.getPregunta20().equals("SI")==true){
				this.pregunta1_20.setSelected(true);
			}else {
				this.pregunta2_20.setSelected(true);
			}
			if (seleccionado.getPregunta21().equals("SI")==true){
				this.pregunta1_21.setSelected(true);
			}else {
				this.pregunta2_21.setSelected(true);
			}
			if (seleccionado.getPregunta22().equals("SI")==true){
				this.pregunta1_22.setSelected(true);
			}else {
				this.pregunta2_22.setSelected(true);
			}
			if (seleccionado.getPregunta23().equals("SI")==true){
				this.pregunta1_23.setSelected(true);
			}else {
				this.pregunta2_23.setSelected(true);
			}
			if (seleccionado.getPregunta23().equals("SI")==true){
				this.pregunta1_23.setSelected(true);
			}else {
				this.pregunta2_23.setSelected(true);
			}
			if (seleccionado.getPregunta24().equals("SI")==true){
				this.pregunta1_24.setSelected(true);
			}else {
				this.pregunta2_24.setSelected(true);
			}
			if (seleccionado.getPregunta25().equals("SI")==true){
				this.pregunta1_25.setSelected(true);
			}else {
				this.pregunta2_25.setSelected(true);
			}
			if (seleccionado.getPregunta26().equals("SI")==true){
				this.pregunta1_26.setSelected(true);
			}else {
				this.pregunta2_26.setSelected(true);
			}
			if (seleccionado.getPregunta27().equals("SI")==true){
				this.pregunta1_27.setSelected(true);
			}else {
				this.pregunta2_27.setSelected(true);
			}
			if (seleccionado.getPregunta28().equals("SI")==true){
				this.pregunta1_28.setSelected(true);
			}else {
				this.pregunta2_28.setSelected(true);
			}
			if (seleccionado.getPregunta29().equals("SI")==true){
				this.pregunta1_29.setSelected(true);
			}else {
				this.pregunta2_29.setSelected(true);
			}
			if (seleccionado.getPregunta30().equals("SI")==true){
				this.pregunta1_30.setSelected(true);
			}else {
				this.pregunta2_30.setSelected(true);
			}
			if (seleccionado.getPregunta31().equals("SI")==true){
				this.pregunta1_31.setSelected(true);
			}else {
				this.pregunta2_31.setSelected(true);
			}
			if (seleccionado.getPregunta32().equals("SI")==true){
				this.pregunta1_32.setSelected(true);
			}else {
				this.pregunta2_32.setSelected(true);
			}
			if (seleccionado.getPreguntaEX1().equals("SI")==true){
				this.preguntaExclusion1_1.setSelected(true);
			}else {
				this.preguntaExclusion2_1.setSelected(true);
			}
			if (seleccionado.getPreguntaEX2().equals("SI")==true){
				this.preguntaExclusion1_2.setSelected(true);
			}else {
				this.preguntaExclusion2_2.setSelected(true);
			}
			if (seleccionado.getPreguntaEX3().equals("SI")==true){
				this.preguntaExclusion1_3.setSelected(true);
			}else {
				this.preguntaExclusion2_3.setSelected(true);
			}
			txtApto.setText(seleccionado.getApto());
			
			ObservableList<Integer> numero_donante = conDonaciones.consultaRellena(seleccionado.getNum_formulario());
			
			this.num_donante.setItems(numero_donante);
			num_donante.setValue(numero_donante.get(0));
			
			if (seleccionado.getApto().equals("SI")==true){
				this.si.setVisible(true);
				this.no.setVisible(false);
			}else {
				if (seleccionado.getApto().equals("NO")==true){
					this.no.setVisible(true);
					this.si.setVisible(false);
				}else {
					this.si.setVisible(false);
					this.no.setVisible(false);
				}
			}
			
		
			
			txtNum_Formulario.setText(""+seleccionado.getNum_formulario()+"");


		}
	}
	public void AbrirVentanaDonaciones2(){

		int num_donante2 = (int) num_donante.getValue();
		
		if (txtApto.getText().equals("SI")==true){
			this.ProgramaPrincipal.mostrarVentanaDonaciones2(num_donante2);
			this.ventana.close();
		}
	
	}

}
