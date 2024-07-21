package com.example.food_order;

import lombok.AllArgsConstructor;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Driver;

@SpringBootApplication
public class FoodOrderApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(FoodOrderApplication.class, args);
	}

}
