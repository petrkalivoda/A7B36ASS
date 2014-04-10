/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.events;

import java.util.List;

/**
 *
 * @author Petr Kalivoda
 */
public class Output {
    
    private List<String> storage;
    
    public Output(List<String> storage) {
        this.storage = storage;
    }
    
    public void write() {
        for(String s : storage) {
            System.out.println(s);
        }
    }
}
