package com.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.database.TaskDatabase;
import com.spring.mvc.entity.Task;

@Service
public class TaskService {
	
	@Autowired
	private TaskDatabase taskDatabase;
	
	public List<Task> getAllTasks()
	{
		return this.taskDatabase.getAllTasks();
	}
	
	public Task getTaskById(int taskid) throws Exception
	{
		Task task = this.taskDatabase.getTaskById(taskid);
		if(task == null)
			throw new Exception(taskid+ " does not exist");
		return task;
	}

	public int insertTask(Task task)
	{
		return this.taskDatabase.addTask(task);
	}
	public boolean updateTask(Task task)
	{
		return this.taskDatabase.updateTask(task);
	}
}
