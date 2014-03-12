/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tvorChallenge.abstractfactory;

import tvorChallenge.Kniha;
import tvorChallenge.Person;
import tvorChallenge.Teacher;
import tvorChallenge.Thing;

/**
 *
 * @author Petr Kalivoda
 */
public class TeacherCoolService implements IFactory {
    
    public Person makePerson() {
        return new Teacher();
    }
    
    public Thing makeThing() {
        return new Kniha();
    }
}
