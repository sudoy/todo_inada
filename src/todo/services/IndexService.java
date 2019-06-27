package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import todo.forms.IndexForm;
import todo.utils.DBUtils;
import todo.utils.HTMLUtils;

public class IndexService {

	public List<IndexForm> service() throws ServletException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		List<IndexForm> form = new ArrayList<>();

		try {
			con = DBUtils.getConnection();

			sql = "SELECT number, daimei, juyodoval, kigen FROM todolist ORDER BY number";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				String number = rs.getString("number");
				String daimei = rs.getString("daimei");
				String juyodoval = HTMLUtils.juyodoFormat(rs.getString("juyodoval"));
				String kigen = HTMLUtils.kigenFormat(rs.getString("kigen"));

				IndexForm f = new IndexForm(number, daimei, juyodoval, kigen);
				form.add(f);
			}
			return form;

		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}

}
