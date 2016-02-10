package com.store.catalog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
			    {
			        response.setContentType("text/html");
			        PrintWriter out = response.getWriter();
			        out.println("<html>");
			        out.println("<body>");
			        out.println("<head>");
			        out.println("<title>My first servlet</title>");
			        out.println("</head>");
			        out.println("<body>");
			        out.println("<h3>My first servlet</h3>");
			        out.println("Method: " + request.getMethod());
			        out.println("Request URI: " + request.getRequestURI());
			        out.println("Protocol: " + request.getProtocol());
			        out.println("</body>");
			        out.println("</html>");
			    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        doGet(request, response);
    }
}
