package LoginRegister;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

public class Log extends HttpServlet {

	private boolean jdbclogin;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String pswrd = req.getParameter("pswrd");
		PrintWriter out = resp.getWriter();
//		out.print("<h1>hello</h1>");
//		out.print("<h1> our compaony boat are ready to work </h1>");
		jdbclogin = Loginjdbc.jdbclogin(pswrd, name);
       if (jdbclogin==true) {
    	   System.out.println("true");
    	   out.print("<h1>succes</h1>");

   		RequestDispatcher rd=req.getRequestDispatcher("/flight.html");
   rd.forward(req, resp);
   		
	}else {
		 out.print("<h1>password is worng</h1>");
		 RequestDispatcher requestDispatcher = req.getRequestDispatcher("/NewFile.html");
		System.out.println("work");
			requestDispatcher.forward(req, resp);
		
	}
	}
}
