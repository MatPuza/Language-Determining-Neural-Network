import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Functions
{
   public static double[] loadLangFileIntoArray(String fileName) throws FileNotFoundException
   {
      double[] result = new double[26];
      
      Scanner scanner = new Scanner(new File(fileName));
      String newLine;
      
      while(scanner.hasNextLine())
      {
         newLine = scanner.nextLine().toLowerCase();
   
         insertLettersIntoArray(result, newLine);
      }
      
      return result;
   }
   
   public static double[] insertLettersIntoArray(double[] result, String input)
   {
      for(char c : input.toCharArray())
      {
         //'a' to 'z'
         if(c <= 122 && c >= 97)
         {
            if(result[c - 97] <= 0) result[c - 97] = 1;
            else result[c - 97]++;
         }
      }
      
      return result;
   }
   
   public static ArrayList<Double> generateWeights(int length)
   {
      ArrayList<Double> result = new ArrayList<>();
      
      Random random = new Random();
      
      for(int i = 0 ; i < length ; i++)
      {
         result.add(random.doubles(-1, 1).findFirst().getAsDouble()); 
      }
      
      return result;
   }
   
}












