package com.lnt.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 
 the web-inf secures the web page and these pages are never directly accesible to user.The pages of 
 this folder are accesible to user through dispatching done by FC.........
 Dispatching always considers project as a root folder n the path to be mentioned must be relative to project folder

 *Session Creation:
 *Creates a unique session Id for the user.This id is used throughout the session.
 *Creates a session space for user to hold session/user specific data
 *With each response to the user,the sessionid is sent.And with each req from the user same sessionid is brought back. 
 *From the sessionId the session space is mapped to the user.
 *
 *
 *For a user never more than one session is created.
 *getSession creates session for first tym and bring the same session reference for next times too.
 *false getsession brings null if session not existing already else if exists then brings reference.
 */

@WebServlet(urlPatterns="*.do", loadOnStartup=1 )
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private EmpService service;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String cmd=getCommand(uri);
		System.out.println(cmd);
		System.out.println(uri);
		RequestDispatcher dispatch=null;
		String preFix="/WEB-INF/pages/";
		String postFix=".jsp";
		String jspName=null;
		try {
			switch(cmd) {
			case "*":
			case "home":{
				jspName="Home";
				
				
				break;
			}
			case "Login":{
				jspName="Login";
				
				break;
			}
			case "logout":{
				//Drop the session 
				HttpSession session=request.getSession(false);
				session.invalidate();//drops the session
				jspName="Login";
				break;
			}
			case "Authenticate":{
				String username=request.getParameter("userName");
				String password=request.getParameter("pwd");
				
				if(username.equals("hr")&& password.equals("hr")) {
				
					HttpSession session=request.getSession(true);//create a session for the user.
					session.setMaxInactiveInterval(120);
				System.out.println(session.getId());
				session.setAttribute("name", "hrhr hrhr hrhr");
				jspName="MainMenu";
				
				}
				else {
					request.setAttribute("message", "Wrong username or password");
					jspName="Login";
				}		
				break;
			}
			
			case "MainMenu":{
				jspName="MainMenu";
				break;
			}
			
			default:{
				request.setAttribute("errmsg","Wrong/Unknown command");
jspName="Error";
			
				System.out.println("wrong command :/ ");
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errormsg", e.getMessage());
			jspName="Error";
		}
		 dispatch=request.getRequestDispatcher(preFix + jspName + postFix);
		dispatch.include(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException  {
		//injection to get reference of service layer
		//service=new EmpServicesImpl();
		
	}

	
	public void destroy() {
	}

	private String getCommand(String uri) {
		int idxSlash=uri.lastIndexOf("/");
		int idxDot=uri.lastIndexOf(".");
		return uri.substring(idxSlash+1, idxDot);
	}
	
	
}
