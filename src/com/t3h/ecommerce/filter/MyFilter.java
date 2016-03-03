package com.t3h.ecommerce.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/add-product.jsp")
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
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
		
		HttpServletRequest rq=(HttpServletRequest)request;
		String user=(String) rq.getSession().getAttribute("user");
		String uri=rq.getRequestURI();
		if(uri.equals("index.jsp")){
			request.getRequestDispatcher("GetEcomProduct")
			.forward(request, response);
			System.out.println("dshhhhhhhh");
		}
		else if(uri.endsWith("css")||uri.endsWith("js")||uri.endsWith("jpg")||uri.endsWith("png")){
			chain.doFilter(request, response);
		}
		if(user!=null){
			chain.doFilter(request, response);
		}else{
			request.setAttribute("str", "Request login success!");
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
