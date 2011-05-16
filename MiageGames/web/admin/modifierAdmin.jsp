<%-- 
    Document   : modifierAdmin
    Created on : 15 mai 2011, 19:17:31
    Author     : Sangre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Miage Games - Modifier Compte Admin</title>
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

            <div class="block">
                <div class="block-bot">
                    <div class="head">
                        <div class="head-cnt">
                            <h3>Modifier votre compte</h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>

                    <span id="erreurModification" style="display:none"></span>
                    <form class="formulaire" id ="formModificationA" name="session" action="" method=post>
                        <fieldset>
                            <legend>Information du compte</legend>
                            <label class="texte" for="login_a">Nom de compte: </label>
                            <input type ="text"name="login_a" id="login_a" value="${modifCompte.login}"/>
                            <br />
                            <label class="texte" for="password_a">Password:</label>
                            <input type="password" name="password_a" id="password_a" value="${modifCompte.password}"/>
                            <br />
                            <label class="texte" for="password_ver"></label>
                            <input  type="password" name="password_ver" id="password_ver" value="${modifCompte.password}"/>
                            <br />
                        </fieldset>
                        <fieldset>
                            <legend>Informations personnelles</legend>
                            <label class="texte" for="nom">Nom: </label>
                            <input type="text" name="nom" id="nom" value="${modifCompte.nom}"/>
                            <br />
                            <label class="texte" for="email">E-mail:</label>
                            <input type="text" name="email" id="email" value="${modifCompte.email}"/>
                            <br />
                            <label class="texte" for="num_tel">Numéro de téléphone:</label>
                            <input type="text" name="num_tel" id="num_tel" value="${modifCompte.telephone}"/>
                            <br />
                        </fieldset>
                        <br />
                        <input id="ValiderModifierBouton" class="button" value=" Valider " name="Valider" type="submit" />
                        <br />
                    </form>
                </div>
            </div>
        </div>

        <%@include file="/config/menu.jsp" %>
        <%@include file="/config/footer.jsp" %>

    </body>
</html>


