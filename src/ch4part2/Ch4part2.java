/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4part2;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Abu Yasser
 */
public class Ch4part2 extends Application{
    static Map<String, Pane> mapPanes ;
    static Scene scene;
    public static void setPane(String pane){
        scene =  new Scene(mapPanes.get(pane));
    }
    public static void main(String[] args) {
       launch(args);
               
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root =  FXMLLoader.load(getClass().getResource("TableViewPane.fxml"));
        scene =  new Scene(root);
//        Pane studentScreen = FXMLLoader.load(getClass().getResource("TableViewPane.fxml"));
//        Pane addCourse = FXMLLoader.load(getClass().getResource("AddCourse.fxml"));
//         mapPanes = new TreeMap<>();
//        mapPanes.put("addCorseScreen", addCourse);
//        mapPanes.put("studentScreen", studentScreen);
//        scene = new Scene(mapPanes.get("studentScreen"));
//        primaryStage.setTitle("Streams App");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
}
