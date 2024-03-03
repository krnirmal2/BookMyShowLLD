package com.example.bookmyshowlld.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.LineNumberInputStream;
import java.util.List;
@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String userName;
    private String password;
    private String name;

    // relationship of user with role
    // so one user may have different role



    // relationship with user and tickets
    // one user can book many tickets
    @OneToMany
    private List<Ticket>tickets; 

}
