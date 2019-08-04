<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty pageData}">
		<table align="center" border="1" style="background-color: cyan;color: black;border-color: red;font-size: 20px">
			<tr>
				<th>eno</th>
				<th>ename</th>
				<th>job</th>
				<th>sal</th>
			</tr>
			<c:forEach items="${pageData}" var="dto">
			<tr>
			    <td>${dto.eno}</td>
			    <td>${dto.ename}</td>
			    <td>${dto.job}</td>
			    <td>${dto.sal}</td>
			</tr>
            </c:forEach>
		</table>
		<br><br>
		<center>
		<c:forEach var="i" begin="1" end="${pageCount}" step="1">
		   <a href="controller?pageNo=${i}">[${i}]</a>&nbsp;&nbsp;
		</c:forEach>
		</center>
	</c:when>
	<c:otherwise>
       no data found
   </c:otherwise>
</c:choose>