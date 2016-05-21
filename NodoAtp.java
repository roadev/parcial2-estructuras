/**
*
* @author Juan Roa
*/

public class NodoAtp {

  private int code;
  private int score;
  private NodoAtp foe;
  private NodoAtp winner;

  public NodoAtp (int code, int score) {
    this.code = code;
    this.score = score;
    foe = null;
    winner = null;
  }

  public int getCode () {
    return code;
  }

  public int getScore () {
    return score;
  }

  public void setCode (int code) {
    this.code=code;
  }

  public void setScore (int score) {
    this.score=score;
  }

  public void setFoe (NodoAtp foe) {
    this.foe=foe;
  }

  public void setWinner (NodoAtp winner) {
    this.winner=winner;
  }

}
