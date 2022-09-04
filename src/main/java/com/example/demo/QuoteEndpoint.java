package com.example.demo;

import com.customexceptions.CaughtCustomException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.RoundingMode;
import java.security.InvalidKeyException;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Random;


@Controller
@RequestMapping("/quote")
public class QuoteEndpoint {

    @Autowired
    private QuoteRepository quoteRepository;

    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path="/new")
    public @ResponseBody QuoteEntity addNewQuote(@RequestBody @NotNull QuoteObject body, HttpServletResponse response){
        System.out.println("Post NEW endpoint");
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.UP);
        System.out.println(body.getStreet_address());
        QuoteEntity quote = new QuoteEntity();
        quote.setStreet_address(body.getStreet_address());
        quote.setCity(body.getCity());
        quote.setZip_code(body.getZip_code());
        quote.setState(body.getState());
        quote.setYear_built(body.getYear_built());

//        System.out.println(body.getConstruction_type());



        quote.setConstruction_type(body.getConstruction_type());
        quote.setCreated_date(Date.from(Instant.now()));

        Random r = new Random();
        double randomValue = 150 + (10000 - 150) * r.nextDouble();
        quote.setQuote_premium(Double.valueOf(df.format(randomValue)));

        QuoteEntity newQuote = quoteRepository.save(quote);
        System.out.println(newQuote.getQuote_number());
        response.addHeader("QuoteDemoKey", "QuoteDemoValue");
//        response.addHeader("Access-Control-Allow-Origin", "*");
        return newQuote;
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://192.168.1.239:3000"})
    @GetMapping(path = "/all")
    public @ResponseBody Iterable < QuoteEntity > getAllQuotes() {

        System.out.println("get all method called");
        return quoteRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{quote_number}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public QuoteEntity getPremium(@PathVariable("quote_number") Integer quote_number) throws InvalidKeyException {
        System.out.println(quote_number);
        QuoteEntity quote = quoteRepository.findById(quote_number).orElseThrow(() -> new CaughtCustomException("Quote number not found"));
        return quoteRepository.findById(quote_number).orElse(new QuoteEntity());
//        return new ResponseTransfer(String.format("Returning premium for quote %d", id ), id*2);
    }






}
