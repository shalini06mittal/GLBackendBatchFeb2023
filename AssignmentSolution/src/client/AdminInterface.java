package client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import entity.Task;
import service.UsersService;

public class AdminInterface {

	private UsersService usersService;

	public AdminInterface(UsersService usersService) {
		this.usersService = usersService;
	}

	public void adminMenu()
	{
		boolean showMenu = true;
		while(showMenu) {
			System.out.println("\n--------------------------------------------------------------\n");
			System.out.println("Welcome ADMIN");
			System.out.println("Please choose options");
			System.out.println("1. View All tasks");
			System.out.println("2. Assign task to a user");
			System.out.println("3. Add a task ");
			System.out.println("4. Delete a task ");
			System.out.println("5. View All Users ");
			System.out.println("6. View All Tasks Assigned to a particular user ");
			System.out.println("7. Exit");
			System.out.println("\n--------------------------------------------------------------\n");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			int id = 0;
			String email = null;
			Task task = null;
			switch(choice)
			{
			case 1 : viewAllTasks();
			break;
			case 2:
				System.out.println("Enter email of user");
				email = sc.next();
				System.out.println("Enter task id to be assigned");
				id= sc.nextInt();
				assignTaskToUser(email, id);
				break;
			case 3:
				System.out.println("Enter task details");
				task = new Task();
				addTask(task);
				break;
			case 4: 
				System.out.println("enter task id to delete");
				id = sc.nextInt(); 
				deleteTaskById(id);
				break;
			case 5:
				viewAllUsers();
				break;
			case 6:
				System.out.println("Enter email of user to see tasks assigned");
				email = sc.next();
				viewTasksAssignedToAParticularuser(email);
				break;
			default:
				System.out.println("Thanks, logged out");
				showMenu = false;
				break;
			}
			
		}
	}
	public void viewTasksAssignedToAParticularuser(String email)
	{
		List<Task> tasks;
		try {
			tasks = usersService.getTasksAssignedToUser(email);
			if(tasks.size() > 0)
			{
				for(Task task:tasks)
				{
					System.out.print(task.getTaskid()+" : "+task.getTasktitle()+" : "+task.getTasktext());
					if(task.isTaskcompleted())
						System.out.println(" : YES");
					else
						System.out.println(" : NO");
				}
			}
			else
				System.out.println("No assigned task yet, ENJOY!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void viewAllUsers()
	{
		System.out.println("All users");
	}
	public void deleteTaskById(int taskid)
	{
		System.out.println("delete task by id");
	}
	public void addTask(Task task)
	{
		System.out.println("Add task");
	}
	public void assignTaskToUser(String email, int taskid)
	{
		System.out.println("Assign task to "+email);
	}
	public void viewAllTasks()
	{
		List<Task> tasks;
		try {
			tasks = usersService.getAllTasks();
			if(tasks.size() > 0)
			{
				for(Task task:tasks)
				{
					System.out.print(task.getTaskid()+" : "+task.getTasktitle()+" : "+task.getTasktext());
					if(task.isTaskcompleted())
						System.out.println(" : YES");
					else
						System.out.println(" : NO");
				}
			}
			else
				System.out.println("No tasks added yet, Please add!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
