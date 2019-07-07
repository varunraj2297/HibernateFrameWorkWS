package com.nt.dao;

public interface OneToManyDAO {
	public void saveData();
	public void loadData();
	public void loadDataNplus1SelectSolutionUsingHQL();
	public void loadDataNplus1SelectSolutionUsingJPACriteria();
	public void loadDataNplus1SelectSolutionUsingQBC();
	public void loadDataNplus1SelectSolutionUsingProperties();
	public void loadDataUsingStreamAPI();
	public void loadDataUsingParentByUserId(int userId);
	public void deleteDataUsingParentByUserId(int userId);
	public void deleteAllChildsOfAParentByUserId(int userId);
	public void deleteOneChildfromCollectionOfChildsOfAParentByUserId(int userId);
}
