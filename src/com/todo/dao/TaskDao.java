package com.todo.dao;

import java.util.ArrayList;

import com.todo.bean.Task;

public interface TaskDao {
	void ajouter(Task task);

	void supprimer(Task task);

	ArrayList<Task> lister();
}
