package db_cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import db_cache.entity.NbuVersionToAPIVersion;

@Repository
public interface MappingRespository extends JpaRepository<NbuVersionToAPIVersion, String>{

}
