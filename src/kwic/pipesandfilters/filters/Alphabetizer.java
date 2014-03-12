/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.pipesandfilters.filters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Petr Kalivoda
 */
public class Alphabetizer extends Filter {
    
    List<String> contents = new ArrayList<String>();
    
    @Override
    public void run() {
        String line;
        
        while((line = read()) instanceof String) {
            contents.add(line);
        }
        
        Collections.sort(contents);
        
        for(String s : contents) {
            write(s);
        }
        
        done();
    }
    
}
