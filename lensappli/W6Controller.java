/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lensappli;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Wadha
 */
public class W6Controller implements Initializable {

    @FXML
    private DatePicker JT_w6_date;
    @FXML
    private TextField JT_w6_time;
    @FXML
    private Button btn_w6_back;
    @FXML
    private Button btn_w6_book;
    @FXML
    private Label lbl_price2;
    @FXML
    private Label lbl_name2;

    static String name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void butnback(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("W4.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

    @FXML
    private void butnbook(ActionEvent event) throws Exception {
        FileWriter file_writer;
        file_writer = new FileWriter("wBooking.txt", true);
        BufferedWriter bw = new BufferedWriter(file_writer);
        bw.write(name+",");
        bw.write("Amasi" + ",");
        bw.write("(Event Photographer)" + ",");
        //bw.write(JT_w5_date.toString().getText()+",");
        bw.write(JT_w6_time.getText() + ",");
        bw.write(lbl_price2.getText() + ",");
        bw.write("Event Photographer"+"\n");


        bw.flush();
        bw.close();
        JOptionPane.showMessageDialog(null, "Added Successfully to BookingList!");


    }


}
