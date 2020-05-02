package Vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuPrincipal {

	private  Controlador.Main ProgramaPrincipal;
	@FXML
	private Button btnDonante;

	@FXML
	private Button btnDonacion;

	@FXML
	private Button btnInformes;
	
	private Stage ventana1;

    public void setProgramaPrincipal(Controlador.Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }
    
	public void pantallaDonaciones (ActionEvent event){
		
	}
	public void pantallaInformes(ActionEvent event){
		
	}
    @FXML
    private void pantallaDonantes() {
    	
       	this.ProgramaPrincipal.mostrarVentanaSecundaria();
    }
}