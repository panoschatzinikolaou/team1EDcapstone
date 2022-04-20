package com.edteam1.smdb.bootstrap;

import com.edteam1.smdb.base.BaseComponent;
import com.edteam1.smdb.domain.Occupation;
import com.edteam1.smdb.domain.Person;
import com.edteam1.smdb.domain.Production;
import com.edteam1.smdb.domain.ProductionType;
import com.edteam1.smdb.service.PersonService;
import com.edteam1.smdb.service.ProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
@Profile("generate-content")
@RequiredArgsConstructor
public class SampleContentCreator extends BaseComponent implements CommandLineRunner {

	private final PersonService personService;
	private final ProductionService productionService;

	@Override
	public void run(final String... args) {


		Person a1 = Person.builder().name("John Papadopoulos").age("18").email("jp@gmail.com").occupation(Occupation.ACTOR).build();
		Person a2 = Person.builder().name("Nick Ioannou").age("55").email("ni@gmail.com").occupation(Occupation.PRODUCER).build();
		Person a3 = Person.builder().name("Peter Tsakos").age("33").email("pt@gmail.com").occupation(Occupation.ACTOR).build();
		Person a4 = Person.builder().name("George Lamp").age("63").email("ptsad@gmail.com").occupation(Occupation.DIRECTOR).build();



		personService.createAll(a1, a2, a3, a4);
		logger.debug("Saved persons: {}, {}, {}, {}.", a1, a2, a3, a4);

		Production b1 = Production.builder().description("description no1").type(ProductionType.FILM).title("title no1").releasedYear(Date.from(LocalDate.of(2021, 10, 3).atStartOfDay(ZoneId.systemDefault()).toInstant())).build();
		Production b2 = Production.builder().description("description no2").type(ProductionType.TV_SHOW).title("title no2").releasedYear(Date.from(LocalDate.of(2020, 9, 13).atStartOfDay(ZoneId.systemDefault()).toInstant())).build();
		Production b3 = Production.builder().description("description no3").type(ProductionType.TV_SHOW).title("title no3").releasedYear(Date.from(LocalDate.of(2000, 8, 6).atStartOfDay(ZoneId.systemDefault()).toInstant())).build();
		Production b4 = Production.builder().description("description no4").type(ProductionType.FILM).title("title no4").releasedYear(Date.from(LocalDate.of(2015, 7, 23).atStartOfDay(ZoneId.systemDefault()).toInstant())).build();
		Production b5 = Production.builder().description("description no5").type(ProductionType.TV_SHOW).title("title no5").releasedYear(Date.from(LocalDate.of(1999, 6, 11).atStartOfDay(ZoneId.systemDefault()).toInstant())).build();
		Production b6 = Production.builder().description("description no6").type(ProductionType.FILM).title("title no6").releasedYear(Date.from(LocalDate.of(2022, 3, 7).atStartOfDay(ZoneId.systemDefault()).toInstant())).build();

		b1.getPersons().add(a1);
		b1.getPersons().add(a2);

		productionService.createAll(b1, b2, b3, b4, b5, b6);
		logger.debug("Saved Productions {}, {}, {}, {}, {}, {}.", b1, b2, b3, b4, b5, b6);






		//authorService.assign(a1, b1, BigDecimal.valueOf(2001L));
	}
}
