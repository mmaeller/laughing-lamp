package de.maeller.parcelshop.service;

import de.maeller.parcelshop.bean.google.GoogleAutoCompleteResponse;
import de.maeller.parcelshop.bean.google.GoogleGeocodeResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Service
public class GoogleServiceImpl implements GoogleService {

    @Autowired
    private RestTemplate restTemplate;
    private URI autocompletionUri;
    private URI geocodeUri;

    public GoogleServiceImpl(@Value("${google.maps.api.baseurl}") String baseUrl, @Value("${google.api.key}") String apiKey, @Value("${google.maps.api.autocompletion}") String autocompletionPath, @Value("${google.maps.api.geocode}") String geocodePath, RestTemplate restTemplate) throws URISyntaxException {
        this.restTemplate = restTemplate;
        this.autocompletionUri = new URIBuilder(baseUrl + autocompletionPath).addParameter("key", apiKey).build();
        this.geocodeUri = new URIBuilder(baseUrl + geocodePath).addParameter("key", apiKey).build();
    }

    @Override
    public GoogleAutoCompleteResponse performAutocompletion(String input, String language) {
        try {
            final URI requestUri = new URIBuilder(autocompletionUri).addParameter("input", input).addParameter("language", language).build();
            return restTemplate.getForObject(requestUri, GoogleAutoCompleteResponse.class);
        } catch (final RestClientException ex) {
            log.error("Autocompletion request failed.", ex);
            return null;
        } catch (final URISyntaxException ex) {
            log.error("Building Autocompletion-URI failed.", ex);
            return null;
        }
    }

    @Override
    public GoogleGeocodeResponse getGeocode(String input, String language) {
        try {
            final URI requestUri = new URIBuilder(geocodeUri).addParameter("address", input).addParameter("language", language).build();
            return restTemplate.getForObject(requestUri, GoogleGeocodeResponse.class);
        } catch (final RestClientException ex) {
            log.error("Geocode request failed.", ex);
            return null;
        } catch (final URISyntaxException ex) {
            log.error("Building Geocode-URI failed.", ex);
            return null;
        }
    }
}
