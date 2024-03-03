package com.example.bookmyshowlld.models;

import com.example.bookmyshowlld.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String id;
    private String name;
    private String num_rows;
    private String num_colmns;

    //relationship between Autitorium with theatre
    // many auditorium is present in one theatre
    @ManyToOne
    private Theatre theatre;

    // relationship between Auditoriaum and seat
    // one auditorium have multiple seats
    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;

    //relationship with feature enum
    //one auditoriam has muliple feature
//    @ElementCollection // when enum has list then use it
//    @Enumerated(EnumType.ORDINAL) // when single enum present then use this
//    private List<Feature> supportedFeature;

    //REALATIONSHIP WITH AUDITORIUM WITH SHOW
    //ONE SHOW IS ASSOCIATED WITH ONE AUDITORIUM
    // ONE AUDITORIUM IS ASSOCIATED WITH MANY SHOW
    @OneToMany(mappedBy = "auditorium")
    private List<MovieShow> showList ;


}
