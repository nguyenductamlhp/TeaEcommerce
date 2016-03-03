package controller.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.data.User;
import model.service.UserService;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rp = (HttpServletResponse) response;

		String requestUrl = rq.getRequestURI(); 
		if (requestUrl.contains(".css") || requestUrl.contains("LoginServlet")) {
			chain.doFilter(rq, rp);
			return;
		}
		else {
			List<User> listUser = new ArrayList<>();
			UserService userService = new UserService();
			listUser = userService.getUserList();
			
			User user = (User) rq.getSession().getAttribute("user");
			if (user == null) {
					rq.getRequestDispatcher("login.jsp").forward(rq, rp);
				
			}
			else {
				for (User u : listUser) {
					if (u.getUserName().equals(user.getUserName()) && u.getPassWord().equals(user.getPassWord())) {
						rq.getSession().setAttribute("user", u);
					}
				}				
				chain.doFilter((ServletRequest)rq, (ServletResponse)rp);
			}

		}			
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
