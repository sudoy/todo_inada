package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.forms.EntryForm;
import todo.services.EntryService;

@WebServlet("/entry.html")
public class EntryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		String daimei = req.getParameter("daimei");
		String syosai = req.getParameter("syosai");
		String juyodoval = req.getParameter("juyodoval");
		String kigen = req.getParameter("kigen");

		EntryForm form = new EntryForm(daimei, syosai, juyodoval, kigen);

		EntryService es = new EntryService();
		es.service(form);
		resp.sendRedirect("index.html");

	}

}
