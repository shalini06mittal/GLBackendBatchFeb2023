package com.spring.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskid;
	private String tasktitle;
	private String tasktext;
	private boolean taskcompleted;
	@Column(name="assignedTo")
	private String email;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Task(String tasktitle, String tasktext) {
		this.tasktitle = tasktitle;
		this.tasktext = tasktext;
		this.taskcompleted = false;
	}

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}

	public String getTasktitle() {
		return tasktitle;
	}

	public void setTasktitle(String tasktitle) {
		this.tasktitle = tasktitle;
	}

	public String getTasktext() {
		return tasktext;
	}

	public void setTasktext(String tasktext) {
		this.tasktext = tasktext;
	}

	public boolean isTaskcompleted() {
		return taskcompleted;
	}

	public void setTaskcompleted(boolean taskcompleted) {
		this.taskcompleted = taskcompleted;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", tasktitle=" + tasktitle + ", tasktext=" + tasktext + ", taskcompleted="
				+ taskcompleted + ", email=" + email + "]";
	}
	
	
}
