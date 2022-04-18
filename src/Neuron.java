import java.util.ArrayList;

public class Neuron
{
   private ArrayList<Double> weights;
   private double alpha;
   private double theta;
   private double thetaChange;
   
   private String lang;
   
   public Neuron(ArrayList<Double> weights, double alpha, double thetaChange,
                 String lang)
   {
      this.weights = weights;
      this.alpha = alpha;
      this.thetaChange = thetaChange;
      this.theta = 1;
      this.lang = lang;
   }
   
   private double getSigmoidValue(double val)
   {
      return 1 / (1 + Math.exp(-val));
   }
   
   private void changeWeight(int index, int correctAnswer, int neuronDecision, int cellValue)
   {
      double temp = weights.get(index);
      temp += (correctAnswer - neuronDecision) * alpha * cellValue;
      theta -= (correctAnswer - neuronDecision) * alpha;
      weights.set(index, temp);
   }
   
   public void checkResult(int[] letterArray, String inputLang)
   {
      double score = 0;
      
      int counter = 0;
      
      for(int let : letterArray)
      {
         score += let * weights.get(counter);
         counter++;
      }
      
      int d;
      if(lang.equals(inputLang)) d = 1;
      else d = 0;
      
      int temp = 0;
      
      if(score > theta) //sum >= theta
      {
         for(int num : letterArray)
         {
            changeWeight(temp, d, 1, num);
            temp++;
         }
      }
      else
      {
         for(int num : letterArray)
         {
            changeWeight(temp, d, 0, num);
            temp++;
         }
      }
   }
   
   /*public boolean testResult(ObjectData object)
   {
      double score = 0;
      
      int counter = 0;
      
      for(Double num : object.getData())
      {
         score += num * weights.get(counter);
         counter++;
      }
      
      int d;
      if(object.getObjectName().equals(aboveObject)) d = 1;
      else d = 0;
      
      //if(getSigmoidValue(score) > 0.49)
      if(score > theta)
      {
         return d == 1;
      }
      else
      {
         return d == 0;
      }
   }*/
   
   public void type()
   {
      for(Double weight : weights)
      {
         System.out.println(weight);
      }
   }
   
}



















