/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Xavier
 */
public class formularioDoctor{
    private GridPane root = new GridPane();
    public formularioDoctor(){
        llenar();
    }
    public void llenar(){
        root = new GridPane();
        root.setId("box");
        TextField nombre = new TextField("Ingrese su nombre:");
        TextField especialidad = new TextField("Ingrese su especialidad:");
        TextField id = new TextField("Ingrese su identificacion");
        Button ingresar = new Button("Ingresar");
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(5);
        root.setHgap(5);
        root.add(new Label("Nombre: "), 0, 0);
        root.add(nombre, 1, 0);
        root.add(new Label("Especialidad: "), 0, 1);
        root.add(especialidad, 1, 1);
        root.add(new Label("Identificación: "), 0, 2);
        root.add(id, 1, 2);
        root.add(ingresar, 1,3);
        Stage window = new Stage();
        window.setTitle("Ingresar doctor");
        window.setMinHeight(400);
        window.setMinWidth(400);
        Scene scene = new Scene((Parent)root,200,200);
        window.setScene(scene);
        window.show();
    }
    public void crearDoctor(){
        
    }
    public GridPane getRoot(){
        return root;
    }
}
