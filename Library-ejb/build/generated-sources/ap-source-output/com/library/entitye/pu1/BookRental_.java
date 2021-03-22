package com.library.entitye.pu1;

import com.library.entitye.Book;
import com.library.entitye.BookRental;
import com.library.entitye.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-13T23:48:19")
@StaticMetamodel(BookRental.class)
public class BookRental_ { 

    public static volatile SingularAttribute<BookRental, Integer> idEmployeer;
    public static volatile SingularAttribute<BookRental, Date> returnDate;
    public static volatile SingularAttribute<BookRental, Date> processingDate;
    public static volatile SingularAttribute<BookRental, Book> idBook;
    public static volatile SingularAttribute<BookRental, User> idReader;
    public static volatile SingularAttribute<BookRental, Integer> id;
    public static volatile SingularAttribute<BookRental, Date> issueDate;
    public static volatile SingularAttribute<BookRental, Short> status;

}