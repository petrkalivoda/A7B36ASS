/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.pipesandfilters;

import java.io.File;
import java.io.IOException;
import kwic.pipesandfilters.filters.Alphabetizer;
import kwic.pipesandfilters.filters.CircularShifter;
import kwic.pipesandfilters.filters.FileInput;
import kwic.pipesandfilters.filters.Filter;
import kwic.pipesandfilters.filters.Output;
import kwic.pipesandfilters.pipes.FilterChain;

/**
 *
 * @author Petr Kalivoda
 */
public class Main {
    public static void main(String[] args) throws IOException{
        
        //Filter input = new StdInput();
        Filter input = new FileInput(new File("src/kwic/pipesandfilters/input.txt"));
        Filter shifter = new CircularShifter();
        Filter alphabetizer = new Alphabetizer();
        Filter output = new Output();
        
        FilterChain f = new FilterChain(input, shifter, alphabetizer, output);
        f.execute();
    }
}
