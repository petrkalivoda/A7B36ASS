/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kwic.pipesandfilters.filters;

import kwic.pipesandfilters.pipes.FilterChain;
import kwic.pipesandfilters.pipes.Pipe;

/**
 *
 * @author Petr Kalivoda
 */
public abstract class Filter implements Runnable, ChainableFilter {

    private Pipe source, destination;
    private FilterChain chain;

    @Override
    public void setChain(FilterChain fc) {
        chain = fc;
    }

    @Override
    public final void run() {
        if (chain instanceof FilterChain) {
            chain.childStarted();
            try {
                synchronized(chain) {
                    chain.wait();
                }

            } catch (InterruptedException e) {
                System.err.println("Interrupted.");
                System.exit(1);
            }
        }

        perform();
        done();
    }

    abstract void perform();

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
        if (destination instanceof Pipe) {
            destination.close();
        }
    }
}
