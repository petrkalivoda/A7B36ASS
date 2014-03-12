/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tvorChallenge.factorymethod;

import tvorChallenge.Ipad;
import tvorChallenge.Student;

/**
 *
 * @author Petr Kalivoda
 */
public class Main {      
    public static void main(String[] args) {
        GenericCoolService<Student, Ipad> s = new GenericCoolService<>(Student.class, Ipad.class);
    }
}
