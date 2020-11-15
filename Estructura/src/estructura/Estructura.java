/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import javafx.application.Application;
import javafx.stage.Stage;
import GUI.gui;
import javafx.scene.Scene;
/**
 *
 * @author carloshumbertomenesesmurillo
 */

public class Estructura extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Scene s = new Scene(new gui().getRoot(),500,500);
        primaryStage.setTitle("TURNOS");
        primaryStage.setScene(s);
        primaryStage.show();
        
    }
    
}
