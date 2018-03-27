package srsjava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import srsjava.bean.User;
import srsjava.dao.UserDAO;

/**
 * 修改密码
 * 
 * @author 59682
 * 
 */
public class UpdatePSWServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 获取表单信息 username password
		String fpassword = req.getParameter("fpassword");
		String password1 = req.getParameter("password1");
		String password2 = req.getParameter("password2");

		String message = "";

		if (fpassword != req.getSession().getAttribute("username")) {
			message = "原密码输入错误";
			System.out.println(message);
		} else if (password1 != password2) {
			message = "两次密码输入不一致";
			System.out.println(message);
		} else {
			// 验证通过
			try {
				UserDAO userdao = new UserDAO();

				// 通过session获取当前的用户User状态
				User user = (User) req.getSession().getAttribute("User");
				
				System.out.println("试图更新密码...");

				// 更新密码
				user.setPassword(password1);
				userdao.updatePassword(user);
				message = "已成功更新密码!";
				System.out.println(message);

				// 更新session属性
				req.getSession().setAttribute("User", user);

			} catch (Exception e) {
				message="更新失败...";
				e.printStackTrace();
			}
		}

		// 刷新页面
		req.setAttribute("message", message);
		req.getRequestDispatcher("userhome.jsp").forward(req, resp);
		return;
	}
}
