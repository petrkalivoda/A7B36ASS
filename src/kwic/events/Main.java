/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.events;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Petr Kalivoda
 */
public class Main {
    public static void main(String[] args) throws IOException {
        
        ObservableList<String> lines = new ObservableList<>(new ArrayList<String>());
        ObservableList<String> shifts = new ObservableList<>(new ArrayList<String>());
        Input i = new Input(lines, new FileInputStream("src/kwic/events/input.txt"));
        Output o = new Output(shifts);
        
        lines.addObserver(new CircularShifter(shifts));
        shifts.addObserver(new Alphabetizer());
        
        i.parse();
        o.write();
    }
}
