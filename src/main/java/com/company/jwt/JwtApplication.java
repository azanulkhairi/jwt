package com.company.jwt;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

/*need to register JPA 2.1 converters so that all the Java 8 Date/Time fields in the domain models automatically get converted to SQL types when we persist them in the database.
*/
@SpringBootApplication
@EntityScan(basePackageClasses = {
		JwtApplication.class,
		Jsr310JpaConverters.class
})
public class JwtApplication {
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}
