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
 * 注册
 * 
 * @author 59682
 * 
 */
public class RegisterServlet extends HttpServlet {
	/**
	 * doPost方法
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 获取表单信息 username password
		String username = req.getParameter("rusername");
		String password = req.getParameter("rpassword");
		String message = "";
		String page = "";
		boolean success = false;
		boolean redirect = false;

		UserDAO userdao = new UserDAO();

		try {
			// 判断是否有这个 username---若无，则执行注册
			if (!userdao.isNameExisted(username)) {

				// 新建user对象
				User user = new User();
				user.setId(userdao.getIdCount() + 1);
				user.setName(username);
				user.setPassword(password);
				user.setLevel("user");

				// 执行注册
				userdao.add(user);

				// 创建session对话连接并设置属性
				HttpSession session = req.getSession();
				session.setAttribute("User", user);

				// 跳转到home.jsp
				System.out.println("用户名和密码都正确");
				success = true;
				redirect = true;
				page = "userhome.jsp";

			} else {
				// 用户名已经存在
				message = "账号已存在";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 若success为false
		if (!success) {
			// 如果出现错误，则返回到登陆页面，并将用户输入的错误信息带回
			message = "注册出现错误....!";
			req.setAttribute("message", message);
			req.setAttribute("username", username);
			req.setAttribute("password", password);
			redirect = false;
			page = "index.jsp";
		}

		if (redirect) {
			// 重定向跳转到userhome
			resp.sendRedirect(page);
			return;
		} else {
			req.getRequestDispatcher(page).forward(req, resp);
			return;
		}
	}
}
