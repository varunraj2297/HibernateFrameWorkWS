package com.nt.dao;

public interface OneToManyDAO {
	public void saveDataThroughParent();
	public void saveDataThroughChild();
	public void loadDataUsingParentToChild();
	public void loadDataUsingChildToParent();
	public void loadDataUsingStreamAPI();
	public void loadDataUsingParentByUserId(int userId);
	public void deleteDataUsingParentByUserId(int userId);
	public void deleteAllChildsOfAParentByUserId(int userId);
	public void deleteOneChildfromCollectionOfChildsOfAParentByUserId(int userId);
}
