package de.maeller.parcelshop.service.util;

import de.maeller.parcelshop.bean.Address;
import de.maeller.parcelshop.bean.Opening;
import de.maeller.parcelshop.bean.ParcelShop;
import de.maeller.parcelshop.bean.hermes.HermesAddress;
import de.maeller.parcelshop.bean.hermes.HermesParcelShop;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ParcelShopMapper {

    public ParcelShop map(HermesParcelShop source) {
        final ParcelShop target = new ParcelShop();
        target.setAddress(map(source.getAddress()));
        target.setBusinessHours(source.getBusinessHours().stream().map(entry -> new Opening(entry.getDayOfWeek(), entry.getOpenFrom(), entry.getOpenTill())).collect(Collectors.toList()));
        target.setDescription(source.getDescription());
        target.setDistance(source.getDistance());
        target.setParcelShopNumber(source.getParcelShopNumber());
        target.setShopOwner(source.getShopOwner());
        return target;
    }

    private Address map(HermesAddress source) {
        final Address target = new Address();
        target.setStreet(source.getStreet());
        target.setHouseNumber(source.getHouseNumber());
        target.setZip(source.getPostCode());
        target.setCity(source.getCity());
        target.setPhoneCode(source.getTelephoneCode());
        target.setPhoneNumber(source.getTelephone());
        target.setFaxCode(source.getFaxCode());
        target.setFaxNumber(source.getFaxNumber());
        return target;
    }
}