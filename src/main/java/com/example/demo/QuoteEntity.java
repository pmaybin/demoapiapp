package com.example.demo;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="quote")
public class QuoteEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quote_number;
    @Column
    private String street_address;
    @Column
    private String city;

    @Column
    private Integer zip_code;

    @Column
    private String state;

    @Column
    private Integer year_built;

    @Column()
    @Enumerated(EnumType.STRING)
    private ConstructionType construction_type;

    @Column
    @DateTimeFormat(pattern = "dd/mm/yyyy HH:MM")
    private Date created_date;

    @Column
    private Double quote_premium;


    public Integer getQuote_number() {
        return quote_number;
    }

    public void setQuote_number(Integer quote_number) {
        this.quote_number = quote_number;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZip_code() {
        return zip_code;
    }

    public void setZip_code(Integer zip_code) {
        this.zip_code = zip_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getYear_built() {
        return year_built;
    }

    public void setYear_built(Integer year_built) {
        this.year_built = year_built;
    }

    @Enumerated(EnumType.STRING)
    public ConstructionType getConstruction_type() {
        return construction_type;
    }
    @Enumerated(EnumType.STRING)
    public void setConstruction_type(ConstructionType construction_type) {
        this.construction_type = construction_type;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Double getQuote_premium() {
        return quote_premium;
    }

    public void setQuote_premium(Double quote_premium) {
        this.quote_premium = quote_premium;
    }
}
