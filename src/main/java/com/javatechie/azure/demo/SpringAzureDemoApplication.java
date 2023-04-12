package com.javatechie.azure.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SpringAzureDemoApplication {

	@GetMapping("/nomeCurso/{obterId}")
	public String list(@PathVariable Integer obterId) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("https://spring-azure-teste.azurewebsites.net/bancoListaCursosId?id=obterId", String.class);
		//ResponseEntity<String> response = restTemplate.getForEntity("https://localhost:8090/bancoListaCursosId/{id}", String.class);
		String responseBody = response.getBody();
		if(responseBody != null || responseBody != ""){
			return responseBody;
		}
		return "Não existe curso com esse id, tente novamente entre 0 e 4!";
	}

	@GetMapping("/listaCursos")
	public String list() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("https://spring-azure-teste.azurewebsites.net/bancoListaCursos", String.class);
		//ResponseEntity<String> response = restTemplate.getForEntity("https://localhost:8090/bancoListaCursos", String.class);
		String responseBody = response.getBody();
		if(responseBody != null || responseBody != ""){
			return responseBody;
		}
		return "Não há dados de nenhum curso na lista!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAzureDemoApplication.class, args);
	}

}
