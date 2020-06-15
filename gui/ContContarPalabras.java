package ejercicios.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ContContarPalabras  implements Initializable {

  @FXML
  Label contador;
  
  @FXML
  TextArea frase;
  
  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    
  }
  
  public void contar(ActionEvent e) {
    String ourString = frase.getText();

    // Borro los posibles espacios al principio y final de la cadena
    ourString = ourString.trim();

    // Si nos dan la cadena vacía terminamos la ejecución con un código de error
    if (ourString.isEmpty()) {
      contador.setText("0");
    }

    // Desde el primer caracter distinto de espacio
    int contadorPalabras = 0;
    for (int posicion = 0; posicion<=ourString.length()-1; posicion++) {
      if (ourString.charAt(posicion)==' ') {
        contadorPalabras++;
        // No tengo en cuanta los posibles espacios que haya entre las palabras
        while (posicion<=ourString.length()-1 && ourString.charAt(posicion)==' ') {
          posicion++;
        }
      }
    }
    
    contadorPalabras++;

    contador.setText(Integer.toString(contadorPalabras));
  }

}
