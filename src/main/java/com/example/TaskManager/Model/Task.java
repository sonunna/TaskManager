package com.example.TaskManager.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "task")
public class Task {

    @Id
    public String taskId;
    public String taskName;
    public String taskDescription;
    public String taskLevel;
    public String taskStatus;
    public String comments;
    public String user;
    
}
