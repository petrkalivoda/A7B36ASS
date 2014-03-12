/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.pipesandfilters.filters;

/**
 *
 * @author Petr Kalivoda
 */
public class CircularShifter extends Filter {
    
    @Override
    public void run() {
        String[] words;
        StringBuilder shiftedLine;
        String line;
        
        while((line = read()) instanceof String) {
            words = line.split("\\s");
            for (int i = 0; i < words.length; i++) {
                shiftedLine = new StringBuilder();
                
                for (int j = i; j < (words.length + i); j++) {
                    if(shiftedLine.length() > 0) {
                        shiftedLine.append(" ");
                    }
                    
                    shiftedLine.append(words[j % words.length]);
                }
                write(shiftedLine.toString());
            }
        }
        
        done();
    }
    
}
