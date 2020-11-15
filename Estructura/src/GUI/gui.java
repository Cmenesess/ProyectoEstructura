/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 *
 * @author Xavier
 */

public class gui{
    private VBox root = new VBox();
    private Label reloj = new Label();
    private HBox principal = new HBox();
    private Media video = new Media("direccion del video");
    private MediaPlayer reproductor = new MediaPlayer(video);
    private Label horarios = new Label("Horario de atención de Lunes a Viernes de 10 a 1 hs/ Sabados");
    private TableView turnos = new TableView();
    private MediaView mv = new MediaView();
    public void organizarinterfaz(){
        principal.getChildren().addAll(mv, turnos);
        root.getChildren().addAll(reloj, principal, horarios);
    }
    public VBox getRoot(){
        return root;
        }
}
