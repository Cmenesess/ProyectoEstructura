
package GUI;


import Persona.Paciente;
import Persona.Sintoma;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
        Button ok = new Button("Confirmar");
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
        root.add(ok,1,5);
        Stage window = new Stage();
        window.setTitle("Formulario Paciente");
        window.setMinHeight(100);
        window.setMinWidth(100);
        Scene scene = new Scene((Parent)root,300,250);
        scene.getStylesheets().add("css/estilos.css");
        window.setScene(scene);
        window.show();
        ok.setOnAction(e->{
            String nombre=((TextField)root.getChildren().get(1)).getText();
            String Apellido=((TextField)root.getChildren().get(3)).getText();
            String Genero=((TextField)root.getChildren().get(7)).getText();
            Sintoma sintoma=(Sintoma)((ComboBox)root.getChildren().get(9)).getValue();
            if(!nombre.isBlank()&&!Apellido.isBlank() &&!Genero.isBlank() ){
                try{
                    int edad=Integer.parseInt(((TextField)root.getChildren().get(5)).getText());
                    Paciente p=new Paciente(nombre,Apellido,Genero,edad,sintoma);
                    Operatividad.operatividad.agregarCola(p);
                    mostrarAlerta("Su turno es: "+p.getTurno());
                }catch(NumberFormatException ex){
                    mostrarAlerta("No ha ingresado una edad valida");
                }
            }else{
                mostrarAlerta("No se olvide de dejar ningun campo vacio");
            }
        }
        );
        
        
    }

    public GridPane getRoot() {
        return root;
    }
    private void mostrarAlerta(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(mensaje);
        alert.show();
    }
    
    
    
    
}
