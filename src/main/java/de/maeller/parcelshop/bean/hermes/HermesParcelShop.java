package de.maeller.parcelshop.bean.hermes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HermesParcelShop {
    private HermesAddress address;
    @JsonProperty("dist")
    private long distance;
    private String description;
    private String shopOwner;
    private long parcelShopNumber;
    private List<HermesOpening> businessHours;
    private boolean acceptSuitcases;
    private boolean sellsBoxes;
    private String externalId;
    private String salesforceID;
    private long typeID;
    private long sortCode1;
}
