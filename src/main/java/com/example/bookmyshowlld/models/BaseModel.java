package com.example.bookmyshowlld.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass // THIS WIILL INHERITEN
public class BaseModel {
    @Id   //THIS IS WHEN THE COMPILER WILL CREATE TABLE ON THAT IT SHOULD NOT GIVE ANY ERROR THAT IT HAS NOT ANY PRIMARY KEY
           // THIS @Id WILL RESOLVE THAT
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this when use there only one value
   private String id;
}
