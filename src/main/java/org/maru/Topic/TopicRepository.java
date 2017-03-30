package org.maru.Topic;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

public interface TopicRepository extends CrudRepository<Topic, String> {
	
	public List<Topic> findByBelts(String belts);
	
	
	//custom query
	@Query("FROM Topic p WHERE LOWER(p.belts) = LOWER(:belts)")
	public List<Topic> findByCusBelts(@Param("belts") String belts);
	
	

	//join query
	//@Query("select t.fees FROM Topic p join Test t where t.name= p.name and p.name =:name")
	@Query("select p.rank FROM Topic p  where p.name =:name")
	public List<String> getJoinName(@Param("name") String name);
	
}
