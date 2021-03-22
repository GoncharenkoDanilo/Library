/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.servlet;

import com.library.controller.ReaderController;
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
@WebServlet("/Reader")
public class ReaderServlet extends HttpServlet {

    ReaderController readerController = new ReaderController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        if (request.getParameter("choise") != null) {
            readerController.addBookRental(Integer.parseInt(request.getSession().getAttribute("id_reader").toString()),
                    Integer.parseInt(request.getParameter("choise")));
        } else if (request.getParameter("remove") != null) {
            readerController.removeBookRental(Integer.parseInt(request.getParameter("remove")));
        } else if (request.getParameter("booklist") != null) {
            request.setAttribute("allBooks", readerController.getAllBooks(request.getSession().getAttribute("id_reader")));
            request.getRequestDispatcher("/reader/booklist.jsp").forward(request, response);
            return;
        } else if (request.getParameter("search") != null) {
            request.setAttribute("allBooks", readerController.getBookSelection(request.getParameter("searchRequest"), request.getParameter("type"), request.getSession()));
            request.getRequestDispatcher("/reader/booklist.jsp").forward(request, response);
            return;
        } else if (request.getParameter("genre") != null) {
            request.setAttribute("allBooks",
                    readerController.getBooksByGenre(request.getParameter("genre"), 
                    request.getSession()));
            request.getRequestDispatcher("/reader/booklist.jsp").forward(request, response);
        } else if (request.getParameter("exit") != null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (request.getParameter("reader") != null) {
            request.getRequestDispatcher("/reader/reader.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/reader/reader.jsp").forward(request, response);
    }

}
