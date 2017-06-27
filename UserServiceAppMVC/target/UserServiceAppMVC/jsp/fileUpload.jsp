<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>File Upload Example</title>
</head>
<body>
  <%--  <form:form method="POST" modelAttribute="fileUpload"
      enctype="multipart/form-data">
      Please select a file to upload : 
      <input type="file" name="file" />
      <input type="submit" value="upload" />
   </form:form>
    --%>
    <form action="/UserServiceAppMVC/upload" method="post"
			enctype="multipart/form-data">
			Select File to Upload:<input type="file" name="file"> <br><br><br>
			<input type="submit" value="Upload file">
			
			<%-- <%if(request.getAttribute("error")!=null){ %>
			<p style="color: red;">*Invalid Extension</p>
			<%} %> --%>
		</form>
</body>
</html>