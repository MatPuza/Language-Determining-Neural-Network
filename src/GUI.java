import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame
{
   private JButton okButton;
   private JPanel mainPanel;
   private JTextArea resultField;
   private JTextArea userInput;
   
   public GUI(Neuron neuron1, Neuron neuron2, Neuron neuron3) throws HeadlessException
   {
      this.setVisible(true);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setSize(new Dimension(960, 580));
      this.add(mainPanel);
      this.setLocationRelativeTo(null);
      
      okButton.addActionListener(e ->
      {
         String text = userInput.getText();
         
         double res1 = neuron1.testResult(Functions.insertLettersIntoArray(new double[26], text));
         double res2 = neuron2.testResult(Functions.insertLettersIntoArray(new double[26], text));
         double res3 = neuron3.testResult(Functions.insertLettersIntoArray(new double[26], text));
         
         String recognizedLang;
         if(res1 > res2)
         {
            if(res1 > res3) recognizedLang = neuron1.getLang();
            else recognizedLang = neuron3.getLang();
         }
         else
         {
            if(res2 > res3) recognizedLang = neuron2.getLang();
            else recognizedLang = neuron3.getLang();
         }
         
         String output = neuron1.getLang() + ": " + (int) (res1 * 100) + "%\n" +
                 neuron2.getLang() + ": " + (int) (res2 * 100) + "%\n" +
                 neuron3.getLang() + ": " + (int) (res3 * 100) + "%\n" + 
                 "User input was recognized as " + recognizedLang;
         
         resultField.setText(output);
      });
   }
   
}












