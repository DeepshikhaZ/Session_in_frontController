package com.lnt.web.filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/*@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/*.do" })*/
public class Filter1 implements Filter {
	//lifecycle method for Filter.Executed once at time of deployment 
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("In init() of Filter1");
	}

  @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//before Part
	  System.out.println("In Before doFilter() of Filter1");
	  //Check for authentication and authorization
	  //Check for size of request.If larger than expected refuse the request.
		chain.doFilter(request, response); //it directs req to reach to next step(may be servlet)
		//After Part
		System.out.println("In After doFilter() of Filter1");
		//Modify response
		//Zip/Encrypt response
		//Audit the request.
		
	}

	
	
  @Override
	public void destroy() {
		System.out.println("In destroy() method of Filter1");
	}

}
