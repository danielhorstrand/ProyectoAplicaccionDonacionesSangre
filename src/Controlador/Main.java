package Controlador;


import java.io.IOException;

import Vista.MenuPrincipal;
import Vista.PantallaDonaciones;
import Vista.PantallaDonacionesDos;
import Vista.pantallaDonantes;
import Controlador.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {

	private static Stage stagePrincipal;
    private AnchorPane rootPane;

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        Main.stagePrincipal = stagePrincipal;
        mostrarVentanaPrincipal();

    }

    public static void main(String[] args) {
        launch(args);
    }

    //cargamos la ventana principal

    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../Vista/UIMenuPrincipal.fxml"));
            rootPane=(AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Menu Principal");
            stagePrincipal.setScene(scene);

            MenuPrincipal controller = loader.getController();
            controller.setProgramaPrincipal(this);

            stagePrincipal.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
    public void mostrarVentanaDonantes() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/UIPantallaDonantes.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventana = new Stage();
            ventana.setTitle("Pantalla Donantes");
            /* Le decimos a la ventana quién es la ventana original */
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);

            pantallaDonantes controller2 = loader.getController();
            controller2.setStagePrincipal(ventana);

            ventana.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }
    public void mostrarVentanaDonaciones() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/UIPantallaDonaciones.fxml"));
            AnchorPane ventanaTres = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventana2 = new Stage();
            ventana2.setTitle("Pantalla Formulario");
            /* Le decimos a la ventana quién es la ventana original */
            ventana2.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaTres);
            ventana2.setScene(scene);

            PantallaDonaciones controller2 = loader.getController();
            controller2.setStagePrincipal(ventana2);
            controller2.setProgramaPrincipal(this);
            ventana2.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }
    public void mostrarVentanaDonaciones2(int numero) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/UiPantallaDonaciones2.fxml"));
            AnchorPane ventanaCuatro = (AnchorPane) loader.load();
            /* Creamos la segunda ventana como otro stage */
            Stage ventana3 = new Stage();
            ventana3.setTitle("Pantalla Donaciones");
            /* Le decimos a la ventana quién es la ventana original */
            ventana3.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaCuatro);
            ventana3.setScene(scene);

            PantallaDonacionesDos controller3 = loader.getController();
            controller3.setStagePrincipal(ventana3);
            controller3.setProgramaPrincipal(this);
            controller3.initialize(numero);

            ventana3.show();

        } catch (Exception e) {
            //tratar la excepción
        }
    }

}

