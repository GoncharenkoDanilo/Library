/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.session;

import com.library.entitye.User;
import com.library.facades.BookFacade;
import com.library.facades.UserFacade;
import com.library.validator.LoginValidator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Данил
 */
@WebServlet("/Session")
public class SessionServlet extends HttpServlet {

    BookFacade bookFacade = lookupBookFacadeBean();
    UserFacade userFacade = lookupUserFacadeBean();
    User user;
    HttpSession se;
    LoginValidator lv = new LoginValidator();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        user = lv.userIsRegistered(userFacade.findAll(), request.getParameter("login"), request.getParameter("password"));
        if (request.getParameter("submit") != null) {

            if (!user.equals(null)) {
                se = request.getSession(true);
                se.setAttribute("id_reader", user.getId());
                se.setAttribute("user", user);
                if (user.getType() == 0) {
                    request.getRequestDispatcher("/reader/reader.jsp").forward(request, response);
                } else if (user.getType() == 1) {
                    request.getRequestDispatcher("/libraryan/libraryan.jsp").forward(request, response);
                } else if (user.getType() == 2) {
                    request.setAttribute("allBooks", bookFacade.findAll());
                    request.getRequestDispatcher("/manager/manager.jsp").forward(request, response);
                }
            }
        } else if (request.getParameter("registration") != null) {
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }

    }

    public int getUserId() {
        return user.getId();
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

    private BookFacade lookupBookFacadeBean() {
        try {
            Context c = new InitialContext();
            return (BookFacade) c.lookup("java:global/Library/Library-ejb/BookFacade!com.library.facades.BookFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
