/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.servlet;

import com.library.controller.ManagerController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Данил
 */
@WebServlet("/Manager")
public class ManagerServlet extends HttpServlet {

    ManagerController managerContlroller = new ManagerController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("booklist") != null) {
            request.setAttribute("allBooks", managerContlroller.getAllBooks());
            request.getRequestDispatcher("/manager/manager.jsp").forward(request, response);
        } else if (request.getParameter("delete") != null) {
            managerContlroller.deleteBook(request.getParameter("delete"));
            request.setAttribute("allBooks", managerContlroller.getAllBooks());
            request.getRequestDispatcher("/manager/manager.jsp").forward(request, response);
        } else if (request.getParameter("alter") != null) {
            request.setAttribute("bookToChange", managerContlroller.getBookById(Integer.parseInt(request.getParameter("alter"))));
            request.setAttribute("genres", managerContlroller.getAllGenres());
            request.setAttribute("authors", managerContlroller.getAllAuthors());
            request.getRequestDispatcher("/manager/alterbook.jsp").forward(request, response);
        } else if (request.getParameter("search") != null) {
            request.setAttribute("allBooks", managerContlroller.getBooksByNameOrAuthor(request));
            request.getRequestDispatcher("/manager/manager.jsp").forward(request, response);
        } else if (request.getParameter("genres") != null) {
            request.setAttribute("allBooks", managerContlroller.getBooksByGenre(request.getParameter("genre")));
            request.getRequestDispatcher("/manager/manager.jsp").forward(request, response);
        } else if (request.getParameter("addNewBook") != null) {
            request.setAttribute("genres", managerContlroller.getAllGenres());
            request.setAttribute("authors", managerContlroller.getAllAuthors());
            request.getRequestDispatcher("/manager/newbook.jsp").forward(request, response);
        } else if (request.getPart("doAlter") != null) {
            managerContlroller.alterBook(request);
            request.setAttribute("allBooks", managerContlroller.getAllBooks());
            request.getRequestDispatcher("/manager/manager.jsp").forward(request, response);
        }else if (request.getPart("doAddNewBook") != null) {
            managerContlroller.addBook(request);
            request.setAttribute("allBooks", managerContlroller.getAllBooks());
            request.getRequestDispatcher("/manager/manager.jsp").forward(request, response);
        }

    }

}
