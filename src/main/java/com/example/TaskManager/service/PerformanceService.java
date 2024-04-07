package com.example.TaskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TaskManager.Model.Task;
import com.example.TaskManager.repository.TaskRepo;

@Service
public class PerformanceService implements ProductService {
    @Autowired
    public TaskRepo repo;
    public Integer getUserPerformance(String user){

        List<Task> tasksCompleted = repo.findAllByUserAndTaskStatus(user,"Completed");
        Integer score=0;
        for(Task task: tasksCompleted){
            String str = task.getTaskLevel();
            if(str.equals("easy")){
                score += 5;
            }
            else if(str.equals("medium")){
                score += 10;
            }
            else{
                score += 15;
            }
        }
        return score;

    }
    
}
