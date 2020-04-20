/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstAss;

import java.io.Serializable;

/**
 *
 * @author Abu Yasser
 */
public class Student {
    protected int id;
    protected String name;
    protected String major;
    protected double grade;

   

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public double getGrade() {
        return grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", major=" + major + ", grade=" + grade + '}';
    }

   
    
    public static Student[] sortData(Student[] a){
          for (int j = 0; j < a.length; j++) {
          for(int i=0; i< a.length-1; i++){
               if(a[i+1].grade > 
                       a[i].grade){
                   Student temp = a[i];
               
                   a[i]= a[i+1];
                   a[i+1] = temp;
               } 
            }             
        }
          return a;
    }
    
}
