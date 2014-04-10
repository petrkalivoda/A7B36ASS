/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwic.events;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author Petr Kalivoda
 */
public class Input {

    private List<String> storage;
    private InputStream source;

    public Input(List<String> storage, InputStream source) {
        this.storage = storage;
        this.source = source;
    }

    public void parse() {
        BufferedReader br = new BufferedReader(new InputStreamReader(source));
        String s;

        try {
            while ((s = br.readLine()) instanceof String) {
                storage.add(s);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
