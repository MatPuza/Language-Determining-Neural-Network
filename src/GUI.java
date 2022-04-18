import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI extends JFrame
{
   private JButton okButton;
   private JPanel mainPanel;
   //private JTextField userInput;
   private JTextArea resultField;
   private JTextArea userInput;
   
   public GUI(Neuron neuron1, Neuron neuron2, Neuron neuron3) throws HeadlessException
   {
      this.setVisible(true);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setSize(new Dimension(960, 580));
      this.add(mainPanel);
      this.setLocationRelativeTo(null);
      
      /*Font font1 = new Font("SansSerif", Font.PLAIN, 20);
      userInput.setFont(font1);
      userInput.setSize(200, 80);*/
      
      okButton.addActionListener(e ->
      {
         String text = userInput.getText();
         
         double res1 = neuron1.testResult(Functions.insertLettersIntoArray(new double[26], text));
         double res2 = neuron2.testResult(Functions.insertLettersIntoArray(new double[26], text));
         double res3 = neuron3.testResult(Functions.insertLettersIntoArray(new double[26], text));
         
         String output = neuron1.getLang() + ": " + (int) (res1 * 100) + "%\n" +
                 neuron2.getLang() + ": " + (int) (res2 * 100) + "%\n" +
                 neuron3.getLang() + ": " + (int) (res3 * 100) + "%";
         
         resultField.setText(output);
         
      });
   }
   
}












