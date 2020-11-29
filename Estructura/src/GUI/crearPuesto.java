
package GUI;

import Persona.Puesto;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import estructura.EscrituraDeArchivos;

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
        if(Operatividad.getInstance().getPuestos().isEmpty()){
            Puesto pu = new Puesto(0);
            Operatividad.getInstance().getPuestos().add(pu);
            EscrituraDeArchivos.escrituraPuesto(Operatividad.getInstance().getPuestos());
        }else{ 
            Puesto p = Operatividad.getInstance().getPuestos().getLast();
            int pos = p.getNumero();
            Puesto pu = new Puesto(pos+1);
            Operatividad.getInstance().getPuestos().addLast(pu);
            EscrituraDeArchivos.escrituraPuesto(Operatividad.getInstance().getPuestos());
        }
    }
}
