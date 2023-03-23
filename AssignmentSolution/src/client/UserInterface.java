package client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import entity.Task;
import service.UsersService;

public class UserInterface {

	private UsersService usersService;

	public UserInterface(UsersService usersService) {
		super();
		this.usersService = usersService;
	}

	public void userMenu(String email)
	{
		boolean showMenu = true;
		while(showMenu) {
			System.out.println("\n--------------------------------------------------------------\n");
			System.out.println("Welcome "+email);
			System.out.println("Please choose options");
			System.out.println("1. View All tasks assigned to you");
			System.out.println("2. View All completed tasks ");
			System.out.println("3. View All incomplete tasks assigned to you");
			System.out.println("4. Search for a task");
			System.out.println("5. Update task to complete");
			System.out.println("6. Exit");
			System.out.println("\n--------------------------------------------------------------\n");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			int id = 0;
			switch(choice)
			{
			case 1 : viewAllTasks(email);
			break;
			case 2:
				viewCompletedTasks(email);
				break;
			case 3:
				viewIncompletedTasks(email);
				break;
			case 4: 
				System.out.println("enter task id");
				viewAllTasks(email);
				id = sc.nextInt(); 
				searchTask(id, email);
				break;
			case 5:
				System.out.println("enter task id");
				viewAllTasks(email);
				id = sc.nextInt(); 
				System.out.println("Set task complete Y or incomplete N");
				char status = sc.next().charAt(0);
				setTaskComplete(id, status);
				break;
			default:
				System.out.println("Thanks, logged out");
				showMenu = false;
				break;
			}
			
		}
	}
	public void viewAllTasks(String email)
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
	public void viewCompletedTasks(String email)
	{
		List<Task> tasks;
		try {
			tasks = usersService.getCompletedTasksAssignedToUser(email);
			if(tasks.size() > 0)
			{
				for(Task task:tasks)
				{
					System.out.print(task.getTaskid()+" : "+task.getTasktitle()+" : "+task.getTasktext());
				}
			}
			else
				System.out.println("No assigned task yet, ENJOY!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void viewIncompletedTasks(String email)
	{
		List<Task> tasks;
		try {
			tasks = usersService.getInCompleteTasksAssignedToUser(email);
			if(tasks.size() > 0)
			{
				for(Task task:tasks)
				{
					System.out.print(task.getTaskid()+" : "+task.getTasktitle()+" : "+task.getTasktext());
				}
			}
			else
				System.out.println("No assigned task yet, ENJOY!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean setTaskComplete(int taskid, char status)
	{
		if (status=='Y')
			try {
				return this.usersService.updateTaskStatus(taskid, true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		try {
			return this.usersService.updateTaskStatus(taskid, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public void searchTask(int taskid, String email)
	{

	}


}
