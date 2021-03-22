package com.library.entitye.pu1;

import com.library.entitye.Author;
import com.library.entitye.Book;
import com.library.entitye.Genre;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-13T23:48:19")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, byte[]> image;
    public static volatile SingularAttribute<Book, String> year;
    public static volatile SingularAttribute<Book, Author> author;
    public static volatile SingularAttribute<Book, String> publish;
    public static volatile SingularAttribute<Book, String> name;
    public static volatile SingularAttribute<Book, Genre> genre;
    public static volatile SingularAttribute<Book, Integer> id;

}