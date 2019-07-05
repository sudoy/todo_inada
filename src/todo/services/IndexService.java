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

	public List<IndexForm> service(String sql) throws ServletException {//一覧に必要なデータの取得

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<IndexForm> form = new ArrayList<>();

		try {
			con = DBUtils.getConnection();

			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				String number = rs.getString("number");
				String daimei = rs.getString("daimei");
				String juyodoval = HTMLUtils.juyodoFormat(rs.getString("juyodoval"));
				String kigen = rs.getString("kigen");
				if (kigen != null) {
					kigen = HTMLUtils.kigenFormat(kigen);
				}
				String status = rs.getString("status");

				IndexForm f = new IndexForm(number, daimei, juyodoval, kigen, status);
				form.add(f);
			}
			return form;

		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			DBUtils.close(con, ps, rs);
		}
	}

	public void kanryoService(IndexForm form) throws ServletException {
		String[] knArray = form.getKanryoNumArray();//完了しているもののnumberの配列

		for (int i = 0; i < knArray.length; i++) {//一つ一つ取り出してstatusを1に更新
			String num = knArray[i];

			Connection con = null;
			PreparedStatement ps = null;
			String sql = null;

			try {

				con = DBUtils.getConnection();
				sql = "update todolist set status = ? where number = ?";
				ps = con.prepareStatement(sql);

				ps.setString(1, "1");
				ps.setString(2, num);

				ps.executeUpdate();
			} catch (Exception e) {
				throw new ServletException(e);
			} finally {
				DBUtils.close(con, ps);
			}

		}

	}

}
