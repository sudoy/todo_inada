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

			sql = "SELECT daimei, syosai, juyodoval, kigen FROM todolist where number = '" + number + "'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			UpdateForm uf = null;

			while(rs.next()) {

				String daimei = rs.getString("daimei");
				String syosai = rs.getString("syosai");
				String juyodoval = HTMLUtils.juyodoFormat(rs.getString("juyodoval"));
				String kigen = rs.getString("kigen");
				if (kigen != null) {
					kigen = HTMLUtils.kigenFormat(kigen);
				}
				System.out.println("sql:" + sql);
				System.out.println("rs:" + rs);

				uf = new UpdateForm(daimei, syosai, juyodoval, kigen);
			}
				return uf;


		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}

}
