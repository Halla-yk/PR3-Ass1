/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondAss.Converter;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Abu Yasser
 */
public class Converter extends Application {

    private Label l1;
    private TextField t;
    private RadioButton fahrenheit;
    private RadioButton kelvin;
    private Label l2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        l1 = new Label("Enter Celsius temperature");
        l1.setAlignment(Pos.CENTER);
        t = new TextField();
        t.setAlignment(Pos.CENTER);
        fahrenheit = new RadioButton("Fahrenheit");
        kelvin = new RadioButton("kevin");
        ToggleGroup tg = new ToggleGroup();
        fahrenheit.setToggleGroup(tg);
        kelvin.setToggleGroup(tg);
        HBox h = new HBox(10,fahrenheit, kelvin);
        h.setAlignment(Pos.CENTER);
        l2 = new Label("");
        fahrenheit.setOnAction(event -> {
            try {
                String text = t.getText();
                double convert = Double.parseDouble(text);
                double result = convert * 9 / 5 + 32;
                l2.setText("New Tempreture in is: " + result);
            } catch (NumberFormatException e) {
                l2.setText("please Enter number :( ");
                System.out.println(e.getMessage());
            }

        });
        kelvin.setOnAction(event -> {
            try {
                String text = t.getText();
                double convert = Double.parseDouble(text);
                double result = convert + 273.15;
                l2.setText("New Tempreture in is: " + result);
            } catch (NumberFormatException e) {
                l2.setText("please Enter number");
                System.out.println(e.getMessage());
                
            }
        });

        VBox v = new VBox(10,l1, t, h, l2);
        v.setAlignment(Pos.CENTER);
        Scene s = new Scene(v, 450, 150);
        primaryStage.setScene(s);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Converter");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
