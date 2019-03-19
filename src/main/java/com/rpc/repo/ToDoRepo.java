package com.rpc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rpc.entity.ToDo;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Long> {

	/*
	 * @Query("SELE new ToDoWrapper(td.id,td.content,td.created,td.updated,td.isClosed) FROM ToDo as td"
	 * ) List<ToDoWrapper> getDoWrappers();
	 */

}
