package net.imparndo.supermercato;

import java.awt.event.ActionEvent;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.imparndo.Model.Supermercato;

import java.util.ArrayList;

public class SupermercatoController {
    @FXML
    private ArrayList<Button> btnsCasse;
    @FXML
    private HBox h;
    @FXML
    public void togliProdotti(){
        for (int i = 0; i < 10; i++) {
            if(mercato.getCassa(i).quantiCarrelli() > 0)
            mercato.getCassa(i).liberaCarrello();
            btnsCasse.get(i).setText(mercato.getCassa(i).quantiCarrelli()+"");
        }


    }
    @FXML
    public void generaCarrelli(){
       int index = mercato.indexOf(mercato.getCassaVuota());
        mercato.getCassaVuota().aggiungiCarrello();
        btnsCasse.get(index).setText(mercato.getCassa(index).quantiCarrelli()+"");


    }
    public Supermercato mercato ;
    private Timeline timeLine1, timeLine2;


    @FXML
    void initialize() {

        timeLine1 = new Timeline(new KeyFrame(Duration.seconds(2), e -> togliProdotti() ));
        timeLine1.setCycleCount(Animation.INDEFINITE);
        timeLine2 = new Timeline(new KeyFrame(Duration.seconds(2), e -> generaCarrelli()));
        timeLine2.setCycleCount(Animation.INDEFINITE);
        mercato= new Supermercato();

        btnsCasse = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            btnsCasse.add(new Button("0"));
            btnsCasse.get(i).setId(""+ i);
            btnsCasse.get(i).setStyle("-fx-background-color:  #0FFE4F; ");
            btnsCasse.get(i).setPrefSize(50, 50);
            h.setSpacing(20);
}
        h.getChildren().addAll(btnsCasse);
        for (int i = 0; i < 10; i++) {
            btnsCasse.get(i).setOnAction(event-> {
                Button a = (Button)event.getSource();
                int indice = Integer.parseInt(a.getId());
                if(mercato.getCassa(indice).isAperta()) {
                    mercato.getCassa(indice).chiudi();
                    a.setStyle("-fx-background-color:  #FF0000; ");
                }
                else{
                    mercato.getCassa(indice).apri();
                    a.setStyle("-fx-background-color:  #0FFE4F; ");
                }


            });
        }



    }
    public void onStartMenuClick(javafx.event.ActionEvent actionEvent) {
        timeLine1.play();
        timeLine2.play();

    }
    public void onStopMenuClick(javafx.event.ActionEvent actionEvent) {
        timeLine1.stop();
        timeLine2.stop();
    }
}