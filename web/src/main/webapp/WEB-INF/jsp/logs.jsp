<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>  
<!DOCTYPE HTML>  
  
<html>  
<head>  
<title>Historique</title>  
</head>  
<body>  
  
  
<table>  
    <tr>  
        <th>Action</th>  
        <th>Date</th>  
        <th>Status</th> 
    </tr>  
      
    <c:forEach var="logtemperature" items="${logtemperature}">  
        <tr>  
            <td>insertion de la temperature ${logtemperature.temperature}</td>  
            <td>${logtemperature.date}</td>  
            <td>${logtemperature.accepted}</td> 
        </tr>  
    </c:forEach>  
</table>  
</body>  
</html>