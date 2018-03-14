package com.jcg.examples;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;




@Component("publishServlet")
public class PublishMessageController extends HttpServlet{


	private static final long serialVersionUID = 5661557978988494229L;
	
	@Resource(name = "publishMessages")
	private PublishMessages publishMessages;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			String message = request.getParameter("message");
			
			publishMessages.publishMessage(message);

			RequestDispatcher rd = request.getRequestDispatcher("welcometodemoproject.jsp");

			rd.forward(request, response);
	}
	
	
}
