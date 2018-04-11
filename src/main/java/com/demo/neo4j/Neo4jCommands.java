package com.demo.neo4j;


import com.demo.neo4j.entity.Status;
import com.demo.neo4j.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class Neo4jCommands {

    @Autowired
    private Neo4jService neo4jService;

    @ShellMethod("Update task's status in Neo4j DB")
    public String updateTaskStatus(@ShellOption String taskKey, @ShellOption String newStatusKey) {
        Status status = null;
        Task task = neo4jService.findTaskByKey(taskKey);
        if(newStatusKey != "null") {
            status = neo4jService.findStatusByKey(newStatusKey);
        }

        neo4jService.updateTaskStatus(task, status);

        return "Task \"" + task.getKey() + "\" updated, status: \"" + newStatusKey + "\"";
    }

    @ShellMethod("Create new task node and save into Neo4j DB")
    public String createTask(@ShellOption String key, @ShellOption String statusKey) {
        Status status = neo4jService.findStatusByKey(statusKey);

        Task task = neo4jService.createTask(key, status);

        return "Task \"" + task.getKey() + "\" created, status: \"" + status.getKey() + "\"";
    }

    @ShellMethod("Crearte all status nodes in Neo4j DB")
    public String createStatuses() {

        neo4jService.createStatus("todo");
        neo4jService.createStatus("in_progress");
        neo4jService.createStatus("done");

        return "Statuses created: \"todo\", \"in_progress\", \"done\"";
    }
}