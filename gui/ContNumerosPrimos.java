package ejercicios.gui;

import java.net.URL;
import java.util.ResourceBundle;
import ejercicios.gui.NumerosPrimos;
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
    pantallaPrimos.setText(NumerosPrimos.contar(Integer.parseInt(nPrimos.getText().toString())).toString());
  }
}
