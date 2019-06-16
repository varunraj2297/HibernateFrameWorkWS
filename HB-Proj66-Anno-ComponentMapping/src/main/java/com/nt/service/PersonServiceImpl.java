package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.dao.PersonDAO;
import com.nt.dao.PersonDAOImpl;
import com.nt.dto.PersonProfileDTO;
import com.nt.entity.PersonProfile;

public class PersonServiceImpl implements PersonService {
	
	private PersonDAO dao;

	public PersonServiceImpl() {
		dao=new PersonDAOImpl();
	}
	
	@Override
	public PersonProfileDTO getEmpById(int no) {
		PersonProfile profile=null;
		PersonProfileDTO dto=null;
		
		profile=dao.fetchEmpById(no);
		
		dto=new PersonProfileDTO();
		dto.setIdno(profile.getIdno());
		dto.setName(profile.getName());
		dto.setGender(profile.getGender());
		dto.setAge(profile.getAge());
		dto.setAddrs(profile.getAddrs());
		
		return dto;
	}

	@Override
	public String registerPerson(PersonProfileDTO dto) {
		PersonProfile profile=null;
		int count=0;
		
		profile=new PersonProfile();
		profile.setIdno(dto.getIdno());
		profile.setName(dto.getName());
		profile.setGender(dto.getGender());
		profile.setAge(dto.getAge());
		profile.setAddrs(dto.getAddrs());
		
		count=dao.insertPerson(profile);
		
		return (count==0)?"Person not Registered":"Person Registered";
	}

	@Override
	public List<PersonProfileDTO> getAllPersonDetails() {
		List<PersonProfile> list=null;
		List<PersonProfileDTO> listDtos=new ArrayList<PersonProfileDTO>();
		list=dao.getAllData();
		list.forEach(profile->{
			PersonProfileDTO dto=new PersonProfileDTO();
			dto.setIdno(profile.getIdno());
			dto.setName(profile.getName());
			dto.setGender(profile.getGender());
			dto.setAge(profile.getAge());
			dto.setAddrs(profile.getAddrs());
			
			listDtos.add(dto);
		});
		return listDtos;
	}

	@Override
	public List<PersonProfileDTO> getPersonDetailsByStreet(String street) {
		List<PersonProfile> list=null;
		List<PersonProfileDTO> listDtos=new ArrayList<PersonProfileDTO>();
		list=dao.getDataByField(street);
		list.forEach(profile->{
			PersonProfileDTO dto=new PersonProfileDTO();
			dto.setIdno(profile.getIdno());
			dto.setName(profile.getName());
			dto.setGender(profile.getGender());
			dto.setAge(profile.getAge());
			dto.setAddrs(profile.getAddrs());
			
			listDtos.add(dto);
		});
		return listDtos;
	}

	

}
