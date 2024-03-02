/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lensappli;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Wadha
 */
public class LensAppli extends Application {
    
    @Override
    public void start(Stage stage) {
       try {
            // Load the FXML file.
            Parent parent = FXMLLoader.load(getClass().getResource("LensAppli.fxml"));

            // Build the scene graph.
            Scene scene = new Scene(parent);

            // Display our window, using the scene graph.
            stage.setTitle("Lens Application");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("FXML Loading Error");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException {
        launch(args);
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
    }
    
}
