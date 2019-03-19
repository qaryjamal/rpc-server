package com.rpc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpc.entity.ToDo;
import com.rpc.repo.ToDoRepo;
import com.rpc.wrapper.ToDoWrapper;

@Service
@Transactional
public class ToDoImpl implements ToDoService {

	@Autowired
	private ToDoRepo toDoRepo;

	public String createToDo(ToDoWrapper toDoWrapper) {
		ToDo toDo = new ToDo(toDoWrapper);
		this.toDoRepo.save(toDo);
		return "";
	}

	public String updateToDo(ToDoWrapper toDoWrapper) throws Exception {
		ToDo toDo = new ToDo();
		toDo = this.toDoRepo.getOne(toDoWrapper.getId());
		if (toDo == null) {
			throw new Exception("To Do not found in data base. Deleted by Admin.");
		}
		toDo = new ToDo(toDo, toDoWrapper);
		this.toDoRepo.save(toDo);
		return "";
	}

	public boolean deleteToDo(long id) throws Exception {
		ToDo toDo = this.toDoRepo.getOne(id);
		if (toDo == null) {
			throw new Exception("Already deleted by admin.");
		}
		return true;
	}

	public ToDoWrapper getToDo(long id) throws Exception {
		ToDo toDo = this.toDoRepo.getOne(id);
		if (toDo == null) {
			throw new Exception("Already deleted by admin.");
		}
		return new ToDoWrapper(toDo.getId(), toDo.getContent(), toDo.getCreated(), toDo.getUpdated(), toDo.isClosed(),
				"");
	}

	public List<ToDoWrapper> getToDoWrappers() {
		List<ToDo> toDos = this.toDoRepo.findAll();
		List<ToDoWrapper> doWrappers = null;
		if (toDos != null && toDos.size() > 0) {
			doWrappers = new ArrayList<>();
			for (ToDo toDo : toDos) {
				doWrappers.add(new ToDoWrapper(toDo.getId(), toDo.getContent(), toDo.getCreated(), toDo.getUpdated(),
						toDo.isClosed()));
			}
		}
		return doWrappers;
	}

}
