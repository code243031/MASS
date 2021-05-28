package mass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"mass"})
public class MassApplication {
	public static void main(String[] args) {
		SpringApplication.run(MassApplication.class, args);
	}
}
