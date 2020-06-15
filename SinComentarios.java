package ejercicios;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SinComentarios extends Application {

  public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("gui/SinComentarios.fxml"));
        GridPane root = fxml.<GridPane>load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setTitle("App " + this.getClass().getSimpleName());
        primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}

