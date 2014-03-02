/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.adt.characters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class CharacterStorage implements Characters {
    
    protected List<String> lines = new ArrayList<String>();

    @Override
    public void addLine(String line) {
        lines.add(line);
    }

    public Iterator<String> iterator() {
        return Collections.unmodifiableList(lines).iterator();
    }
}
