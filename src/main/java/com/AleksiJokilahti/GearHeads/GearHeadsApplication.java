package com.AleksiJokilahti.GearHeads;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.AleksiJokilahti.GearHeads.domain.Category;
import com.AleksiJokilahti.GearHeads.domain.CategoryRepository;
import com.AleksiJokilahti.GearHeads.domain.Instrument;
import com.AleksiJokilahti.GearHeads.domain.InstrumentRepository;
import com.AleksiJokilahti.GearHeads.domain.User;
import com.AleksiJokilahti.GearHeads.domain.UserRepository;

@SpringBootApplication
public class GearHeadsApplication {
	private static final Logger log = LoggerFactory.getLogger(GearHeadsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GearHeadsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner instrumentdemo(InstrumentRepository instrumentrepository, CategoryRepository categoryrepository, UserRepository userrepository) {
		return(args) -> {
			
			log.info("Save a couple of instruments");
			
			// CREATING A FEW CATEGORIES
			Category category1 = new Category("Drums");
			categoryrepository.save(category1);
			Category category2 = new Category("Guitars");
			categoryrepository.save(category2);
			Category category3 = new Category("Pianos");
			categoryrepository.save(category3);
			
			//CREATING EXAMPLE USERS AND ADMIN
			User user1 = new User("User", "$2a$10$shfbs/SgVlah69aAy05ygOSODLPBawuILEmQfCn2awyBPUzX.DLwW", "user@mail.com", "USER");
			User user2 = new User("User2", "$2a$10$shfbs/SgVlah69aAy05ygOSODLPBawuILEmQfCn2awyBPUzX.DLwW", "user@mail.com", "USER");
			User user3 = new User("User3", "$2a$10$shfbs/SgVlah69aAy05ygOSODLPBawuILEmQfCn2awyBPUzX.DLwW", "user@mail.com", "USER");
			User user4 = new User("Admin", "$2a$10$2aDoNJFdMhaNAiX7SL6b1utwlKmilh7.e7b3EhpO//eStU6Q8.mIW", "admin@mail.com", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);
			userrepository.save(user3);
			userrepository.save(user4);
			
			// CREATING A FEW instruments
			instrumentrepository.save(new Instrument(category1, "Ludwig", "Supraphonic", 2021, "xyz1234567", java.util.Date.from( Instant.now() ),
					799.99, "New", "A true classic"));//, user1
			
			log.info("fetch all instruments");
			for(Instrument instrument : instrumentrepository.findAll()) {
				log.info(instrument.toString());
			}
		};
	}

}
