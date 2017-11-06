package de.maeller.parcelshop.controller;

import de.maeller.parcelshop.bean.ParcelShop;
import de.maeller.parcelshop.service.ParcelShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParcelShopController {

    @Autowired
    private ParcelShopService parcelShopService;

    @GetMapping(value = "/parcelshops", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ParcelShop> getParcelShops(@RequestParam String input, @RequestParam String language) {
        return parcelShopService.getParcelShopsFor(input, language);
    }
}
