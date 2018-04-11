package com.demo.neo4j;

import com.demo.neo4j.entity.Status;
import com.demo.neo4j.entity.Task;
import com.demo.neo4j.repository.StatusRepository;
import com.demo.neo4j.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Neo4jService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private StatusRepository statusRepository;

    public Task createTask(String key, Status status) {
        Task task = new Task();
        task.setKey(key);
        task.setStatus(status);

        this.saveTask(task);

        return task;
    }

    public Status createStatus(String key) {
        Status status = new Status();
        status.setKey(key);

        this.saveStatus(status);

        return status;
    }

    public void updateTaskStatus(Task task, Status status) {
        Status prevStatus = task.getStatus();
        if(prevStatus != null) {
            prevStatus.removeTask(task);
            this.saveStatus(prevStatus);
        }

        task.setStatus(status);
        if(status != null) {
            status.addTask(task);
            this.saveStatus(status);
        }

        this.saveTask(task);
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public void saveStatus(Status status) {
        statusRepository.save(status);
    }

    public Status findStatusByKey(String key) {
        return statusRepository.findByKey(key);
    }

    public Task findTaskByKey(String key) {
        return taskRepository.findByKey(key);
    }
}
