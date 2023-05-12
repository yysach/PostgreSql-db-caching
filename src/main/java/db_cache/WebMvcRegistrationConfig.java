package db_cache;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import db_cache.controller.MappingController;
import db_cache.repository.MappingRespository;
import db_cache.service.MappingService;

public class WebMvcRegistrationConfig implements WebMvcConfigurer{

	@Bean
	public MappingService getMappingService(MappingRespository mappingRespository) {
		return new MappingService(mappingRespository);
	}
	
	@Bean
	public MappingController getMappingController(MappingRespository mappingRespository) {
		return new MappingController(getMappingService(mappingRespository));
	}
}
