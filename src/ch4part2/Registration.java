/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch4part2;

/**
 *
 * @author Abu Yasser
 */
public class Registration {
    private Course c;
    private Student s;

    public Registration(Course c, Student s) {
        this.c = c;
        this.s = s;
    }

    public Course getC() {
        return c;
    }

    public void setC(Course c) {
        this.c = c;
    }

    public Student getS() {
        return s;
    }

    public void setS(Student s) {
        this.s = s;
    }
    
    
}
