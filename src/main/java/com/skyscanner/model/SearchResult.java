package com.skyscanner.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {
    @JsonProperty
    private String city;

    @JsonProperty
    private String kind;

    @JsonProperty
    private String title;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
