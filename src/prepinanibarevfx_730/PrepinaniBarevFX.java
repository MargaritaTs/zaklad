/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepinanibarevfx_730;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.IObserver;
import utils.ISubject;

/**
 *
 * @author NOBODY
 */
public class PrepinaniBarevFX extends Application implements ISubject{
    private ListBarev listBarev;
    private PanelBarev panelBarev;
    
    private List <IObserver> seznamObserveru = new ArrayList<IObserver>();
    
    private String barva = "červená";
    private String styl = "-fx-background-color: red;";
    
    @Override
    public void start(Stage primaryStage) {
        listBarev = new ListBarev(this);
        panelBarev = new PanelBarev(this);
        
        BorderPane border = new BorderPane();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        ToggleGroup group = new ToggleGroup();
        RadioButton cervenaRadioB = new RadioButton("červená");
        cervenaRadioB.setSelected(true);
        cervenaRadioB.setToggleGroup(group);
        RadioButton modraRadioB = new RadioButton("modrá");
        modraRadioB.setToggleGroup(group);
        
        //RadioButton cernaRadioB = new RadioButton("černá");
        //cernaRadioB.setToggleGroup(group);
        
        vbox.getChildren().add(cervenaRadioB);
        vbox.getChildren().add(modraRadioB);
       //vbox.getChildren().add(cernaRadioB);
        border.setCenter(vbox);
        
        //cernaRadioB.setOnAction(new EventHandler<ActionEvent>() {
            
          //  @Override
            //public void handle(ActionEvent event) {
              //  setStyl("-fx-background-color: black;");
                //setBarva("černá");
                //notifyAllObservers();
            //}
        //});
        
        cervenaRadioB.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                setStyl("-fx-background-color: red;");
                setBarva("červená");
                notifyAllObservers();
            }
        });
        
        modraRadioB.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                setStyl("-fx-background-color: blue;");
                setBarva("modrá");
                notifyAllObservers();
            }
        });
        
        
        border.setBottom(panelBarev);
        border.setLeft(listBarev);

        Scene scene = new Scene(border, 400, 350);

        primaryStage.setTitle("Prepinani barev");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void registerObserver(IObserver iObserver) {
        seznamObserveru.add(iObserver);
    }

    @Override
    public void removeObserver(IObserver iObserver) {
        seznamObserveru.remove(iObserver);
    }

    @Override
    public void notifyAllObservers() {
        for (IObserver seznamObserveruItem : seznamObserveru) {
            seznamObserveruItem.update();
        }
    }

    /**
     * @return the barva
     */
    public String getBarva() {
        return barva;
    }

    /**
     * @param barva the barva to set
     */
    public void setBarva(String barva) {
        this.barva = barva;
    }

    /**
     * @return the styl
     */
    public String getStyl() {
        return styl;
    }

    /**
     * @param styl the styl to set
     */
    public void setStyl(String styl) {
        this.styl = styl;
    }
}
