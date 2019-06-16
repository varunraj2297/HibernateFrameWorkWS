package com.nt.dto;

import com.nt.entity.AddressDetails;

import lombok.Data;

@Data
public class PersonProfileDTO {
    private int idno;
    private String name;
    private String gender;
    private int age;
    private AddressDetails addrs;
}
