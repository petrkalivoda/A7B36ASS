/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.adt.alphabetizer;

import kwic.adt.circular_shifter.CircularShifter;

/**
 *
 * @author Petr Kalivoda
 */
public interface Alphabetizer extends Iterable<String>{
    
    public void alphabetize(CircularShifter c);
}
