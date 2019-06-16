package com.nt.test;

import com.nt.dto.PersonProfileDTO;
import com.nt.entity.AddressDetails;
import com.nt.service.PersonService;
import com.nt.service.PersonServiceImpl;
import com.nt.utility.HibernateUtil;

public class ComponentMappingTest {

	public static void main(String[] args) {
		AddressDetails details = null;
		PersonProfileDTO dto = null;
		PersonService service = null;
		try {
			service = new PersonServiceImpl();
			
			dto=service.getEmpById(1);
			
			System.out.println(dto);

			/*details = new AddressDetails();
			
			details.setHouseno("1-5-1855");
			details.setStreet("Chaitanyapuri");
			details.setArea("L.B.NAGAR");
			details.setCity("Hyderabad");
			details.setPinCode(500062);
			
			dto = new PersonProfileDTO();
			
			dto.setName("srinivas");
			dto.setGender("male");
			dto.setAge(23);
			dto.setAddrs(details);*/

			//System.out.println(service.registerPerson(dto));
			System.out.println(service.getAllPersonDetails());
		    System.out.println(service.getPersonDetailsByStreet("Kandiguda"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}