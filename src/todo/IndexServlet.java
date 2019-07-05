package todo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.forms.IndexForm;
import todo.services.IndexService;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	//すべての一覧
	private static final String SQLALL = "SELECT number, daimei, juyodoval, kigen, status FROM todolist "
			+ "ORDER BY number";
	//未完了のみの一覧
	private static final String SQLMIKAN = "SELECT number, daimei, juyodoval, kigen, status FROM todolist "
			+ "WHERE status = 0 ORDER BY number";

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
			IndexService is = new IndexService();
			if (req.getParameter("hyoji") != null) {//ぬるぽ対策
				if (req.getParameter("hyoji").equals("mikan")) {//mikanなら未完了のみ表示
					req.setAttribute("form", is.service(SQLMIKAN));
					getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

				} else if (req.getParameter("hyoji").equals("all")) {//allならGetに飛んで全部表示
					req.setAttribute("form", is.service(SQLALL));
					getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
				}
			} else {
				String[] kanryoNumArray = req.getParameterValues("status");//完了しているやつのnumberを取っている

				IndexForm form = new IndexForm(kanryoNumArray);//完了のみ更新してformを返すメソッド

				is.kanryoService(form);
				doGet(req, resp);
			}

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

			req.setAttribute("form", is.service(SQLALL));

			getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

			//エラーと成功メッセージのみ解放
			session.removeAttribute("error");
			session.removeAttribute("kousintouroku");
		}
	}

}
