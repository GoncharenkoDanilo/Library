/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.validator;
import com.library.entitye.User;
import java.util.List;

/**
 *
 * @author Данил
 */

public class LoginValidator{

    public User userIsRegistered(List<User> ull, String login, String password)
    {
        for(User ul : ull)
            if (ul.getLogin().equals(login) && ul.getPassword().equals(password))
                return ul;
        return null;
    }

}
