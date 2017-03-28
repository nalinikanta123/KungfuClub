package org.test.springtest;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
	
	public List<Topic> findByBelts(String belts);
}
