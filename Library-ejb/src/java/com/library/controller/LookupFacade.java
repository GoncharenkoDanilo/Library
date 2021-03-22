 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.controller;

import com.library.facades.AuthorFacade;
import com.library.facades.BookContentFacade;
import com.library.facades.BookFacade;
import com.library.facades.BookRentalFacade;
import com.library.facades.GenreFacade;
import com.library.facades.UserFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Данил
 */
public abstract class LookupFacade {

    protected BookContentFacade bookContentFacade = lookupBookContentFacadeBean();
    protected BookRentalFacade bookRentalFacade = lookupBookRentalFacadeBean();
    protected UserFacade userFacade = lookupUserFacadeBean();
    protected GenreFacade genreFacade = lookupGenreFacadeBean();
    protected AuthorFacade authorFacade = lookupAuthorFacadeBean();
    protected BookFacade bookFacade = lookupBookFacadeBean();

    private BookFacade lookupBookFacadeBean() {
        try {
            Context c = new InitialContext();
            return (BookFacade) c.lookup("java:global/Library/Library-ejb/BookFacade!com.library.facades.BookFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private AuthorFacade lookupAuthorFacadeBean() {
        try {
            Context c = new InitialContext();
            return (AuthorFacade) c.lookup("java:global/Library/Library-ejb/AuthorFacade!com.library.facades.AuthorFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private GenreFacade lookupGenreFacadeBean() {
        try {
            Context c = new InitialContext();
            return (GenreFacade) c.lookup("java:global/Library/Library-ejb/GenreFacade!com.library.facades.GenreFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private UserFacade lookupUserFacadeBean() {
        try {
            Context c = new InitialContext();
            return (UserFacade) c.lookup("java:global/Library/Library-ejb/UserFacade!com.library.facades.UserFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private BookRentalFacade lookupBookRentalFacadeBean() {
        try {
            Context c = new InitialContext();
            return (BookRentalFacade) c.lookup("java:global/Library/Library-ejb/BookRentalFacade!com.library.facades.BookRentalFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private BookContentFacade lookupBookContentFacadeBean() {
        try {
            Context c = new InitialContext();
            return (BookContentFacade) c.lookup("java:global/Library/Library-ejb/BookContentFacade!com.library.facades.BookContentFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
