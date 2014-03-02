/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.adt.alphabetizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kwic.adt.circular_shifter.CircularShifter;


public class DefaultAlphabetizer implements Alphabetizer {
    
    protected List<String> alphabetized = new ArrayList<String>();

    @Override
    public void alphabetize(CircularShifter c) {
        for(String line : c) {
            alphabetized.add(line);
        }
        
        Collections.sort(alphabetized);
    }

    @Override
    public Iterator<String> iterator() {
        return Collections.unmodifiableList(alphabetized).iterator();
    }
    
}
