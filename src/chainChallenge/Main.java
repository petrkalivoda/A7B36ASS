/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainChallenge;

import chainChallenge.filters.Application;
import chainChallenge.filters.Filter;
import chainChallenge.filters.Internet;
import chainChallenge.filters.Link;
import chainChallenge.filters.Transport;

/**
 *
 * @author Petr Kalivoda
 */
public class Main {
    public static void main(String[] args) {
        Filter application = new Application("Marcel");
        Filter transport = new Transport(1);
        Filter internet = new Internet(1);
        Link link = new Link(1);
        
        application.setNext(transport);
        transport.setNext(internet);
        internet.setNext(link);
        
        application.mux("Hello, world!");
        System.out.println("---------------");
        link.recv("MAC2:IP3:Port8:From Frantisek> Hello, world!");
    }
}
