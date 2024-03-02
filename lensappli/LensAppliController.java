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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Wadha
 */
public class LensAppliController implements Initializable {

    @FXML
    private TextField JT_w1_user;
    @FXML
    private Button btn_w1_signin;
    @FXML
    private Button btn_w1_signup;
    @FXML
    private TextField JT_w1_email;
    @FXML
    private PasswordField JT_w1_pass;
    @FXML
    private RadioButton PhotographerR;
    @FXML
    private ToggleGroup pcgroup;
    @FXML
    private RadioButton customerR;
    @FXML
    private TextField JT_w1_number;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    @FXML
    private void butnsignin(ActionEvent event) {
        //TO CONNECT ANOTHER WINDOW
            
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("w2.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
        
        
    }

    @FXML
    private void butnsignup(ActionEvent event) throws Exception {
        //TO CONNECT ANOTHER WINDOW
        //هنا يتم تخزين بيانات انشاء الحساب في ملف .WAD  
            inputValidation();
            FileWriter file_writer;
            
            file_writer = new FileWriter("WAD.txt",true);
            BufferedWriter bw = new BufferedWriter(file_writer);
            bw.write(JT_w1_user.getText()+",");
            bw.write(JT_w1_email.getText()+",");
            bw.write(JT_w1_number.getText()+",");
            bw.write(JT_w1_pass.getText()+"\n");
            
            bw.flush();
            bw.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("w2.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }
// التحقق
   private void inputValidation() throws Exception {

        //check that all fields are valid
        if (!validatephonenumber()) {
            JOptionPane.showMessageDialog(null, "Invalid phone number\nMust be 10 numbers & starts with 05 "
                    + "\nExample: 0512345678"
                    , "Error", JOptionPane.ERROR_MESSAGE);
           throw new Exception();
        }
        
        if (!validateEmail()) {

            JOptionPane.showMessageDialog(null, "Invalid email\nMust have (@) & ( . )\nExample: lensapp@gmail.com"
                    , "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception();
        }
       
        
        if (!validatePassword()){
             JOptionPane.showMessageDialog(null, "Invalid password\nMust be at least one uppercase & lowercase character"
                     + "& at least one numeric character,Must have (@)\nExample: Lens4@"
                     , "Error", JOptionPane.ERROR_MESSAGE);
              throw new Exception();
         }
        
        
        
    }

    private boolean validateEmail() {
          return JT_w1_email.getText().matches("^(.+)@(.+)$");
    }

    private boolean validatePassword() {
        return JT_w1_pass.getText().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$");
      
    }
    private boolean validatephonenumber() {

        return JT_w1_number.getText().matches("(05)[0-9]{8}");

    }
    
}
