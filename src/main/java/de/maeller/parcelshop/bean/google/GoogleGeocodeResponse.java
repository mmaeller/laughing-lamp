package de.maeller.parcelshop.bean.google;

import lombok.Data;

import java.util.List;

@Data
public class GoogleGeocodeResponse {
    private List<GoogleGeocodeResult> results;
    private GoogleResponseStatus status;
}
