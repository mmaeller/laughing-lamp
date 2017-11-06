package de.maeller.parcelshop.bean.hermes;

import lombok.Data;

@Data
public class HermesAddress {
    private String street;
    private String houseNumber;
    private String postCode;
    private String city;
    private String telephoneCode;
    private String telephone;
    private String faxCode;
    private String faxNumber;
}
