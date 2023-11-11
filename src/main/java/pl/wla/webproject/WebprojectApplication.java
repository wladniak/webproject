package pl.wla.webproject;


import org.mapstruct.MapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "pl.wla.webproject")

public class WebprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebprojectApplication.class, args);
	}

}
