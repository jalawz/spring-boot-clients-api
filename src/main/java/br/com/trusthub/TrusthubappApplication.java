package br.com.trusthub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.trusthub.domain.Cliente;
import br.com.trusthub.domain.enums.Risco;
import br.com.trusthub.repositories.ClienteRepository;

@SpringBootApplication
public class TrusthubappApplication implements CommandLineRunner {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(TrusthubappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente cli1 = new Cliente("Paulo Menezes", 4000.0, Risco.valueOf("B"));
		clienteRepository.save(cli1);
	}
}
