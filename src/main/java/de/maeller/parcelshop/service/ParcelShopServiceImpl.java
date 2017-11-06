package de.maeller.parcelshop.service;

import de.maeller.parcelshop.bean.ParcelShop;
import de.maeller.parcelshop.bean.google.GoogleAutoCompleteResponse;
import de.maeller.parcelshop.bean.google.GoogleCoordinates;
import de.maeller.parcelshop.bean.google.GoogleGeocodeResponse;
import de.maeller.parcelshop.bean.hermes.HermesParcelShop;
import de.maeller.parcelshop.service.util.ParcelShopMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ParcelShopServiceImpl implements ParcelShopService {

    private static final String AUTOCOMPLETE_QUERY = "https://maps.googleapis.com/maps/api/place/queryautocomplete/json?key=AIzaSyD54pofE8XRWfqhrIjf7pGr6RkjfkH9CiE&language=de&input=";
    private static final String GEOCODE_QUERY = "https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyD54pofE8XRWfqhrIjf7pGr6RkjfkH9CiE&language=de&address=";
    private static final String HERMES_QUERY = "https://psfinder.hermesworld.com/psfinder-rest-api-impl/rest/findParcelShopsByLocation?consumerName=EXT002524&consumerPassword=1a640b82b431a5eab1684d5d828f1bb9081d75b1ecb12965";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GoogleService googleService;
    @Autowired
    private HermesService hermesService;
    @Autowired
    private ParcelShopMapper parcelShopMapper;

    @Override
    public List<ParcelShop> getParcelShopsFor(String input, String language) {
        StopWatch sw = new StopWatch("Google-Hermes-Requests");
        try {
            sw.start("autocomplete");
            GoogleAutoCompleteResponse googleAutoCompleteResponse = googleService.performAutocompletion(input, language);
            sw.stop();
            if (googleAutoCompleteResponse == null || googleAutoCompleteResponse.getPredictions() == null) {
                return Collections.emptyList();
            }

            sw.start("geocode");
            GoogleGeocodeResponse googleGeocodeResponse = googleService.getGeocode(googleAutoCompleteResponse.getPredictions().get(0).getDescription(), language);
            sw.stop();
            if (googleGeocodeResponse == null || googleGeocodeResponse.getResults() == null) {
                return Collections.emptyList();
            }

            GoogleCoordinates googleCoordinates = googleGeocodeResponse.getResults().get(0).getGeometry().getLocation();
            sw.start("hermes");
            List<HermesParcelShop> hermesParcelShops = hermesService.findParcelShopsByLocation(googleCoordinates.getLng(), googleCoordinates.getLat());
            sw.stop();
            log.info(sw.prettyPrint());
            return hermesParcelShops.stream().map(parcelShopMapper::map).collect(Collectors.toList());
        } catch (final RestClientException rce) {
            log.error("Unable perform address requests.", rce);
            return Collections.emptyList();
        }
    }

}
