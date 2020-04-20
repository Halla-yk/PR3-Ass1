/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  SecondAss.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Abu Yasser
 */
public class Login extends Application{

   private TextField t;
   private PasswordField p;
   private Button signin;
   private Button exit;
   private Scene s1;
   private Scene s2;
   private Button add;
   private Button  view;
   private Label alert;
   private Label welcome;
    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    public String hash(String pass) throws NoSuchAlgorithmException{
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest);
        return myHash;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        welcome = new Label("WELCOME");
        welcome.setStyle("-fx-font-size:23px ;");
        t = new TextField();
        p = new PasswordField();
        signin = new Button("add");
        signin.setStyle("-fx-background-color: #00ff00");
        exit = new Button("Exit");
        exit.setStyle("-fx-background-color: #00ff00");
        alert = new Label("");
        Text name = new Text("Name:     ");
        Text password = new Text("Password:");
        HBox h1 = new HBox(10,name,t);
        HBox h2 = new HBox(10,password,p);
        HBox h3 = new HBox(10,signin,exit);
        h1.setAlignment(Pos.CENTER);
        h2.setAlignment(Pos.CENTER);
        h3.setAlignment(Pos.CENTER);
        signin.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(10,welcome,h1,h2,alert,h3);
        vbox.setStyle("-fx-background-color: #99ff00");
        vbox.setAlignment(Pos.CENTER);
        signin.setOnAction(event ->{
            String hashpass ="";
            String username ="";
            String userpass ="";
            try {
                hashpass = hash(p.getText());
                 Employee e = new Employee(t.getText(),hashpass);
            PrintWriter output;
            try{
                Scanner s = new Scanner(new File("src/Login/emp.data"));
                
                while(s.hasNextLine()){
                    String line = s.nextLine();
                    String[] data = line.split(" ");
                     username = data[0];
                     userpass = data[1];
                    System.out.println(username);
                    System.out.println(t.getText());
                    System.out.println(userpass);
                    System.out.println(hashpass);
                    
                    
                }
                s.close();
                   if(username.equals(t.getText()) && userpass.equals(hashpass)){
                       primaryStage.setScene(s2); 
                       primaryStage.setTitle("option page");
                    }
                   else
                       alert.setText("sorry username or password is invalid");
            }catch(FileNotFoundException ex){
                System.out.println(ex.getMessage());
            }
            //////this commented code  for register user in the file//////
//        try {
//                output = new PrintWriter(new File("src/Login/emp.data"));
//                  output.println(e);
//                  output.close();
//            } catch (FileNotFoundException ex) {
//               
//            }
            } catch (NoSuchAlgorithmException ex) {
               
            }
          
        });
        /////////////////scene 2///////////////////
        add = new Button("add");
        add.setStyle("-fx-background-color: #00ff00");
        view = new Button("view");
        view.setStyle("-fx-background-color: #00ff00");
        VBox vbox2= new VBox(10,add,view);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setStyle("-fx-background-color: #99ff00");
        ////////////////scene 3///////////////////
        
        
        s1 = new Scene(vbox,300,250 );
        s2 = new Scene(vbox2,300,250);
       // s1.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        //s2.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(s1);
        primaryStage.setTitle("login page");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
}
