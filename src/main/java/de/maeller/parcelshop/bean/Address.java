package de.maeller.parcelshop.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {
    private static final long serialVersionUID = 4195949695138931992L;
    private String street;
    private String houseNumber;
    private String zip;
    private String city;
    private String phoneCode;
    private String phoneNumber;
    private String faxCode;
    private String faxNumber;
}
