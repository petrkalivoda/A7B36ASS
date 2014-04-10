/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.pipesandfilters.filters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Petr Kalivoda
 */
abstract class Input extends Filter {
    
    private Reader input;
    
    public Input(Reader in) {
        input = in;
    }
    
    @Override
    public void perform() {
        try {
            BufferedReader br = new BufferedReader(input);
            String line;
            
            while((line = br.readLine()) instanceof String) {
                write(line);
            }
            
            done(); //not needed anymore
            
        }catch(IOException e) {
            System.err.println("I/O error.");
            System.exit(1);
        }
    }
}
