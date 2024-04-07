package com.example.TaskManager.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManager.Model.Task;
import com.example.TaskManager.repository.TaskRepo;
import com.example.TaskManager.service.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    public TaskRepo repo;
    ProductService serv;
    
    public TaskController(ProductService serv) {
        this.serv = serv;
    }
    @GetMapping()
    public String greet() {
        return "Welcome to Task Management Application";
    }
    @GetMapping("/getAllTasks")
    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    @GetMapping("/getTask/{id}")
    public Optional<Task> getTaskById(@PathVariable String id) {
        return repo.findById(id);
    }

    @GetMapping("/getTasks/user/{user}")
    public List<Task> getTasksByUser(@PathVariable String user) {
        return repo.findAllByUser(user);
    }

    @GetMapping("/getTasks/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return repo.findAllByTaskStatus(status);
    }

    @GetMapping("/getTasks/{user}/{status}")
    public List<Task> getTasksByUserAndStatus(@PathVariable String user,@PathVariable String status) {
        return repo.findAllByUserAndTaskStatus(user,status);
    }

    @GetMapping("/getUserPerformance/{user}")
    public Integer getUserPerformance(@PathVariable String user) {

        return serv.getUserPerformance(user);
    }

    
    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task) {
        return repo.save(task);
    }

   
    @PostMapping("/addTasks")
    public List<Task> addTasks(@RequestBody List<Task> task) {
        return repo.saveAll(task);
    }
    
    @PutMapping("/updateTask")
    public Task updateTask(@RequestBody Task task) {
        return repo.save(task);
    }

    @PutMapping("/updateTasks")
    public List<Task> updateTasks(@RequestBody List<Task> task) {
        return repo.saveAll(task);
    }
    
    @DeleteMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable String id) {
        repo.deleteById(id);
        return "Deleted Task id"+id;
    }

    
    
}
