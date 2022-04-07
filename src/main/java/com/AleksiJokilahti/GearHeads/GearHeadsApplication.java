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

@SpringBootApplication
public class GearHeadsApplication {
	private static final Logger log = LoggerFactory.getLogger(GearHeadsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GearHeadsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner instrumentdemo(InstrumentRepository instrumentrepository, CategoryRepository categoryrepository) {
		return(args) -> {
			
			log.info("Save a couple of instruments");
			
			// CREATING A FEW CATEGORIES
			Category category1 = new Category("Drums");
			categoryrepository.save(category1);
			Category category2 = new Category("Guitars");
			categoryrepository.save(category2);
			Category category3 = new Category("Pianos");
			categoryrepository.save(category3);
			
			// CREATING A FEW instruments
			instrumentrepository.save(new Instrument(category1, "Ludwig", "Supraphonic", 2021, "xyz1234567", java.util.Date.from( Instant.now() ),
					799.99, "New", "A true classic"));
			
			log.info("fetch all instruments");
			for(Instrument instrument : instrumentrepository.findAll()) {
				log.info(instrument.toString());
			}
		};
	}

}
