/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Persona.Medico;
import Persona.Paciente;
import Persona.Puesto;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Xavier
 */
public class atender {
    private Puesto p;
    public atender(){
        llenar();
    }
    public void llenar(){
        VBox root = new VBox();
        TextField enfermedad = new TextField("Ingrese la enfermedad presentada");
        Label in = new Label("Debido a los sintomas mencionados, usted padece de: ");
        TextField medicina = new TextField("Ingrese la medicina a recetar");
        Label mid = new Label("Por lo que se le recomienda tomar la siguiente medicina: ");
        Button ingresar = new Button("Enviar Receta");
        root.getChildren().addAll(in,enfermedad,mid,medicina,ingresar);
        Stage window = new Stage();
        window.setTitle("Recetas");
        window.setMinHeight(400);
        window.setMinWidth(400);
        Scene scene = new Scene((Parent)root,400,400);
        window.setScene(scene);
        window.show();
    }
    public Medico obtenerDoctor(Puesto p){
        Medico m = p.getMedicoTurnoo();
        return m;
    }
    public Paciente obtenerPaciente(Puesto p){
        Paciente pa = p.getPaciente();
        return pa;
        
    }
    public void generarReceta(Paciente p, Medico d, String resultado, String medi){
        String apellidoDoc = d.getApellido();
        String apellidoPaciente = p.getApellido();
        try {
        FileWriter writer = new FileWriter("src/Archivos/recetas.txt");
        String res = ("El doctor " + apellidoDoc + " le receta al Sr/Sra "+ apellidoPaciente +  medi + " debido a su " + resultado );
    }
    catch (IOException e){
    System.err.println("ERROR EN LECTURA");
    }
}
}
