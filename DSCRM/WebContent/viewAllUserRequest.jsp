<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <table border="1">
    <tr>
             <th>id</th>
              <th>name</th>
              <th>mobile</th>
               <th>email</th>
               <th>requirementDescription</th>
               <th>requesttime</th>
              <th>requestUpdateTime</th>
              
    </tr>
    <c:forEach var="userRequest" items="${userRequests}">
			<tr>
				<td>${userRequest.id}</td>
				<td>${userRequest.name}</td>
				<td>${userRequest.mobile}</td>
				<td>${userRequest.email}</td>
				<td>${userRequest.requestTime}</td>
				<td>${userRequest.requestUpdateTime}</td>
			</tr>
		</c:forEach>
    </table>
</body>
</html>