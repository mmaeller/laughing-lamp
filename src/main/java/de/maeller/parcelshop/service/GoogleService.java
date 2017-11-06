package de.maeller.parcelshop.service;

import de.maeller.parcelshop.bean.google.GoogleAutoCompleteResponse;
import de.maeller.parcelshop.bean.google.GoogleGeocodeResponse;

public interface GoogleService {

    GoogleAutoCompleteResponse performAutocompletion(String input, String language);

    GoogleGeocodeResponse getGeocode(String input, String language);
}
