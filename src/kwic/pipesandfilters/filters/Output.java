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
public class Output extends Filter {
    
    @Override
    public void run() {
        String line;
        while((line = read()) instanceof String) { //inf not - pipe is closed
            System.out.println(line);
        }
    }
    
}
