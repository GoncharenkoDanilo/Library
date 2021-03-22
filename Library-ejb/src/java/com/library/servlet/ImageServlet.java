/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.servlet;

import com.library.facades.BookFacade;
import java.io.IOException;
import java.io.OutputStream;
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

/**
 *
 * @author Данил
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {

    BookFacade bookFacade = lookupBookFacadeBean();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        byte[] image = bookFacade.find(Integer.parseInt(request.getParameter("id"))).getImage();
        response.setContentType("image/jpg");
        response.setContentLength(image.length);
        OutputStream o = response.getOutputStream();
        o.write(image);
        o.flush();
        o.close();
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
