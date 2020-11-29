package GUI;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;


public class SistemaDeTurnos extends Application {
    @Override
    public void start(Stage primaryStage) {
        Scene sc = new Scene(new gui().getRoot(), 900, 450);
        sc.getStylesheets().add("css/estilos.css");
        primaryStage.setTitle("Sistema de Turnos");
        primaryStage.setScene(sc);
        primaryStage.show();        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
