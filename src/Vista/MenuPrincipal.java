package Vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuPrincipal {

	private Controlador.Main ProgramaPrincipal;
	@FXML
	private Button btnDonante;

	@FXML
	private Button btnDonacion;

	@FXML
	private Button btnInformes;


    public void setProgramaPrincipal(Controlador.Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }
    
    @FXML
    private void pantallaDonantes(ActionEvent event) {
    	
       	this.ProgramaPrincipal.mostrarVentanaDonantes();
    }
    @FXML
	public void pantallaDonaciones(ActionEvent event){
    	
    	this.ProgramaPrincipal.mostrarVentanaDonaciones();
	}
}