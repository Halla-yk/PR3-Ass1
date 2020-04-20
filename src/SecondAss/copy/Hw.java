/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondAss.copy;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Abu Yasser
 */
public class Hw extends Application{

    private ListView<String> listViewNames;
    private Button b1;
    private ListView<String> copyListView;
    public static void main(String[] args) {
         launch(args);    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       
        listViewNames = new ListView<>();
        listViewNames.getItems().addAll("Black","Green","Yellow","Blue","Pink","white","Orange","Red");
        listViewNames.setPrefSize(120,100);
        b1 = new Button("Copy");
        b1.setAlignment(Pos.CENTER);
        copyListView = new ListView<>();
        HBox h = new HBox(10,listViewNames,b1,copyListView);
        h.setPadding(new Insets(10));
        listViewNames.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
         Alert a = new Alert(AlertType.NONE);
        b1.setOnAction(event -> {
            if(listViewNames.getSelectionModel().getSelectedIndex() !=-1){
                 copyListView.getItems().setAll(listViewNames.getSelectionModel().getSelectedItems());
                
             
        }
            else{
           a.setAlertType(AlertType.ERROR); 
                a.show(); 
           
            }});
        Scene s = new Scene(h,450,150 );
        primaryStage.setScene(s);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Multiple selection lists");
        primaryStage.show();
    }
    
}
