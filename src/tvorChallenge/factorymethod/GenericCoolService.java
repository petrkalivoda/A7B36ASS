/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tvorChallenge.factorymethod;

import tvorChallenge.Ipad;
import tvorChallenge.Student;
import tvorChallenge.Person;
import tvorChallenge.Thing;


public class GenericCoolService<A extends Person, B extends Thing> extends CoolService {

    private final Class<A> personClazz;
    private final Class<B> thingClazz;
    
    public GenericCoolService(Class<A> person, Class<B> thing) {
        personClazz = person;
        thingClazz = thing;
    }
    
    @Override
    Person makePerson() {
        try {
            return personClazz.newInstance();
        } catch(InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    @Override
    Thing makeThing() {
        try {
            return thingClazz.newInstance();
        } catch(InstantiationException | IllegalAccessException e) {
            return null;
        }
    }    
}
