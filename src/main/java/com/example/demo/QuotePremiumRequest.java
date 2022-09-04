package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuotePremiumRequest {

    public int getQuoteNumber() {
        return quote_number;
    }

    public void setQuoteNumber(int quote_number) {
        this.quote_number = quote_number;
    }

    @JsonProperty
    private int quote_number;
}

