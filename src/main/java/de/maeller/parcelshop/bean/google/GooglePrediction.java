package de.maeller.parcelshop.bean.google;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GooglePrediction {
    private String id;
    private String description;
    @JsonProperty("matched_substrings")
    private List<GoogleMatchedSubstring> matchedSubstrings;
    private List<GoogleTerm> terms;
    @JsonProperty("place_id")
    private String placeId;
    private List<GoogleAddressType> types;
    private String reference;
    @JsonProperty("structured_formatting")
    private GoogleStructuredFormatting structuredFormatting;
}
