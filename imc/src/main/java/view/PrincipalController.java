package view;

import java.net.URL;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class PrincipalController implements Initializable {
    
    private final char ds = new DecimalFormatSymbols(Locale.getDefault(Locale.Category.FORMAT)).getDecimalSeparator();
    private final NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
    
    @FXML
    private RadioButton rdbtnMasc;
    
    @FXML 
    private RadioButton rdbtnFem;
    
    @FXML 
    private Button button;
    
    @FXML 
    private TextField peso;
    
    @FXML
    private TextField altura;
    
    @FXML
    private Label label;
    
    @FXML
    private Label label2;
    
    private int sexo=1;
    private double z;
   
     
    @FXML
    private void handleButtonAction(ActionEvent event) {
         try {
            double valor1 = nf.parse(peso.getText()).doubleValue();
            double valor2 = nf.parse(altura.getText()).doubleValue();
            double valor3 = valor2 * valor2;
            z = valor1 / valor3;
            label2.setText(nf.format(z));
        } catch (ParseException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
         }
                     switch (sexo) {
             case 1:
                 if (z <= 20.7){
                     label.setText("Abaixo do peso");
                 } else if (z <=26.7) {
                     label.setText("Peso normal");
                 } else if (z <=27.8) {
                     label.setText("Levemente acima do peso");
                 } else if (z <=31.1) {
                     label.setText("Acima do peso");
                 } else {
                     label.setText("Obeso");
             }
             break;
             case 2:
                 if (z <= 19.1){
                     label.setText("Abaixo do peso");
                 } else if (z <=25.8) {
                     label.setText("Peso normal");
                 } else if (z <=27.3) {
                     label.setText("Levemente acima do peso");
                 } else if (z <=32.3) {
                     label.setText("Acima do peso");
                 } else {
                     label.setText("Obeso");
             }  
             break;
             default:
                 break;
            }
    }
   
    @FXML
    private void mascClick(ActionEvent event) {
        sexo = 1;
        peso.clear();
        altura.clear();
}
    
    @FXML
    private void femClick (ActionEvent event) {
        sexo = 2;
        peso.clear();
        altura.clear();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
