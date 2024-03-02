/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lensappli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;


/**
 * FXML Controller class
 *
 * @author Wadha
 */
public class W10Controller implements Initializable {

    @FXML
    private Button btn_w10_back;
    @FXML
    private Button btn_w10_conf1;
    @FXML
    private TextArea text_Area;

    static  String name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        try {
            File file = new File("wBooking.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();

                String arr[] = line.split(",");

                if (name.equals(arr[0])){

                    String nameBooking =  arr[0];
                    String nameInstr = arr[1];
                    String nameService = arr[2];
                    String time = arr[3];
                    String price = arr[4];


                    String show = "Type of service: "+arr[5]+"\nPhotographer: "+nameInstr+"\nService: "+nameService+"\nTime: "+time+"\nPrice: "+price;

                    String book = text_Area.getText();


                    text_Area.setText(book+show+"\n\n");

                }



            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }    


    @FXML
    private void click_conf(ActionEvent event) {


        JOptionPane.showMessageDialog(null,"Thank you for choosing Lens Application");
        System.exit(0);
        
    }

    @FXML
    private void click_back(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("w3.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }
   
}
