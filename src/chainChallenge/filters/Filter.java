/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainChallenge.filters;

/**
 *
 * @author Petr Kalivoda
 */
abstract public class Filter {

    protected Filter next;
    protected Filter prev;

    public void setNext(Filter f) {
        next = f;
        f.setPrev(this);
    }
    
    protected void setPrev(Filter f) {
        prev = f;
    }
    
    abstract public void mux(String s);
    abstract public void demux(String s);

}
