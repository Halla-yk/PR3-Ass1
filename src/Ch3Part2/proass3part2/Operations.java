/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3Part2.proass3part2;

import java.util.Arrays;

/**
 *
 * @author Abu Yasser
 */
public class Operations {
  private interface IntConsumer<Integer>{
      void accept(int value);
  }
  private interface Display{
      void display();
  }
  private interface Operation<String>{
      String toUpper(String s);
  }
    public static void main(String[] args) {
        ////question 1(A)
        IntConsumer<Integer> x = value -> System.out.printf("%d ", value);
        x.accept(7);
        System.out.println();
        ////question 1(B)
        Operation<String> o = String :: toUpperCase;
        System.out.println(o.toUpper("hello world"));
        String[] arr = {"a","b","c","d"};
        Arrays.stream(arr).map(String:: toUpperCase).forEach(s-> System.out.println(s));
        /////question 1(c)
        Display d  = () -> System.out.println("Welcome to lambdas!");
        d.display();
        //////question 1(d)
        IntConsumer<Integer> c = num -> System.out.println("the cube of "+num+" = "+num*num*num);
        c.accept(3);
    }
   
    
}