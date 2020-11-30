
package GUI;

import Persona.*;
import java.util.LinkedList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import estructura.EscrituraDeArchivos;

public class FormularioPuesto extends Formulario {
    private LinkedList<Puesto> PuestoDisponible;
    private  LinkedList<Medico> DoctoresDisponibles;
    public FormularioPuesto(LinkedList<Puesto> PuestoDisponible,LinkedList<Medico> DoctoresDisponibles){
        this.PuestoDisponible=PuestoDisponible;
        this.DoctoresDisponibles=DoctoresDisponibles;
        CrearFormulario();
    }
    public void CrearFormulario(){
        ComboBox<Puesto> combo = new ComboBox<Puesto>();
        root.setId("box");
        combo.getItems().addAll(PuestoDisponible);
        System.out.println(DoctoresDisponibles);
        ComboBox<Medico> medicos=new ComboBox<Medico>();
        medicos.getItems().addAll(DoctoresDisponibles);
        combo.getSelectionModel().selectFirst();
        medicos.getSelectionModel().selectFirst();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(5);
        root.setHgap(5);
        root.add(new Label("Puesto Disponibles "), 0, 0);
        root.add(combo, 1, 0);
        root.add(new Label("Medicos Disponibles "), 0, 1);
        root.add(medicos, 1, 1);
        Button ok = new Button("Confirmar");
        root.add(ok, 1, 2);
        CrearVentana();
        ok.setOnAction(e->{
           Puesto puesto=(Puesto)((ComboBox)root.getChildren().get(1)).getValue();
           Medico medico=(Medico)((ComboBox)root.getChildren().get(3)).getValue();
           EscrituraDeArchivos.escrituraPuestosMed(puesto, medico);
           medico.setEstado(true);
           puesto.setMedicoTurnoo(medico);
           Operatividad.getInstance().generarPuesto(puesto);
           mostrarAlerta("Se ha asignado exitosamente el puesto al medico");
           window.close();
        });
    }
    
}
