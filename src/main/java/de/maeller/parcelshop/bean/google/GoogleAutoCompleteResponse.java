package de.maeller.parcelshop.bean.google;

import lombok.Data;

import java.util.List;

@Data
public class GoogleAutoCompleteResponse {
    private List<GooglePrediction> predictions;
    private GoogleResponseStatus status;
}
