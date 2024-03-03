package com.example.bookmyshowlld.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Test {
    @Id
    private long id;
    private String name;
}
