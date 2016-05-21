/**
*
* @author Juan Roa
*/
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JuegoAtp {

  private ArrayList<NodoAtp> listNodes;
  private ArrayList<String> playerNames;
  private NodoAtp tree; // Final Node Binary Tree
  private String result;

  public JuegoAtp () {
    listNodes = new ArrayList<NodoAtp>();
    playerNames = new ArrayList<String>();
    readTxt();
    for(int i=1; i<65; i++) {
      listNodes.add(new NodoAtp(i,0));
    }

    tree = new NodoAtp (0,0);
    result="";
  }

  public static int randInt(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
  }

  public void readTxt() {

    BufferedReader br = null;

    try {

      String sCurrentLine;

      br = new BufferedReader(new FileReader("names.txt"));
      int a = 0;
      while ((sCurrentLine = br.readLine()) != null) {
        
        playerNames.add(sCurrentLine);
        System.out.println(playerNames.get(a));
        a++;
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }

  }

  public void defineDad (NodoAtp foe1, NodoAtp foe2) {
    foe1.setFoe(foe2);
    foe2.setFoe(foe1);
    int sets1 = randInt(3,8);
    int sets2 = 0;
    do {
      sets2 = randInt(3,8);
    } while (sets2 == sets1);
    foe1.setScore(sets1);
    foe2.setScore(sets2);

    NodoAtp winner = new NodoAtp(0,0);

    if(foe1.getScore()< foe2.getScore()){
      winner.setCode(foe2.getCode());
    } else if (foe2.getScore()< foe1.getScore()) {
      winner.setCode(foe1.getCode());
    }

    foe1.setWinner(winner);
    foe2.setWinner(winner);
  }

  public String printSubTree() {
    String cadena = "";
    for (int i=0; i<listNodes.size(); i+=2) {
      cadena += playerNames.get(i) + String.valueOf(listNodes.get(i).getCode()) + " vs Jugador " + String.valueOf(listNodes.get(i+1).getCode());
      cadena += " [" + String.valueOf(listNodes.get(i).getScore()) + " , " + String.valueOf(listNodes.get(i+1).getScore()) + "]\n";
    }
    return cadena;
  }

  public String getResult() {
    String copyresult = result;
    result="";
    return copyresult;
  }

  //hace crecer los arboles binarios parciales* con los ganadores de la respectiva ronda
  private void roundPlay () {
    int limit = listNodes.size() - 2;
    for (int i=0; i<=limit; i+=2) {
      defineDad(listNodes.get(i), listNodes.get(i+1));
    }
  }

  public void playGame() {
    int i=6;
    String auxiliar="Ronda ";
    do {
      if (i==4)
        auxiliar = "Octavos de Final";
      else if (i==3)
        auxiliar = "Cuartos de Final";
      else if (i==2)
        auxiliar = "Semifinal";
      else if (i==1)
        auxiliar = "Final";

      System.out.println("Ronda " + i + ", size " +listNodes.size());
      roundPlay();
      if(i>4)
        result += auxiliar + i + "\n";
      else
        result += auxiliar + "\n";

      result += printSubTree();
      int j=0;
      //eliminando de la lista de control los perdedores de la respectiva ronda
      while (j <= (listNodes.size()-2)) {
        if ( listNodes.get(j).getScore() > listNodes.get(j+1).getScore() )
          listNodes.remove(j+1);
        else
          listNodes.remove(j);
        j++;
      }
      result += "\n\n";
      i--;
    }while(listNodes.size() >= 2);

    //en este momento la lista de control tiene el arbol binario construído de manera inversa
    result += "GANA JUGADOR " + listNodes.get(0).getCode() + "!!!!";
  }
}
