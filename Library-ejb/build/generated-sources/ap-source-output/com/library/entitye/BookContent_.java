package com.library.entitye;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BookContent.class)
public abstract class BookContent_ {

	public static volatile SingularAttribute<BookContent, Integer> id;
	public static volatile SingularAttribute<BookContent, byte[]> content;
	public static volatile SingularAttribute<BookContent, Integer> bookId;

}

