package com.example.bookmyshowlld.models;

import com.example.bookmyshowlld.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
public class MovieShow extends BaseModel{
    private String name;
    private Date start;
    private Date end;

    //relationship show with feature
    // one show have multiple feature
//    @ElementCollection
//    @Enumerated(EnumType.ORDINAL)
//    private List<Feature> supportedFeature;

    //RELATIONSHIP WITH SHOW TO AUDITORIAM
    @ManyToOne
    private  Auditorium auditorium;


}
