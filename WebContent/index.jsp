<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Example in JSP and Servlet - Java web
	application</title>
</head>

<body>
	<div>
		<img src="https://www.underconsideration.com/brandnew/archives/capgemini_logo.png" alt="Capgemini" width="250" height="90">
		<br> 
		<h3 style="color:blue;">Choose File to Upload</h3>
		<form action="Upload" method="post" enctype="multipart/form-data">
			<input type="file" name="file" /> <br> <br> <input
				type="submit" value="upload" />
		</form>
	</div>
</body>
</html>
