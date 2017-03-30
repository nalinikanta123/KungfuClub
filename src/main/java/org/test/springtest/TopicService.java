package org.test.springtest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics= new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String name){
		return topicRepository.findOne(name);
	}
	
	public void addTopic(Topic topic){
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String name){
		topicRepository.delete(name);
	}
	 
	public List<Topic> getCustTopic(String belts){
		List<Topic> topics= new ArrayList<Topic>();
		topicRepository.findByCusBelts(belts).forEach(topics::add);
		return topics;
	}
	
	public List<String> getJoinName(String name){
		List<String> topics= new ArrayList<String>();
		topicRepository.getJoinName(name).forEach(topics::add);
		return topics;
	}
	
	
	
	public List<Topic> getSpecificBelts(String belts){
		List<Topic> topics= new ArrayList<Topic>();
		topicRepository.findByBelts(belts).forEach(topics::add);
		return topics;
	}
	
}
