/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch3Part2.Q4;

/**
 *
 * @author Abu Yasser
 */
public class Student implements Comparable{
    
    public int id;
    public String name;
    public String major;
    public double grade;

    public Student(int id, String name, String major, double grades) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.grade = grades;
    }

    @Override
    public int compareTo(Object o) {
   Student s;
        if(o instanceof Student){
            s = (Student)o;
        if(this.grade> s.grade)
            return 1;
        else if(this.grade < s.grade)
            return -1;
        else 
            return 0;
    }    
    
    return 0;
    
}

    @Override
    public String toString() {
        return String.format("%-3s %-13s %-6s %2.2f",id,name,major,grade );
    }

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
    
    
}