/**
*
* @author Juan Roa
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VistaAtp extends JFrame implements ActionListener{

  Container contenedor;
  JPanel panelButton, panelArea;
  JButton buttonInit;
  JTextArea areaResultados;

  public VistaAtp () {
    graphics();
    organize();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  private void graphics () {
    contenedor = getContentPane();

    panelButton = new JPanel(new FlowLayout());
    panelButton.setVisible(true);

    panelArea = new JPanel(new FlowLayout());
    panelArea.setBorder(BorderFactory.createTitledBorder("Resultados Torneo"));
    panelArea.setVisible(true);

    buttonInit = new JButton("Iniciar Torneo");
    buttonInit.addActionListener(this);

    areaResultados = new JTextArea();
    areaResultados.setEditable(false);
  }

  private void organize () {
    contenedor.setLayout(new BorderLayout());

    panelArea.add(areaResultados);
    panelButton.add(buttonInit);

    contenedor.add(panelArea,BorderLayout.CENTER);
    contenedor.add(buttonInit,BorderLayout.SOUTH);

    this.pack();
  }

  public void actionPerformed(ActionEvent e) {
    if(e.getSource()==buttonInit){
      //
    }
  }
}
