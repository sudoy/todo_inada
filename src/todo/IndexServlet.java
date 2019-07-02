package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.services.IndexService;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		IndexService is = new IndexService();

		req.setAttribute("form", is.service());

		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

	}

}
