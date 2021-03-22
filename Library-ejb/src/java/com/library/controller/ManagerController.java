/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.controller;

import com.library.entitye.Author;
import com.library.entitye.Book;
import com.library.entitye.Genre;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author Данил
 */
public class ManagerController extends LookupFacade {

    public List<Book> getBooksByNameOrAuthor(HttpServletRequest request) {
        String type = request.getParameter("type");
        String substr = request.getParameter("searchRequest");
        if (type.equals("name")) {
            return bookFacade.findAll().stream().filter(b -> b.getName().toLowerCase().lastIndexOf(substr.toLowerCase()) != -1).collect(Collectors.toList());
        } else {
            return bookFacade.findAll().stream().filter(b -> b.getAuthor().getSurname().toLowerCase().lastIndexOf(substr.toLowerCase()) != -1).collect(Collectors.toList());
        }
    }

    public List<Author> getAllAuthors() {
        return authorFacade.findAll();
    }

    public List<Genre> getAllGenres() {
        return genreFacade.findAll();
    }

    public List<Book> getAllBooks() {
        return bookFacade.findAll();
    }

    public void deleteBook(Object id) {
        bookFacade.remove(bookFacade.find(id));
    }

    public Book getBookById(Object id) {
        return bookFacade.find(id);
    }

    public void alterBook(HttpServletRequest request) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        Book book = bookFacade.find(Integer.parseInt(request.getParameter("id")));
        book.setAuthor(authorFacade.find(Integer.parseInt(request.getParameter("author"))));
        book.setGenre(genreFacade.find(Integer.parseInt(request.getParameter("genre"))));
        book.setName(request.getPart("name").toString());
        book.setYear(request.getParameter("year"));

        Part filePart = request.getPart("image");
        if (filePart != null) {
            InputStream is = filePart.getInputStream();
            byte[] image = new byte[is.available()];
            is.read(image);
            book.setImage(image);
        }
        bookFacade.edit(book);
    }

    public List<Book> getBooksByGenre(String genreId) {
        Integer id = Integer.parseInt(genreId);
        return bookFacade.findAll().stream().filter(b -> b.getGenre().getId().equals(id)).collect(Collectors.toList());
    }

    public void addBook(HttpServletRequest request) throws IOException, ServletException {
        Part filePart = request.getPart("image");
        byte[] image = null;
        if (filePart != null) {
            InputStream is = filePart.getInputStream();
            image = new byte[is.available()];
            is.read(image);
        }

        Book book = new Book(request.getPart("name").toString(),
                authorFacade.find(Integer.parseInt(request.getParameter("author"))),
                genreFacade.find(Integer.parseInt(request.getParameter("genre"))),
                request.getParameter("year"),
                request.getParameter("publish"),
                image);

        bookFacade.create(book);
    }

}
