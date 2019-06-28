package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;

import todo.forms.EntryForm;
import todo.utils.DBUtils;

public class EntryService {

	public void service(EntryForm form) throws ServletException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try {

			con = DBUtils.getConnection();
			sql = "INSERT INTO todolist (daimei, syosai, juyodoval, kigen) VALUES(?, ?, ?, ?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, form.getDaimei());
			ps.setString(2, form.getSyosai());
			ps.setString(3, form.getJuyodoval());
			ps.setString(4, form.getKigen());

			ps.executeUpdate();
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			DBUtils.close(con, ps);

		}

	}

}
