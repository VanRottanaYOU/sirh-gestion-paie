<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Employé ajouté</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>       
    </head>
    <body>

        <div>
            <form method="get" action="<c:url value="/employeAjoute"/>">
                <fieldset>
                    <legend>Informations nouveau employé</legend>
					<label for="matricule">Matricule<span class="requis"></span></label>
                    <input type="text" id="matricule" name="matricule" value="${employe.matricule}" size="20" maxlength="20" />
                    <br />
                    
                    <label for="entreprise">Entreprise </label>  
                    <input type="text" id="entreprise" name="entreprise" value="${employe.entreprise.denomination}" size="20" maxlength="20" />                
                    <br />
                                           
                    <label for="profil">Profil</label>              
                    <input type="text" id="profil" name="profil" value="${employe.profilRemuneration.code}" size="20" maxlength="20" />
                    <br /> 

                    <label for="grade">Grade</label>
                    <input type="text" id="grade" name="grade" value="${employe.grade.code}" size="20" maxlength="20" />
                    <br />                                        
                </fieldset>

            </form>
        </div>
    </body>
</html>