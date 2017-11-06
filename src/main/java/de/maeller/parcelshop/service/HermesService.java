package de.maeller.parcelshop.service;

import de.maeller.parcelshop.bean.hermes.HermesParcelShop;

import java.util.List;

public interface HermesService {

    List<HermesParcelShop> findParcelShopsByLocation(float longitude, float latitude);
}
