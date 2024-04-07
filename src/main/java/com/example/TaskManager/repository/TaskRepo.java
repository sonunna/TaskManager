package com.example.TaskManager.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.TaskManager.Model.Task;

public interface TaskRepo extends MongoRepository <Task, String> {

    List<Task> findAllByUser(String user);

    List<Task> findAllByTaskStatus(String status);

    List<Task> findAllByUserAndTaskStatus(String user, String status);

    

   

   
    
}
