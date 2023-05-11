package db_cache.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import db_cache.entity.NbuVersionToAPIVersion;
import db_cache.repository.MappingRespository;

@Service
public class MappingService {
	
	@Autowired
	private MappingRespository respository;
	
	public List<NbuVersionToAPIVersion> getAllMappingInfo() {
		Optional< List<NbuVersionToAPIVersion> > listOfMapping = Optional.ofNullable(respository.findAll());
		
		if(listOfMapping.isPresent()) {
			return listOfMapping.get();
		}
		
		return null;
	}
	
	@Cacheable(cacheNames = {"mappingCache"}, key = "#nbuVersion")
	public NbuVersionToAPIVersion getApiVersionFromNbuVersion(String nbuVersion) {
		System.out.println("This is taking from DB...");
		Optional< NbuVersionToAPIVersion > apiVersion = respository.findById(nbuVersion);
		if(apiVersion.isPresent()) {
			return apiVersion.get();
		}
		return null;
	}
	
	   // this method will pause main thread for 5 seconds
    public void simulateBackendCall() {
        try {
            System.out.println("------------- Going to sleep for 2 seconds to simulate Backend Delay -----------");
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
