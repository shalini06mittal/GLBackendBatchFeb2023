package com.spring.mvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.entity.Task;
import com.spring.mvc.service.TaskService;
import com.spring.mvc.service.UsersService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private UsersService usersService;
	
	@GetMapping
	public String adminPage(Map<String, List<Task>> map)
	{
		map.put("tasks", this.taskService.getAllTasks());
		return "admin";
	}
	
	@GetMapping("/task")
	public String addTaskForm()
	{
		return "taskform";
	}
	@PostMapping("/task")
	public String insertTask(Task task)
	{
		System.out.println("insert");
		System.out.println(task);
		int taskid = 0;
		if(task.getTaskid()== 0 )
		 taskid = this.taskService.insertTask(task);
		else
			if(this.taskService.updateTask(task))
				return "redirect:/admin";
		System.out.println(taskid+" inserted");
		return "redirect:/admin";
	}
	@GetMapping("/users")
	public String getAllUsers()
	{
		return "users";
	}
	@GetMapping("/edit/{taskid}")
	public String editTask(@PathVariable int taskid,
			Map<String, Task> map, Map<String, List<String>> useremails)
	{
		Task task = null;
		try {
			 task = this.taskService.getTaskById(taskid);
			 map.put("task", task);
			 useremails.put("emailids", this.usersService.getAllUsersEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/admin";
		}
		return "taskform";	
	}
	
}
