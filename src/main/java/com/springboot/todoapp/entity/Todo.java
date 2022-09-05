package com.springboot.todoapp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name="userName", nullable = false)
	private User user;
	
	@NotBlank(message = "Description is required!!")
	private String description;
	private boolean complete;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date createdDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date modifiedDate;
	
	
	
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Todo(long id,  @NotBlank(message = "Description is required!!") String description) {
		super();
		this.id = id;
		this.description = description;
		this.complete = false;
		this.createdDate = new Date();
		this.modifiedDate = new Date();
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", complete=" + complete
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
	
}
