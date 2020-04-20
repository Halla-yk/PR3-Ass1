/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3Part1.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Abu Yasser
 */
public class hashMap {
    public static void main(String[] args) {
         try {
      File myObj = new File("C:\\text\\hash.txt");
      Scanner myReader = new Scanner(myObj);
      String[] words ={};
      char[] character = {};
      while (myReader.hasNextLine()) {
        String line = myReader.nextLine();
         words= line.split(" ");
         character = line.toCharArray();
         
      }
        Map<String, Integer> wordsMap = new HashMap<>();
        Map<Character,Integer> charactersMap = new HashMap<>();
        wordsMap.put(words[0], 0);
        charactersMap.put(character[0], 0);
        for(String s: words){
            if(wordsMap.containsKey(s)){
                int value =  wordsMap.get(s)+1;
                 wordsMap.replace(s, wordsMap.get(s),value);
                
            }
            else
                wordsMap.put(s,1);
         }
         for(char c: character){
            if(charactersMap.containsKey(c) && c!= ' '){
                int value =  charactersMap.get(c)+1;
                 charactersMap.replace(c, charactersMap.get(c),value);
                
            }
            else if(c!=' ')
                charactersMap.put(c,1);
         }
        System.out.println(Arrays.asList(wordsMap));
        System.out.println(Arrays.asList(charactersMap));

      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      
    }
    }
    
}
