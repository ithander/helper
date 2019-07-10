package org.ithang.tools.gener;

import java.lang.reflect.Field;

public class ModelSQL {

	private Class<?> cls;
	private Field[] fields;
	
	
	private volatile String tableName;
	private volatile String[] columnNames;
	private volatile String[] fieldNames;
	private volatile String[] primaryFieldNames;
	
	
	public ModelSQL(Class<?> cls){
		setCls(cls);
		setFields(cls.getDeclaredFields());
		tableName=MateTool.getTableName(this);
		fieldNames=MateTool.getFieldNames(this);
		columnNames=MateTool.getColumnNames(this);
		primaryFieldNames=MateTool.getPrimaryFieldNames(this);
	}

	
	public String getTableName(){
		if(null==tableName){
			tableName=MateTool.getTableName(this);
		}
		return tableName;
	}
	
	public String[] getPrimaryFieldNames(){
		if(null==primaryFieldNames||0==primaryFieldNames.length){
			primaryFieldNames=MateTool.getPrimaryFieldNames(this);
		}
		return primaryFieldNames;
	}
	
	public String[] getFieldNames(){
		if(null==fieldNames||0==fieldNames.length){
			fieldNames=MateTool.getFieldNames(this);
		}
		return fieldNames;
	}
	
	public String[] getColumnNames(){
		if(null==columnNames||0==columnNames.length){
			columnNames=MateTool.getColumnNames(this);
		}
		return columnNames;
	}
	
	public String getColumnName(String fieldName){
		if(null!=fieldName&&fieldName.trim().length()>0){
			return MateTool.getColumnName(this, fieldName);
		}
		return null;
	}
	
	public Field getField(String fieldName) {
		if(null!=fields&&fields.length>0){
			for(Field field:fields){
				if(fieldName.equals(field.getName())){
					return field;
				}
			}
		}
		return null;
	}
	
	public Field[] getFields() {
		return fields;
	}

	public void setFields(Field[] fields) {
		this.fields = fields;
	}

	public Class<?> getCls() {
		return cls;
	}

	public void setCls(Class<?> cls) {
		this.cls = cls;
	}
	
	
}
