
package GUI;


import Persona.Sintoma;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class formularioPaciente implements Formulario{
    private GridPane root;
    private ArrayList<Sintoma> sintomas;

    public formularioPaciente(ArrayList<Sintoma> sintomas){
        this.sintomas = sintomas;
        crearFormulario();
        
    }
    
    public void crearFormulario(){
        root = new GridPane();
        root.setId("box");
        TextField nametxt = new TextField();
        TextField lastnametxt = new TextField();
        TextField agetxt = new TextField();
        TextField genretxt = new TextField();
        ObservableList<Sintoma> Sintomas = FXCollections.observableList(sintomas);
        ComboBox combo = new ComboBox(Sintomas);
        combo.getSelectionModel().selectFirst();
        root.setPadding(new Insets(10, 10, 10, 10)); 
        root.setVgap(5);
        root.setHgap(5);
        root.add(new Label("Nombre: "), 0, 0);
        root.add(nametxt, 1, 0);
        root.add(new Label("Apellido: "), 0, 1);
        root.add(lastnametxt, 1, 1);
        root.add(new Label("Edad: "), 0, 2);
        root.add(agetxt, 1, 2);
        root.add(new Label("Genero: "), 0, 3);
        root.add(genretxt, 1, 3);
        root.add(new Label("Sintoma: "), 0, 4);
        root.add(combo, 1, 4); 
        Stage window = new Stage();
        window.setTitle("Formulario Paciente");
        window.setMinHeight(100);
        window.setMinWidth(100);
        Scene scene = new Scene((Parent)root,300,250);
        scene.getStylesheets().add("css/estilos.css");
        window.setScene(scene);
        window.show();
    }

    public GridPane getRoot() {
        return root;
    }
    
    
    
    
}
