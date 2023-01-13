package LoginRegister;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Flightbook extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String from = req.getParameter("from");		
     String where = req.getParameter("where");		
     String startdate = req.getParameter("startdate");		
     String returndate = req.getParameter("returndate");		
     String totalpassanger = req.getParameter("totalpassanger");
     Loginjdbc.flight(from,where,startdate,returndate,totalpassanger);
     System.out.println("DATABASE INSTERT");
//     RequestDispatcher dr=req.getRequestDispatcher(totalpassanger);
//    PrintWriter out= resp.getWriter();
//    out.println("<h1>"+from+"</h1>");
//    out.println("<h1>"+where+"</h1>");
//    out.println("<h1>"+startdate+"</h1>");
//    out.println("<h1>"+returndate+"</h1>");
//    out.println("<h1>"+totalpassanger+"</h1>");
     RequestDispatcher rd=req.getRequestDispatcher("/flightsummary.html");
     rd.forward(req, resp);
	}

}
