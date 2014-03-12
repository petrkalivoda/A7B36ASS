/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tvorChallenge.singleton;

import tvorChallenge.Ipad;
import tvorChallenge.Kniha;
import tvorChallenge.Student;
import tvorChallenge.Teacher;

/**
 *
 * @author Petr Kalivoda
 */
public class Main {
    public static void main(String[] args) {
        CoolService c = CoolService.getInstance();
        Teacher t = c.makeTeacher();
        Student s = c.makeStudent();
        
        Ipad i = new Ipad();
        Kniha k = new Kniha();
        
        c.join(t, k);
        c.join(s, i);
    }
}
