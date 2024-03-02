package lensappli;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.JOptionPane;


public class W8Controller {

    @FXML
    private Button btn_w8_bak;

    @FXML
    private Button btn_w8_bok;
    @FXML
    private Label lbl_name3;
    @FXML
    private Text level;
    @FXML
    private Text inst;
    @FXML
    private Text time;
    @FXML
    private Text price;

    static String name;


    @FXML
    void click_bak(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("W7.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }

    }


    @FXML
    void click_book(ActionEvent event) throws Exception {
        FileWriter file_writer;
        file_writer = new FileWriter("wBooking.txt", true);
        BufferedWriter bw = new BufferedWriter(file_writer);
        bw.write(name + ",");
        bw.write(inst.getText() + ",");

        bw.write(lbl_name3.getText() + ",");
        bw.write(time.getText() + ",");
        bw.write(price.getText() + ",");
        bw.write("Course"+"\n");
        bw.flush();
        bw.close();
        JOptionPane.showMessageDialog(null, "Added Successfully to BookingList!");


    }


}
