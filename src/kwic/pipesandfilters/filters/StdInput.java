/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.pipesandfilters.filters;

import java.io.InputStreamReader;

/**
 *
 * @author Petr Kalivoda
 */
public class StdInput extends Input {
    
    public StdInput() {
        super(new InputStreamReader(System.in));
    }
}
