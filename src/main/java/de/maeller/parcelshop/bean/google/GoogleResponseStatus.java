package de.maeller.parcelshop.bean.google;

import lombok.Getter;

@Getter
public enum GoogleResponseStatus {
    OK, ZERO_RESULTS, OVER_QUERY_LIMIT, REQUEST_DENIED, INVALID_REQUEST, UNKNOWN_ERROR
}
