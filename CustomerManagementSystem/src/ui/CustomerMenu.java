package ui;

import java.util.Scanner;

import database.CustomerDatabase;
import model.Customer;
import service.CustomerService;

public class CustomerMenu {


	public static void adminMenu()
	{
		System.out.println("1. See All customers");
		System.out.println("2. Fetch customer by email");
		System.out.println("3. Logout");
	}

	public static void customerMenu()
	{
		System.out.println("1. Profile");
		System.out.println("2. Change password");
		System.out.println("3. Edit Profile");
		System.out.println("4. Logout");
	}

	public static void main(String[] args) {

		CustomerDatabase customerDb = new CustomerDatabase();
		CustomerService customerService = new CustomerService(customerDb);
		Scanner sc = new Scanner(System.in);
		String email, password, phone, city, name;
		int choice;
		boolean flag = true;
		do {
			// Home page
			System.out.println("Choose one of the options");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				// login part
				System.out.println("Please enter email id");
				email = sc.next();
				System.out.println("Please enter password");
				password = sc.next();
				if(email.equals("admin@a.c") && password.equals("admin"))
				{
					adminDashboard(sc, customerService);
				}
				else {
					try {
						if(customerService.validateCredentials(email, password))
						{
							customerDashboard(sc, customerService);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
			case 2:
				System.out.println("Register Customer");
				break;
			case 3: System.out.println("Thanks exiting the application");
			flag = false;
			default : System.out.println("Wrong option");
			}
		}while(flag);

	}

	public static void adminDashboard(Scanner sc, CustomerService customerService)
	{
		boolean flag = true;
		do {
			System.out.println("\n ********** admin dashboard ********** \n");
			adminMenu();
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				try {
					for(Customer customer: customerService.getAllCustomers())
						System.out.println(customer);
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			case 2:
				System.out.println("Enter email of customer");
				String email = sc.next();
				try {
					Customer customer = customerService.getCustomerByEmail(email);
					System.out.println("Name "+customer.getCustname());
					System.out.println("City "+customer.getCity());
					System.out.println("Phone "+customer.getPhone());
					System.out.println("Email "+customer.getEmail());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Logging off");
				flag = false;
				break;
			default:System.out.println("Wrong choice");
			}
		}while(flag);
	}

	public static void customerDashboard(Scanner sc, CustomerService customerService)
	{
		customerMenu();
		int choice = sc.nextInt();
	}

}

