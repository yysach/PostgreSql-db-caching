package db_cache.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import db_cache.entity.NbuVersionToAPIVersion;
import db_cache.model.HostDetails;
import db_cache.service.MappingService;

@RestController
public class MappingController {
	
	private MappingService service;
	
	public MappingController(MappingService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/getAllMappingInfo", method = RequestMethod.GET)
	public String getAllMappingInfo(@RequestBody HostDetails hostDetails) {
		System.out.println(hostDetails);
		Optional< List<NbuVersionToAPIVersion>> listOfMapping = Optional.ofNullable(service.getAllMappingInfo());
		
		if(listOfMapping.isPresent()) {
			for(NbuVersionToAPIVersion mapping : listOfMapping.get()) {
				System.out.println(mapping);
			}
			
			return "API executed successfully";
		}
		return "API execution failed";
	}
	
	@RequestMapping(value = "/getApiVersion", method = RequestMethod.GET) 
	public String getApiVersion(@RequestBody HostDetails hostDetails) {
		System.out.println(hostDetails);
		Optional< NbuVersionToAPIVersion> row = Optional.ofNullable(
				service.getApiVersionFromNbuVersion(
						hostDetails.getHostName()));
		
		if(row.isPresent()) {
			System.out.println(row.get());
			return "API executed successfully";
		}
		return "API execution failed";
	}
}
