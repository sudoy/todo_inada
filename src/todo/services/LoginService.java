package todo.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import todo.forms.LoginForm;
import todo.utils.DBUtils;
import todo.utils.SHA2;

public class LoginService {

	public LoginForm service(LoginForm form) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = null;
		ResultSet rs = null;

		boolean b = false;
		LoginForm f;
		String name = null;
		String mail = null;
		String pass = null;

		try {
			con = DBUtils.getConnection();
			sql = "select mail, pass, name from user where mail = ? and pass = ?";
			ps = con.prepareStatement(sql);

			//入力されたパスワードをハッシュ化
			String hashPass = SHA2.getSHA256(form.getPass());

			ps.setString(1, form.getMail());
			ps.setString(2, hashPass);

			rs = ps.executeQuery();

			while (rs.next()) {
				name = rs.getString("name");
				mail = rs.getString("mail");
				pass = rs.getString("pass");

				if (mail != null && pass != null) {
					b = true;

				}
			}
			f = new LoginForm(b, name, form.getMail());

			return f;

		} catch (Exception e) {
			e.printStackTrace();
			b = false;
			f = new LoginForm(b, name, form.getMail());
			return f;
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}

}
