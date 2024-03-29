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

		boolean login = false;
		String number = req.getParameter("number");

		if (session.getAttribute("login") != null) {
			//loginがtrue(ログイン状態にある)じゃないと入れないように
			login = (boolean) session.getAttribute("login");
		}

		if (login == false) {
			session.setAttribute("error", "ログインしてください。");
			resp.sendRedirect("login.html");
		} else if (number == null) {//updateでnumberは設定できないので
			resp.sendRedirect("index.html");
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

			String number = req.getParameter("number"); //update文で使う
			String daimei = req.getParameter("daimei");
			String syosai = req.getParameter("syosai");
			String juyodoval = req.getParameter("juyodoval");
			String kigen = req.getParameter("kigen");
			String status = req.getParameter("status");

			String radio1 = HTMLUtils.radio1(juyodoval);//チェックされていればcheckedが返る
			String radio2 = HTMLUtils.radio2(juyodoval);//チェックされていればcheckedが返る
			String radio3 = HTMLUtils.radio3(juyodoval);//チェックされていればcheckedが返る

			String status1 = HTMLUtils.status1(status);//チェックされていればcheckedが返る
			String status0 = HTMLUtils.status0(status);//チェックされていればcheckedが返る

			UpdateForm form = new UpdateForm(number, daimei, syosai, juyodoval, kigen, radio1, radio2, radio3,
					status, status1, status0);

			List<String> error = validate(form);

			if (error.size() == 0) {//エラーが一つもなければ

				session.setAttribute("kousintouroku", "No." + number + "のTodoを更新しました。");
				session.setAttribute("error", null);

				UpdateService us = new UpdateService();
				us.postService(form);
				resp.sendRedirect("index.html");
			} else {//エラーがあれば

				session.setAttribute("error", error);
				req.setAttribute("form", form);

				getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);

			}
		}
	}

	//エラーチェック
	private List<String> validate(UpdateForm form) {

		List<String> error = new ArrayList<>();

		//id(number)の必須入力チェック
		if (form.getNumber().equals("")) {
			try {
				Integer.parseInt(form.getNumber());
			} catch (Exception e) {
				error.add("#は必須入力です。");
			}
		}

		//題名の必須入力チェック
		if (form.getDaimei().equals("")) {//daimeiが空
			error.add("題名は必須入力です。");
		}
		if (100 < form.getDaimei().length()) {//daimeiが100字より多い
			error.add("題名は100文字以内にしてください。");
		}

		//期限のチェック
		if (!(form.getKigen().equals(""))) {//kigenが空じゃない時

			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				String kigen = form.getKigen();
				dtf.format(LocalDate.parse(kigen, dtf));//ここで変換できればok
			} catch (DateTimeParseException e) {
				error.add("期限は「YYYY/MM/DD」形式で入力して下さい。");
			}
		}

		//重要度がoption1,2,3のどれでもない、またはnull
		if (form.getJuyodoval() == null) {
			error.add("重要度は必須入力です。");
		} else if (!(form.getJuyodoval().equals("option1")) && !(form.getJuyodoval().equals("option2"))
				&& !(form.getJuyodoval().equals("option3"))) {
			error.add("重要度の入力が不適です。");
		}

		//statusが0でも1でもない、またはnull
		if (form.getStatus() == null) {
			error.add("ステータスは必須入力です。");
		} else if (!(form.getStatus().equals("0")) && !(form.getStatus().equals("1"))) {
			error.add("ステータスの入力が不適です。");
		}

		return error;

	}

}
