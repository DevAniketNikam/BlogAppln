package com.aniket;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean // equivalent to <bean id ..../> in xml file
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
				.setPropertyCondition(Conditions.isNotNull());
		return modelMapper;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//accept admissionn data for a learner includign the course name, and the data of admission
	//retrive the list of courrses in whichh admi have beem taken i the last 6 month considering the curet month as the 0th month
	
//provide the list of these courses in reverse chronological order, startiign from he msot recent admis
	
}
