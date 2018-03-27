package srsjava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import srsjava.bean.User;
import srsjava.bean.UserMsg;
import srsjava.dao.UserDAO;
import srsjava.dao.UserMsgDAO;

/**
 * 更新用户信息
 * 
 * @author 59682
 * 
 */
public class UpdateMSGServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String message = "";

		try {
			UserMsgDAO usermsgdao = new UserMsgDAO();

			System.out.println("试图通过session获去user对象...");

			// 通过session获取当前的用户User状态
			User user = (User) req.getSession().getAttribute("User");

			System.out.println("获取到了req.getSession().getAttribute(user)");

			// 获取表单信息 username password
			String nickname = req.getParameter("nickname");
			String sex = req.getParameter("sex");
			String age = req.getParameter("age");
			String birthday = req.getParameter("birthday");
			String email = req.getParameter("email");
			int id = user.getId();

			System.out.println("获取到了form提交的数据");

			UserMsg usermsg = new UserMsg();

			usermsg.setId(id);
			usermsg.setNickname(nickname);
			usermsg.setSex(sex);
			usermsg.setAge(age);
			usermsg.setBirthday(birthday);
			usermsg.setEmail(email);

			System.out.println("试图更新用户信息...");

			usermsgdao.update(usermsg);

			message = "已成功更新用户信息!";
			System.out.println(message);

			// 更新session属性
			req.getSession().setAttribute("UserMsg", usermsg);
		} catch (Exception e) {
			System.out.println("更新用户信息--ERROR");
			message = "更新失败....";
			e.printStackTrace();
		}

		// 刷新页面
		req.setAttribute("message", message);
		req.getRequestDispatcher("userhome.jsp").forward(req, resp);
		return;
	}
}
