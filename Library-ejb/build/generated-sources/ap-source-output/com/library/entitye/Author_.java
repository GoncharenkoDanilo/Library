package com.library.entitye;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Author.class)
public abstract class Author_ {

	public static volatile SingularAttribute<Author, Date> birthday;
	public static volatile SingularAttribute<Author, Date> death;
	public static volatile SingularAttribute<Author, String> surname;
	public static volatile SingularAttribute<Author, String> name;
	public static volatile SingularAttribute<Author, Integer> id;

}

