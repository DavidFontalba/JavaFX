package ejercicios.gui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import ejercicios.gui.FraccionClass;

public class ContFraccion implements Initializable {
  
  @FXML
  private TextField num1, den1, num2, den2, numResult, denResult;
  
  @FXML
  private RadioButton plus, minus, multiply, division;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }
  
  public void calc () {
    try {
      FraccionClass f1 = new FraccionClass (Integer.parseInt(num1.getText()), Integer.parseInt(den1.getText()));
      FraccionClass f2 = new FraccionClass (Integer.parseInt(num2.getText()), Integer.parseInt(den2.getText()));
      FraccionClass fR = null;
      if (plus.isSelected()) {
        fR = FraccionClass.sumar(f1, f2);
      } else if (minus.isSelected()) {
        fR = FraccionClass.restar(f1, f2);  
      } else if (multiply.isSelected()) {
        fR = FraccionClass.multiplicar(f1, f2);
      } else if (division.isSelected()) {
        fR = FraccionClass.dividir(f1, f2);
      }
      numResult.setText(Integer.toString(fR.getNum()));
      denResult.setText(Integer.toString(fR.getDen()));
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}