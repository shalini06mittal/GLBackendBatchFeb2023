package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Task;

public class TaskDatabase {

	private Connection conn = DBConnection.getConn();
	
	public List<Task> getAllTasks() throws SQLException
	{
		List<Task> tasks = new ArrayList<Task>();
		String sql = "select * from task";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			Task task  = new Task();
			task.setTaskid(rs.getInt(1));
			task.setTasktitle(rs.getString(2));
			task.setTasktext(rs.getString(3));
			task.setTaskcompleted(rs.getBoolean(4));
			task.setEmail(rs.getString(5));
			tasks.add(task);
		}
		return tasks;
	}
	public List<Task> getAllTasksAssignedToUser(String email) throws SQLException
	{
		List<Task> tasks = new ArrayList<Task>();
		String sql = "select * from task where assignedto=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, email);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
			Task task  = new Task();
			task.setTaskid(rs.getInt(1));
			task.setTasktitle(rs.getString(2));
			task.setTasktext(rs.getString(3));
			task.setTaskcompleted(rs.getBoolean(4));
			task.setEmail(rs.getString(5));
			tasks.add(task);
		}
		return tasks;
	}
	public boolean updateTaskStatus(int taskid, boolean taskComplete) throws SQLException
	{
		String sql = "update task set taskcompleted = ? where taskid=? ";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(2, taskid);
		st.setBoolean(1, taskComplete);
		st.executeUpdate();
		return true;
	}
	
}
