import webman.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;

public class DelUser extends HttpServlet
{
    Connection con=null;

	webman.User U=new webman.User();
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
        U.deleteUser(req.getParameter("uid"));
            pw.println("<html><head><TITLE>Web-Enabled Automated Manufacturing System</TITLE></head>");
			pw.println("<table align='center' border=0>");
			pw.println("<tr col span=2><th>Web-Enabled Automated Manufacturing Process</th></tr>");
			pw.println("<tr><td>User Name :</td><td>"+req.getParameter("uid")+"</td></tr>");

			pw.println("<tr><td>User data is deleted Click on OK to Continue</td></tr>");
			pw.println("<tr><td align=center><a href='http://peers:8080/servlet/deleteUser' target='main'>OK</a></td>");
			pw.println("<td></td></tr>");
			pw.println("</table></form></body></html>");
			pw.flush();
			pw.close();
			
			}
            
}