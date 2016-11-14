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

  private static int x = 0;
  private static int y = 200;
  private static int w = 470;
  private static int h = 240;

  /**
   @return the h
   */
  public static int getH() {
    return (int) astage.getHeight();
  }

  /**
   @return the w
   */
  public static int getW() {
    return (int) astage.getWidth();
  }

  /**
   @return the x
   */
  public static int getX() {
    return (int) astage.getX();
  }

  /**
   @return the y
   */
  public static int getY() {
    return (int) astage.getY();
  }

  public static Stage astage;

  @Override
  public void start(Stage stage) throws Exception {
    astage = stage;
    Parent root = FXMLLoader.load(getClass().getResource("Homeworlds.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setX(x);
    stage.setY(y);
    stage.setWidth(w);
    stage.setHeight(h);
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
