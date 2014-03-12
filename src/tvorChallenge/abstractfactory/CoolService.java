/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tvorChallenge.abstractfactory;

import tvorChallenge.Person;
import tvorChallenge.Thing;

/**
 *
 * @author Petr Kalivoda
 */
public class CoolService {
    
    protected IFactory f;
    
    public CoolService(IFactory f) {
        this.f = f;
    }
     
    final public Person wireUp() {
        Person p = f.makePerson();
        Thing t = f.makeThing();
     
        p.setThing(t);
        t.setPerson(p);
        
        return p;
    }
}
