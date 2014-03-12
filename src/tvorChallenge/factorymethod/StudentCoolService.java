/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tvorChallenge.factorymethod;

import tvorChallenge.Ipad;
import tvorChallenge.Person;
import tvorChallenge.Student;
import tvorChallenge.Thing;


public class StudentCoolService extends CoolService {

    @Override
    Person makePerson() {
        return new Student();
    }

    @Override
    Thing makeThing() {
        return new Ipad();
    }
    
}
