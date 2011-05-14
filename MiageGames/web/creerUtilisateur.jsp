<%-- 
    Document   : categorie
    Created on : 8 mai 2011, 20:25:48
    Author     : Sangre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Miage Games - Creer un utilisateur</title>
        <link rel="stylesheet" href="css/jquery-ui.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
        
        <!--[if IE 6]>
			<link rel="stylesheet" href="css/ie6-style.css" type="text/css" media="all" />
		<![endif]-->
        <script src="js/jquery-1.6.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.8.12.custom.min.js" type="text/javascript"></script>
        <script src="js/jquery.validate.js" type="text/javascript"></script>

        <!-- Script qui permet le changement de jeu dans le cadre principal -->
        <script src="js/fns.js" type="text/javascript"></script>
        <script src="js/validerConnexion.js" type="text/javascript"></script>

    </head>
    <body>
        <%@include file="/config/header.jsp" %>
        <div id="content">
            <h2>Création de compte</h2>
            <div class="block">
                <br />
                <form class="creer-client" id ="formCreation" name="session" action="" method=post>
                    <fieldset>
                        <legend>Information du compte</legend>
                        <label class="texte" for="login">Nom de compte: </label>
                        <input name="login" id="login" />
                        <br />
                        <label class="texte" for="password_c">Password:</label>
                        <input type="text" name="password" id="password_c" />
                        <br />
                        <label class="texte" for="password_ver"></label>
                        <input  type="text" name="password_ver" id="password_ver" />
                        <br />
                    </fieldset>
                    <fieldset>
                        <legend>Informations personnelles</legend>
                        <label class="texte" for="nom">Nom: </label>
                        <input type="text" name="nom" id="nom" />
                        <br />
                        <label class="texte" for="prenom">Prénom:</label>
                        <input type="text" name="prenom" id="prenom" />
                        <br />
                        <label class="texte" for="email">E-mail:</label>
                        <input type="text" name="email" id="email" />
                        <br />
                        <label class="texte" for="num_tel">Numéro de téléphone:</label>
                        <input type="text" name="num_tel" id="num_tel" />
                        <br />
                    </fieldset>
                    <fieldset>
                        <legend>Adresse</legend>
                        <label class="texte"  for="adresse">Adresse: </label>
                        <input type="text" name="adresse" id="adresse" />
                        <br />
                    </fieldset>
                    <br />
                    <input id="ValiderCreationBouton" class="button" value=" Valider " name="Valider" type="submit" />
                </form>
                
                <br />
            </div>
        </div>
        <%@include file="/config/menu.jsp" %>
        <%@include file="/config/footer.jsp" %>

    </body>
</html>
