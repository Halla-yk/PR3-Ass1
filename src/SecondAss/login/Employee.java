/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondAss.login;

import java.io.Serializable;

/**
 *
 * @author Abu Yasser
 */
public class Employee implements Serializable{
    private String name;
    private String password;

    public Employee(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return  name + " "+password;
    }}