package database;

import entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
// DAO
public class EmployeeDatabase {

    Connection conn = DBConnection.getConnection();

    public List<Employee> getAllEmployees()
    {
        String sql = "select * from employee";
        /**
         * 1. get DB connection
         */
        //2. create statements
        List<Employee> emps = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                Employee e1 = new Employee();
                e1.setEmail(rs.getString(1));
                e1.setEmpname(rs.getString("empname"));
                e1.setPhone(rs.getString(3));
                emps.add(e1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return emps;
    }
}
