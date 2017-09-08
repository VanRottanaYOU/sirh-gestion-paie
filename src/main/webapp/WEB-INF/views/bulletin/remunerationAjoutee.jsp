<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création bulletin de salaire</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>       
    </head>
    <body>

        <div>
            <form method="get" action="<c:url value="/mvc/bulletin/AjouterRemuneration"/>">
                <fieldset>
                    <legend>Créer bulletin de salaire</legend>
                    
					<label for="periodes">Période<span class="requis">*</span></label>
	                <input type="text" id="periodes" name="periodes" value="${monBulletinSalaire.periode}" size="20" maxlength="20" />                       
                    <br />
                    <br />
                                                                                  
                    <label for="remunerationEmploye">Matricule</label>              
	                 <input type="text" id="remunerationEmploye" name="remunerationEmploye" value="${monBulletinSalaire.remunerationEmploye}" size="20" maxlength="20" />   
                    <br /> 

                    <label for="prime">Primes Exceptionnelles</label>
					<input type="text" id="prime" name="prime" value="${monBulletinSalaire.primeExceptionnelle}" size="20" maxlength="20" /> 
                    <br />                                        
                </fieldset>

            </form>
        </div>
    </body>
</html>