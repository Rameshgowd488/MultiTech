package Ramservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet1110 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		 String s1=request.getParameter("t2");
		 String s2=request.getParameter("t3");
		 String s3=request.getParameter("t4");
		 String s4=request.getParameter("t5");
		 
		 pw.println(s1);
		 pw.println(s2);
		 pw.println(s3);
		 
		 
	 
	  try
	  {
		  int age=Integer.parseInt(s4);
			if(age>=18)
		{
				
				pw.println("Username"+" "+"age is valid");
			}
			else
			{
			pw.println("Username"+" "+"age is invalid");
			}
	  }
	  catch(NumberFormatException e)
	  {
		  pw.println("invalid age");
	  }
		 
	 
	 
		 
		 pw.close();

	}

	
	
	}


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oter RegistrationForm</title>
</head>
<body>
<form action="Servlet1110" method="get">
<pre>
Enter UserName: <input type ="text"  name="t2">

Enter EmailId:  <input type="text"   name="t3">
Enter PhoneNu:  <input type="text"   name="t4">
Enter UserAge:  <input type="text"   name="t5">

<input type="submit">
</pre>
</form>
</body>

