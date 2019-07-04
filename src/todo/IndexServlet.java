package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.services.IndexService;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		boolean login = false;

		if (session.getAttribute("login") != null) {
			//loginがtrue(ログイン状態にある)じゃないと入れないように
			login = (boolean) session.getAttribute("login");
		}

		if (login == false) {
			session.setAttribute("error", "ログインしてください。");
			resp.sendRedirect("login.html");
		} else {

			getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		boolean login = false;

		if (session.getAttribute("login") != null) {
			//loginがtrue(ログイン状態にある)じゃないと入れないように
			login = (boolean) session.getAttribute("login");
		}

		if (login == false) {
			session.setAttribute("error", "ログインしてください。");
			resp.sendRedirect("login.html");
		} else {

			if ((req.getParameter("cancel") != null) && (req.getParameter("cancel").equals("cancel"))) {

				//エラーと成功メッセージのみ解放
				session.removeAttribute("error");
				session.removeAttribute("kousintouroku");

			}

			IndexService is = new IndexService();

			req.setAttribute("form", is.service());

			getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

			//エラーと成功メッセージのみ解放
			session.removeAttribute("error");
			session.removeAttribute("kousintouroku");
		}
	}

}
