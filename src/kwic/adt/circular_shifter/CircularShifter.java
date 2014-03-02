/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.adt.circular_shifter;

import kwic.adt.characters.Characters;

/**
 *
 * @author Petr Kalivoda
 */
public interface CircularShifter extends Iterable<String> {
    /**
     * Perform the actual circular shifting.
     * @param chr 
     */
    public void setup(Characters chr);
}
