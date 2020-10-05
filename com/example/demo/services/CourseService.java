package com.example.demo.services;

import com.example.demo.models.CourseModel;
import com.example.demo.models.TopicModel;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//singleton, an instance will be created at startup

@Service
public class CourseService {

    //inject an instance of the TR:
    @Autowired
    private CourseRepository courseRepository;

 public List<CourseModel> getAllCourses(String topicId){
     List<CourseModel> courses = new ArrayList<>();

      courseRepository
              .findByTopicId(topicId)
             .forEach(courses::add);

     return courses;
 }

 public Optional<CourseModel> getCourse(String courseId){
     return courseRepository.findById(courseId);
 }

    public void addCourse(CourseModel course){
        courseRepository.save(course);
    }


    public void updateCourse(CourseModel course) {
        courseRepository.save(course); // identic cu add
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

}
