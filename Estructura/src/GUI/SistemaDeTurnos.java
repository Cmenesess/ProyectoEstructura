
package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Persona.Medico;
import java.util.ArrayList;
import Persona.Paciente;
import java.util.PriorityQueue;

public class SistemaDeTurnos extends Application {
    @Override
    public void start(Stage primaryStage) {
        Scene sc = new Scene(new gui().getRoot(), 900, 450);
        sc.getStylesheets().add("css/estilos.css");
        primaryStage.setTitle("Sistema de Turnos");
        primaryStage.setScene(sc);
        primaryStage.show();        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
