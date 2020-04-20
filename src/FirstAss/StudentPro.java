/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstAss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author Abu Yasser
 */
public class StudentPro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        
        Student[] std = {
            new ItStudent(5,"A std","AA",56,78,89),
        new ItStudent(1,"B std","bb",57,85,99),
        new ItStudent(2,"C std","cc",95,99,89),
        new ArtStudent(3,"D std","DD",66,66,79),
        new ArtStudent(4,"E std","EE",99,55,89)};
        
        
        Student.sortData(std);
        for(Student s : std){
            System.out.println(s);
    }
        PrintWriter output = new PrintWriter(new File("src/StudentPro/std.data"));
        for(Student s : std){
            output.println(s);
        }
        output.close();
        
  
}}
