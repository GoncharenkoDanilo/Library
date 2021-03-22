/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.controller;

import com.library.entitye.User;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Данил
 */
public class RegistrationController extends LookupFacade {

    public void addNewReader(HttpServletRequest request) throws ParseException {

        String test = request.getParameter("birthday");
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        User newUser = new User(request.getParameter("fullname"),
                request.getParameter("address"),
                request.getParameter("phone"),
                format.parse(request.getParameter("birthday")),
                0,
                request.getParameter("login"),
                request.getParameter("password"));
        userFacade.create(newUser);
    }
}
