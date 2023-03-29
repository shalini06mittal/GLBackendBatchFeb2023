package com.spring.mvc.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.entity.Task;

@Repository
public class TaskDatabase {

	@Autowired
	private SessionFactory factory;
	
	public List<Task> getAllTasks()
	{
		Session session = factory.openSession();
		List<Task> tasks = session.createQuery("from Task",Task.class).getResultList();
		session.close();
		return tasks;
	}
	public Task getTaskById(int taskid)
	{
		Session session = factory.openSession();
		Task task = session.get(Task.class,taskid);
		session.close();
		return task;
	}
	public int addTask(Task task)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Integer taskid = (Integer) session.save(task);
		tx.commit();
		
		session.close();
		return taskid;
	}
	public boolean updateTask(Task task)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(task);
		tx.commit();
		
		session.close();
		return true;
	}
}
