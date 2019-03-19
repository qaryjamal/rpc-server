package com.rpc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rpc.wrapper.ToDoWrapper;

@Service
public interface ToDoService {
	String createToDo(ToDoWrapper toDoWrapper) throws Exception;

	String updateToDo(ToDoWrapper toDoWrapper) throws Exception;

	boolean deleteToDo(long id) throws Exception;

	ToDoWrapper getToDo(long id) throws Exception;

	List<ToDoWrapper> getToDoWrappers();
}
