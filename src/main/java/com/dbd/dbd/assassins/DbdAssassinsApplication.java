package com.dbd.dbd.assassins;

import com.dbd.dbd.assassins.Models.Client;
import com.dbd.dbd.assassins.Repositories.ClientRepository;
import com.dbd.dbd.assassins.Repositories.KillerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DbdAssassinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbdAssassinsApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(KillerRepository killerRepository, ClientRepository clientRepository){
		return  args ->{

				Client david = new Client("david","vazquez","davidvazquezt2001@gmail.com","dolar500");
			clientRepository.save(david);

		};

	}


}
