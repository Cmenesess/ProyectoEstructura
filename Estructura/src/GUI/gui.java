
package GUI;

import java.time.LocalDateTime;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;

public class gui {

    private Label reloj = new Label();
    Thread cl = new Thread(new Time(reloj));
    private BorderPane root = new BorderPane();
    private Label horarios = new Label("                                     Horario de atención de Lunes a Viernes de 10 a 18 hs/ Sabados");
    private TableView turnos = new TableView();
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
}
