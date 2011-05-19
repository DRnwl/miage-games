<%-- 
    Document   : voirAdmin
    Created on : 15 mai 2011, 20:10:43
    Author     : Sangre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Miage Games - Page Admin</title>
        <link rel="stylesheet" href="css/jquery-ui.css" type="text/css" media="all" />
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

        <!--[if IE 6]>
			<link rel="stylesheet" href="css/ie6-style.css" type="text/css" media="all" />
		<![endif]-->
        <script src="js/jquery-1.6.js" type="text/javascript"></script>
        <script src="js/jquery-ui-1.8.12.custom.min.js" type="text/javascript"></script>
        <script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/tableSorter.js" type="text/javascript"></script>
        <!-- Script qui permet le changement de jeu dans le cadre principal -->
        <script src="js/fns.js" type="text/javascript"></script>
        <script src="js/validerConnexion.js" type="text/javascript"></script>

    </head>
    <body>
        <%@include file="/config/header.jsp" %>

        <div class="cl">&nbsp;</div>
        <!-- Content -->
        <div id="content">
            <div class="block" id="block">
                <div class="block-bot">
                    <div class="head">
                        <div class="head-cnt">
                            <h3><a id="AjoutAdm" href="#" onClick="return false">Ajouter un administrateur</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div style="display:none" id="toggleCrea">
                        <span id="erreurCreation" style="display:none"></span>
                        <form class="formulaire" id ="formCreationA" name="session" action="" method=post>
                            <fieldset>
                                <legend>Information du compte</legend>
                                <label class="texte" for="login_aa">Nom de compte: </label>
                                <input type ="text" name="login_aa" id="login_aa" />
                                <br />
                                <label class="texte" for="password_aa">Password:</label>
                                <input type="password" name="password_aa" id="password_aa" />
                                <br />
                                <label class="texte" for="password_ver_a"></label>
                                <input  type="password" name="password_ver_a" id="password_ver_a"/>
                                <br />
                            </fieldset>
                            <fieldset>
                                <legend>Informations personnelles</legend>
                                <label class="texte" for="nom_a">Nom: </label>
                                <input type="text" name="nom_a" id="nom_a"/>
                                <br />
                                <label class="texte" for="email_a">E-mail:</label>
                                <input type="text" name="email_a" id="email_a"/>
                                <br />
                                <label class="texte" for="num_tel_a">Numéro de téléphone:</label>
                                <input type="text" name="num_tel_a" id="num_tel_a"/>
                                <br />
                            </fieldset>
                            <br />
                            <input id="ValiderAjouterBouton" class="button" value=" Valider " name="Valider" type="submit" />
                            <br />
                        </form>
                    </div>
                </div>

            </div>

            <div class="block">
                <div class="block-bot">
                    <div class="head">
                        <div class="head-cnt">
                            <h3><a id="RechMAdmin" href="#" onClick="return false"> Modifier un administrateur</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div id="toggleModif" style="display:none">
                        <div class="search" >
                            <span id="erreurRecherche" style="display:none"></span>

                            <form   class="formulaire" id ="formRechercheA" name="session" action="" method=post>

                                <fieldset>
                                    <legend>Recherche d'un administrateur</legend>

                                    <div class="fieldplace">
                                        <input class="field" type ="text" name="login_ar" id="login_ar" />
                                    </div>
                                    <input id="ValiderRechercheABouton" class="button" value=" Valider " name="Valider" type="submit" />

                                </fieldset>
                                <br />
                                <br />
                            </form>

                        </div>
                        <span id="erreurModification" style="display:none"></span>
                        <div class="formulaire" id="menuModif" style="display:none"></div>
                    </div>
                </div>
            </div>
            <div class="block">
                <div class="block-bot">
                    <div class="head">
                        <div class="head-cnt">
                            <h3><a  id="SupprAdm" href="#" onClick="return false"> Supprimer un administrateur</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div style="display:none" id="toggleSupp">
                        <div class="search" >
                            <span id="erreurSuppression" style="display:none"></span>
                            <form class="formulaire" id ="formSupprimmerA" name="session" action="" method=post>
                                <fieldset>
                                    <legend>Identifiant du compte</legend>
                                    <div class="fieldplace">
                                        <input class="field" type ="text" name="login_as" id="login_as" />
                                    </div>
                                    <input id="ValiderSuppressionBouton" class="button" value=" Valider " name="Valider" type="submit" />
                                    <br />
                                </fieldset>
                                <br />
                                <br />
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div class="block">
                <div class="block-bot">
                    <div class="head">
                        <div class="head-cnt">
                            <h3><a  id="VoirTousAdm" href="#" onClick="return false"> Voir tous les admins</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div style="display:none" id="toggleVoir">
                        <span id="erreurVoir" style="display:none"></span>
                        <div id="voirAdm" class="formulaire">
                            <fieldset>
                                <legend >Admins</legend>
                                <div id="afficherAdmin" class="formulaire"></div>
                            </fieldset>
                            <br />
                            <br />
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!-- / Content -->
        <!--  -->
        <%@include file="/config/menu.jsp" %>

        <%@include file="/config/footer.jsp" %>


    </body>
</html>

