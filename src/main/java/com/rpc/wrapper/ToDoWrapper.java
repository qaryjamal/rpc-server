package com.rpc.wrapper;

import java.io.Serializable;
import java.util.Date;

public class ToDoWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String content;
	private Date created;
	private Date updated;
	private boolean closed;
	private String request;

	public ToDoWrapper() {
	}

	public ToDoWrapper(Long id, String content, Date created, Date updated) {
		this.id = id;
		this.content = content;
		this.created = created;
		this.updated = updated;
	}

	public ToDoWrapper(Long id, String content, Date created, Date updated, boolean closed) {
		this.id = id;
		this.content = content;
		this.created = created;
		this.updated = updated;
		this.closed = closed;
	}

	public ToDoWrapper(Long id, String content, Date created, Date updated, boolean closed, String request) {
		this.id = id;
		this.content = content;
		this.created = created;
		this.updated = updated;
		this.closed = closed;
		this.request = request;
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

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

}
