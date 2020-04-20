/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3Part1.one;

import static java.lang.Math.random;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author Abu Yasser
 */
public class linked {
    
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> l = new LinkedList<>();
        for(int i = 0; i<30; i++){
        l.add(random.nextInt(100)) ;
        }
        Collections.sort(l);
        int sum = 0;
        for(Integer i : l){
            sum+=i;
        }
        double avg = sum/30.0;
        System.out.println("sorted: "+l);
        System.out.println("sum: "+sum);
        System.out.println("average: "+avg);
    }
    
}
