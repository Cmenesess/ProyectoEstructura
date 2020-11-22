/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Persona.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author carloshumbertomenesesmurillo
 */
public class FormularioPuesto extends Formulario {
    public LinkedList<Puesto> PuestoDisponible;
    public LinkedList<Medico> DoctoresDisponibles;
    public FormularioPuesto(LinkedList<Puesto> PuestoDisponible,LinkedList<Medico> DoctoresDisponibles){
        this.PuestoDisponible=PuestoDisponible;
        this.DoctoresDisponibles=DoctoresDisponibles;
        CrearFormulario();
    }
    public void CrearFormulario(){
        ComboBox<Puesto> combo = new ComboBox<Puesto>();
        combo.getItems().addAll(PuestoDisponible);
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
           Medico medico=(Medico)((ComboBox)root.getChildren().get(1)).getValue();
           medico.EstadoAsignado();
           puesto.setMedicoTurnoo(medico);
           mostrarAlerta("Se ha asignado exitosamente el puesto al medico");
           window.close();
        });
    }
    
}
