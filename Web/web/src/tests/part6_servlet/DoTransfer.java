package tests.part6_servlet;

import tests.part6_servlet.utils.DBUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoTransfer extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		var con = DBUtils.getConnection();

		var account_from = req.getParameter("account_from");
		var account_to = req.getParameter("account_to");
		var amount = Integer.valueOf(req.getParameter("amount"));

		var sql1 = "select money from Account where name=?";
		try {
			con.setAutoCommit(false);

			var pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, account_from);
			var rs1 = pstmt1.executeQuery();
			pstmt1.setString(1, account_to);
			var rs2 = pstmt1.executeQuery();
			pstmt1.close();

			if (rs1.next() && rs2.next()) {
				//判断余额
				if (rs1.getInt("money") < amount) System.out.println("余额不足！");

				//扣钱
				var sql2 = "update Account set money=money+? where name=?";
				var pstmt2 = con.prepareStatement(sql2);
				pstmt2.setInt(1, -amount);
				pstmt2.setString(2, account_from);
				pstmt2.executeUpdate();
				//加钱
				pstmt2.setInt(1, amount);
				pstmt2.setString(2, account_to);
				if(pstmt2.executeUpdate() == 1){
					System.out.println("转账成功！");
					con.commit();
				}else{
					System.out.println("转账失败！");
					con.rollback();
				}
				pstmt2.close();
			} else {
				System.out.println("账户不存在！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DBUtils.closeConnection(con);
	}
}
