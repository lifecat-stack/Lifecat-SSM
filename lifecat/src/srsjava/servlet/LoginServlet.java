package srsjava.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.UserException;

import srsjava.bean.User;
import srsjava.dao.UserDAO;
import srsjava.util.DBUtil;

/**
 * 用户登录servlet 登录成功--跳转到userhome.jsp 登录失败--返回到index.jsp
 * 
 * @author 59682
 * 
 */
public class LoginServlet extends HttpServlet {
	/**
	 * doPost方法
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* super.doPost(req, resp); */

		// 获取表单信息 username password
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String message = "";
		String page = "";
		boolean success = false; // 是否需要跳转？
		boolean redirect = false; // 是否重定向？

		System.out.println("点击了登录按钮");

		// 连接数据库，进行登录检验
		UserDAO userdao = new UserDAO();

		try {
			// 判断是否有这个 username
			if (userdao.isNameExisted(username)) {
				// 若有此用户名,验证密码
				if (userdao.login(username, password)) {
					// 若密码正确
					User user = userdao.getByName(username);

					// 创建session对话连接并设置属性
					HttpSession session = req.getSession();
					session.setAttribute("User", user);

					// 跳转到home.jsp
					System.out.println("用户名和密码都正确");
					success = true;
					// 重定向senRedirect
					redirect = true;
					page = "userhome.jsp";

				} else {
					// 若密码不正确
					message = "密码错误";
				}
			} else {
				// 若无此用户名
				message = "用户不存在";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 若success为false
		if (!success) {
			// 如果出现错误，则返回到登陆页面，并将用户输入的错误信息带回
			message = "登录出现错误....!";
			req.setAttribute("message", message);
			req.setAttribute("username", username);
			req.setAttribute("password", password);
			// 无需重定向,getRequestDispatcher
			redirect = false;
			page = "index.jsp";
		}

		if (redirect) {
			// 重定向跳转到userhome
			System.out.println("重定向到userhome.jsp");
			resp.sendRedirect(page);
			return;
		} else {
			System.out.println("重定向到index.jsp");
			req.getRequestDispatcher(page).forward(req, resp);
			return;
		}
	}
}
