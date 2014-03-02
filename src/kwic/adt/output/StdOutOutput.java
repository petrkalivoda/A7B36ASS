/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.adt.output;

import kwic.adt.alphabetizer.Alphabetizer;


public class StdOutOutput implements Output {

    @Override
    public void print(Alphabetizer a) {
        for(String line : a) {
            System.out.println(line);
        }
    }
    
}
