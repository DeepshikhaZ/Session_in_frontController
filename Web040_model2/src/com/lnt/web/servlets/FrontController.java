package com.lnt.web.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Document Object
import com.itextpdf.text.Document;
//For adding content into PDF document
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.DocumentException;
//import com.lnt.core.daos.OutputStream;
import com.lnt.core.entities.Employee;
import com.lnt.core.exceptions.EmpException;
import com.lnt.core.services.EmpService;
import com.lnt.core.services.EmpServicesImpl;
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
 */

@WebServlet(urlPatterns="*.do", loadOnStartup=1 )
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService service;
	

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
			case "Authenticate":{
				String username=request.getParameter("userName");
				String password=request.getParameter("pwd");
				
				if(username.equals("hr")&& password.equals("hr")) {
				HttpSession session=request.getSession(true);//create a session for the user.
				jspName="MainMenu";
				
				}
				else {
					request.setAttribute("message", "Wrong username or password");
					jspName="Login";
				}		
				break;
			}
			case "GetEmpList":{
			    
				List<Employee> empList=service.getEmpList();
				request.setAttribute("List", empList);
				jspName="List";
				break;
			}
			case "GetEmpListpdf":{
			    /*response.setContentType("application/pdf;charset=UTF-8");
			    ServletOutputStream out = response.getOutputStream();
				//List<Employee> empList=service.getEmpList();
				
				ByteArrayOutputStream baos = GeneratePdf.getPdfFile(empList);
		        baos.writeTo(out);
				jspName="List";*/
				generatePdf(request,response);
				break;
			}
			case "MainMenu":{
				jspName="MainMenu";
				break;
			}
			case "acceptEmpNo":{
				jspName="AcceptEmpNo";
				break;
			}
			case "getEmpDetails":{
			
		     
				String strEmpNo = request.getParameter("empNo");
				int empNo = Integer.parseInt(strEmpNo);
				Employee emp = service.getEmpDetails(empNo);
				request.setAttribute("emp", emp);
				
				jspName="GetEmpDetails";//show EMP details wala method
				break;
			}
			
			default:{
				request.setAttribute("errmsg","Wrong/Unknown command");
jspName="Error";
			
				System.out.println("wrong command :/ ");
			}
			}
		} catch (EmpException e) {
			e.printStackTrace();
			request.setAttribute("errormsg", e.getMessage());
			jspName="Error";
		}
		 dispatch=request.getRequestDispatcher(preFix + jspName + postFix);
		dispatch.include(request,response);
	}


	private void generatePdf(HttpServletRequest request, HttpServletResponse response) {
		//Set content type to application / pdf
        //browser will open the document only if this is set
        response.setContentType("application/pdf");
        //Get the output stream for writing PDF object        
        ServletOutputStream out=null;
      
		try {
			out = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
        	List<Employee> empList=service.getEmpList();
        	  Iterator<Employee> itr = empList.iterator();
            Document document = new Document();
            document.open();
            /* Basic PDF Creation inside servlet */
            while(itr.hasNext()) {
            PdfWriter.getInstance(document, out);
            
            document.add(new Paragraph(empList.empNm));
            }
            document.close();
        }
          catch (Exception exc){
                exc.printStackTrace();
              
                }
        finally {            
            try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException  {
		//injection to get reference of service layer
		service=new EmpServicesImpl();
		
	}

	
	public void destroy() {
	}

	private String getCommand(String uri) {
		int idxSlash=uri.lastIndexOf("/");
		int idxDot=uri.lastIndexOf(".");
		return uri.substring(idxSlash+1, idxDot);
	}
	
	
}
