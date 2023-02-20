package database;

import entity.Employee;

public class TestDatabase {
    public static void main(String[] args) {
        //DBConnection.getConnection();
        Employeedatabase db = new Employeedatabase();
        for(Employee emp :db.getAllEmployees())
            System.out.println(emp);
    }
}
