/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.pipesandfilters.pipes;

import kwic.pipesandfilters.filters.Filter;

/**
 *
 * @author Petr Kalivoda
 */
public class FilterChain { //zaridit, at filtry nedelaji nic dokud je nezavolam vsechny
    
    Filter[] filters;
    int runningChildren = 0;
    
    public FilterChain(Filter ... filters) {
        this.filters = filters;
        for (int i = 0; i < filters.length - 1; i++) {
            Pipe p = new Pipe();
            filters[i].setDestination(p);
            filters[i+1].setSource(p);
        }
        
    }
    
    public void execute() {
        for(Filter f : filters) {
            f.setChain(this);
            (new Thread(f)).start();
        }

        while(runningChildren != filters.length) {
            try {
                Thread.sleep(50);
                
            }catch(InterruptedException e) {
                System.err.println("Interrupted.");
                System.exit(1);
            }   
        }
        
        synchronized(this) {
            notifyAll();
        }
    }
    
    public void childStarted() {
        runningChildren++;
    }
}
