import webman.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;

public class addPart extends HttpServlet
{
    Connection con=null;
	HttpSession hs=null;
	webman.Part P=new webman.Part();
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
	 try{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
			if (P.createPart(req.getParameter("pid"),req.getParameter("pname"),req.getParameter("pdesc"),req.getParameter("status"),Integer.parseInt(req.getParameter("qty")),Integer.parseInt(req.getParameter("rl")))==true)
			{
            pw.println("<html><head><TITLE>Web-Enabled Automated Manufacturing System</TITLE></head>");
			pw.println("<table align='center' border=0>");
			pw.println("<tr col span=2><th>Web-Enabled Automated Manufacturing Process</th></tr>");
			pw.println("<tr><td>Part ID :</td><td>"+req.getParameter("pid")+"</td></tr>");
			pw.println("<tr><td>Part Name:</td><td>"+req.getParameter("pname")+"</td></tr>");
			pw.println("<tr><td>Description:</td><td>"+req.getParameter("pdesc")+"</td></tr>");
			pw.println("<tr><td>ReOrderLevel:</td><td>"+req.getParameter("rl")+"</td></tr>");
			pw.println("<tr><td>Quantity :</td><td>"+req.getParameter("qty")+"</td></tr>");
			pw.println("<tr><td>Status:</td><td>"+req.getParameter("status")+"</td></tr>");
			pw.println("<tr><td>Click on OK to Continue</td></tr>");
			pw.println("<tr><td align=center><a href='/docs/AddPart.html' target='main'>OK</a></td>");
			pw.println("<td></td></tr>");
			pw.println("</table></form></body></html>");
			pw.flush();
			pw.close();
			
			}}catch(Exception e){System.out.println(e);}
			}
            
}