/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package homeworlds;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**

 @author Mark Ferguson
 */
public class HomeworldsController implements Initializable {

  //<editor-fold defaultstate="collapsed" desc="FXMLVariables">
  @FXML
  private TextField habZone;
  @FXML
  private TextField homeStar;
  @FXML
  private Label homestar;
  @FXML
  private Label hz;
  private Image img;
  @FXML
  private ImageView iv;
  @FXML
  private Label orbits;
  @FXML
  private TextField orbitsAt;
  @FXML
  private Label remarks;
  @FXML
  private TextField remarksTxt;
  @FXML
  private TextArea ta;
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="private static String[] Hab">
  private static String[] Hab = new String[]{
    "12",
    "Sp/Si", "A0-A3", "A4-A8", "A9-F1", "F2-F6", "F7-G1", "G2-G8", "G9-K3",
    "K4-K8", "K9-M3", "M4-M8", "M9",
    "Ia", "12", "12", "12", "12", "11", "12", "12", "12", "12", "12", "12",
    "Ib", "11", "11", "10", "10", "10", "10", "10", "10", "10", "11", "11",
    "II", "9", "9", "8", "8", "8", "8", "8", "9", "9", "10", "11",
    "III", "8", "8", "7", "6", "6", "6", "7", "7", "8", "8", "9",
    "IV", "7", "7", "6", "6", "5", "5", "5", "-1", "-1", "-1", "-1",
    "V", "7", "7", "6", "5", "4", "3", "2", "2", "0", "0", "0",
    "VI", "-1", "-1", "-1", "3", "3", "2", "1", "0", "0", "0", "0",
    "VII", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "D", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="private static String[] StarColor">
  private static String[] StarColor = {
    "3",
    "Code", "Description", "Temperature (K)",
    "O", "Blue", ">33,000",
    "B", "Blue-White", "10,000-33,000",
    "A", "Blue-White", "7,500-10,000",
    "F", "Yellow-White", "6,000-7,500",
    "G", "Yellow", "5,200-6,000",
    "K", "Orange", "3,700-5,200",
    "M", "Red", "2,000-3,700"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="private static String[] StarSize">
  private static String[] StarSize = {
    "3",
    "Code", "Description", "Diameter (Sol = 1)",
    "Ia", "Bright Supergiant", "52 - 3500",
    "Ib", "Weak Supergiant", "30 - 3000",
    "II", "Bright Giant", "14 - 1000",
    "III", "Normal Giant", "4.6 - 360",
    "IV", "Subgiant", "3.3 - 13",
    "V", "Main Sequence Star", "0.2 - 10",
    "VI", "Subdwarf", "0.1 - 1.2",
    "VII", "White Dwarf", "0.006 - 0.018",
    "D", "White Dwarf", "0.006 - 0.018"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="private static String[] HomeStar">
  private static String[] HomeStar = {
    "9",
    "Flux", "Spectral", "O", "B", "A", "F", "G", "K", "M",
    "-6", "OB", "Ia", "Ia", "Ia", "II", "II", "II", "II",
    "-5", "A", "Ia", "Ia", "Ia", "II", "II", "II", "II",
    "-4", "A", "Ib", "Ib", "Ib", "III", "III", "III", "II",
    "-3", "F", "II", "II", "II", "IV", "IV", "IV", "II",
    "-2", "F", "III", "III", "III", "V", "V", "V", "III",
    "-1", "G", "III", "III", "IV", "V", "V", "V", "V",
    "0", "G", "III", "III", "V", "V", "V", "V", "V",
    "+1", "K", "V", "III", "V", "V", "V", "V", "V",
    "+2", "K", "V", "V", "V", "V", "V", "V", "V",
    "+3", "M", "V", "V", "V", "V", "V", "V", "V",
    "+4", "M", "IV", "IV", "V", "VI", "VI", "VI", "VI",
    "+5", "M", "D", "D", "3", "D", "D", "D", "D",
    "+6", "M", "D", "D", "3", "D", "D", "D", "D"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="private static String[] HZWorldOrbits">
  private static String[] HZWorldOrbits = {
    "5",
    "Flux", "World", "HZ Var", "Close", "Far",
    "-6", "Close", "-2", "Ay", "En",
    "-5", "Far", "-1", "Bee", "Oh",
    "-4", "Far", "-1", "Cee", "Pee",
    "-3", "Close", "-1", "Dee", "Que",
    "-2", "World", "0", "Ee", "Arr",
    "-1", "World", "0", "Eff", "Ess",
    "0", "World", "0", "Gee", "Tee",
    "+1", "World", "0", "Aitch", "Yu",
    "+2", "World", "0", "Eye", "Vee",
    "+3", "World", "+1", "Jay", "Dub",
    "+4", "World", "+1", "Kay", "Ex",
    "+5", "World", "+1", "Ell", "Wye",
    "+6", "World", "+2", "Em", "Zee"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="private static String[] Remarks">
  private static String[] Remarks = {
    "9",
    "Code", "Siz", "Atm", "Hyd", "Pop", "Govt", "Law", "Definition", "Formula",
    //---------------------------------PLANETARY
    "As", "0", "0", "0", "", "", "", "Asteroid", "",
    "De", "23456789", "0", "", "", "", "", "Desert", "",
    "Fl", "", "ABC", "123456789A", "", "", "", "Fluid", "",
    "Ga", "678", "568", "567", "", "", "", "Garden World", "",
    "He", "3459ABC", "2479ABC", "012", "", "", "", "Hell World", "",
    "Ic", "", "01", "123456789A", "", "", "", "Ice Capped", "",
    "Oc", "ABC", "", "A", "", "", "", "Ocean World", "",
    "Va", "", "0", "", "", "", "", "Vacuum", "",
    "Wa", "56789", "", "A", "", "", "", "Water World", "",
    //---------------------------------POPULATION
    "Di", "", "", "", "0", "0", "0", "Dieback (000-T)", "",
    "Ba", "", "", "", "0", "0", "0", "Barren", "",
    "Lo", "", "", "", "123", "", "", "Low Population", "",
    "Ni", "", "", "", "456", "", "", "Non Industrial", "",
    "Ph", "", "", "", "8", "", "", "Pre High", "",
    "Hi", "", "", "", "9ABC", "", "", "High Population", "",
    //---------------------------------ECONOMIC
    "Pa", "", "456789", "45678", "48", "", "", "Pre Agricultural", "",
    "Ag", "", "456789", "45678", "567", "", "", "Agricultural", "",
    "Na", "", "0123", "0123", "6789ABC", "", "", "Non Agricultural", "",
    "Pi", "", "012479", "", "78", "", "", "Pre Industrial", "",
    "In", "", "012479", "", "9ABC", "", "", "industrial", "",
    "Po", "", "2345", "0123", "", "", "", "Poor", "",
    "Pr", "", "68", "", "59", "", "", "Pre Rich", "",
    "Ri", "", "68", "", "678", "", "", "Rich", "",
    //---------------------------------CLIMATE
    "Fr", "23456789", "", "123456789A", "", "", "", "Frozen", "HZ +2 or outer",
    "Ho", "", "", "", "", "", "", "Hot", "HZ -1",
    "Co", "", "", "", "", "", "", "Cold", "HZ +1",
    "Lk", "", "", "", "", "", "", "Locked", "Close Satellite",
    "Tr", "6789", "456789", "34567", "", "", "", "Tropic", "HZ -1",
    "Tu", "6789", "456789", "34567", "", "", "", "Tundra", "HZ +1",
    "Tz", "", "", "", "", "", "", "Twilight Zone", "Orbit 0-1",
    //---------------------------------SECONDARY
    "Fa", "", "456789", "45678", "23456", "", "", "Farming",
    "Not MainWorld.  HZ",
    "Mi", "", "", "", "23456", "", "", "Mining", "Not MainWorld.  MainWorld=In",
    "Mr", "", "", "", "", "", "", "Military Rule by Regional Power", "",
    "Px", "", "23AB", "12345", "3456", "", "6789", "Prison.  Exile Camp", "",
    "Pe", "", "23AB", "12345", "3456", "6", "6789", "Penal Colony", "",
    "Re", "", "", "", "1234", "6", "45", "Reserve", "",
    //---------------------------------POLITICAL
    "Cp", "", "", "", "", "", "", "Subsector Capital", "Imperial",
    "Cs", "", "", "", "", "", "", "Client State", "Imperial",
    "Cx", "", "", "", "", "", "", "Sector Capital", "Imperial",
    "Cy", "", "", "", "", "", "", "Colony", "O:xxyy (p434)",
    //---------------------------------SPECIAL
    "Sa", "", "", "", "", "", "", "Satellite", "",
    "Fo", "", "", "", "", "", "", "Forbidden", "Red Zone",
    "Pz", "", "", "", "789ABC", "", "", "Puzzle", "Amber Zone",
    "Da", "", "", "", "0123456", "", "", "Dangerous", "Amber Zone",
    "Ab", "", "", "", "", "", "", "Data Repository", "",
    "An", "", "", "", "", "", "", "Ancient Site", "",
    "Rs", "", "", "", "", "", "", "Research Station", "",
    "RsA", "", "", "", "", "", "", "Research Station Alpha", "",
    "RsB", "", "", "", "", "", "", "Research Station Beta", "",
    //    "", "", "", "", "", "", "", "", "",
    "RsD", "", "", "", "", "", "", "Research Station Delta", ""
  };
  //</editor-fold>
  private static String string = "";
  private String CRLF = "\n";
  private String[][] strings;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    MouseEvent me = null;
    img = new Image(getClass().getResource("ImperialSunBurst.gif").toString());
    iv.setImage(img);
    iv.setVisible(true);
  }

  @FXML
  private void imgClick(MouseEvent event) {
    System.out.println(getClass().getResource("ImperialSunBurst.gif").toString());
  }

  @FXML
  private void homestarClick(MouseEvent event) {
    string = homestar.getText();
    System.out.println(string);
    showTable(string);
    add(string);
  }

  @FXML
  private void orbitsClick(MouseEvent event) {
    labelClick(orbits);
  }

  @FXML
  private void hzClick(MouseEvent event) {
    labelClick(hz);
  }

  @FXML
  private void remarksClick(MouseEvent event) {
    labelClick(remarks);
  }

  private void labelClick(Label lab) {
    string = lab.getText();
    System.out.println(string);
    showTable(string);
    add(string);
  }

  private void showTable(String labelText) {
    ta.setText("");
    String[] array = null;
    switch (labelText) {
      case "Homestar": {
        //Generate Star type & size
        array = HomeStar;
        break;
      }
      case "Orbits": {
        //Generate HabZoneVariance
        array = HZWorldOrbits;
        break;
      }
      case "HZ": {
        //Generate HabZone
        array = Hab;
        break;
      }
      case "Remarks": {
        //Generate HabZone
        array = Remarks;
        break;
      }
      default: {
        System.out.println(string);
      }
    }
    strings = new String[][]{array};
    int num = 0;
    for (int i = 0; i < strings.length; i++) {
      num = Integer.parseInt(strings[i][0]);
      for (int j = 1; j < strings[i].length; j++) {
        String it = strings[i][j] + "\t";
        ta.appendText(it);
        System.out.print(it);
        if (j % num == 0) {
          ta.appendText(CRLF);
          System.out.println("");
        }
      }
      ta.appendText(CRLF);
      System.out.println("");
    }
  }

  private void add(String string) {
    ta.appendText(string + CRLF);
    System.out.println("string");
  }

}
