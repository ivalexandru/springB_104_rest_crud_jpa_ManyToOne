package com.example.demo.repositories;

import com.example.demo.models.CourseModel;
import com.example.demo.models.TopicModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//the id in our model class is a String, therefore <.. , String>
public interface CourseRepository extends CrudRepository<CourseModel, String> {

    //when the method needed does not exist in the CrudRepository,
    //we manually add it:

    //name the methods so that JPA PROVIDES THE METHODS AUTOMATICALLY:
    //start with "find",
    //then filter by a condition: "By"
//    the property based on which we want to filter: "name"
    // YOU DON'T HAVE TO IMPLEMENT THE METHOD. jpa will do that!

    // get all the courses given a particular name:
    // ( courseModel has a 'name' field )

    //searches in the db for All the courses with the specified name
//    ex:
//    public List<CourseModel> findByName(String name);


    //specify the 'id', that is the field in the TopicModel class
    // Topic here is from the property ( field ) in the CourseModel class
    // the one you annotate with @ManyToOne
    // not the className (that would be TopicModel)
    public List<CourseModel> findByTopicId(String name);




}
