package com.example.demo.repositories;

import com.example.demo.models.TopicModel;
import org.springframework.data.repository.CrudRepository;

//the id in our model class is a String, therefore <.. , String>
public interface TopicRepository extends CrudRepository<TopicModel, String> {

}
