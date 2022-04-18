/**
 * @author Mateusz Puza S23121
 * Project 3 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NAI_3
{
   private static final String lang1File = "Lang1.txt";
   private static final String lang2File = "Lang2.txt";
   private static final String lang3File = "Lang3.txt";
   
   public static void main(String[] args) throws FileNotFoundException
   {
      /*Languages used:
   German
   English
   French*/
   
      int[] lang1Array = loadLangFileIntoArray(lang1File);
      int[] lang2Array = loadLangFileIntoArray(lang2File);
      int[] lang3Array = loadLangFileIntoArray(lang3File);
      
      
   }
   
   public static int[] loadLangFileIntoArray(String fileName) throws FileNotFoundException
   {
      int[] result = new int[26];
      
      Scanner scanner = new Scanner(new File(fileName));
      String newLine;
      
      while(scanner.hasNextLine())
      {
         newLine = scanner.nextLine().toLowerCase();
         
         for(char c : newLine.toCharArray())
         {
            //'a' to 'z'
            if(c <= 122 && c >= 97)
            {
               if(result[c - 97] <= 0) result[c - 97] = 1;
               else result[c - 97]++;
            }
         }
      }
      
      return result;
   }
   
}




















