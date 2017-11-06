package de.maeller.parcelshop.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ParcelShop implements Serializable {
    private static final long serialVersionUID = 5542602553181629289L;
    private Address address;
    private String description;
    private String shopOwner;
    private long parcelShopNumber;
    private List<Opening> businessHours;
    private long distance;
}
