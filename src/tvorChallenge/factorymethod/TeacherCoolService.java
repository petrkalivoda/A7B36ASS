/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tvorChallenge.factorymethod;

import tvorChallenge.Kniha;
import tvorChallenge.Person;
import tvorChallenge.Teacher;
import tvorChallenge.Thing;


public class TeacherCoolService extends CoolService {

    @Override
    Person makePerson() {
        return new Teacher();
    }

    @Override
    Thing makeThing() {
        return new Kniha();
    }
    
}
