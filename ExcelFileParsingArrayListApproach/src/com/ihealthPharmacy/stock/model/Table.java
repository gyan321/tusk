package com.ihealthPharmacy.stock.model;

public class Table {
	
	
	String tableName;
	String column;
	String type;
	int size;
	String defaults;
	String constraint;
	String primaryKey;
	String foreignKey;
	String foreignKeyTable;
	String relationShip;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getDefaults() {
		return defaults;
	}
	public void setDefaults(String defaults) {
		this.defaults = defaults;
	}
	public String getConstraint() {
		return constraint;
	}
	public void setConstraint(String constraint) {
		this.constraint = constraint;
	}
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getForeignKey() {
		return foreignKey;
	}
	public void setForeignKey(String foreignKey) {
		this.foreignKey = foreignKey;
	}
	public String getForeignKeyTable() {
		return foreignKeyTable;
	}
	public void setForeignKeyTable(String foreignKeyTable) {
		this.foreignKeyTable = foreignKeyTable;
	}
	public String getRelationShip() {
		return relationShip;
	}
	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}
	
	

}
