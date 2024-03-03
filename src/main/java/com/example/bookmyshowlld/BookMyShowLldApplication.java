package com.example.bookmyshowlld;

import com.example.bookmyshowlld.models.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  BookMyShowLldApplication {

	public static void main(String[] args) {
		Test obj = new Test();
		obj.getId();
		obj.setId(19);
		SpringApplication.run(BookMyShowLldApplication.class, args);


	}


}
