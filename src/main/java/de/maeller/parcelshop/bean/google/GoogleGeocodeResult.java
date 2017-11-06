package de.maeller.parcelshop.bean.google;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GoogleGeocodeResult {
    @JsonProperty("address_components")
    private List<GoogleAddressComponent> addressComponents;
    @JsonProperty("formatted_address")
    private String formattedAddress;
    private GoogleGeometry geometry;
    @JsonProperty("place_id")
    private String placeId;
    private List<GoogleAddressType> types;
}
