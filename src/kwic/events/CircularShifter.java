/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwic.events;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Petr Kalivoda
 */
public class CircularShifter implements Observer {

    private List<String> storage;

    public CircularShifter(List<String> storage) {
        this.storage = storage;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals(ObservableList.Event.ADD)) {
            List<String> l = (List) o;
            shift(l.get(l.size() - 1));
        }
    }

    private void shift(String s) {
        String[] words = s.split("\\s");
        for (int i = 0; i < words.length; i++) {
            StringBuilder shiftedLine = new StringBuilder();

            for (int j = i; j < (words.length + i); j++) {
                if (shiftedLine.length() > 0) {
                    shiftedLine.append(" ");
                }

                shiftedLine.append(words[j % words.length]);
            }
            storage.add(shiftedLine.toString());
        }
    }
}
