package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.utils.DBUtils;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;



		try {
			con = DBUtils.getConnection();

			sql = "SELECT number, daimei, juyodoval, kigen FROM todolist ORDER BY number";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			List<String> nlist = new ArrayList<>();
			List<String> dlist = new ArrayList<>();
			List<String> jlist = new ArrayList<>();
			List<String> klist = new ArrayList<>();

			while (rs.next()) {


				String number = rs.getString("number");
				String daimei = rs.getString("daimei");
				String juyodoval = rs.getString("juyodoval");
				String kigen = rs.getString("kigen");

				nlist.add(number);
				dlist.add(daimei);
				jlist.add(juyodoval);
				klist.add(kigen);

			}

			req.setAttribute("nlist", nlist);
			req.setAttribute("dlist", dlist);
			req.setAttribute("jlist", jlist);
			req.setAttribute("klist", klist);

			getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);

		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			DBUtils.close(con, ps, rs);
		}

	}

}
