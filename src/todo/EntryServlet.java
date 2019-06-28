package todo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

		if(kigen.equals("")) {
			kigen = null;
		}

		EntryForm form = new EntryForm(daimei, syosai, juyodoval, kigen);

		int i = validate(form);

		if (i == 0) {
			EntryService es = new EntryService();
			es.service(form);
			resp.sendRedirect("index.html");
		} else {
			getServletContext().getRequestDispatcher("/WEB-INF/entry.jsp").forward(req, resp);
		}

	}

	private int validate(EntryForm form) {

		int i = 0;

		if (form.getDaimei().equals("")) {//daimeiが空
			i++;
		}
		if (100 < form.getDaimei().length()) {//daimeiが100字より多い
			i++;
		}

		if (form.getKigen() != null) {//kigenが空じゃない時

			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				String kigen = form.getKigen();
				dtf.format(LocalDate.parse(kigen, dtf));//ここで変換できればok
			} catch (DateTimeParseException e) {
				i++;
			}
		}

		//option1,2,3のどれでもない
		if (!(form.getJuyodoval().equals("option1")) || !(form.getJuyodoval().equals("option1"))
				|| !(form.getJuyodoval().equals("option1"))) {
			i++;
		}

		return i;

	}

	//重要度がちゃんとoption1,2,3のどれかで返ってきているか判定？？
	//（ (ex) hoge って返ってきたらエラー）

}
