package com.game.firefire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class FirefireApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirefireApplication.class, args);
	}

}
