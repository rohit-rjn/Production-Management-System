import webman.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;
import java.util.*;

public class deleteDealer extends HttpServlet
{
    Connection con=null;
 	HttpSession hs=null;
	Vector v=new Vector();
	int i;
	String id;
	webman.Dealer D=new webman.Dealer();
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		try
		{
 		    PrintWriter pw=res.getWriter();
		    pw.println("<html><head><TITLE>Web-Enabled Automated Manufacturing System</TITLE></head>");
		    pw.println("<body><br><br><br><form name=deleteydealer method=post action='http://peers:8080/servlet/showDealer1')");
        	v=D.allDealers();
		    pw.println("<table align='center' border=0> <tr><td>");
			pw.println("Select Dealer Name To Delete</td><td><SELECT id=select1 name=did style='HEIGHT: 22px; LEFT: 74px; TOP: 222px; WIDTH: 155px'>"); 
			pw.println("<OPTION selected value=''></OPTION>");
			for(i=0;i<v.size();i++)
				pw.println("<OPTION value="+(String)v.elementAt(i)+">"+(String)v.elementAt(i)+"</OPTION>");
     		pw.println("</SELECT></td></tr><tr><td></td><td><input type='submit' name='submit' value='Submit'></td></tr></table></form></body></html>");
			pw.flush();
			pw.close();

			}catch(Exception e){}
	}

}