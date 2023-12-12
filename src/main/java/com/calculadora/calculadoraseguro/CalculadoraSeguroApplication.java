package com.calculadora.calculadoraseguro;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.calculadora")
@EnableSwagger2
public class CalculadoraSeguroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraSeguroApplication.class, args);
	}

}
