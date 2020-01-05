package textcallwithtwilio.textcallapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import textcallwithtwilio.textcallapp.controllers.TextCallController;

@SpringBootApplication
public class TextCallAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(TextCallAppApplication.class, args);


	}

}
