/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.controller;

import com.library.entitye.Book;
import com.library.entitye.BookRental;
import com.library.entitye.Genre;
import com.library.entitye.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Данил
 */
public class ReaderController extends LookupFacade {

    public List<Genre> getAllGenres() {
        return genreFacade.findAll();
    }

    public List<Book> getBooksByGenre(String genre, HttpSession se) {
        List<Book> allBooks = getAllBooks(se.getAttribute("id_reader"));
        List<Book> resBooks = new ArrayList<>();
        allBooks.stream().filter((b) -> 
                (b.getGenre().getId() == Integer.parseInt(genre))).forEachOrdered((b) -> {
            resBooks.add(b);
        });
        return resBooks;
    }

    public List<Book> getBookSelection(String subStr, String type, HttpSession se) {
        List<Book> allBooks = getAllBooks(se.getAttribute("id_reader"));
        List<Book> resBooks = new ArrayList<>();
        if (type.equals("name")) {
            allBooks.stream().filter((b) -> (b.getName().toLowerCase().lastIndexOf(subStr.toLowerCase()) != -1)).forEachOrdered((b) -> {
                resBooks.add(b);
            });
        } else {
            allBooks.stream().filter((b) -> (b.getAuthor().getSurname().toLowerCase().lastIndexOf(subStr.toLowerCase()) != -1)).forEachOrdered((b) -> {
                resBooks.add(b);
            });
        }
        return resBooks;
    }

    public List<Book> getAllBooks(Object idr) {
        List<Book> books = bookFacade.findAll();
        List<BookRental> bookRentals = getApplicationsPending(idr);
        List<BookRental> bookRentals1 = getApplicationsProcessed(idr);
        bookRentals.forEach((br) -> {
            books.remove(br.getIdBook());
        });
        bookRentals1.forEach((br) -> {
            books.remove(br.getIdBook());
        });
        return books;
    }

    public String getReaderName(Object idr) {
        int idReader = (int) idr;
        User user = userFacade.find(idReader);
        return user.getFullName();
    }

    public void addBookRental(int readerId, int bookId) {
        Date date = new Date();
        bookRentalFacade.create(new BookRental(userFacade.find(readerId), bookFacade.find(bookId), date));
    }

    public void removeBookRental(int rentalId) {

        bookRentalFacade.remove(bookRentalFacade.find(rentalId));
    }

    public List<BookRental> getApplicationsPending(Object rid) {
        int readerId = (Integer) rid;
        List<BookRental> resultBookRental = new ArrayList<>();

        List<BookRental> allBookRental = bookRentalFacade.findAll();
        allBookRental.stream().filter((br) -> (br.getIdReader().getId() == readerId && br.getStatus() == null)).forEachOrdered((br) -> {
            resultBookRental.add(br);
        });

        return resultBookRental;
    }

    public List<BookRental> getApplicationsProcessed(Object rid) {
        int readerId = (Integer) rid;
        List<BookRental> resultBookRental = new ArrayList<>();

        List<BookRental> allBookRental = bookRentalFacade.findAll();
        allBookRental.stream().filter((br) -> (br.getIdReader().getId() == readerId && br.getStatus() != null)).forEachOrdered((br) -> {
            resultBookRental.add(br);
        });

        return resultBookRental;
    }

}
