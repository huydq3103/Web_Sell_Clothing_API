package com.example.sell_clothing_api;

import com.example.sell_clothing_api.Config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({WebConfig.class})
public class SellClothingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellClothingApiApplication.class, args);
    }

}
