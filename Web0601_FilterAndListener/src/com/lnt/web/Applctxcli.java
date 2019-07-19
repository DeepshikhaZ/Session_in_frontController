package com.lnt.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class Applctxcli implements ServletContextListener {

//at  the time of deployment
	//declare resources essential for whole application
    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("in appclxListener-contextInitialized()");    
    
    	arg0.getServletContext().setAttribute("interestrate", 11.5);
    }
	//Undeployment 
    //close and clean resources at the time of creation of servlet context
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("in appclxListener-contextDestroyed()");

    }

}
