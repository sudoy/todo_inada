package todo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import todo.forms.UpdateForm;
import todo.services.UpdateService;
import todo.utils.HTMLUtils;

@WebServlet("/update.html")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		//エラーと成功メッセージのみ解放
		session.removeAttribute("error");
		session.removeAttribute("kousintouroku");

		//loginがtrue(ログイン状態にある)じゃないと入れないように
		boolean login = (boolean) session.getAttribute("login");

		if (login != true) {
			session.setAttribute("error", "ログインしてください。");
			resp.sendRedirect("login.html");
		} else {

			UpdateService us = new UpdateService();

			req.setAttribute("form", us.service(req.getParameter("number")));//indexから取得したnumberをServiceに渡す

			getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String number = req.getParameter("number"); //update文で使う
		String daimei = req.getParameter("daimei");
		String syosai = req.getParameter("syosai");
		String juyodoval = req.getParameter("juyodoval");
		String kigen = req.getParameter("kigen");

		String radio1 = HTMLUtils.radio1(juyodoval);
		String radio2 = HTMLUtils.radio2(juyodoval);
		String radio3 = HTMLUtils.radio3(juyodoval);

		UpdateForm form = new UpdateForm(number, daimei, syosai, juyodoval, kigen, radio1, radio2, radio3);

		List<String> error = validate(form);
		HttpSession session = req.getSession();

		if (error.size() == 0) {

			session.setAttribute("kousintouroku", "No." + number + "のTodoを更新しました。");
			session.setAttribute("error", null);

			UpdateService us = new UpdateService();
			us.postService(form);
			resp.sendRedirect("index.html");
		} else {

			session.setAttribute("error", error);
			req.setAttribute("form", form);

			getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);

		}
	}

	//エラーチェック
	private List<String> validate(UpdateForm form) {

		List<String> error = new ArrayList<>();

		if (form.getNumber().equals("")) {
			try {
				Integer.parseInt(form.getNumber());
			} catch (Exception e) {
				error.add("#は必須入力です。");
			}
		}

		if (form.getDaimei().equals("")) {//daimeiが空
			error.add("題名は必須入力です。");
		}
		if (100 < form.getDaimei().length()) {//daimeiが100字より多い
			error.add("題名は100文字以内にしてください。");
		}

		if (!(form.getKigen().equals(""))) {//kigenが空じゃない時

			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				String kigen = form.getKigen();
				dtf.format(LocalDate.parse(kigen, dtf));//ここで変換できればok
			} catch (DateTimeParseException e) {
				error.add("期限は「YYYY/MM/DD」形式で入力して下さい。");
			}
		}

		//option1,2,3のどれでもない、またはnull
		if (form.getJuyodoval() == null) {
			error.add("重要度は必須入力です。");
		} else if (!(form.getJuyodoval().equals("option1")) && !(form.getJuyodoval().equals("option2"))
				&& !(form.getJuyodoval().equals("option3"))) {
			error.add("重要度の入力が不適です。");
		}

		return error;

	}

}
