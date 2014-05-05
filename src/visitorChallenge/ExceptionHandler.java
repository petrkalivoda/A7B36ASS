/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visitorChallenge;

import visitorChallenge.exception.ServiceException;

/**
 *
 * @author Petr Kalivoda
 */
public class ExceptionHandler {

    public static void handle(ServiceException e) {
        ExceptionVisitor v = new ExceptionVisitor();
        e.accept(v);
    }
}
