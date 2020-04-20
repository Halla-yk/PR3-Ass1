/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstAss;

/**
 *
 * @author Abu Yasser
 */
public class ArtStudent extends Student{

    public ArtStudent(int id, String name, String major,int midd,int report,int finall) {
        this.id = id;
        this.major = major;
        this.name =name;
        this.grade = midd*0.4+report*0.1+finall*0.5;
    }

   
   
}
