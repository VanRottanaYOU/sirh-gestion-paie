<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des employés</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>       
    </head>
    <body>
        <table border =1>
        <tr>
        	<td>Date heure création</td>
        	<td>Matricule</td>
        	<td>Grade</td>
        	<c:forEach var="remuEmploye"  items="${listeEmployes}" >
		         <tr> 
		        	 <td> Absent </td>
		      	 	 <td> "${remuEmploye.matricule}" </td>
		       	 	 <td> "${remuEmploye.grade.code}" </td>
		         </tr>
			</c:forEach>
        </tr>
    </body>
</html>