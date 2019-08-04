package com.nt.dao;

public interface ManyToOneDAO {
	public void saveData();

	public void loadData();
	/*public void loadDataUsingStreamAPI();
	public void loadDataUsingParentByUserId(int userId);
	public void deleteDataUsingParentByUserId(int userId);*/
	public void deleteOneChildfromCollectionOfChildsOfAParentByUserId(int userid);
	/*public void deleteAllChildsOfAParentByUserId(int userId);
	public void deleteOneChildfromCollectionOfChildsOfAParentByUserId();*/
	public void deleteAllChildsWithParent();
}
