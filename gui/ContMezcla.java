package ejercicios.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class ContMezcla implements Initializable {
  String originFileA;
  String originFileB;
  
  @FXML
  private Button bfileA, bfileB;
  
  @FXML
  private TextField destination;
  
  @FXML
  private TextArea result;
  
  @FXML
  private VBox root;
  
  private String selectFile () {
    String result;
    FileChooser fileChooser = new FileChooser();
    File file = fileChooser.showOpenDialog(root.getScene().getWindow());
    result = file.getPath();
    return result;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }
  
  public void originFileA () {
    originFileA = selectFile();
  }
  
  public void originFileB () {
    originFileB = selectFile();
  }
  
  public void mix () {
    try {
      BufferedReader brA = new BufferedReader(new FileReader(originFileA));
      BufferedReader brB = new BufferedReader(new FileReader(originFileB));
      BufferedWriter mixed = new BufferedWriter(new FileWriter(destination.getText()));
      
      String lineA = brA.readLine();
      String lineB = brB.readLine();
      
      while (lineA != null || lineB != null) {
        if (lineA != null) {
          insertMixedLine(mixed, lineA);
          lineA = brA.readLine();
        }
        if (lineB != null) {
          insertMixedLine(mixed, lineB);
          lineB = brB.readLine();
        }
      }
      brA.close();
      brB.close();
      mixed.close();
      
    } catch (FileNotFoundException e){
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void insertMixedLine(BufferedWriter mixed, String lineB) throws IOException {
    mixed.write(lineB);
    mixed.newLine();
    result.setText(result.getText()+lineB+"\n");
  }
}