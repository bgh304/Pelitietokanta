package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.Kategoria;
import fi.haagahelia.course.domain.KategoriaRepository;
import fi.haagahelia.course.domain.Peli;
import fi.haagahelia.course.domain.PeliRepository;
import fi.haagahelia.course.domain.User2;
import fi.haagahelia.course.domain.User2Repository;


@SpringBootApplication
public class PelitietokantaApplication {
	private static final Logger log = LoggerFactory.getLogger(PelitietokantaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PelitietokantaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner peliDemo(PeliRepository srepository, KategoriaRepository drepository, User2Repository urepository) {
		return (args) -> {
			log.info("tallenna muutama peli, kategoria ja käyttäjä");
			drepository.save(new Kategoria("Toiminta"));
			drepository.save(new Kategoria("Tasohyppely"));
			drepository.save(new Kategoria("Roolipeli"));
			
			srepository.save(new Peli("Contra III: The Alien Wars", "Konami", 1992, "SNES", drepository.findByNimi("Toiminta").get(0), "Läpi perusaseella"));
			srepository.save(new Peli("Super Mario World", "Nintendo", 1990, "SNES", drepository.findByNimi("Tasohyppely").get(0), "Läpi yhdellä elämällä"));	
			srepository.save(new Peli("Final Fantasy VI", "Square", 1997, "PS1", drepository.findByNimi("Roolipeli").get(0), "Läpi yhdellä istumalla"));
			
			User2 user1 = new User2("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User2 user2 = new User2("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("kerää kaikki pelit");
			for (Peli peli : srepository.findAll()) {
				log.info(peli.toString());
			}

		};
	}
}
