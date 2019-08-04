package com.nt.dao;

import java.util.List;

import com.nt.entity.PersonProfile;

public interface PersonDAO {
	public PersonProfile fetchEmpById(int no);
	public int insertPerson(PersonProfile profile);
	public List<PersonProfile> getAllData();
	public List<PersonProfile> getDataByField(String street);
}
