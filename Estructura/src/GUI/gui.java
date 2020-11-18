/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.time.LocalDateTime;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/**
 *
 * @author Xavier
 */

public class gui{
    private VBox root = new VBox();
    private Label reloj = new Label();
    Thread cl = new Thread(new Time(reloj));
    private BorderPane p = new BorderPane();
    private Label horarios = new Label("Horario de atención de Lunes a Viernes de 10 a 18 hs/ Sabados");
    private TableView turnos = new TableView();
    private Button opciones = new Button("OPCIONES");
    Thread hilo = new Thread(new Time(reloj));
    
    
    public gui(){
        hilo.start();
        root.getChildren().addAll(reloj, p, horarios);
        VBox cont=new VBox();
        cont.setId("video");
        cont.setAlignment(Pos.CENTER);
        cont.getChildren().addAll((new video().getVideo()));
        p.setRight(turnos);
        p.setLeft(opciones);
        p.setCenter(cont);
        
        
    }
    public VBox getRoot(){
        return root;
        }
    private class Time implements Runnable {

        private Label lbl;
        LocalDateTime tp;

        public Time(Label lbl) {
            this.lbl = lbl;
            lbl.setId("hora");
        }

        @Override
        public void run() {
                while(0<1){
                try {
                    tp = LocalDateTime.now();
                    int hour = tp.getHour();
                    int minute = tp.getMinute();
                    int second = tp.getSecond();

                    Platform.runLater(() -> {
                        lbl.setText(hour+":"+minute+":"+second);
                        
                    });
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                }
        }
    
}
}
