/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package homeworlds;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**

 @author Mark Ferguson
 */
public class Homeworlds extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("Homeworlds.fxml"));
    Scene scene = new Scene(root, 450, 800);
    stage.setScene(scene);
    stage.setX(0);
    stage.setY(200);
    stage.show();
    HomeworldsController.running = true;
  }

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
