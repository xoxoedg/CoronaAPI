package rug.coronaApi.CoronaTracking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CoronaTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaTrackingApplication.class, args);
	}

}
