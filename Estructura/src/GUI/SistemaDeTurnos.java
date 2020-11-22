/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Persona.Medico;
import java.util.ArrayList;

/**
 *
 * @author carloshumbertomenesesmurillo
 */
public class SistemaDeTurnos extends Application {
    private ArrayList<Medico> doctores;
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
