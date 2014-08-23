import webman.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;

public class addProduct extends HttpServlet
{
    Connection con=null;
	HttpSession hs=null;
	webman.Product PR=new webman.Product();
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		try{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
	
			if (PR.createProduct(req.getParameter("prid"),req.getParameter("prname"),req.getParameter("prdesc"),Double.parseDouble(req.getParameter("price")),req.getParameter("status"))==true)
			{
		    pw.println("<html><head><TITLE>Web-Enabled Automated Manufacturing System</TITLE></head>");
			pw.println("<table align='center' border=0>");
			pw.println("<tr col span=2><th>Web-Enabled Automated Manufacturing Process</th></tr>");
			pw.println("<tr><td>User Name :</td><td>"+req.getParameter("prid")+"</td></tr>");
			pw.println("<tr><td>Click on OK to Continue</td></tr>");
			pw.println("<tr><td align=center><a href='/servlet/addPrds' target='main'>OK</a></td>");
			pw.println("<td></td></tr>");
			pw.println("</table></form></body></html>");
			pw.flush();
			pw.close();
			}
}catch(Exception e){System.out.println(e);}
			}
            
}