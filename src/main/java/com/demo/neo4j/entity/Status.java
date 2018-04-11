package com.demo.neo4j.entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Status {

    @GraphId
    private Long id;
    private String key;

    @Relationship(type = "HAS_STATUS", direction = Relationship.INCOMING)
    private Set<Task> tasks;

    public Status() {
        tasks = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean removeTask(Task task) {
        if(this.hasTask(task)) {
            return this.tasks.remove(task);
        }
        return false;
    }

    public boolean hasTask(Task task) {
        return this.tasks.contains(task);
    }
}
