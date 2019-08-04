package com.nt.dao;

public interface OneToManyDAO {
       public void saveDataUsingParent();
       public void saveDataUsingChilds();
       public void loadData();
       public void loadDataUsingQBC();
       public void deleteOneChildOfAParent();
}
