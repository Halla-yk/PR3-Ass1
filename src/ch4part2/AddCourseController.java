/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4part2;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abu Yasser
 */
public class AddCourseController implements Initializable {

    @FXML
    private TextField txtStudentId;
    @FXML
    private TextField txtCourseId;
    @FXML
    private TextField txtLabel;
    @FXML
    private Button addButton;

    Statement statement;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/university?serverTimezone=UTC","root","");
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    

    @FXML
    private void addButtonHandle(ActionEvent event) throws Exception {
         Integer studentid = Integer.parseInt(txtStudentId.getText());
        Integer courseid = Integer.parseInt(txtCourseId.getText());
        
        String semester = txtLabel.getText();
       
        String sql = "Insert Into registration values(" + studentid+ "," +courseid + ",'" 
                + semester+ "')";
        this.statement.executeUpdate(sql);
        
    }
    
}
