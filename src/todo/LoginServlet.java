package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.forms.LoginForm;
import todo.services.LoginService;

@WebServlet("/login.html")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();

		String mail = req.getParameter("mail");
		String pass = req.getParameter("pass");

		LoginForm form = new LoginForm(mail, pass);

		LoginService ls = new LoginService();
		boolean b = ls.service(form);
		session.setAttribute("login", b);

		System.out.println(b);

		if (b == true) {
			session.removeAttribute("error");
			resp.sendRedirect("index.html");
		} else {
			session.setAttribute("error", "メールアドレス、またはパスワードが間違っています。");
			getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
			//エラーと成功メッセージのみ解放
			session.removeAttribute("error");
			session.removeAttribute("kousintouroku");
		}

	}
}
