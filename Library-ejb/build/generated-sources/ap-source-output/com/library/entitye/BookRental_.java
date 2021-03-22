package com.library.entitye;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BookRental.class)
public abstract class BookRental_ {

	public static volatile SingularAttribute<BookRental, Integer> idEmployeer;
	public static volatile SingularAttribute<BookRental, Date> returnDate;
	public static volatile SingularAttribute<BookRental, Date> processingDate;
	public static volatile SingularAttribute<BookRental, Book> idBook;
	public static volatile SingularAttribute<BookRental, User> idReader;
	public static volatile SingularAttribute<BookRental, Integer> id;
	public static volatile SingularAttribute<BookRental, Date> issueDate;
	public static volatile SingularAttribute<BookRental, Short> status;

}

