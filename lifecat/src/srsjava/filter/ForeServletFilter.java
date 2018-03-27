/*package srsjava.filter;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.lang.StringUtils;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import srsjava.bean.*;
import srsjava.dao.*;


public class ForeServletFilter implements Filter {
	
	@Override
    public void destroy() {
 
    }
	
	@Override
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//getServletContext():获取page上下文
		//getContextPath():获取项目名
		String contextPath = request.getSession().getServletContext().getContextPath();
		request.getSession().getServletContext().setAttribute("contextPath", contextPath);
		
		String[] noNeedAuthPage = new String[]{
				"login",
				"register"
        };
		ArrayList<String> a=new ArrayList<String>();
		a.add(noNeedAuthPage[0]);
		a.add(noNeedAuthPage[1]);
		
		String uri = request.getRequestURI();
		uri = StringUtils.remove(uri, contextPath);
		
		if(uri.startsWith("/fore") && !uri.startsWith("/foreServlet")){
			String method = StringUtils.substringAfterLast(uri,"/fore" );
            if(!a.contains(method)){
                
                if(null==(User) request.getSession().getAttribute("user")){
                	System.out.println((User) request.getSession().getAttribute("user"));
                    response.sendRedirect("index.jsp");
                    return;
                }
            }
			request.setAttribute("method", method);
			req.getRequestDispatcher("/foreServlet").forward(request, response);
			return;
		}
		if(uri.startsWith("/admin_")){
			System.out.println("拦截/admin成功");
			//获取Category + Servlet
			String servletPath = StringUtils.substringBetween(uri,"_","_") + "Servlet";
			//获取list
			String method = StringUtils.substringAfterLast(uri,"_");
			//将list传递给servlet,调用对应方法
			System.out.println(method);
			request.setAttribute("method", method);
			//请求转发到CategoryServlet
			System.out.println("/" + servletPath);
			req.getRequestDispatcher("/" + servletPath).forward(request, response);
			
			return;
			//中断过滤器，服务端跳转/categoryServlet就到了CategoryServlet这个类里
		}
		chain.doFilter(request, response);
		
		
		
		
		
	}
	@Override
	public void init (FilterConfig arg0) throws ServletException {
		System.out.println("First Filter init()");
		
	}
	
	
	
}
*/