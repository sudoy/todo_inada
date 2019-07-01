package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.services.UpdateService;

@WebServlet("/update.html")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		UpdateService us = new UpdateService();

		req.setAttribute("form", us.service(req.getParameter("number")));//indexから取得したnumberをServiceに渡す

		getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);

	}
}
