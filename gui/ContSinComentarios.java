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
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public class ContSinComentarios implements Initializable {
  String originFile;
  
  @FXML
  private GridPane root;
  
  @FXML
  private Button search;
  
  @FXML
  private TextField destinationFile;
  
  @FXML
  private TextArea result;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }
  
  public void selectFile () {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Ficheros Java", "*.java"));
    File file = fileChooser.showOpenDialog(root.getScene().getWindow());
    originFile = file.getPath();
  }
  
  
  
  public void deleteComments () {
    try {
      BufferedReader originBR = new BufferedReader(new FileReader(originFile));
      BufferedWriter destinationBR = new BufferedWriter(new FileWriter(destinationFile.getText()));
      
      boolean isInBigComment = false; 
      String line = originBR.readLine();
      while (line != null) {
        boolean isWritingNextLine = true;
        if (isInBigComment) {
          if (line.trim().endsWith("*/")) {
            isInBigComment = false;
          }
        } else if (line.trim().startsWith("/*")) {
          isInBigComment = true;
        } else {
          
          if (line.contains("//")){
            int firstIndexOfSmallComment = line.indexOf("//");
            line = line.substring(0, firstIndexOfSmallComment);
            if (line.trim().equals("")) {
              isWritingNextLine = false;
            }
          }
          
          if (isWritingNextLine && !isInBigComment) {
            result.appendText(line+"\n");
            destinationBR.write(line);
            destinationBR.newLine();
          }  
          
        }
       
        line = originBR.readLine();
        }
      
      originBR.close();
      destinationBR.close();
      
    } catch (FileNotFoundException e){
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}