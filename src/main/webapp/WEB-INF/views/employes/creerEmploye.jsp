<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Ajouter un employé</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
  		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>       
    </head>
    <body>

        <div>
            <form method="get" action="<c:url value="/mvc/employes/ajouter"/>">
                <fieldset>
                    <legend>Informations nouveau employé</legend>
					<label for="matricule">Matricule<span class="requis">*</span></label>
                    <input type="text" id="matricule" name="matricule" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="entreprises">Entreprise </label>
	                    <SELECT name="listeEntreprises" size="1">
		                    <c:forEach var="entreprise"  items="${listeNomEntreprise}" >
		          				<option value="${entreprise.id}"> ${entreprise.denomination} </option>
							</c:forEach>
						</SELECT>                    
                    <br />
                                           
                    <label for="profils">Profil</label>              
	                    <SELECT name="listeProfils" size="1">
	                    <c:forEach var="Profil"  items="${listeProfils}" >
	          					<option value="${Profil.id}"> ${Profil.code} </option>
						</c:forEach>
						</SELECT>
                    <br /> 

                    <label for="grades">Grade</label>
                    <SELECT name="listeGrades" size="1">
	                    <c:forEach var="Grade"  items="${listeGrades}" >
	          					<option value="${Grade.id}"> ${Grade.code} </option>
						</c:forEach>
						</SELECT>
                    <br />                                        
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>