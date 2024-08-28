<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculation Results</title>
</head>
<body>
	<%-- Scriplet tag --%>
<%
    int num1 = Integer.parseInt(request.getParameter("num1"));
    int num2 = Integer.parseInt(request.getParameter("num2"));
    int sum = num1 + num2;
%>

<h2>Results</h2>
	<%-- Expression tag --%>
<p>Sum of <%= num1 %> and <%= num2 %> is: <%= sum %></p>

	<%-- Declaration tag --%>
<%!
    public double calculateAverage(int num1, int num2)
	{
        return (num1 + num2) / 2.0;
    }
%>

<p>Average of <%= num1 %> and <%= num2 %> is: <%= calculateAverage(num1, num2) %></p>

</body>
</html>

