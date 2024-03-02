/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lensappli;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Wadha
 */
public class W2Controller implements Initializable {

    @FXML
    private Button btn_w2_signin;
    @FXML
    private TextField JT_w2_user;
    @FXML
    private PasswordField JT_w2_pass;
    @FXML
    private Button btn_w2_signup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
     void butnsignin(ActionEvent event) throws IOException {
        //TO CONNECT ANOTHER WINDOW
        //هنا لازم يكون انشى حساب ويدخل الحساب اذا غلط مايدخل 
        boolean flag = true;
        ArrayList<String[]> AccountsList = readAccounts();

        for (String[] account : AccountsList) {
            if (account[0].equals(JT_w2_user.getText()) && account[3].equals(JT_w2_pass.getText())) {
                //name for show WADD 

                W5Controller.name = JT_w2_user.getText();
                W6Controller.name = JT_w2_user.getText();
                W8Controller.name = JT_w2_user.getText();
                W9Controller.name = JT_w2_user.getText();
                W10Controller.name = JT_w2_user.getText();



                FileWriter file_writer;
                //يخزن بيانات تسجيل الدخول لعميل واحد

                file_writer = new FileWriter("WADD.txt");
                BufferedWriter bw = new BufferedWriter(file_writer);
                bw.write(account[0] + ",");
                bw.write(account[1] + ",");
                bw.write(account[2] + ",");
                bw.write(account[3]+ "\n" );


                bw.flush();
                bw.close();
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("w3.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);

                } catch (IOException io) {
                    System.out.println("FXML Loading Error");
                }
                break;
            }
        }
        if (!flag){
            JOptionPane.showMessageDialog(null, "Username or Password not valid");
        }
        /*
        else{
        JOptionPane.showMessageDialog(null, "USER or Password not valid");
        }*/
    }

    public ArrayList<String[]> readAccounts() {
        ArrayList<String[]> AccountsList = new ArrayList<>();
        String splitData[];
        try {

            File myObj = new File("WAD.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                splitData = data.split(",");

                AccountsList.add(splitData);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return AccountsList;

    }

    @FXML
    private void butnsignup(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LensAppli.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

}
