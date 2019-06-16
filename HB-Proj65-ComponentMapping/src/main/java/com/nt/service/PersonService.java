package com.nt.service;

import java.util.List;

import com.nt.dto.PersonProfileDTO;

public interface PersonService {
	 public PersonProfileDTO getEmpById(int no);
     public String registerPerson(PersonProfileDTO dto);
     public List<PersonProfileDTO> getAllPersonDetails();
     public List<PersonProfileDTO> getPersonDetailsByStreet(String street);
}
