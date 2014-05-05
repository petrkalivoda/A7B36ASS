/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitorChallenge;

import visitorChallenge.exception.AuthorizationException;
import visitorChallenge.exception.BusinessException;
import visitorChallenge.exception.BusinessRuleViolation;
import visitorChallenge.exception.DuplicateEntityViolation;
import visitorChallenge.exception.SearchException;
import visitorChallenge.exception.ServiceException;
import visitorChallenge.exception.SystemError;

/**
 *
 * @author Petr Kalivoda
 */
public class ExceptionVisitor {

    public void visit(SystemError e) {
        System.err.println("Unexpected error" + e.getErrorName() + " " + e.getType());
    }

    public void visit(SearchException e) {
        System.err.println(e.getErrorName() + " " + e.getMessage());
        e.printStackTrace();
    }

    public void visit(DuplicateEntityViolation e) {
        System.err.println(e.getErrorName() + " " + e.getDuplicatedEntity().getName());
        e.printStackTrace();
    }

    public void visit(BusinessRuleViolation e) {
        System.err.println(e.getErrorName() + " " + e.getBusinessRuleViolated() + " " + e.getCauser().getClass().getSimpleName());
        e.printStackTrace();
    }

    public void visit(AuthorizationException e) {
        System.err.println(e.getErrorName() + " " + e.getType());
        e.printStackTrace();
    }
}
