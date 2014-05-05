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
public class Internet extends Filter {
    
    private final int ip;
    
    public Internet(int ip) {
        this.ip = ip;;
    }
 
    @Override
    public void mux(String s) {
        String message = "IP"+ip+":" + s;
        System.out.println(message);
        
        if(next instanceof Filter) {
            next.mux(message);
        }
    }

    @Override
    public void demux(String s) {
        String message = s.replaceAll("^IP\\d+:", "");
        System.out.println(message);
        
        if(prev instanceof Filter) {
            prev.demux(message);
        }
    }
    
}
