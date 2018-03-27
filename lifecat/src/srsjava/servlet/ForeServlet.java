/*package srsjava.servlet;
 
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.web.util.HtmlUtils;
 
import srsjava.bean.User;
import srsjava.dao.UserDAO;
import srsjava.util.Page;
 
public class ForeServlet extends BaseForeServlet {
	
    public String home(HttpServletRequest request, HttpServletResponse response, Page page) {
        List<Course> cs= new CourseDAO().list();
        request.setAttribute("cs", cs);
        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getId());
        List<Course> choosen= new CourseDAO().listChoosen(user.getId());
        request.setAttribute("choosen", choosen);
        List<Course> notice= new CourseDAO().listNotice(user.getId());
        request.setAttribute("notice", notice);
        return "home.jsp";
    }
    
    
    
    public String search(HttpServletRequest request, HttpServletResponse response, Page page) {
    	String keyword = request.getParameter("keyword");
        List<Course> ps= new CourseDAO().search(keyword,0,20);
        request.setAttribute("cs",ps);
        return "home.jsp";
    }
  
    
    public String change(HttpServletRequest request, HttpServletResponse response, Page page) {
    	String fpassword = request.getParameter("fpassword");
    	String password1 = request.getParameter("password1");
    	String password2 = request.getParameter("password2");
    	User user = (User) request.getSession().getAttribute("user");
    	if(!user.getPassword().equals(fpassword)){
    		request.setAttribute("msg", "原密码错误，修改失败！");
    		System.out.println("密码修改失败");

    		
    	}else if(! password1.equals(password2)){
    		request.setAttribute("msg", "两次密码不一致，修改失败！");
    		System.out.println("密码修改失败");

    		
    	}else {
    		userDAO.setPassword(user.getId(),password2);
    		
    		request.setAttribute("msg", "修改成功");
    		System.out.println("密码修改成功");
    	}
    	if(user.getLevel().equals("admin"))
        	return "foreahome"; 
        if(user.getLevel().equals("teacher"))
        	return "forethome";
        return "forehome";
    }
    

    public String logout(HttpServletRequest request, HttpServletResponse response,Page page) {
    	request.getSession().removeAttribute("user");
    	return "@index.jsp";
    }
}*/