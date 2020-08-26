package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.todo.bean.Task;

public class TaskDaoImpl implements TaskDao {
	private DaoFactory daoFactory;

	public TaskDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void ajouter(Task task) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO todos(name) VALUES(?);");
			preparedStatement.setString(1, task.getName());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void supprimer(Task task) {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("DELETE FROM todos WHERE id = ?;");
			preparedStatement.setInt(1, task.getId());
			preparedStatement.executeUpdate();
			System.out.println("Item supprimé");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Task> lister() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT name, id FROM todos;");

			while (resultat.next()) {
				String name = resultat.getString("name");
				int id = resultat.getInt("id");
				Task task = new Task();
				task.setName(name);
				task.setId(id);
				tasks.add(task);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}
}
