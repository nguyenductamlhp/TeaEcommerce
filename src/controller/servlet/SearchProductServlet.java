package controller.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import model.data.Product;
import model.service.ProductService;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductService proService = new ProductService();
		String SearchKey = request.getParameter("SearchKey");
		
		try {
			
			Product product = proService.getProduct(SearchKey);
			if (product != null) {
			
				request.setAttribute("product", proService.getProduct(SearchKey));
				request.getRequestDispatcher("single-product.jsp").forward(request, response);;
				return;
			}
		} catch (SQLException e) {
			
			response.getWriter().println(e);
			e.printStackTrace();
		} finally {
		
		}
		
		request.getRequestDispatcher("single-product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
