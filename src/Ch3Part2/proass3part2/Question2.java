/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3Part2.proass3part2;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Character;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 *
 * @author Abu Yasser
 */
public class Question2 {
    public static void main(String[] args) {
         try ( Stream<String> lines = Files.lines(Paths.get("C:\\text\\hash.txt"))) {
       lines.
                flatMap(line -> IntStream.range(0, line.length()).mapToObj(line::charAt)). 
               filter(Character::isLetter).
                collect(Collectors.groupingBy(Character::toLowerCase,                             
                             Collectors.counting()
                             )
                ).forEach((cha,count) -> 
                 System.out.println(cha+" : " + count));
       
    } catch (IOException e) {
        System.out.println("Failed to read file.");
    }
}
    }

