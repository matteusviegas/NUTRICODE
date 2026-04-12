package br.com.challenge.nutricode.projectNutricode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProjectNutricodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectNutricodeApplication.class, args);
	}
}