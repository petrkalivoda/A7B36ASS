/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tvorChallenge.factorymethod;

import tvorChallenge.Ipad;
import tvorChallenge.Kniha;
import tvorChallenge.Person;
import tvorChallenge.Student;
import tvorChallenge.Teacher;
import tvorChallenge.Thing;

/**
 *
 * @author Petr Kalivoda
 */
public abstract class CoolService {
    
    public Student makeStudent() {
        return new Student();
    }
    
    public Teacher makeTeacher() {
        return new Teacher();
    }
    
    public Ipad makeIpad() {
        return new Ipad();
    }
    
    public Kniha makeKniha() {
        return new Kniha();
    }
    
    abstract Person makePerson();
    abstract Thing makeThing();
    
    final public Person wireUp() {
        Person p = makePerson();
        Thing t = makeThing();
     
        p.setThing(t);
        t.setPerson(p);
        
        return p;
    }
}
