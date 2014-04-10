/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.events;

import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Petr Kalivoda
 */
public class Alphabetizer implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals(ObservableList.Event.ADD)) {
            List<String> l = (List<String>) o;
            Collections.sort(l);
        }
    }
    
}
