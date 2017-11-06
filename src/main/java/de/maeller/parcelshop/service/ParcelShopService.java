package de.maeller.parcelshop.service;

import de.maeller.parcelshop.bean.ParcelShop;

import java.util.List;

public interface ParcelShopService {

    List<ParcelShop> getParcelShopsFor(String input, String language);
}
