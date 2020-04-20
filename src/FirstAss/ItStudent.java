
package FirstAss;
 class ItStudent extends Student{
     
     

    public ItStudent(int id, String name, String major,int mid,int project,int finall) {
       this.id = id;
       this.major = major;
       this.name = name;
       this.grade = mid*0.3+project*0.3+finall*0.4;
    }

   
}
