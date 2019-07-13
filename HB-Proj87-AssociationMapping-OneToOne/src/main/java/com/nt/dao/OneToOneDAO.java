package com.nt.dao;

public interface OneToOneDAO {
	public void saveDataUsingParent();
	public void saveDataUsingChild();
	public void loadData();
	public void deleteFromParentToChild();
}
