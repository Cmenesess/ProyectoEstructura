
package GUI;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public abstract class Formulario {
    protected GridPane root = new GridPane();
    protected Stage window;
    protected void mostrarAlerta(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(mensaje);
        alert.show();
    }
    protected void CrearVentana(){
        window = new Stage();
        window.setTitle("Formulario Puesto y Doctor");
        window.setMinHeight(400);
        window.setMinWidth(400);
        Scene scene = new Scene((Parent)root,200,200);
		scene.getStylesheets().add("css/estilos.css");
        window.setScene(scene);
        window.show();
    }

}
