import webman.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;
import java.util.*;

public class CheckUser extends HttpServlet
{
    Connection con=null;
	HttpSession hs=null;
    String uid;
    String pwd;
	String utype,cname;
	Vector v=new Vector();
	webman.User U=new webman.User();
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		hs=req.getSession(true);
		PrintWriter pw=res.getWriter();
				uid=req.getParameter("uid");
				pwd=req.getParameter("pwd");
			if (U.validUser(uid)==true)
			{
			v=U.ShowUser(uid);
			hs.putValue("uid",uid);
			hs.putValue("pwd",pwd);
			hs.putValue("cname",cname=(String)v.elementAt(0));
			hs.putValue("utype",utype=(String)v.elementAt(3));
            if (utype.equals("Admin"))
            {
            pw.println("<html><head><TITLE>Web-Enabled Automated Manufacturing System</TITLE></head>");
			pw.println("<body><br><br><form name=useradm action='/docs/Frame.htm'>");
			pw.println("<table align='center' border=0>");
			pw.println("<tr col span=2><th>Web-Enabled Automated Manufacturing Process</th></tr>");
			pw.println("<tr><td>User Name :</td><td>"+uid+"</td></tr>");
			pw.println("<tr><td>Member of :</td><td>"+utype+"</td></tr>");
			pw.println("<tr><td align=center><input type='submit' name='submit' value='Submit'></td>");
			pw.println("<td></td></tr>");
			pw.println("</table></form></body></html>");
			}
            if (utype.equals("Dealer"))
            {
            pw.println("<html><head><title>DEALER CHECK</title></head>");
			pw.println("<body><br><br><form name=userDealer action='/docs/DFrame.htm'>");
			pw.println("<table align='center' border=0>");
			pw.println("<tr col span=2><th>Web-Enabled Automated Manufacturing Process</th></tr>");
			pw.println("<tr><td>User Name :</td><td>"+uid+"</td></tr>");
			pw.println("<tr><td>Member of :</td><td>"+utype+"</td></tr>");
			pw.println("<tr><td align=center><input type='submit' name='submit' value='Submit'></td>");
			pw.println("<td></td></tr>");
			pw.println("</table></form></body></html>");
			}
			if (utype.equals("Supplier"))
            {
            pw.println("<html><head><title>SUPPLIER CHECK</title></head>");
			pw.println("<body><br><br><form name=userSupplier action='/docs/SFrame.htm'>");
			pw.println("<table align='center' border=0>");
			pw.println("<tr col span=2><th>Web-Enabled Automated Manufacturing Process</th></tr>");
			pw.println("<tr><td>User Name :</td><td>"+uid+"</td></tr>");
			pw.println("<tr><td>Member of :</td><td>"+utype+"</td></tr>");
			pw.println("<tr><td align=center><input type='submit' name='submit' value='Submit'></td>");
			pw.println("<td></td></tr>");
			pw.println("</table></form></body></html>");
			}
			if (utype.equals("Staff"))
            {
            pw.println("<html><head><title>STAFF CHECK</title></head>");
			pw.println("<body><br><br><form name=userSupplier action='/docs/StFrame.htm'>");
			pw.println("<table align='center' border=0>");
			pw.println("<tr col span=2><th>Web-Enabled Automated Manufacturing Process</th></tr>");
			pw.println("<tr><td>User Name :</td><td>"+uid+"</td></tr>");
			pw.println("<tr><td>Member of :</td><td>"+utype+"</td></tr>");
			pw.println("<tr><td align=center><input type='submit' name='submit' value='Submit'></td>");
			pw.println("<td></td></tr>");
			pw.println("</table></form></body></html>");
			}
			pw.flush();
			pw.close();
			}
		}
        
}