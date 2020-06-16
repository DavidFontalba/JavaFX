package ejercicios.gui;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class Utils {
  public static String exportarArchivo (ActionEvent e, VBox root) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos .txt", "*.txt"));
    File file = fileChooser.showSaveDialog(root.getScene().getWindow());
    return file.getPath();
  }
  
  public static String importarArchivo (ActionEvent e, VBox root) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos .txt", "*.txt"));
    File file = fileChooser.showOpenDialog(root.getScene().getWindow());
    return file.getPath();
  }
}
