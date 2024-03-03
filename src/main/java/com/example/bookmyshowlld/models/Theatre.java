package com.example.bookmyshowlld.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Theatre extends BaseModel {
    private String name;
    private String address;

    @ManyToOne
    private City city;

    // theatre to auditoriam relationship
    // one theatre multiple auditoriam
    @OneToMany (mappedBy = "theatre")
    private List<Auditorium> auditoriumList;

    //


}
