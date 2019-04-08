package kz.kazimpex.parserxml;

import kz.kazimpex.parserxml.domain.Documentolog;
import kz.kazimpex.parserxml.domain.DomainRepositoryImpl;
import kz.kazimpex.parserxml.domain.repositories.DocumentologRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.List;

@EnableAutoConfiguration
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class ParserxmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParserxmlApplication.class, args);
	}

	@Bean
	CommandLineRunner init(DocumentologRepositories domainRepository) {

		return args -> {

			List<Documentolog> list = domainRepository.findAll();
			for (Documentolog documentolog : list) {
				System.out.println(documentolog.getName());
			}

//			Do obj = domainRepository.findOne(7L);7L
//			System.out.println(obj);
//
//			Domain obj2 = domainRepository.findFirstByDomain("mkyong.com");
//			System.out.println(obj2);
//
//			int n = domainRepository.updateDomain("mkyong.com", true);
//			System.out.println("Number of records updated : " + n);

		};

	}

	@Bean
	MongoMappingContext springDataMongoMappingContext() {
		return new MongoMappingContext();
	}
}
