package de.maeller.parcelshop.service;

import de.maeller.parcelshop.bean.hermes.HermesParcelShop;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class HermesServiceImpl implements HermesService {

    @Autowired
    private RestTemplate restTemplate;
    private URI baseUri;

    public HermesServiceImpl(@Value("${hermes.parcelshopfinder.baseurl}") String baseUrl, @Value("${hermes.consumer.name}") String user, @Value("${hermes.consumer.password}") String password, RestTemplate restTemplate) throws URISyntaxException {
        this.restTemplate = restTemplate;
        this.baseUri = new URIBuilder(baseUrl).addParameter("consumerName", user).addParameter("consumerPassword", password).build();
    }

    @Override
    public List<HermesParcelShop> findParcelShopsByLocation(float longitude, float latitude) {
        try {
            final URI requestUri = new URIBuilder(baseUri).addParameter("lng", String.valueOf(longitude)).addParameter("lat", String.valueOf(latitude)).build();
            final ResponseEntity<List<HermesParcelShop>> hermesResponse = restTemplate.exchange(requestUri, HttpMethod.GET, null, new ParameterizedTypeReference<List<HermesParcelShop>>() {
            });
            if (hermesResponse.getStatusCode() != HttpStatus.OK) {
                log.error("Hermes request failed with status {}", hermesResponse.getStatusCode());
                return Collections.emptyList();
            }
            return hermesResponse.getBody();
        } catch (final URISyntaxException ex) {
            log.error("Building Hermes-URI failed.", ex);
            return Collections.emptyList();
        } catch (final RestClientException ex) {
            log.error("Hermes request failed.", ex);
            return Collections.emptyList();
        }
    }
}
