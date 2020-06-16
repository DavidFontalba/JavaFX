package ejercicios.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class ContClaveCesar implements Initializable {
  String originFile;
  String destinyFile;
  int index;
  
  @FXML
  private VBox root;
  
  @FXML
  private Button bCharge, bDecrypt, bSave, bPlus, bMinus;
  
  @FXML
  private TextArea firstText, finalText;
  
  @FXML
  private TextField pass;
  
  @FXML
  private Slider passSlider;
    
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    pass.setText(Integer.toString(passSlider.valueProperty().getValue().intValue()));    
  }
  
  public void useSlide (MouseEvent e) {
    passSlider.valueProperty().addListener((observable, oldValue, newValue) ->  {
      pass.setText(Integer.toString(observable.getValue().intValue()));
    });  
  }
  
  public void slideModify (ActionEvent e) {
    if (e.getSource().equals(bPlus)) {
      passSlider.valueProperty().setValue(passSlider.valueProperty().getValue().intValue()+1);
      pass.setText(Integer.toString(passSlider.valueProperty().getValue().intValue()));
    } else if (e.getSource().equals(bMinus)) {
      passSlider.valueProperty().setValue(passSlider.valueProperty().getValue().intValue()-1);
      pass.setText(Integer.toString(passSlider.valueProperty().getValue().intValue()));
    }
  }
  
  
  public void selectFile (ActionEvent e) {
    originFile = Utils.importarArchivo(e, root);
    show(originFile);
  }
  
  public void saveFile (ActionEvent e) {
    destinyFile = Utils.exportarArchivo(e, root);
    decryptFile(e);
  }
  
  private void show (String localizacion) {
    try {
      // Abrimos fichero origen
      BufferedReader originBR = new BufferedReader(new FileReader(localizacion));
      String line = originBR.readLine();
      while (line != null) {
        firstText.setText(firstText.getText()+line+"\n");
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
  
  public void decryptFile (ActionEvent e) {
    try{
    BufferedReader originBR = originBR(originFile);
    ArrayList<String> originLines = new ArrayList<String>();
    String line = originBR.readLine();
    while (line != null) {
      originLines.add(line);
      line = originBR.readLine();
    }
    originBR.close();
    
    // desplazamiento
    int desp = Integer.parseInt(pass.getText());
    
    if (e.getSource().equals(bDecrypt)) {
      finalText.setText("");
      for (String nLine: originLines) {
        finalText.setText(finalText.getText()+ cesarDecrypt(nLine, desp) +"\n");
      }
    } else if (e.getSource().equals(bSave)) {
      // Abrimos fichero para desencriptar
      BufferedWriter finalBR = finalBR(destinyFile);
      
      // Desencriptamos
      for (String nLine: originLines) {
        finalBR.write(cesarDecrypt(nLine, desp));
        finalBR.newLine();
      }
      finalBR.close();
    }
    
    } catch (Exception excep) {
      excep.printStackTrace();
    }
  }
  
  
  private static BufferedReader originBR(String originFIle) {
    try {
      return new BufferedReader(new FileReader(originFIle));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
  
  private static BufferedWriter finalBR(String finalFile) {
    try {
      return new BufferedWriter(new FileWriter(finalFile));
    } catch (Exception e) {
      System.err.println("No se ha podido abrir " + finalFile);
      System.exit(3);
    }
    return null;
  }
  

  private static String cesarDecrypt(String ourString, int desp) {
    String decryptedString = "";
    String avaibleCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZáéíóúüñÁÉÍÓÚÜÑ";
    
    for (char character : ourString.toCharArray()) {
      char decryptedChar = character;
      if (avaibleCharacters.contains(Character.toString(character))) {
        int realPosition = avaibleCharacters.indexOf(character);
        int decryptedPosition = ((realPosition - desp) % avaibleCharacters.length());
        if (decryptedPosition < 0) {
          decryptedPosition = avaibleCharacters.length() + decryptedPosition;
        }
        decryptedChar = avaibleCharacters.charAt(decryptedPosition);
      } 
      decryptedString += decryptedChar;
    }
    return decryptedString;
  }
  
}