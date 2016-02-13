package nl.joris.text;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MyTextsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTextsApplication.class, args);
	}
}
