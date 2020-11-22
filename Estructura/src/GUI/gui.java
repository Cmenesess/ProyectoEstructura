
package GUI;

import Persona.Paciente;
import Persona.Puesto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class gui {
    private ArrayList<Puesto> puestos = new ArrayList<>();
    private Label reloj = new Label();
    Thread cl = new Thread(new Time(reloj));
    private BorderPane root = new BorderPane();
    private Label horarios = new Label("                                     Horario de atención de Lunes a Viernes de 10 a 18 hs/ Sabados");
    private TableView turnos = createTable();
    private Button opt = new Button("OPCIONES");
    Thread hilo = new Thread(new Time(reloj));
    public gui() {
        hilo.start();
        BorderPane l = new BorderPane();
        l.setRight(reloj);
        l.setLeft(opt);
        root.setId("main");
        root.setCenter(new video().getVideo());
        root.setRight(turnos);
        opt.setOnAction(o -> new opciones());
        root.setBottom(horarios);
        root.setTop(l);
        root.setPadding(new Insets(20, 20, 20, 20));
        actualizarTableView();
    }

    public BorderPane getRoot() {
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
            while (0 < 1) {
                try {
                    tp = LocalDateTime.now();
                    int hour = tp.getHour();
                    int minute = tp.getMinute();
                    int second = tp.getSecond();

                    Platform.runLater(() -> {
                        lbl.setText(hour + ":" + minute + ":" + second);

                    });
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }
    
    private TableView createTable(){
        TableView table = new TableView();
        TableColumn<Paciente, Puesto> turn = new TableColumn<>("Turno");
        turn.setCellValueFactory(new PropertyValueFactory<>("paciente"));
        TableColumn<Integer, Puesto> slot = new TableColumn<>("Puesto");
        slot.setCellValueFactory(new PropertyValueFactory<>("numero"));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(turn, slot);

        return table;
    }
    
    private void actualizarTableView(){
        turnos.getItems().clear();        
        for (Puesto p: puestos){
            turnos.getItems().add(p);
        }
    }
    
}
