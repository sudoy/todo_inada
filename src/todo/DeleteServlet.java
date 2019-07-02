package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.forms.DeleteForm;
import todo.services.DeleteService;

@WebServlet("/delete.html")
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String number = req.getParameter("number");
		DeleteForm form = new DeleteForm(number);

		int i = validate(number);
		HttpSession session = req.getSession();

		if (i == 0) {
			DeleteService ds = new DeleteService();
			ds.service(form);
			session.setAttribute("kousintouroku", "No." + number + "を削除しました。");
			session.setAttribute("error", null);
			resp.sendRedirect("index.html");
		} else {
			resp.sendRedirect("index.html");
		}

	}

	private int validate(String number) {

		int i = 0;

		if (number.equals("")) {
			try {
				Integer.parseInt(number);
			} catch (Exception e) {
				i++;
			}
		}
		return i;
	}

}
