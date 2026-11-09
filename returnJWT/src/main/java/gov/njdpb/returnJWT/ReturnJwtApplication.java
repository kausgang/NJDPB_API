package gov.njdpb.returnJWT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ReturnJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReturnJwtApplication.class, args);
	}

}
