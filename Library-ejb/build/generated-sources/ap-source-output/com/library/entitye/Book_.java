package com.library.entitye;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, byte[]> image;
	public static volatile SingularAttribute<Book, String> year;
	public static volatile SingularAttribute<Book, Author> author;
	public static volatile SingularAttribute<Book, String> publish;
	public static volatile SingularAttribute<Book, String> name;
	public static volatile SingularAttribute<Book, Genre> genre;
	public static volatile SingularAttribute<Book, Integer> id;

}

