/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.servlet;

import com.library.controller.LibraryanController;
import com.library.entitye.BookRental;
import com.library.entitye.User;
import com.library.facades.BookRentalFacade;
import com.library.facades.UserFacade;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Данил
 */
@WebServlet("/Libraryan")
public class LibraryanServlet extends HttpServlet {

    LibraryanController libraryanController = new LibraryanController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("ok") != null) {
            libraryanController.changeBookRental(Integer.parseInt(request.getParameter("ok")), new Short("1"), request.getSession());
        } else if (request.getParameter("cancel") != null) {
            libraryanController.changeBookRental(Integer.parseInt(request.getParameter("cancel")), new Short("0"), request.getSession());
        } else if (request.getParameter("readerlist") != null) {
            request.setAttribute("users", libraryanController.getAllUsers());
            request.getRequestDispatcher("/libraryan/listofreaders.jsp").forward(request, response);
        } else if (request.getParameter("exit") != null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (request.getParameter("libraryan") != null) {
            request.getRequestDispatcher("/libraryan/libraryan.jsp").forward(request, response);
        }

        request.getRequestDispatcher("/libraryan/libraryan.jsp").forward(request, response);
    }

}
