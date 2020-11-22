/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Persona.Medico;
import java.util.ArrayList;
import Persona.Paciente;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author carloshumbertomenesesmurillo
 */
public class SistemaDeTurnos extends Application {
    public ArrayList<Medico> doctores;
    public PriorityQueue<Paciente> Pacientes;
    @Override
    public void start(Stage primaryStage) {
        Scene sc = new Scene(new gui().getRoot(), 830, 450);
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
