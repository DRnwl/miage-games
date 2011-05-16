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
        <title>Miage Games - Modifier Compte</title>
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
                            <h3>Modifier un compte client</h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <span id="erreurModification" style="display:none"></span>
                    <form class="formulaire" id ="formModificationC" name="session" action="" method=post>
                        <fieldset>
                            <legend>Information du compte</legend>
                            <label class="texte" for="login_c">Nom de compte: </label>
                            <input type ="text"name="login_c" id="login_c" value="${typeUtilisateur.login}" disabled="disabled"/>
                            <br />
                            <label class="texte" for="password_c">Password:</label>
                            <input type="password" name="password_c" id="password_c" value="${typeUtilisateur.password}"/>
                            <br />
                            <label class="texte" for="password_ver"></label>
                            <input  type="password" name="password_ver" id="password_ver" value="${typeUtilisateur.password}"/>
                            <br />
                        </fieldset>
                        <fieldset>
                            <legend>Informations personnelles</legend>
                            <label class="texte" for="nom">Nom: </label>
                            <input type="text" name="nom" id="nom" value="${typeUtilisateur.nom}"/>
                            <br />
                            <label class="texte" for="prenom">Prénom:</label>
                            <input type="text" name="prenom" id="prenom" value="${typeUtilisateur.prenom}"/>
                            <br />
                            <label class="texte" for="email">E-mail:</label>
                            <input type="text" name="email" id="email" value="${typeUtilisateur.email}"/>
                            <br />
                            <label class="texte" for="num_tel">Numéro de téléphone:</label>
                            <input type="text" name="num_tel" id="num_tel" value="${typeUtilisateur.telephone}"/>
                            <br />
                        </fieldset>
                        <fieldset>
                            <legend>Adresse Facturation</legend>
                            <label class="texte"  for="adresse_f">Adresse: </label>
                            <input type="text" name="adresse_f" id="adresse_f" value="${typeUtilisateur.adrFact}"/>
                            <br />
                            <label class="texte"  for="adresse_f_suite"></label>
                            <input type="text" name="adresse_f_suite" id="adresse_f_suite" />
                            <br />
                            <label class="texte"  for="adresse_f_zip">Zip: </label>
                            <input type="text" name="adresse_f_zip" id="adresse_f_zip" value="${typeUtilisateur.adrFactZip}" />
                            <br />
                            <label class="texte"  for="adresse_f_ville">Ville: </label>
                            <input type="text" name="adresse_f_ville" id="adresse_f_ville" value="${typeUtilisateur.adrFactVille}"/>
                            <br />
                        </fieldset>
                        <fieldset>
                            <legend>Adresse Livraison</legend>
                            <label class="texte"  for="adresse_l">Adresse: </label>
                            <input type="text" name="adresse_l" id="adresse_l" value="${typeUtilisateur.adrLivraison}"/>
                            <br />
                            <label class="texte"  for="adresse_l_suite"></label>
                            <input type="text" name="adresse_l_suite" id="adresse_l_suite"/>
                            <br />
                            <label class="texte"  for="adresse_l_zip">Zip: </label>
                            <input type="text" name="adresse_l_zip" id="adresse_l_zip" value="${typeUtilisateur.adrLivrZip}"/>
                            <br />
                            <label class="texte"  for="adresse_l_ville">Ville: </label>
                            <input type="text" name="adresse_l_ville" id="adresse_l_ville" value="${typeUtilisateur.adrLivrVille}"/>
                            <br />
                        </fieldset>

                        <br />
                        <input id="ValiderModifierBouton" class="button" value=" Valider " name="Valider" type="submit" />
                    </form>

                    <br />
                </div>
            </div>
        </div>
        <%@include file="/config/menu.jsp" %>
        <%@include file="/config/footer.jsp" %>

    </body>
</html>

