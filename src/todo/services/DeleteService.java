package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;

import todo.forms.DeleteForm;
import todo.utils.DBUtils;

public class DeleteService {

	public void service(DeleteForm form) throws ServletException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try {

			con = DBUtils.getConnection();
			sql = "delete from todolist where number = ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, form.getNumber());

			System.out.println("ps:" + ps);

			ps.executeUpdate();
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			DBUtils.close(con, ps);

		}

	}

}
