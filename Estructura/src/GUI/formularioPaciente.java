
package GUI;


import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class formularioPaciente implements formulario{
    private GridPane root;
    private ArrayList<String> sintomas;

    public formularioPaciente(ArrayList<String> sintomas){
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
        ComboBox<String> symtomp = new ComboBox<String>();
        symtomp.getItems().setAll(sintomas);
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
        root.add(symtomp, 1, 4);       
    }

    public GridPane getRoot() {
        return root;
    }
    
    
    
}
