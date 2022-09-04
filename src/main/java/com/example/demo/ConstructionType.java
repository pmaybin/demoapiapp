package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.Enumerated;
import java.util.stream.Stream;
public enum ConstructionType {
    /**
     * ENUM for the construction type, three are shown, however only two are used in the database
     * The first Null enum is a holder as the others do not pass correctly when either is the first enum*/
    NULL,
    MASONRY,
    FRAME
}
