/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Persona.Medico;
import Persona.Paciente;
import Persona.Puesto;
import java.io.FileWriter;
import java.io.IOException;
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
    TextField enfermedad = new TextField("Ingrese la enfermedad presentada");
    Label in = new Label("Debido a los sintomas mencionados, usted padece de: ");
    TextField medicina = new TextField("Ingrese la medicina a recetar");
    Label mid = new Label("Por lo que se le recomienda tomar la siguiente medicina: ");
    Button ingresar = new Button("Enviar Receta");
    public atender(Puesto p){
        llenar();
    }
    public void llenar(){
        VBox root = new VBox();
        Label sin = new Label(textoCaso(p));
        root.getChildren().addAll(sin,in,enfermedad,mid,medicina,ingresar);
        Stage window = new Stage();
        window.setTitle("Recetas");
        window.setMinHeight(400);
        window.setMinWidth(400);
        Scene scene = new Scene((Parent)root,400,400);
		scene.getStylesheets().add("css/estilos.css");
        window.setScene(scene);
        window.show();
    }

    public void generarReceta(Puesto pu){
        Medico d = pu.getMedicoTurnoo();
        Paciente p = pu.getPaciente();
        
        String apellidoDoc = d.getApellido();
        String apellidoPaciente = p.getApellido();
        try {
        FileWriter writer = new FileWriter("src/Archivos/recetas.txt");
        String res = ("El doctor " + apellidoDoc + " le receta al Sr/Sra "+ apellidoPaciente +  medicina.getText()  + " debido a su " + enfermedad.getText() );
    }
    catch (IOException e){
    System.err.println("ERROR EN LECTURA");
    }
}
	 public String textoCaso(Puesto p){
        Paciente pac = p.getPaciente();
        int Edad = pac.getEdad();
        String enf = pac.getSintoma().toString();
        String t = ("El paciente " + pac.getNombre() + " " + pac.getApellido()+ " de "+ Integer.toString(Edad)+(" años de edad presenta")+enf);
        return t;
    }
}
