package de.maeller.parcelshop.bean.google;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GoogleStructuredFormatting {
    @JsonProperty("main_text")
    private String mainText;
    @JsonProperty("main_text_matched_substrings")
    private List<GoogleMatchedSubstring> mainTextMatchedSubstrings;
    @JsonProperty("secondary_text")
    private String secondaryText;
    @JsonProperty("secondary_text_matched_substrings")
    private List<GoogleMatchedSubstring> secondaryTextMatchedSubstrings;
}
