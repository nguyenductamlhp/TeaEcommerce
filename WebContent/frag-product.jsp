
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@page import="model.data.Product"%>
<%@page import="model.service.ProductService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.data.Product"%>
<%@page import="model.service.ProductService"%>
<%@page import="model.data.User"%>

	<%
	ProductService proService = new ProductService();
    List<Product> list = proService.getAllProduct();
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="single-sidebar">
		<h2 class="sidebar-title">Products</h2>
        <%
        for (Product product : list) {
		%>
        	<div class="thubmnail-recent">
            	<img src="<%=product.getImageLink()%>" class="recent-thumb" alt="">
                	<h2><a href=""><%=product.getName()%></a></h2>
					<div class="product-sidebar-price">
                    	<ins>$<%=product.getPrice()%></ins> <del>$<%=product.getPrice_promotion()%></del>
                    </div>                             
			</div>
		<%	
        }
        %>
	</div>

</body>
</html>