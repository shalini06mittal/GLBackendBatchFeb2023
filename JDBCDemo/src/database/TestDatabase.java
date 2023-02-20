package database;

import entity.Employee;

public class TestDatabase {
    public static void main(String[] args) {
        //DBConnection.getConnection();
        EmployeeDatabase db = new EmployeeDatabase();
        for(Employee emp :db.getAllEmployees())
            System.out.println(emp);
    }
}
