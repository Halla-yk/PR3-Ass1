/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4part2;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Abu Yasser
 */
public class SqlQueryController implements Initializable {

    @FXML
    private TableColumn<Student, Integer> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student,String> majorColumn;
    @FXML
    private TableColumn<Student,Double> gradeColumn;

    Statement statement;
    @FXML
    private TextArea textArea;
    @FXML
    private Button selectButton;
    @FXML
    private Button updateButton;
    @FXML
    private TableView<Student> tableView;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/university?serverTimezone=UTC","root","");
            this.statement = connection.createStatement();
             idColumn.setCellValueFactory(new PropertyValueFactory("id"));
         nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
         majorColumn.setCellValueFactory(new PropertyValueFactory("major"));
         gradeColumn.setCellValueFactory(new PropertyValueFactory("grade"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // TODO
    }    


    @FXML
    private void selectButtonHandle(ActionEvent event) throws Exception {
       String sql =  textArea.getText();
        ResultSet rs = this.statement.executeQuery(sql);
        tableView.getItems().clear();
        while(rs.next()){
            Student std = new Student();
            std.setId(rs.getInt("id"));
            std.setName(rs.getString("name"));
            std.setMajor(rs.getString("major"));
            std.setGrade(rs.getDouble("grade"));
            tableView.getItems().add(std);
        }
    }

    @FXML
    private void updateButtonHandle(ActionEvent event) throws Exception{
       String sql =  textArea.getText();
       this.statement.executeUpdate(sql);
    }
    
}
