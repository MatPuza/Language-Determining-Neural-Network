/**
 * @author Mateusz Puza S23121
 * Project 3 
 */

import java.io.FileNotFoundException;

public class NAI_3
{
   private static final String lang1File = "Lang1.txt";
   private static final String lang2File = "Lang2.txt";
   private static final String lang3File = "Lang3.txt";
   
   private static final String lang1 = "German";
   private static final String lang2 = "English";
   private static final String lang3 = "French";
   
   private static final double alpha = 0.05;
   private static final double thetaChange = 0.01;
   
   public static void main(String[] args) throws FileNotFoundException
   {
      /*Languages used:
      German
      English
      French*/
      
      int[] lang1Array = Functions.loadLangFileIntoArray(lang1File);
      int[] lang2Array = Functions.loadLangFileIntoArray(lang2File);
      int[] lang3Array = Functions.loadLangFileIntoArray(lang3File);
      
      Neuron neuronLang1 = new Neuron(Functions.generateWeights(lang1Array.length), alpha, thetaChange, lang1);
      Neuron neuronLang2 = new Neuron(Functions.generateWeights(lang1Array.length), alpha, thetaChange, lang2);
      Neuron neuronLang3 = new Neuron(Functions.generateWeights(lang1Array.length), alpha, thetaChange, lang3);
      
   }
   
}




















