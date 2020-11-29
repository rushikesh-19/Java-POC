	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title> 
</head>
<body>
<h2>Hello User</h2>

<form action="SendingMail" method="post">
<input type="text" name="name" placeholder="Enter your name" required="required">
<input type="text" name="email" placeholder="Enter your mail" required="required">
<input type="text" name="message" placeholder="Enter your message" required="required">
<input type="submit" value="submit">
</form>
</body>
</html>