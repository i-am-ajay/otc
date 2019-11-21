package com.filix.view;

import java.io.IOException;

import javax.faces.application.ViewExpiredException;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


 
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthFilter implements Filter {
     
    public AuthFilter() {
    }
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
    	try {
            // check whether session variable is set
            HttpSession session = req.getSession(false);           
           // //CMLog.error(1,"inside filter");
            //  allow user to procceed if url is login.xhtml or user logged in or user is accessing any page in //public folder
            String reqURI = req.getRequestURI();
           // System.out.println("session @: "+session);
           // //CMLog.error(1,"reqURI::"+reqURI);
           // System.out.println("reqURI::"+reqURI);
            //consultant_dependent_view.xhtml
            //emp_dependent_view.xhtml
            //patient_otc_view.xhtml
            if ( reqURI.indexOf("/admin/consultant_dependent_view.xhtml") >= 0 || reqURI.indexOf("/accessDenied.xhtml") >= 0 || reqURI.indexOf("/common/fpwd.xhtml") >= 0  || (session != null && session.getAttribute("username") != null)
                                      || reqURI.contains("javax.faces.resource") ) { 
            	////CMLog.error(1,"reqURI"+reqURI);
                   chain.doFilter(request, response);                  
            }
            else  { // user didn't log in but asking for a page that is not allowed so take user to login page
            	//removeSessionAttribute(session);
                   res.sendRedirect(req.getContextPath() + "/admin/consultant_dependent_view.xhtml");  // Anonymous user. Redirect to login page
                   
            }
      }
    catch(ViewExpiredException e){
    	 FacesContext.getCurrentInstance().getViewRoot().getViewId();
    }
     catch(Throwable t) {
         System.out.println("Context Path :"+req.getContextPath());
         res.sendRedirect(req.getContextPath() + "/admin/consultant_dependent_view.xhtml"); 
     }
    } //doFilter
 
    @Override
    public void destroy() {
    	
         
    }
    
 
}
