package Vista;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import Modelo.ControladoraBBDD;
import Modelo.Donantes;
import Modelo.Formulario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
	@FXML
	private Button btnEliminar;
	
	private Stage ventana;
	
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
	private DatePicker fecha;
	
	@FXML
	private TableView<Formulario> tabla;
	@FXML
	private TableColumn<Formulario,Integer> col_num_formulario;
	                                   
	ObservableList<Integer> datos = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
	ObservableList<Integer> datos2 = FXCollections.observableArrayList();
	ObservableList<Formulario> datos3 = FXCollections.observableArrayList();

    public void initialize () throws SQLException{  
    	
    	ControladoraBBDD conDonaciones3 = new ControladoraBBDD();
    	
    	datos2 = conDonaciones3.ConsultaNumDonantes();
    	
    	datos3 = conDonaciones3.ConsultaFormularios();
    	
    	col_num_formulario.setCellValueFactory(new PropertyValueFactory<Formulario,Integer>("num_formulario"));
    	
    	num_donante.setItems(datos2);

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
		
		String apto = "";
		String estado_donacion="";
		
		DateTimeFormatter isoFecha = DateTimeFormatter.ISO_LOCAL_DATE;
		String fecha1 = fecha.getValue().format(isoFecha);
		String fecha_exclusion = "";
		
		if ( preguntaEX1.equals("SI") || preguntaEX2.equals("SI")  || preguntaEX3.equals("SI") ){
			apto = "NO";
			estado_donacion="EXCLUIDO";
			fecha_exclusion = fecha.getValue().format(isoFecha);
			
		}else {
			if (pregunta1.equals("NO") || pregunta3.equals("NO") || pregunta12.equals("SI") || pregunta14.equals("SI") || pregunta16.equals("SI") || pregunta17.equals("SI") ){
				apto = "NO";
				estado_donacion="EXCLUIDO TEMPORAL";
				fecha_exclusion = fecha.getValue().format(isoFecha);
			}else {
				apto ="SI";
				estado_donacion="APTO";
			}
		}
		
		int num_formulario2 = Integer.parseInt(txtNum_Formulario.getText());
		int num_donante2 = (int) num_donante.getValue();
		conDonaciones.guardarFormulario(num_formulario2, pregunta1,pregunta2,pregunta3,pregunta4,pregunta5,pregunta6,pregunta7,pregunta8,pregunta9,pregunta10,pregunta11,pregunta12,pregunta13,pregunta14,pregunta15,pregunta16,pregunta17,pregunta18,pregunta19,pregunta20,pregunta21,pregunta22,pregunta23,pregunta24,pregunta25,pregunta26,pregunta27,pregunta28,pregunta29,pregunta30,pregunta31,pregunta32,preguntaEX1,preguntaEX2,preguntaEX3,apto,fecha1,estado_donacion,fecha_exclusion,num_donante2);
		conDonaciones.guardarRellena(num_formulario2, num_donante2);
	}
	public void eliminarFormulario () throws SQLException{
		
		ControladoraBBDD conDonaciones = new ControladoraBBDD();
		
		int num_formulario2 = Integer.parseInt(txtNum_Formulario.getText());
		conDonaciones.BorrarFormulario(num_formulario2);
		
	}

}
