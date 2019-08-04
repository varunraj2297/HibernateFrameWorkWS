<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@page import="com.nt.dto.ProjectDTO" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>results</title>
</head>
<body>


<%
      ProjectDTO dto=(ProjectDTO)request.getAttribute("dto");
      if(dto!=null) {
      %>    
      
      <h1 style="text-align:center;color:red">Results</h1>  
		<table border="2" bgcolor="cyan" align="center">
		<tr>
		   <td><%=dto.getProjid()%></td>
			<td><%=dto.getProjname()%></td>
			<td><%=dto.getDomain()%></td>
			<td><%=dto.getTeamsize()%></td>
			<td><%=dto.getProjstartdate() %></td>
			<td><%=dto.getProjenddate() %></td>
		</tr>
		</table>
		
     <% }  else  {
          out.println("record not found") ; 
     } %>
      
     <a href="input.html">home</a>
	
</body>
</html>