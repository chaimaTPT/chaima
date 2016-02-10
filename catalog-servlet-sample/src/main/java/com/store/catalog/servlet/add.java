package com.store.catalog.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class add extends HttpServlet {
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
        String a=request.getParameter("param1");
        String b=request.getParameter("param2");
        out.println("a= " + a);
        out.println("b= " + b);
        int somme=Integer.parseInt(a)+Integer.parseInt(b);
        out.println("a+b=: " + somme);
        out.println("</body>");
        out.println("</html>");
        
        
        
    }

public void doPost(HttpServletRequest request, HttpServletResponse response)
throws IOException, ServletException
{	        
	
	PrintWriter out = response.getWriter();

	 StringBuilder buffer = new StringBuilder();
     BufferedReader reader = request.getReader();

     String line;
     while((line = reader.readLine()) != null){
         buffer.append(line);
     }

	String in=buffer.toString();;
	String[] S=in.split("\\+");
  //  out.println(in);
    out.println("a= " + S[0]);
    out.println("b= " + S[1]);
    int somme=Integer.parseInt(S[0])+Integer.parseInt(S[1]);
    out.println("a+b=: " + somme);
    }
}
