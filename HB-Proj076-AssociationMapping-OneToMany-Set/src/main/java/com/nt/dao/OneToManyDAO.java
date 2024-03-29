package com.nt.dao;

public interface OneToManyDAO {
	public void saveData();
	public void loadData();
	public void loadDataNplus1SelectSolution();
	public void loadDataUsingStreamAPI();
	public void loadDataUsingParentByUserId(int userId);
	public void deleteDataUsingParentByUserId(int userId);
	public void deleteAllChildsOfAParentByUserId(int userId);
	public void deleteOneChildfromCollectionOfChildsOfAParentByUserId(int userId);
}
