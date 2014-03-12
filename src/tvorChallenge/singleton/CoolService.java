/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tvorChallenge.singleton;

import tvorChallenge.Person;
import tvorChallenge.Student;
import tvorChallenge.Teacher;
import tvorChallenge.Thing;

/**
 *
 * @author Petr Kalivoda
 */
public class CoolService {
    private static CoolService me;
    private CoolService() {}
    
    public static CoolService getInstance() {
        if(!(me instanceof CoolService)) {
            me = new CoolService();
        }
        
        return me;
    }
    
    public Student makeStudent() {
        return new Student();
    }
    
    public Teacher makeTeacher() {
        return new Teacher();
    }
    
    public void join(Person p, Thing t) {
        p.setThing(t);
        t.setPerson(p);
    }
}
