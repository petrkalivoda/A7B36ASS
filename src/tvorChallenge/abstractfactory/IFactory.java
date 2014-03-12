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
public interface IFactory {
    Person makePerson();
    Thing makeThing();
}
