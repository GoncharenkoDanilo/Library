package com.library.entitye;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Date> birthday;
	public static volatile SingularAttribute<User, Date> endWorkDate;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> address;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SingularAttribute<User, String> fullName;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, Integer> type;
	public static volatile SingularAttribute<User, String> login;
	public static volatile SingularAttribute<User, Date> startWorkDate;

}

