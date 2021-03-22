/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.servlet;

import com.library.entitye.BookContent;
import com.library.facades.BookContentFacade;
import com.library.facades.BookFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.List;
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
@WebServlet("/PDF")
public class PDFServlet extends HttpServlet {

    BookContentFacade bookContentFacade = lookupBookContentFacadeBean();

    BookFacade bookFacade = lookupBookFacadeBean();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("read"));
        List<BookContent> abc = bookContentFacade.findAll();
        BookContent bc = abc.stream().filter(b -> b.getBookId() == id).findFirst().get();
        byte[] content = bc.getContent();
        File file = new File("temp.pdf");
        file.createNewFile();
        OutputStream out = new FileOutputStream(file);
        out.write(content);
        out.close();
        response.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"temp.pdf\"");
        Files.copy(file.toPath(), response.getOutputStream());
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
