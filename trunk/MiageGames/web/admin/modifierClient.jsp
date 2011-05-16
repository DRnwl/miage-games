<%-- 
    Document   : modifierClient
    Created on : 15 mai 2011, 14:19:27
    Author     : Sangre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Miage Games - Modifier Compte Client</title>
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
                    <form class="formulaire" id ="formModificationC" name="session" action="" method=post>
                        <fieldset>
                            <legend>Information du compte</legend>
                            <label class="texte" for="login_cm">Nom de compte: </label>
                            <input type ="text"name="login_cm" id="login_cm" value="${modifCompte.login}" />
                            <br />
                            <label class="texte" for="password_cm">Password:</label>
                            <input type="password" name="password_cm" id="password_cm" value="${modifCompte.password}"/>
                            <br />
                            <label class="texte" for="password_ver_cm"></label>
                            <input  type="password" name="password_ver_cm" id="password_ver_cm" value="${modifCompte.password}"/>
                            <br />
                        </fieldset>
                        <fieldset>
                            <legend>Informations personnelles</legend>
                            <label class="texte" for="nom_cm">Nom: </label>
                            <input type="text" name="nom_cm" id="nom_cm" value="${modifCompte.nom}"/>
                            <br />
                            <label class="texte" for="prenom_cm">Prénom:</label>
                            <input type="text" name="prenom_cm" id="prenom_cm" value="${modifCompte.prenom}"/>
                            <br />
                            <label class="texte" for="email_cm">E-mail:</label>
                            <input type="text" name="email_cm" id="email_cm" value="${modifCompte.email}"/>
                            <br />
                            <label class="texte" for="num_tel_cm">Numéro de téléphone:</label>
                            <input type="text" name="num_tel_cm" id="num_tel_cm" value="${modifCompte.telephone}"/>
                            <br />
                        </fieldset>
                        <fieldset>
                            <legend>Adresse Facturation</legend>
                            <label class="texte"  for="adresse_f_cm">Adresse: </label>
                            <input type="text" name="adresse_f_cm" id="adresse_f_cm" value="${modifCompte.adrFact}"/>
                            <br />
                            <label class="texte"  for="adresse_f_suite_cm"></label>
                            <input type="text" name="adresse_f_suite_cm" id="adresse_f_suite_cm" />
                            <br />
                            <label class="texte"  for="adresse_f_zip_cm">Zip: </label>
                            <input type="text" name="adresse_f_zip_cm" id="adresse_f_zip_cm" value="${modifCompte.adrFactZip}" />
                            <br />
                            <label class="texte"  for="adresse_f_ville_cm">Ville: </label>
                            <input type="text" name="adresse_f_ville_cm" id="adresse_f_ville_cm" value="${modifCompte.adrFactVille}"/>
                            <br />
                        </fieldset>
                        <fieldset>
                            <legend>Adresse Livraison</legend>
                            <label class="texte"  for="adresse_l_cm">Adresse: </label>
                            <input type="text" name="adresse_l_cm" id="adresse_l_cm" value="${modifCompte.adrLivraison}"/>
                            <br />
                            <label class="texte"  for="adresse_l_suite_cm"></label>
                            <input type="text" name="adresse_l_suite_cm" id="adresse_l_suite_cm"/>
                            <br />
                            <label class="texte"  for="adresse_l_zip_cm">Zip: </label>
                            <input type="text" name="adresse_l_zip_cm" id="adresse_l_zip_cm" value="${modifCompte.adrLivrZip}"/>
                            <br />
                            <label class="texte"  for="adresse_l_ville_cm">Ville: </label>
                            <input type="text" name="adresse_l_ville_cm" id="adresse_l_ville_cm" value="${modifCompte.adrLivrVille}"/>
                            <br />
                        </fieldset>

                        <br />
                        <input id="ValiderModifierBoutonC" class="button" value=" Valider " name="Valider" type="submit" />
                    <br />
                    </form>

                    
                </div>
            </div>
        </div>
        <%@include file="/config/menu.jsp" %>
        <%@include file="/config/footer.jsp" %>

    </body>
</html>

