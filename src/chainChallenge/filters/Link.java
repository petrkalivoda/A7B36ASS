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
public class Link extends Filter{
    
    private final int mac;
    
    public Link(int mac) {
        this.mac = mac;
    }
    
    @Override
    public void setNext(Filter f) {
        throw new UnsupportedOperationException("This is an endpoint.");
    }

    @Override
    public void mux(String s) {
        String message = "MAC"+mac+":"+s;
        send(message);
    }
    
    protected void send(String s) {
        System.out.println(s);
    }

    @Override
    public void demux(String s) {
        throw new UnsupportedOperationException("This is an endpoint.");
    }
    
    public void recv(String s) {
        String message = s.replaceAll("^MAC\\d+:", "");
        System.out.println(message);
        
        if(prev instanceof Filter) {
            prev.demux(message);
        }
    }
     
}
