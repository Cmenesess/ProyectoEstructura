
package GUI;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import GUI.formularioPaciente;
import Persona.*;
import estructura.LecturaDeArchivos;
import java.util.LinkedList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;

public class opciones {
    private VBox root = new VBox(20);
    private Label texto = new Label("Escoja la opcion que desee: ");
    private Button sturno = new Button("Sacar Turno");
    private Button cpuesto = new Button("Crear puesto");
    private Button eturno = new Button("Eliminar turno");
    private Button AsignarMedico = new Button("Asignacion de medico a Puesto");
    private Button atender = new Button("Atender paciente");
    private Button doctor = new Button("Ingresar a un doctor");
    public opciones(){
    llenar();
    }
    public VBox getRoot(){
        return root;
    }
    public void llenar(){
        root.setPadding(new Insets(20,20,20,20));
        root.setId("box");
        root.getChildren().addAll(texto, sturno, cpuesto, eturno, atender, doctor);
        sturno.setOnAction(e->{new formularioPaciente(LecturaDeArchivos.LecturaSintomas());});
        doctor.setOnAction(d-> new formularioDoctor());
        cpuesto.setOnAction(p-> {crearPuesto.crear(); new crearPuesto();});
        AsignarMedico.setOnAction(d->{ 
            LinkedList<Puesto> puestos= Operatividad.getInstance().puestosSinAsignar();
            LinkedList<Medico> medicos=Operatividad.getInstance().MedicosSinAsignar();
            if(!puestos.isEmpty() && !medicos.isEmpty()){
                new FormularioPuesto(puestos,medicos);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Actualmente no hay medicos suficientes o puestos suficientes para poder asignar");
                alert.show();
            }
        });
        atender.setOnAction(a->new atender());
        Stage window = new Stage();
        window.setTitle("OPCIONES");
        window.setMinHeight(100);
        window.setMinWidth(100);
        Scene scene = new Scene((Parent)root,250,300);
        scene.getStylesheets().add("css/estilos.css");
        window.setScene(scene);
        window.show();
    }
}
