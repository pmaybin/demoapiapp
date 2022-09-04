package com.example.demo;

public class ResponseTransfer {
    private int quote_premium;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public int getQuote_premium() {
        return quote_premium;
    }

    public void setQuote_premium(int quote_premium) {
        this.quote_premium = quote_premium;
    }

    public ResponseTransfer(String text, int quote_premium) {
        this.text = text;
        this.quote_premium = quote_premium;
    }
}
