package ejercicios;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rectangulo extends Application {

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("App " + this.getClass().getSimpleName());
    
    GridPane root = new GridPane();
    root.setHgap(10);
    root.setVgap(10);
    root.setPadding(new Insets(10, 10, 10, 10));
 
    root.add(new Label ("Base: "), 0, 1);
    TextField base = new TextField();
    root.add(base, 1, 1);

    root.add(new Label("Altura: "), 0, 2);
    TextField altura = new TextField();
    root.add(altura, 1, 2);

    Button calcular = new Button("Ok");
    root.add(calcular, 0, 3, 2, 1);
    GridPane.setHalignment(calcular, HPos.CENTER);
    
    TextArea resultado = new TextArea();
    resultado.setEditable(false);
    resultado.setWrapText(true);
    root.add(resultado,0,4,2,1);
    
    calcular.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent e) {
        try {
          double area, perimeter;
          if (base.getText().compareTo("") == 0) {
            alert("Falta el valor de la base");

          }else if (altura.getText().compareTo("") == 0) {
            alert("Falta el valor de la altura");

          } else if (Double.parseDouble(base.getText()) <= 0 || (Double.parseDouble(altura.getText()) <= 0)) {
            alert("Los valores introducidos han de ser positivos.");
          } else {
            area = Double.parseDouble(base.getText()) * Double.parseDouble(altura.getText());
            perimeter = 2 * (Double.parseDouble(base.getText()) + Double.parseDouble(altura.getText()));
            resultado.setText("Triángulo base: " + base.getText() + " y altura: "+ altura.getText() +"\n"+"Área: "+area+"\n"+"Perímetro: " + perimeter);
          }
        } catch (Exception error) {
            alert("Los valores para la base y para la altura han de ser numéricos");
        }
      }
    });

    // creamos escena y asignamos a escenario
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void alert (String mensaje) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setHeaderText(null);
    alert.setTitle("Error");
    alert.setContentText(mensaje);
    alert.showAndWait();
  }
  public static void main(String[] args) {
    launch(args);
  }
}
