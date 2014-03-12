/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tvorChallenge.abstractfactory;

import tvorChallenge.Person;

/**
 *
 * @author Petr Kalivoda
 */
public class Main {
    public static void main(String[] args) {
        CoolService s = new CoolService(new StudentCoolService());
        Person p = s.wireUp();
    }
}
