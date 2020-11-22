/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.io.FileWriter;
import java.io.IOException;
import Persona.Puesto;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Xavier
 */
public class crearPuesto {
    
    public crearPuesto(){
        llenar();
    }
    public void llenar(){
        VBox root = new VBox();
        Label text = new Label("SE CREO EXITOSAMENTE EL TURNO");
        root.getChildren().add(text);
        Stage window = new Stage();
        window.setTitle("Creacion de puesto");
        window.setMinHeight(400);
        window.setMinWidth(400);
        Scene scene = new Scene((Parent)root,400,400);
        window.setScene(scene);
        window.show();
    }
    
    public static void crear(){
        try {
        FileWriter writer = new FileWriter("src/Archivos/puestos.txt");
        if(Operatividad.getInstance().puestos.isEmpty()){
            Puesto pu = new Puesto(0);
            Operatividad.getInstance().puestos.add(pu);
            writer.write(pu.toString());
        }else{ 
            Puesto p = Operatividad.getInstance().puestos.getLast();
            int pos = Operatividad.getInstance().puestos.indexOf(p);
            Puesto pu = new Puesto(pos+1);
            Operatividad.getInstance().puestos.addLast(pu);
            writer.write(pu.toString());
        }
    }
    catch (IOException e){
    System.err.println("ERROR EN LECTURA");
}
}
}
