/**
* @author Diana Carolina Hernández
* @version 1.0
* @license 
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VistaAtp extends JFrame implements ActionListener{

  Container contenedor;
  JPanel panelButton, panelArea;
  JButton buttonInit;
  JTextArea areaResultados;
  JScrollPane scroll;
  JuegoAtp game;

  public VistaAtp () {
    game = new JuegoAtp ();

    graphics();
    organize();
    this.setSize(400,400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  private void graphics () {
    buttonInit = new JButton("Iniciar Torneo");
    buttonInit.addActionListener(this);

    areaResultados = new JTextArea(20,30);
    areaResultados.setEditable(false);

    scroll = new JScrollPane();
    scroll.setViewportView(areaResultados);
  }

  private void organize () {
    contenedor = getContentPane();
    contenedor.setLayout(new BorderLayout());

    panelArea = new JPanel(new FlowLayout());
    panelArea.setBorder(BorderFactory.createTitledBorder("Resultados Torneo"));
    panelArea.setVisible(true);
    panelArea.add(scroll);

    panelButton = new JPanel(new FlowLayout());
    panelButton.setVisible(true);
    panelButton.add(buttonInit);

    contenedor.add(panelArea,BorderLayout.CENTER);
    contenedor.add(buttonInit,BorderLayout.SOUTH);
  }

  public void actionPerformed(ActionEvent e) {
    if(e.getSource()==buttonInit){
      game.playGame();
      areaResultados.setText(game.getResult());
      game = new JuegoAtp ();
    }
  }
}
