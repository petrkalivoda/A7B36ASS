/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.adt.circular_shifter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kwic.adt.characters.Characters;


public class SimpleCircularShifter implements CircularShifter {
       
    protected List<String> shifts = new ArrayList<String>();
    
    @Override
    public void setup(Characters chr) {
        String[] words;
        StringBuilder shiftedLine;
        
        for(String line : chr) {
            words = line.split("\\s");
            for (int i = 0; i < words.length; i++) {
                shiftedLine = new StringBuilder();
                
                for (int j = i; j < (words.length + i); j++) {
                    if(shiftedLine.length() > 0) {
                        shiftedLine.append(" ");
                    }
                    
                    shiftedLine.append(words[j % words.length]);
                }
                shifts.add(shiftedLine.toString());
            }
        }
    }    

    @Override
    public Iterator<String> iterator() {
        return Collections.unmodifiableList(shifts).iterator();
    }
}
