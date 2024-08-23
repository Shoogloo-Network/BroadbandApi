package com.bb.controller.helper;

import java.io.Serializable;

import jakarta.persistence.Id;


public class Search implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	String entityName;
	String fieldName;
	Object value;
	String operator ;
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}