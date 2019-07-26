<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<c:choose>
 <c:when test="${!empty listStudentDTO }">
  <table align="center" border="1" bgcolor="yellow">
    <tr style="color: red">
     <th>SRNO</th>
     <th>SID</th>
     <th>SNAME</th>
     <th>COURSEFEE</th>
     <th>LIBID</th>
     <th>JOINDATE</th>
     <th>LIBFEE</th>
     <th>DELETEPARENT</th>
     <th>DELETECHILD</th>
    </tr>
   <c:forEach var="dto" items="${listStudentDTO}">
    <tr style="color: blue">
      <td>${dto.srno}</td>
      <td>${dto.sid}</td>
      <td>${dto.sname}</td>
      <td>${dto.coursefee}</td>
      <td>${dto.library.libid}</td>
      <td>${dto.library.joinDate}</td>
      <td>${dto.library.libfee}</td>
      <td>
         <a href="controller?option=deleteParent&id=${dto.sid}" onclick="return confirm('Are you sure to delete ${dto.sid} record?')"><img src="images/deleteIcon.png" width="30" height="30"></a>
        </td>
         <td>
         <a href="delete.htm?option=deleteChild&id=${dto.sid}" onclick="return confirm('Are you sure to delete ${dto.sid} record?')"><img src="images/deleteIcon.png" width="30" height="30"></a>
         </td>
    </tr>
   </c:forEach>         
  </table>
 </c:when>
 <c:otherwise>
  <h1 style="color: red;text-align: center">No Records Found</h1>
 </c:otherwise>
</c:choose>

<c:if test="${!empty resultMsg}">
   <h1 style="color: red;text-align: center">${resultMsg}</h1>
</c:if>

<a href="welcome.jsp">home</a>
<br>
<a href="form.jsp">add more</a>
