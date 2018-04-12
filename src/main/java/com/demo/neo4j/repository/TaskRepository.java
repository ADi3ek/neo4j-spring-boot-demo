package com.demo.neo4j.repository;

import com.demo.neo4j.entity.Status;
import com.demo.neo4j.entity.Task;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends Neo4jRepository<Task, Long> {

    Task findByKey(String key);

}
