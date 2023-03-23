package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.TaskDatabase;
import database.UsersDatabase;
import entity.Task;

public class UsersService {

	private UsersDatabase usersDatabase;
	private TaskDatabase taskDatabase;

	public UsersService(UsersDatabase usersDatabase, TaskDatabase taskDatabase) {
		super();
		this.usersDatabase = usersDatabase;
		this.taskDatabase = taskDatabase;
	}
	
	public boolean loginUser(String email, String password) throws Exception
	{
		// email and password empty or null
		// password decryption
		if(this.usersDatabase.loginUser(email, password))
			return true;
		return false;
	}
	public List<Task> getAllTasks() throws SQLException
	{
		return this.taskDatabase.getAllTasks();
	}
	public List<Task> getTasksAssignedToUser(String email) throws SQLException
	{
		return this.taskDatabase.getAllTasksAssignedToUser(email);
	}
	public List<Task> getCompletedTasksAssignedToUser(String email) throws SQLException
	{
		List<Task> tasks =  this.taskDatabase.getAllTasksAssignedToUser(email);
		List<Task> completedTask = new ArrayList<Task>();
		for(Task task:tasks)
		{
			if(task.isTaskcompleted())
				completedTask.add(task);
		}
		return completedTask;
	}
	public List<Task> getInCompleteTasksAssignedToUser(String email) throws SQLException
	{
		List<Task> tasks =  this.taskDatabase.getAllTasksAssignedToUser(email);
		List<Task> incompleteTask = new ArrayList<Task>();
		for(Task task:tasks)
		{
			if(! task.isTaskcompleted())
				incompleteTask.add(task);
		}
		return incompleteTask;
	}
	public boolean updateTaskStatus(int taskid, boolean status) throws SQLException
	{
		return this.taskDatabase.updateTaskStatus(taskid, status);
	}
}
