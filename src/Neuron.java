import java.util.ArrayList;
import java.util.Arrays;

public class Neuron
{
   private ArrayList<Double> weights;
   private double alpha;
   private double theta;
   private double thetaChange;
   
   private String lang;
   
   public Neuron(ArrayList<Double> weights, double alpha, double theta, double thetaChange,
                 String lang)
   {
      this.weights = weights;
      this.alpha = alpha;
      this.thetaChange = thetaChange;
      this.theta = theta;
      this.lang = lang;
   }
   
   public String getLang()
   {
      return lang;
   }
   
   private double getSigmoidValue(double val)
   {
      return 1 / (1 + Math.exp(-val));
   }
   
   private double countScore(double[] letterRepeatsArray)
   {
      double result = 0;
      int counter = 0;
      
      for(double let : letterRepeatsArray)
      {
         result += let * weights.get(counter);
         counter++;
      }
      
      return result;
   }
   
   private double[] normalizeInput(double[] input)
   {
      double[] result = new double[input.length];
      
      double max = Arrays.stream(input).max().getAsDouble();
      double min = Arrays.stream(input).min().getAsDouble();
      
      int counter = 0;
      
      for(double i : input)
      {
         result[counter] = (i - min) / (max - min);
         counter++;
      }
      
      return result;
   }
   
   private void changeWeight(int index, int correctAnswer, int neuronDecision, double cellValue)
   {
      double temp = weights.get(index);
      temp += (correctAnswer - neuronDecision) * alpha * cellValue;
      weights.set(index, temp);
   }
   
   public void teachNeuron(double[] letterRepeatsArray, String inputLang)
   {
      //letterRepeatsArray = normalizeInput(letterRepeatsArray);
      
      double score = countScore(letterRepeatsArray);
      
      int d;
      if(lang.equals(inputLang)) d = 1;
      else d = 0;
      
      int temp = 0;
      
      if(score > theta) //sum > theta
      {
         //Change all weights accordingly to expected result
         for(double num : letterRepeatsArray)
         {
            changeWeight(temp, d, 1, num);
            temp++;
         }
         
         theta -= (d - 1) * thetaChange;
      }
      else
      {
         //Change all weights accordingly to expected result
         for(double num : letterRepeatsArray)
         {
            changeWeight(temp, d, 0, num);
            temp++;
         }
         
         theta -= d * thetaChange;
      }
   }
   
   public double testResult(double[] letterRepeatsArray)
   {
      letterRepeatsArray = normalizeInput(letterRepeatsArray);
      
      double score = countScore(letterRepeatsArray);
      
      return getSigmoidValue(score);
   }
   
}



















