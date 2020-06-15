package ejercicios.gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ContMaxMinMediaVar implements Initializable {
  
  @FXML
  Label contadorNotas, max, min, med, var;
  int contador = 0;
  ArrayList<Double> notas = new ArrayList<Double>();
  
  @FXML
  TextField nota;
  
  @FXML
  TextArea totalNotas;
  
  
  
  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    
  }
  
  public void addNota(ActionEvent e) {
    if (contador > 9) {
      double sumaNotas = 0;
      double media;
      double varianza;
      double maximo = 0;  // nota mínima
      double minimo = 10; // nota máxima
      
      
      // Proceso primera parte: media, máximo y mínimo
      for (int i=0; i<notas.size(); i++) {
        // Actualizar los datos intermedios: sumatorio, máximo y mínimo
        if (notas.get(i) > maximo) {
          maximo = notas.get(i);
        }
        if (notas.get(i) < minimo) {
          minimo = notas.get(i);
        }
        sumaNotas += notas.get(i);
      }
      media = sumaNotas/notas.size();
          
      // Proceso segunda parte: varianza
      sumaNotas = 0;
      for (int i=0; i<notas.size(); i++) {
        sumaNotas += Math.pow(notas.get(i)-media, 2);
      }
      varianza = sumaNotas/notas.size();
      
      // Mostramos resultados 
      max.setText("Máxima: " + maximo);
      min.setText("Mínima: " + minimo);
      med.setText("Media: " + media);
      var.setText("Varianza: " + varianza);
    } else {
      
      totalNotas.appendText(nota.getText()+", ");
      notas.add(Double.parseDouble(nota.getText()));
      nota.clear();
      contador++;
      contadorNotas.setText("Nota " + (contador+1)+":");
    }
  }

}
