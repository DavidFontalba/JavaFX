package ejercicios.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ContAdivinaNumeroConFor implements Initializable {
  @FXML
  TextField tEscribir;
  
  @FXML
  TextArea tResult;
  
  @FXML
  Label intentos;
  
  int intentosQueQuedan = 10;
  int numRandom;
  
  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
   numRandom = (int) (Math.random() * 100 + 1);
//   tResult.setText("Introduce un número y dale a probar para intentar averiguar el número en el que estoy pensando.");
  }
  
  public void probarNumero(ActionEvent e) {
    if (intentosQueQuedan != 0 ) {
      int n = Integer.parseInt(tEscribir.getText());
      if (n < numRandom) {
        tResult.setText(n + " es menor que el número a adivinar");
      } else if (n > numRandom){
        tResult.setText(n + " es mayor que el número a adivinar");
      } else {
        if (numRandom==n) {
          tResult.setText("¡Exacto! Usted adivinó en "+(10-intentosQueQuedan)+" intentos.");
        }
      }
      tResult.appendText("\nDame otro número (de 1 a 100): ");
      
      intentosQueQuedan--;
      intentos.setText(Integer.toString(intentosQueQuedan));
    } else {
      tResult.setText("Has agotado el número máximo de intentos. El número a adivinar era: " + numRandom + "\n Reinicie el programa para volver a jugar.");
    }
    
  }
  
}
