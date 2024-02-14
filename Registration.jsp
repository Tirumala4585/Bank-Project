<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="http://localhost:8082/RegistrationProject/RegistrationServlet" method="post">
  <table>
     <tr>
       <th><label>Name</label>
       <th><input type="text" name="uname"></th>
      </tr>
      <tr>
        <th><label>Email</label></th>
        <th><input type="text" name="ename"></th>
      </tr>
      <tr>
        <th><label>Phno</label></th>
        <th><input type="text" name="phname"></th>
     </tr>
     <tr>
       <th><label>Password</label></th>
       <th><input type="password" name="pname"></th>
     </tr>
     <tr>
       <th><label>Conform Password</label></th>
       <th><input type="password" name="cname"></th>
     </tr>
     <tr>
       <th><input type="submit" value="Submit"></th>
     </tr> 
     </table>
     </form>     
</body>
</html>