/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import GUI.Formulario;

/**
 *
 * @author Xavier
 */
public class opciones {
    private VBox root = new VBox();
    private Label texto = new Label("Escoja la opcion que desee: ");
    private Button sturno = new Button("Sacar Turno");
    private Button cturno = new Button("Crear turno");
    private Button eturno = new Button("Eliminar turno");
    private Button atender = new Button("Atender paciente");
    private Button doctor = new Button("Ingresar a un doctor");
    public opciones(){
    llenar();
    }
    public VBox getRoot(){
        return root;
    }
    public void llenar(){
    root.getChildren().addAll(texto, sturno, cturno, eturno, atender, doctor);
    texto.setAlignment(Pos.CENTER);
    Stage window = new Stage();
    window.setTitle("OPCIONES");
    window.setMinHeight(400);
    window.setMinWidth(400);
    Scene scene = new Scene((Parent)root,200,200);
    window.setScene(scene);
    window.show();
    }
}
