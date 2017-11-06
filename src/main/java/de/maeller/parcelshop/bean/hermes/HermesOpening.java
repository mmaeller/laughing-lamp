package de.maeller.parcelshop.bean.hermes;

import lombok.Data;

@Data
public class HermesOpening {
    private String dayOfWeek;
    private String openFrom;
    private String openTill;
}
