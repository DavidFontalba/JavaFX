package ejercicios.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ContNumerosPrimos implements Initializable {
  @FXML
  private TextField nPrimos;
  @FXML
  private Button botonOK;
  @FXML
  private TextArea pantallaPrimos;

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    
  }
  public void okClick(ActionEvent e) {
    pantallaPrimos.setText(contar(Integer.parseInt(nPrimos.getText().toString())).toString());
  }
  
  public static ArrayList<Integer> contar(int cantidadAMostrar) {
    ArrayList<Integer> numerosPrimos = new ArrayList<Integer>();
    if (cantidadAMostrar > 0) numerosPrimos.add(2);
    int cantidadMostrados;
    int num;
    cantidadMostrados = 1;
    // ...a partir de 3
    num = 3;
    while (cantidadMostrados < cantidadAMostrar) {
      // pienso que es primo hasta que encuentre con que dividirlo
      boolean esPrimo = true;
      // ya sabemos que es impar
      for (int divisor=3; divisor<=Math.sqrt(num) && esPrimo; divisor+=2) {
        // si la división da exacta...
        if (num%divisor==0) {
          // ...ya no es primo
          esPrimo = false;
        }
      }
      if (esPrimo) {
        cantidadMostrados++;
        numerosPrimos.add(num);
      }
      num += 2;
    }
    return numerosPrimos;
  }
}
