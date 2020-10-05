package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CourseModel {
    @Id
    private String id;
    private String name;
    private String description;

    //establish a many to one relationship between the topic and course
    // (JPA does this, and hibernate or other frameworks can understand this)
    @ManyToOne
    private TopicModel topic;

    public TopicModel getTopic() {
        return topic;
    }

    public void setTopic(TopicModel topic) {
        this.topic = topic;
    }

    public CourseModel() {

    }

    public CourseModel(String id, String name, String description, String topicId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new TopicModel(topicId, "", "");
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
