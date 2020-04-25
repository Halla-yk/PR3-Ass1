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
public class Course {
    
    private int id;
    private String name;
    private String room;

    public Course(int id, String name, String room) {
        this.id = id;
        this.name = name;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
    
}
