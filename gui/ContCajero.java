package ejercicios.gui;

/**
 * Controlador-vista para los eventos de CajeroCambio.
 * 
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ContCajero implements Initializable {
  
  @FXML
  private TextField total;
  
  @FXML
  private TextField unC, dosC, cincoC, diezC, veinteC,
  cincuentaC, unE, dosE, cincoE, diezE, veinteE, cincuentaE,
  cienE, doscientosE, quinientosE; 
  
  private ArrayList<Integer> values;
  private ArrayList<TextField> fullChange;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    values = new ArrayList<Integer>(Arrays.asList(
        50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1));
    
    fullChange = new ArrayList<TextField>(Arrays.asList(
        quinientosE, doscientosE, cienE, cincuentaE, veinteE, diezE, cincoE, dosE, 
        unE, cincuentaC, veinteC, diezC, cincoC, dosC, unC));
  }
  
  public void calc () {
    try {
      Integer result;
      Double amount;
      
      for (TextField texto : fullChange) texto.clear();
      

      amount = Double.parseDouble(total.getText())*100;
      int index = 0;
      for (Integer value : values) {
        if (amount >= value) {
          result = (int)(amount/value);
          amount = amount - (result)* value;
          fullChange.get(index).setText(Integer.toString(result));
        }
        index++;
      }
      
    } catch (Exception e) {
     e.printStackTrace();
    }
  }
}
