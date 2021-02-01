package com.leiskies.app.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractModelDAO<T,PK> implements InterfaceModelDAO<T,PK> {
 
	protected static PreparedStatement preparedStatement = null;
	protected Connection connection = null;
	protected static Statement statement = null;
	protected static ResultSet resultSet = null;
	
	protected static Integer rowsInserted = null;
	protected Field[] fields = null;
	protected static String sql = null;
	protected Class<T> entityClass;
	protected T t = null; 
	
	public AbstractModelDAO(final Class<T> entityClass) {
		this.entityClass = entityClass;
		List<Field> fieldsList = new ArrayList<Field>();
		if(getEntityClass().getDeclaredFields().length==0) {
			Arrays.asList(getEntityClass().getSuperclass().getDeclaredFields())
			.stream().forEach(field->fieldsList.add(field));;
		}	else {
			fields = getEntityClass().getDeclaredFields();
		}
	}
	
	public Class<T> getEntityClass() {
		return entityClass;
	}
	
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
