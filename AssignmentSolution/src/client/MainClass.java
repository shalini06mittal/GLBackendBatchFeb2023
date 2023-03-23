package client;

import java.util.Scanner;

import database.TaskDatabase;
import database.UsersDatabase;
import service.UsersService;

public class MainClass {

	public static void main(String[] args) {
		
		 UsersDatabase usersDatabase = new UsersDatabase();
		 TaskDatabase taskDatabase = new TaskDatabase();
		 UsersService usersService = new UsersService(usersDatabase, taskDatabase);
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println("Are you admin or user?");
		 String userType = sc.next();
		 if(userType.equals("admin"))
		 {
			 // admin
			 AdminInterface ai = new AdminInterface(usersService);
			 ai.adminMenu();
		 }
		 else {
			 System.out.println("Enter email");
			 String email = sc.next();
			 System.out.println("Enter password");
			 String password = sc.next();
			 try {
				if(usersService.loginUser(email, password)) {
					System.out.println("User login success");
					 UserInterface userInterface = new UserInterface(usersService);
					 userInterface.userMenu(email);
				}
				else
					System.out.println("Invalid credentials");
			} catch (Exception e) {
				System.out.println("User login failure. Please contact admin");
				System.out.println(e.getMessage());
			}
		 }
		 
		

	}


}
