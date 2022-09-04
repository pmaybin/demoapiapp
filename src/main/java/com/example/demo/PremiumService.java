package com.example.demo;

import org.springframework.stereotype.Service;

public class PremiumService {
    public ResponseTransfer getPremiumValue(int quote_number){

        return new ResponseTransfer("Premium for quote ", quote_number);
    }
}
