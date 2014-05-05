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
public class Application extends Filter {
    
    private final String username;
    
    public Application(String username) {
        this.username = username;
    }

    @Override
    public void mux(String s) {
        String message = "From " + username + "> " + s;
        System.out.println(message);
        
        if(next instanceof Filter) {
            next.mux(message);
        }
    }

    @Override
    public void demux(String s) {
       print(s.replaceAll("^From \\S+>\\s", ""));
    }
    
    protected void print(String s) {
        System.out.println(s);
    }
    
    @Override
    public void setPrev(Filter f) {
        throw new UnsupportedOperationException("This is an endpoint.");
    }
    
}
