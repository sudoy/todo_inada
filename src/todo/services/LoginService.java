package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import todo.forms.LoginForm;
import todo.utils.DBUtils;
import todo.utils.SHA2;

public class LoginService {

	public boolean service(LoginForm form) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		boolean b = false;

		try {
			con = DBUtils.getConnection();
			sql = "select mail, pass from user where mail = ? and pass = ?";
			ps = con.prepareStatement(sql);

			//入力されたパスワードをハッシュ化
			String hashPass = SHA2.getSHA256(form.getPass());

			ps.setString(1, form.getMail());
			ps.setString(2, hashPass);

			rs = ps.executeQuery();

			System.out.println(ps);

			while (rs.next()) {
				System.out.println(rs.getString("mail"));
				System.out.println(rs.getString("pass"));

				if (rs.getString("mail") != null && rs.getString("pass") != null) {
					b = true;
				}
			}

			return b;

		} catch (Exception e) {
			e.printStackTrace();
			b = false;
			return b;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}

}
