/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tvorChallenge.abstractfactory;

import tvorChallenge.Ipad;
import tvorChallenge.Person;
import tvorChallenge.Student;
import tvorChallenge.Thing;

/**
 *
 * @author Petr Kalivoda
 */
public class StudentCoolService implements IFactory {
    
    public Person makePerson() {
        return new Student();
    }
    
    public Thing makeThing() {
        return new Ipad();
    }
}
