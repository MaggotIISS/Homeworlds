/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package homeworlds;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static javax.swing.JOptionPane.showInputDialog;

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
  private Label l4uwp;
  private int line;
  private MouseEvent me;
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
  @FXML
  private TextField uwp;
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Variables">
  static boolean running = false;
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
    "+5", "M", "D", "D", "D", "D", "D", "D", "D",
    "+6", "M", "D", "D", "D", "D", "D", "D", "D"
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
  private String[][] strings = null;
  private String[] array = null;
  private int cols = 0;
  private int lines = 0;
  private String[] bits = null;
  private String[] colnames;
  private String var = "";
  private int num = 0;
  private String UWP = "A788999-C";
  private String reply = UWP;
  private ActionEvent ae;
  //</editor-fold>

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    uwp.setText("A788999-C");
    remarksTxt.setText("Ri Pa Ph An Cp (Amindii)2 Varg0 Asla0 Sa");
    MouseEvent me = null;
    img = new Image(getClass().getResource("ImperialSunBurst.gif").toString());
    iv.setImage(img);
    iv.setVisible(true);
    goClick(ae);
  }

  @FXML
  private void goClick(ActionEvent event) {
    homestarClick(me);
    orbitsClick(me);
    hzClick(me);
    remarksClick(me);
    uwpClick(me);
//    imgClick(me);
  }

  @FXML
  private void imgClick(MouseEvent event) {
    createImage();
  }

  @FXML
  private void homestarClick(MouseEvent event) {
//    string = homestar.getText();
//    showTable(string);
//    add(string);
    labelClick(homestar);
    creatStar();
  }

  @FXML
  private void orbitsClick(MouseEvent event) {
    labelClick(orbits);
    createVariance();
  }

  @FXML
  private void hzClick(MouseEvent event) {
    labelClick(hz);
    createHabZone();
  }

  @FXML
  private void remarksClick(MouseEvent event) {
    labelClick(remarks);
    createRemarks();
  }

  @FXML
  private void uwpClick(MouseEvent event) {
    labelClick(l4uwp);
    createRemarks();
  }

  private void labelClick(Label lab) {
    string = lab.getText();
    showTable(string);
    add(string.toUpperCase());
  }

  private void showTable(String labelText) {
    ta.setText("");
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
//    System.out.println(string);
  }

  private int roll(int D) {
//    int num = Integer.parseInt(D);
    int reply = 0;
    for (int i = 0; i < D; i++) {
      reply += (int) (Math.random() * 6) + 1;
    }
    return reply;
  }

  private String type = null, dec = null, siz = null;

  private void creatStar() {
    int flux;
    //flux = roll(1) - roll(1);
    flux = roll(2) - 7;//Either way works
//    ta.appendText("array = HomeStar" + CRLF);
//    ta.appendText("Roll flux = " + flux + CRLF);
    cols = Integer.parseInt(HomeStar[0]);
    lines = array.length / cols;
//    ta.appendText("lines = " + lines + " mod " + (array.length % lines) + CRLF);
//    ta.appendText("cols = " + cols + CRLF);
//    ta.appendText("start @ " + array[cols + 1] + CRLF);
    //Get Spectral Class
    flux = roll(2) - 7;
//    ta.appendText("Roll flux = " + flux + CRLF);
    for (int i = 1; i < array.length; i += cols) {
      if ((array[i].equals("" + flux)) || (array[i].equals("+" + flux))) {
        ta.appendText("Spectral class = " + array[i + 1] + CRLF);
        type = array[i + 1];
        //Get Size by comparing class with column title
        for (int j = 1; j < cols + 1; j++) {
          if ((array[j].equals(array[i + 1]))) {
//            ta.appendText("j = " + j + CRLF);
            ta.appendText("Size = " + array[i + j - 1] + CRLF);
            siz = array[i + j - 1];
          }
        }
      }
      //Create decimal
      int num = (int) (Math.random() * 10);
      dec = "" + num;
      homeStar.setText(type + dec + " " + siz);
    }
  }

  private void createVariance() {
    int worldroll = roll(2) - 7;
    int varroll = roll(2) - 7;
    int closeroll = roll(2) - 7;
    int farroll = roll(2) - 7;
    String line = "";
    try {
      String spec = homeStar.getText().substring(0, 1);
      String dec = homeStar.getText().substring(1, 2);
      String size = homeStar.getText().substring(3);
      // Setup line array
      String[] lines = ta.getText().split(CRLF);
      int tablemax = lines.length - 3;
//    ta.appendText("tablemax = " + tablemax + CRLF);
//    ta.appendText("worldroll" + " = " + worldroll + CRLF);
      // Setup column names
      colnames = lines[0].split(CRLF);
//      for (int j = 0; j < colnames.length; j++) {
//        if (colnames[j].contains("World")) {
////        ta.appendText("" + colnames[j] + CRLF);
//        }
//      }
      // Find required line
      String out = "";
      for (int i = 1; i < tablemax; i++) {
        if (lines[i].startsWith("" + worldroll) || lines[i].startsWith("+" + worldroll)) {
//        ta.appendText("lines[" + i + "] = " + lines[i] + CRLF);
          // Split relevant line into bits
          line = lines[i];
          bits = line.split("\t");
          switch (bits[1]) {
            case "World": {
              out = "World";
              break;
            }
            default: {
              out = "Moon";
            }
          }
          ta.appendText("Mainworld = " + out + CRLF);
          break;
        }
      }
      // Habitable Zone
      //varroll = roll(2) - 7;
      String s = "";
      String a = null;
      for (int i = 1; i < tablemax; i++) {
        if ((lines[i].startsWith("" + varroll)) | (lines[i].startsWith("+" + varroll))) {
          line = lines[i];
          var = lines[i].split("\t")[2];
          ta.appendText("Orbits @ HZ " + var);
          // Show climate
          num = Integer.parseInt(var.replace("+", ""));
          if (num > 0) {
            s = out + " @ HZ +" + num;
          } else {
            s = out + " @ HZ " + num;
          }
          if (num < 0) {
            a = " (Hot)";
          }
          if (num == 0) {
            a = " (Temperate)";
          }
          if (num > 0) {
            a = " (Cold)";
          }
          ta.appendText(a + CRLF);
          s += a;
        }
      }
      orbitsAt.setText(s);

    } catch (Exception e) {

    }
  }

  private void createHabZone() {
    System.out.println("createHabZone");
    String[] liness = ta.getText().split(CRLF);
    for (int i = 0; i < liness.length; i++) {
      if (liness[i].equals("")) {
        lines = i - 1;
      }
    }
//    ta.appendText("Lines in liness = " + lines + CRLF);
    cols = Integer.parseInt("" + liness[0].split("\t").length);
//    ta.appendText("Columns in line = " + cols + CRLF);
//    ta.appendText("type = " + type + CRLF);
    colnames = liness[0].split("\t");
    String letter1 = null;
    String letter2 = null;
    int[] tcols = new int[3];
    int cnt = 0;
    for (int i = 1; i < colnames.length; i++) {
      letter1 = colnames[i].substring(0, 1);
      try {
        letter2 = colnames[i].substring(3, 4);
      } catch (Exception e) {
      }
      if ((type.equals(letter1)) | (type.equals(letter2))) {
//        ta.appendText("cols[" + i + "] = " + colnames[i] + CRLF);
        tcols[cnt] = i;
        cnt += 1;
      }
    }
    for (int i = 0; i < liness.length; i++) {
      bits = liness[i].split("\t");
      if (bits[0].equals(siz)) {
//        ta.appendText("lines[" + i + "] = " + liness[i] + CRLF);
        line = i;
        break;
      }
    }
    int col = 0;
    int num = 0;
    switch (type) {
      case "A": {
        if (Integer.parseInt(dec) < 4) {
          col = 1;
        }
        if (Integer.parseInt(dec) > 3 & Integer.parseInt(dec) < 9) {
          col = 2;
        }
        if (Integer.parseInt(dec) == 9) {
          col = 3;
        }
        break;
      }
      case "F": {
        if (Integer.parseInt(dec) < 2) {
          col = 3;
        }
        if (Integer.parseInt(dec) > 1 & Integer.parseInt(dec) < 7) {
          col = 4;
        }
        if (Integer.parseInt(dec) > 6) {
          col = 5;
        }
        break;
      }
      case "G": {
        if (Integer.parseInt(dec) < 2) {
          col = 5;
        }
        if (Integer.parseInt(dec) > 1 & Integer.parseInt(dec) < 9) {
          col = 6;
        }
        if (Integer.parseInt(dec) == 9) {
          col = 7;
        }
        break;
      }
      case "K": {
        if (Integer.parseInt(dec) < 4) {
          col = 7;
        }
        if (Integer.parseInt(dec) > 1 & Integer.parseInt(dec) < 9) {
          col = 8;
        }
        if (Integer.parseInt(dec) == 9) {
          col = 9;
        }
        break;
      }
      case "M": {
        if (Integer.parseInt(dec) < 4) {
          col = 9;
        }
        if (Integer.parseInt(dec) > 3 & Integer.parseInt(dec) < 9) {
          col = 10;
        }
        if (Integer.parseInt(dec) == 9) {
          col = 11;
        }
        break;
      }
    }
//    ta.appendText("col = " + col + CRLF);

    ta.appendText("HZ = " + bits[col] + CRLF);
    String s = var;
    if ("0".equals(var)) {
      s = "+" + var;
    }
//    ta.appendText("s = " + s + CRLF);
    int num1 = Integer.parseInt(bits[col].trim());
    int num2 = Integer.parseInt(s.trim());
    int total = num1 + num2;
    habZone.setText(("HZ=" + bits[col]) + ".  Mainworld @ " + total + CRLF);
    System.out.println(num1);
    System.out.println(num2);
    System.out.println(total);

    if (total < 0) {
      goClick(ae);
    }

  }

  private void createRemarks() {
    ta.appendText("show Remarks from Panel4T5Locator or get UWP ???????-?" + CRLF);
    ta.appendText("OR BOTH!" + CRLF);
    if (!running) {
    } else {
      if (uwp.getText().isEmpty()) {
        reply = showInputDialog(null, "Enter UWP", UWP);
        ta.setText(reply);
        if (reply != null) {
          uwp.setText(reply);
        } else {
          uwp.setText(UWP);
        }
        goClick(ae);
      }
      findRemarks(reply);
    }
  }

  private void findRemarks(String reply) {
    try {
      if (reply != "") {
        ta.appendText("findRemarks for " + reply.substring(1, 7) + CRLF);
      } else {
        reply = UWP;
        uwp.setText(reply);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  private void createImage() {
    ta.setText("createImage" + CRLF);
    String s = "";
    s += "img.getWidth() = " + img.getWidth() + CRLF;
    s += "img.getHeight() = " + img.getHeight() + CRLF;
    ta.setText(s);
  }

}
