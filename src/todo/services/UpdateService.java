package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;

import todo.forms.UpdateForm;
import todo.utils.DBUtils;
import todo.utils.HTMLUtils;

public class UpdateService {

	public UpdateForm service(String number) throws ServletException {

		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		try {
			con = DBUtils.getConnection();

			sql = "SELECT daimei, syosai, juyodoval, kigen FROM todolist where number = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, number);
			rs = ps.executeQuery();
			UpdateForm uf = null;

			while (rs.next()) {

				String daimei = rs.getString("daimei");
				String syosai = rs.getString("syosai");
				String juyodoval = rs.getString("juyodoval");
				String kigen = rs.getString("kigen");
				if (kigen != null) {
					kigen = HTMLUtils.kigenFormat(kigen);
				}

				uf = new UpdateForm(number, daimei, syosai, kigen, HTMLUtils.radio1(juyodoval),
						HTMLUtils.radio2(juyodoval), HTMLUtils.radio3(juyodoval));
			}

			return uf;

		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}

	public void postService(UpdateForm form) throws ServletException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;

		try {

			con = DBUtils.getConnection();
			sql = "update todolist set daimei = ?, syosai = ?, juyodoval = ?, kigen = ? where number = ?";
			ps = con.prepareStatement(sql);

			String kigen = form.getKigen();
			String juyodoval = form.getJuyodoval();
			if (kigen.equals("")) {
				kigen = null;
			}

			ps.setString(1, form.getDaimei());
			ps.setString(2, form.getSyosai());
			ps.setString(3, juyodoval);
			ps.setString(4, kigen);
			ps.setString(5, form.getNumber());

			System.out.println("ps:" + ps);

			ps.executeUpdate();
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			DBUtils.close(con, ps);

		}

	}

}
