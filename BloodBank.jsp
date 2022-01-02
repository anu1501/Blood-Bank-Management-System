<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {text-align: center;}
p {text-align: center;}
fieldset{
  border: 1px solid rgb(255,0,0);
  width: 400px;
  float: center;
  margin: auto;
}
legend {text-align: center;}
a {text-align: center;}
</style>
<meta charset="ISO-8859-1">
<title>Blood Bank</title>
</head>
<body> 
<h1>BLOOD BANK</h1>
	<p>
	<%
		Integer count = (Integer)application.getAttribute("visitor");
		if(count==null)
		{
			count = 1;
			out.println("Welcome to the page! ");
		}
		else
		{
			out.println("Welcome back to the page!");
			count++;
		}
		application.setAttribute("visitor", count);
	%>
	</p>
	<fieldset> 
<legend>LOGIN AS: </legend>  
<a href="adminlogin.html">Admin.<br></a>
<a href="donorlogin.html">Donor.<br></a>
<a href="ViewBloodBank">View Blood Bank.<br></a>
</fieldset> 
</body>
</html>