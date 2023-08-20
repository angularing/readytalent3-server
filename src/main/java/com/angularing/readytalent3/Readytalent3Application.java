package com.angularing.readytalent3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

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
			repository.save(new Job("Software Developer","TechCo","Full Time"));
			repository.save(new Job("Software Developer","BKYW","Full Time"));
			repository.save(new Job("Software Developer","SIT","Contract"));
			repository.save(new Job("Graphic Designer","Design Inc","Part Time"));
			repository.save(new Job("Project Manager","Projects Ltd","Contract"));

			log.info("Jobs:");
			log.info("-------------------------------");
			for (Job job : repository.findAll()){
				log.info(job.toString());
			}
			log.info("");

		};
	}
}
