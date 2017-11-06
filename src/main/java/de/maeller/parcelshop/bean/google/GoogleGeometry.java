package de.maeller.parcelshop.bean.google;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GoogleGeometry {
    private GoogleBoundaryArea bounds;
    private GoogleCoordinates location;
    @JsonProperty("location_type")
    private String locationType;
    private GoogleBoundaryArea viewport;
}
