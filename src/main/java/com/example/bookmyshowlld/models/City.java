package com.example.bookmyshowlld.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class City extends BaseModel{
    private String id;
    private String name;
    @OneToMany(mappedBy = "city")// this is because ambiguity remove as in models we have allowed both class ids
    // it and then they related and one foreign key make not thiking two table separately
    private List<Theatre> theatres;

}
