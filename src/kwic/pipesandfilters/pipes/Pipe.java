/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kwic.pipesandfilters.pipes;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Petr Kalivoda
 */
public class Pipe {
    
    private Queue<String> queue = new ConcurrentLinkedQueue<String>();
    private boolean closed = false;
    
    public void write(String s) {
        queue.add(s);
    }
    
    public String read() {
        if(closed && queue.isEmpty()) {
            return null;
        }
        
        while(true) {
            if(queue.isEmpty()) {
                try {
                    Thread.sleep(50);
                    
                }catch(InterruptedException e) {
                    System.err.println("Interrupted.");
                    System.exit(1);
                }
                
            }else {
                return queue.poll();
            }
        }
    }
    
    public void close() {
        closed = true;
    }
    
}
