package co.com.ceiba.parqueadero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

import com.netflix.discovery.EurekaClient;

@SpringBootApplication
public class CeibaEstacionamientoApplication {
	
	
	 @Autowired
	 @Lazy
	 private EurekaClient eurekaClient;

	public static void main(String[] args) {
		SpringApplication.run(CeibaEstacionamientoApplication.class, args);
	}

}
