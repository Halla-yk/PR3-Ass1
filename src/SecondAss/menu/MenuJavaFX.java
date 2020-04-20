/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondAss.menu;

/*import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 *
 * @author Abu Yasser
 */
public class MenuJavaFX extends Application{
      TextArea textAreaFileContent;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File view");
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("_File");
        MenuItem menuItemOpen = new MenuItem("_Open");
        MenuItem menuItemClose = new MenuItem("_Close");
        MenuItem menuItemExit = new MenuItem("_Exit");
        menuFile.getItems().addAll(menuItemOpen, menuItemClose, menuItemExit);
        Menu menuEdit = new Menu("_Edit");
        MenuItem menuItemFont = new MenuItem("_Font");
        MenuItem menuItemColor = new MenuItem("_Color");
        menuEdit.getItems().addAll(menuItemFont, menuItemColor);
        menuBar.getMenus().addAll(menuFile, menuEdit);
        textAreaFileContent = new TextArea("Intial Text");
        VBox vbox = new VBox(menuBar, textAreaFileContent);
        Scene scene = new Scene(vbox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
         EventHandler1 e = new EventHandler1();
        menuItemOpen.setOnAction(e);
        menuItemClose.setOnAction(e);
        menuItemExit.setOnAction(e);
        menuItemFont.setOnAction(e);
        menuItemColor.setOnAction(e);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private class EventHandler1 implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String menuItem = ((MenuItem) event.getSource()).getText();
            switch (menuItem) {
                case "_Open":
                    FileChooser fc = new FileChooser();
                    fc.setTitle("File Selection");
                    
                    fc.setInitialDirectory(new File("."));
                    File file = fc.showOpenDialog(null);
                    textAreaFileContent.setText("");
                    textAreaFileContent.setWrapText(true);
                    Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                } catch (FileNotFoundException ex) {
                   
                }
                    while (scanner.hasNext()) {
                        textAreaFileContent.appendText(scanner.nextLine());
                    }
                    scanner.close();

                    break;


                case "_Close":
                    textAreaFileContent.clear();
                    break;

                case "_Exit":
                    System.exit(0);
                    break;

                case "_Font":
                   Dialog<String> font = new 
                   ChoiceDialog<>("20", FXCollections.observableArrayList("24","36","42"));
                    font.setTitle("font selection");
                    font.setHeaderText("Select font from list");
                    String f = font.showAndWait().get();
                    textAreaFileContent.setStyle("-fx-font-size:" + f + "px ;");

                    break;

                case "_Color":
                    Dialog<String> dialogColor = new 
                    ChoiceDialog<>("yellow", FXCollections.observableArrayList("Red", "pink", "Green"));
                    dialogColor.setTitle("Color selection");
                    dialogColor.setHeaderText("Select Color from list");
                    String color = dialogColor.showAndWait().get();
                    textAreaFileContent.setStyle("-fx-text-fill:" + color + ";");
                    break;
            }
        }
    }
}
