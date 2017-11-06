package de.maeller.parcelshop.bean.google;

import lombok.Data;

@Data
public class GoogleBoundaryArea {
    private GoogleCoordinates northeast;
    private GoogleCoordinates southwest;
}
