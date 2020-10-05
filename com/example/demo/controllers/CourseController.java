package com.example.demo.controllers;

import com.example.demo.models.CourseModel;
import com.example.demo.models.TopicModel;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    //autowired = needs dependency injection
    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{topicId}/courses")
    //get all courses for THAT topic id
    public List<CourseModel> getAllCourses(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }

    @GetMapping("/topics/{topicId}/courses/{courseId}")
    public Optional<CourseModel> getCourse(@PathVariable String courseId){
        return courseService.getCourse(courseId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody CourseModel course, @PathVariable String topicId){
        //u do not want the user to pass in the topic info in the course,
        // u wanna create that based on the url
        //for this, you need a connection from the courseModel to the topicModel
        //create an instance variable an initialize some default in the constructor of the courseModel
 
        course.setTopic(new TopicModel(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
    public void updateCourse(@RequestBody CourseModel course, @PathVariable String topicId, @PathVariable String courseId){
        course.setTopic(new TopicModel(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId){
        courseService.deleteCourse(courseId);
    }



}








