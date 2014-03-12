/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.pipesandfilters.filters;

import kwic.pipesandfilters.pipes.Pipe;

/**
 *
 * @author Petr Kalivoda
 */
public abstract class Filter implements Runnable {
    
    private Pipe source, destination;
    
    protected String read() {
        return source.read();
    }
    
    protected void write(String s) {
        destination.write(s);
    }
    
    public void setSource(Pipe p) {
        source = p;
    }
    
    public void setDestination(Pipe p) {
        destination = p;
    }
    
    protected void done() {
        if(destination instanceof Pipe) {
            destination.close();
        }
    }
}
