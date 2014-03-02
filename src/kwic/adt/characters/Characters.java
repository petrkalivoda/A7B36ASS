/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.adt.characters;

/**
 *
 * @author Petr Kalivoda
 */
public interface Characters extends Iterable<String> {
    
    public void addLine(String line);
}
