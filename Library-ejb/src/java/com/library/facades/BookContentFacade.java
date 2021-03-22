/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.facades;

import com.library.entitye.BookContent;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Данил
 */
@Stateless
public class BookContentFacade extends AbstractFacade<BookContent> {

    @PersistenceContext(unitName = "Library-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookContentFacade() {
        super(BookContent.class);
    }
    
}
