/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.controller;

import com.library.entitye.BookRental;
import com.library.entitye.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Данил
 */
public class LibraryanController extends LookupFacade {

    public List<BookRental> getAllOrders() {
        List<BookRental> resultOrders = new ArrayList<>();
        List<BookRental> allOrders = bookRentalFacade.findAll();
        allOrders.stream().filter((o) -> (o.getStatus() == null)).forEachOrdered((o) -> {
            resultOrders.add(o);
        });
        return resultOrders;
    }

    public List<User> getAllReaders() {
        List<User> allUsers = userFacade.findAll();
        List<User> allReaders = new ArrayList<>();
        allUsers.stream().filter((u) -> (u.getType() == 0)).forEachOrdered((u) -> {
            allReaders.add(u);
        });

        return allReaders;
    }

    public User getReaderInfo(String id) {
        return userFacade.find(Integer.parseInt(id));
    }

    public List<BookRental> getAllDebt(String id) {
        int readerId = Integer.parseInt(id);
        List<BookRental> resultBookRental = new ArrayList<>();
        List<BookRental> allBookRental = bookRentalFacade.findAll();
        allBookRental.stream().filter((br) -> (br.getIdReader().getId() == readerId && br.getStatus() != null)).forEachOrdered((br) -> {
            resultBookRental.add(br);
        });

        return resultBookRental;
    }

    public void changeBookRental(Integer id, Short status, HttpSession se) {

        Date date = new Date();
        BookRental ebr = bookRentalFacade.find(id);
        ebr.setIdEmployeer((Integer) se.getAttribute("id_reader"));
        ebr.setProcessingDate(date);
        ebr.setStatus(status);
        bookRentalFacade.edit(ebr);
    }

    public List<User> getAllUsers() {
        return userFacade.findAll();
    }
}
