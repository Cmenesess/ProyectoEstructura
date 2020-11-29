
package GUI;

import Persona.Medico;
import Persona.Puesto;
import java.util.LinkedList;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EliminarPuesto {
    VBox root;
    ComboBox puestos;
    Label label1;
    Button eliminar;
    
    public EliminarPuesto(){
        createContent(Operatividad.getInstance().getPuestos());
    }
    
    public void createContent(LinkedList<Puesto> slot){
        root = new VBox(10);
        root.setPadding(new Insets(20));
        puestos = new ComboBox();
        puestos.getItems().addAll(slot);
        label1 = new Label("¿Que puesto quieres eliminar?");
        eliminar = new Button("Eliminar");
        label1.setAlignment(Pos.CENTER);
        eliminar.setAlignment(Pos.CENTER);
        root.getChildren().addAll(label1, puestos, eliminar);
        Stage stage = new Stage();
        stage.setTitle("Eliminar Puesto");
        stage.setMinHeight(100);
        stage.setMinWidth(100);
        Scene scene = new Scene(root,250,150);
        scene.getStylesheets().add("css/estilos.css");
        stage.setScene(scene);
        stage.show();
        eliminar.setOnAction(e ->{
            Puesto puesto = (Puesto) puestos.getValue();
            Medico medico= puesto.getMedicoTurnoo();
            if(medico!=null){
                crearAlerta(puesto);
            }
            Operatividad.getInstance().eliminarPuesto(puesto);
            stage.close();
        });
    }
    public void crearAlerta(Puesto p){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("En ese puesto esta el doctor asignado "+p.getMedicoTurnoo());
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            Operatividad.getInstance().eliminarPuesto(p);
            p.getMedicoTurnoo().setEstado(false);
            if(p.getPaciente()!=null){
                Operatividad.getInstance().agregarCola(p.getPaciente());
            }
        }
    }
}
