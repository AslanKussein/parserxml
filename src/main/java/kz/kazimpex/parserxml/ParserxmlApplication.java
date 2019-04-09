package kz.kazimpex.parserxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class ParserxmlApplication {

	@Autowired
	MainParser parser;

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = SpringApplication.run(ParserxmlApplication.class, args);
		MainParser mainParser = applicationContext.getBean(MainParser.class);
		mainParser.run();
	}


}
