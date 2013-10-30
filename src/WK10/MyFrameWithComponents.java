package WK10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrameWithComponents {
  public static void main(String[] args) {
    JFrame frame = new JFrame("MyFrameWithComponents");

    // Add a button into the frame
    final JButton jbtOK = new JButton("OK");
    frame.add(jbtOK);
    
    ActionListener al = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null, ae.paramString());
        jbtOK.setVisible(false);
      }
    };
    jbtOK.addActionListener(al);

    frame.setSize(400, 300); // Set the frame size
    frame.setLocationRelativeTo(null); // Centers the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true); // Display the frame
  }
}