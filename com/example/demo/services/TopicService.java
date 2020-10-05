package com.example.demo.services;

import com.example.demo.models.TopicModel;
import com.example.demo.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//singleton, an instance will be created at startup

@Service
public class TopicService {

    //inject an instance of the TR:
    @Autowired
    private TopicRepository topicRepository;

 public List<TopicModel> getAllTopics(){
     //    convert iterable (returned by findAll) to list:
     List<TopicModel> topics = new ArrayList<>();
      topicRepository //interfata JPA
             .findAll()
             .forEach(topics::add); // populate the topics list with each element found
     return topics;
 }

 public Optional<TopicModel> getTopic(String id){
   return topicRepository.findById(id);
 }

    public void addTopic(TopicModel topic){
        topicRepository.save(topic);
    }


    public void updateTopic(String id, TopicModel topic) {
        topicRepository.save(topic); // identic cu add
    }

    public void deleteTopic(String id) {
     topicRepository.deleteById(id);
    }

}
