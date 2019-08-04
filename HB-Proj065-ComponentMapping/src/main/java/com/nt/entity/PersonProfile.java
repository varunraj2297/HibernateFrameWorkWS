package com.nt.entity;

import lombok.Data;

@Data
public class PersonProfile {
    private int idno;
    private String name;
    private String gender;
    private int age;
    private AddressDetails addrs;
}
