package com.angularing.readytalent3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.time.LocalDate;

@SpringBootApplication
public class Readytalent3Application {

	private static final Logger log = LoggerFactory.getLogger(Readytalent3Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Readytalent3Application.class, args);
	}

	@Autowired
	private DataSource dataSource;

	@Bean
	public CommandLineRunner demo(JobRepository repository){
		return (args) -> {
			log.info(dataSource.getConnection().toString());


			repository.deleteAll();
			repository.save(new Job("Software Developer","TechCo","Full Time", 4000, LocalDate.now(), 2));
			repository.save(new Job("Software Developer","BKYW","Full Time", 6500, LocalDate.now(), 1));
			repository.save(new Job("Software Developer","SIT","Contract", 20, LocalDate.now(), 3));
			repository.save(new Job("Graphic Designer","Design Inc","Part Time", 15, LocalDate.now(), 1));
			repository.save(new Job("Project Manager", "Projects Ltd", "Contract", 30, LocalDate.now(), 1));

			log.info("Jobs:");
			log.info("-------------------------------");
			for (Job job : repository.findAll()){
				log.info(job.toString());
			}
			log.info("");

		};
	}
}
