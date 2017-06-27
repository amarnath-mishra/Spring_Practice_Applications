
<%@page import="com.mvcapp1.controllerpackage.UserData"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Hello World</title>
   </head>
   
   <body>
   <form action="/UserServiceAppMVC/adduser" method="post">
    <input type="submit" value="Add more user" />
</form>

          <form action="/UserServiceAppMVC/upload" method="post"
			enctype="multipart/form-data">
			Select File to Upload:<input type="file" name="file"> <br><br><br>
			<input type="submit" value="Upload Json file">
			
			<%-- <%if(request.getAttribute("error")!=null){ %>
			<p style="color: red;">*Invalid Extension</p>
			<%} %> --%>
		</form>
   "src/main"
   <h2>  USER CRUD OPS</h2>
       <h2>${Lname}</h2> 
       <table>
       <tr>
       <td> first name  </td>
       <td>last name  </td>
       <td> ID</td>
       
       </tr>
       <% ArrayList<UserData> list =(ArrayList<UserData>) request.getAttribute("userList"); %>
       <%for(UserData uList : list) { %>
       <tr>
       <td> <%= uList.getFirstName() %> </td> 
       <td><%= uList.getLastName()%>  </td>
       <td> <%=uList.getId()%></td>
       
       <td>
   <form action="/UserServiceAppMVC/updateuser/<%=uList.getId()%>" method="post">
    <input type="submit" value="update User" />
</form> <td>

 <td>
   <form action="/UserServiceAppMVC/deleteuser/<%=uList.getId()%>" method="post">
    <input type="submit" value="Delete User" />
</form> <td>

<td>
   <form action="/UserServiceAppMVC/jasonview/<%=uList.getId()%>" method="post">
    <input type="submit" value="View in Json" />
</form> <td>
       </tr>
       
       
       <%} %>
       
       </table>
       
      
   </body>
</html>