
package GUI;

import Persona.Puesto;
import java.util.LinkedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        createContent(Operatividad.getInstance().puestos);
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
            Operatividad.getInstance().eliminarPuesto(puesto);
            stage.close();
        });
        
        
               
    }
    
    
}
