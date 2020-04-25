/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4part2;

import static ch4part2.Ch4part2.scene;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abu Yasser
 */
public class TableViewPaneController implements Initializable {

    @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldName;
    @FXML
    private TextField txtFieldMajor;
    @FXML
    private TextField txtFieldGrade;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    @FXML
    private TableColumn<Student,String> tcMajor;
    @FXML
    private TableColumn<Student,Double> tcGrade;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteAdd;
    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonAddCourse;

     Statement statement;
    @FXML
    private Button sqlStatement;
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
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
         tcID.setCellValueFactory(new PropertyValueFactory("id"));
         tcName.setCellValueFactory(new PropertyValueFactory("name"));
         tcMajor.setCellValueFactory(new PropertyValueFactory("major"));
         tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
         tableView.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudent() );
         try{
             showStudents();
          
         }catch(Exception ex){}
         
          
    }    

    private void showStudents()throws Exception{
        ResultSet rs = this.statement.executeQuery("Select * From students");
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
    private void addButtonHandle(ActionEvent event)throws Exception {
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "Insert Into students values(" + id + ",'" +name + "','" 
                + major + "'," + grade+ ")";
        this.statement.executeUpdate(sql);
         txtFieldID.setText("");
        txtFieldName.setText("");
        txtFieldMajor.setText("");
        txtFieldGrade.setText("");
        showStudents();
        
    }

    @FXML
    private void deleteAddHandle(ActionEvent event)throws Exception{
        
        Integer id = Integer.parseInt(txtFieldID.getText());
        String sql = "Delete From students Where id = "+id;
        this.statement.executeUpdate(sql);
       txtFieldID.setText("");
        txtFieldName.setText("");
        txtFieldMajor.setText("");
        txtFieldGrade.setText("");
        showStudents();
    }

    @FXML
    private void buttonUpdateHandle(ActionEvent event) throws Exception{
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "Update students Set name='" + name + "', major='" + 
                major + "', grade=" + grade + " Where id=" +id;
        this.statement.executeUpdate(sql);
        showStudents();
    }

    @FXML
    private void addCourseHandle(ActionEvent event) throws Exception{
          Pane addCourse = FXMLLoader.load(getClass().getResource("AddCourse.fxml"));
          scene =  new Scene(addCourse);
          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(scene);
          window.show();
    }
    private void showSelectedStudent(){
        Student employee = tableView.getSelectionModel().getSelectedItem();
        if(employee != null){
        txtFieldID.setText(String.valueOf(employee.getId()));
        txtFieldName.setText(employee.getName());
        txtFieldGrade.setText(String.valueOf(employee.getGrade()));
        txtFieldMajor.setText(String.valueOf(employee.getMajor()));
        }

    }

    @FXML
    private void sqlHandle(ActionEvent event) throws Exception{
        Pane addCourse = FXMLLoader.load(getClass().getResource("SqlQuery.fxml"));
          scene =  new Scene(addCourse);
          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(scene);
          window.show();
    }
}
