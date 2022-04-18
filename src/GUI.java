import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI extends JFrame
{
   private JButton okButton;
   private JPanel mainPanel;
   private JTextField userInput;
   private JTextArea resultField;
   
   public GUI() throws HeadlessException
   {
      this.setVisible(true);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setSize(new Dimension(720, 480));
      this.add(mainPanel);
      this.setLocationRelativeTo(null);
   
      okButton.addActionListener(e ->
      {
         StringBuilder stringBuilder = new StringBuilder();
   
         for(double v : Functions.insertLettersIntoArray(new double[26], userInput.getText()))
         {
            stringBuilder.append(v).append(" ");
         }
         
         resultField.setText(stringBuilder.toString());
         
      });
   }
   
}












