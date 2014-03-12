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
import kwic.pipesandfilters.filters.StdInput;
import kwic.pipesandfilters.pipes.Pipe;

/**
 *
 * @author Petr Kalivoda
 */
public class Main {
    public static void main(String[] args) throws IOException{
        Pipe p1 = new Pipe();
        Pipe p2 = new Pipe();
        Pipe p3 = new Pipe();
        
        //Filter input = new StdInput();
        Filter input = new FileInput(new File("src/kwic/pipesandfilters/input.txt"));
        Filter shifter = new CircularShifter();
        Filter alphabetizer = new Alphabetizer();
        Filter output = new Output();
        
        input.setDestination(p1);
        
        shifter.setSource(p1);
        shifter.setDestination(p2);
        
        alphabetizer.setSource(p2);
        alphabetizer.setDestination(p3);
        
        output.setSource(p3);
        
        (new Thread(input)).start();
        (new Thread(shifter)).start();
        (new Thread(alphabetizer)).start();
        (new Thread(output)).start();
        
        
        
    }
}
