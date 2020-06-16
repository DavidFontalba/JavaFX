package ejercicios.gui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ContExpresionesRegulares implements Initializable {
  String originFile;
  double fontSize;
  String fontType;
  
  @FXML
  private TextField regexpToSearch;
  
  @FXML
  private TextArea userWriteHere, userReadHere;
  
  @FXML
  private VBox root;
  
  
  @FXML
  private ComboBox<String> comboFonts;
  
  @FXML
  private Spinner<Integer> spinnerFontSize;
    
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    comboFonts.getItems().addAll("Arial", "Comic Sans MS", "Impact", "Verdana", "Gill Sans");
    fontSize = userReadHere.getFont().getSize();
    fontType = userReadHere.getFont().getName(); 
    spinnerFontSize.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 150, (int) fontSize));
  }
  
  public void selectFile (ActionEvent e) {
    originFile = Utils.importarArchivo(e, root);
    showText();
  }
  
  public void showText () {
    try {
      // Abrimos fichero origen
      BufferedReader originBR = new BufferedReader(new FileReader(originFile));
      String line = originBR.readLine();
      while (line != null) {
        userWriteHere.setText(userWriteHere.getText()+line+"\n");
        line = originBR.readLine();  
      }
      
      // Cerramos el fichero.
      originBR.close();
      
    } catch (FileNotFoundException e){
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void search(ActionEvent e) {
    if (regexpToSearch.getText().compareTo("")== 0) {
      userReadHere.setText("Debes introducir un patrón de búsqueda");
    } else {
      Pattern pattern = Pattern.compile("("+regexpToSearch.getText()+")\\b");
      Matcher matcher = pattern.matcher(userWriteHere.getText());
      userReadHere.setText("");
      while (matcher.find()) {
        userReadHere.setText(userReadHere.getText()+ matcher.group(1)+"\n");
      }
    }
  } 
  
  public void switchFont (ActionEvent e) {
    if (comboFonts.getValue().toString().compareTo("Arial")==0) {
      fontType = "Arial";
    } else if (comboFonts.getValue().toString().compareTo("Comic Sans MS")==0) {
      fontType = "Comic Sans MS";
    } else if (comboFonts.getValue().toString().compareTo("Impact")==0) {
      fontType = "Impact";
    } else if (comboFonts.getValue().toString().compareTo("Verdana")==0) {
      fontType = "Verdana";
    } else if (comboFonts.getValue().toString().compareTo("Gill Sans")==0) {
      fontType = "Gill Sans";
    } else {
      fontType = comboFonts.getValue().toString();
    }
    userReadHere.setFont(new Font(fontType, fontSize));
    userWriteHere.setFont(new Font(fontType, fontSize));    
  }
  
  public void switchFontSize (MouseEvent e) {
    fontSize = spinnerFontSize.getValue();
    userReadHere.setFont(new Font(fontType, fontSize));
  }
  
  
}