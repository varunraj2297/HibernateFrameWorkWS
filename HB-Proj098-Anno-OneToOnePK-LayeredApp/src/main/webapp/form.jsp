<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<h1>Student Registration Form</h1>
<form action="controller" method="POST">
  Student details::<br>
   Student name::<input type="text" name="sname"><br>
   Student fee::<input type="text" name="coursefee"><br><br>
   
   Library details::<br>
   Join Date::<input type="text" name="joinDate"><br>
   Library Fee::<input type="text" name="libfee"><br><br>
   <input type="hidden" name="option" value="add">
   <input type="submit" name="register">
</form>