
package GUI;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Xavier
 */
public class formularioDoctor extends Formulario{
    private GridPane root = new GridPane();
    private TextField nombre = new TextField("Ingrese su nombre");
    private TextField especialidad = new TextField("Ingrese su especialidad");
    private TextField id = new TextField("Ingrese su identificacion");
    private Button ingresar = new Button("Ingresar");
    public formularioDoctor(){
        llenar();
    }
    public void llenar(){
        root = new GridPane();
        root.setId("box");
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(5);
        root.setHgap(5);
        root.add(new Label("Nombre: "), 0, 0);
        root.add(nombre, 1, 0);
        root.add(new Label("Especialidad: "), 0, 1);
        root.add(especialidad, 1, 1);
        root.add(new Label("Identificación: "), 0, 2);
        root.add(id, 1, 2);
        root.add(ingresar, 1,3);
        CrearVentana();
    }
    public void crearDoctor(){
        String nom = nombre.getText();
        String esp = especialidad.getText();
    }
    public GridPane getRoot(){
        return root;
    }
}
