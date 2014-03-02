/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.adt;

import java.io.File;
import kwic.adt.alphabetizer.Alphabetizer;
import kwic.adt.alphabetizer.DefaultAlphabetizer;
import kwic.adt.characters.Characters;
import kwic.adt.circular_shifter.CircularShifter;
import kwic.adt.circular_shifter.SimpleCircularShifter;
import kwic.adt.input.FileInput;
import kwic.adt.input.Input;
import kwic.adt.output.Output;
import kwic.adt.output.StdOutOutput;

/**
 *
 * @author Petr Kalivoda
 */
public class Main {
    
    public static void main(String[] args) {
        Input i = new FileInput(new File(/*args[0]*/ "src/kwic/adt/input.txt"));
        Characters ch = i.parse();
        
        CircularShifter cs = new SimpleCircularShifter();
        cs.setup(ch);
        
        Alphabetizer a = new DefaultAlphabetizer();
        a.alphabetize(cs);
        
        Output o = new StdOutOutput();
        o.print(a);
    }
    
    
}
