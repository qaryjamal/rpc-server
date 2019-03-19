package com.rpc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.rpc.wrapper.ToDoWrapper;

@Entity
@Table(name = "to_do")
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String content;
	private boolean closed;
	@CreationTimestamp
	private Date created;
	@UpdateTimestamp
	private Date updated;

	public ToDo() {
	}

	public ToDo(Long id, String content, boolean closed, Date created, Date updated) {
		this.id = id;
		this.content = content;
		this.closed = closed;
		this.created = created;
		this.updated = updated;
	}

	public ToDo(boolean closed) {
		this.closed = closed;
	}

	public ToDo(ToDoWrapper toDoWrapper) {
		if (toDoWrapper.getId() != null && toDoWrapper.getId() > 0)
			this.id = toDoWrapper.getId();
		this.content = toDoWrapper.getContent();
		this.closed = toDoWrapper.isClosed();
	}

	public ToDo(ToDo toDo, ToDoWrapper toDoWrapper) {
		toDo.content = toDoWrapper.getContent();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
