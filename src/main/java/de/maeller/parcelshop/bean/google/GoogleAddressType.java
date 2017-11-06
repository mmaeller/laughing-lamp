package de.maeller.parcelshop.bean.google;

import lombok.Getter;

@Getter
public enum GoogleAddressType {
    street_address, route, intersection, political, country,
    administrative_area_level_1, administrative_area_level_2, administrative_area_level_3, administrative_area_level_4, administrative_area_level_5,
    sublocality_level_1, sublocality_level_2, sublocality_level_3, sublocality_level_4, sublocality_level_5,
    colloquial_area, locality, ward, sublocality, neighborhood, premise, subpremise, postal_code, natural_feature, airport, park, point_of_interest,
    floor, establishment, parking, post_box, postal_town, room, street_number, bus_station, train_station, transit_station, geocode
}
