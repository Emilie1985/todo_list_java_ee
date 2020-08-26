package com.todo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.bean.Task;
import com.todo.dao.DaoFactory;
import com.todo.dao.TaskDao;

@WebServlet("/Todo")
public class Todo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskDao taskDao;

	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.taskDao = daoFactory.getTaskDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("tasks", taskDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Task task = new Task();
		task.setName(request.getParameter("newTodo"));
		if (request.getParameter("ajouter") != null && !task.getName().equals("")) {
			taskDao.ajouter(task);
		}

		request.setAttribute("tasks", taskDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

}
