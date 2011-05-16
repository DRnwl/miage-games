<%-- 
    Document   : voirClient
    Created on : 15 mai 2011, 21:21:43
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
                            <h3><a id="AjoutClt" href="#" onClick="return false">Ajouter un client</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div style="display:none" id="toggleCrea">
                        <span id="erreurCreation" style="display:none"></span>
                        <form class="formulaire" id ="formCreationC" name="session" action="" method=post>
                            <fieldset>
                                <legend>Information du compte</legend>
                                <label class="texte" for="login_c">Nom de compte: </label>
                                <input name="login_c" id="login_c" />
                                <br />
                                <label class="texte" for="password_c">Password:</label>
                                <input type="password" name="password_c" id="password_c" />
                                <br />
                                <label class="texte" for="password_ver"></label>
                                <input  type="password" name="password_ver" id="password_ver" />
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
                                <legend>Adresse Facturation</legend>
                                <label class="texte"  for="adresse_f">Adresse: </label>
                                <input type="text" name="adresse_f" id="adresse_f" />
                                <br />
                                <label class="texte"  for="adresse_f_suite"></label>
                                <input type="text" name="adresse_f_suite" id="adresse_f_suite" />
                                <br />
                                <label class="texte"  for="adresse_f_zip">Zip: </label>
                                <input type="text" name="adresse_f_zip" id="adresse_f_zip" />
                                <br />
                                <label class="texte"  for="adresse_f_ville">Ville: </label>
                                <input type="text" name="adresse_f_ville" id="adresse_f_ville" />
                                <br />
                            </fieldset>
                            <fieldset>
                                <legend>Adresse Livraison</legend>
                                <label class="texte"  for="adresse_l">Adresse: </label>
                                <input type="text" name="adresse_l" id="adresse_l" />
                                <br />
                                <label class="texte"  for="adresse_l_suite"></label>
                                <input type="text" name="adresse_l_suite" id="adresse_l_suite" />
                                <br />
                                <label class="texte"  for="adresse_l_zip">Zip: </label>
                                <input type="text" name="adresse_l_zip" id="adresse_l_zip" />
                                <br />
                                <label class="texte"  for="adresse_l_ville">Ville: </label>
                                <input type="text" name="adresse_l_ville" id="adresse_l_ville" />
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
                            <h3><a id="RechMClt" href="#" onClick="return false">Modifier un client</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div id="toggleModif" style="display:none">
                        <div class="search" >
                            <span id="erreurRecherche" style="display:none"></span>

                            <form   class="formulaire" id ="formRechercheC" name="session" action="" method=post>

                                <fieldset>
                                    <legend>Recherche d'un client</legend>

                                    <div class="fieldplace">
                                        <input class="field" type ="text" name="login_cr" id="login_cr" />
                                    </div>
                                    <input id="ValiderRechercheBouton" class="button" value=" Valider " name="Valider" type="submit" />

                                </fieldset>
                                <br />
                                <br />
                            </form>

                        </div>
                        <span id="erreurModification" style="display:none"></span>
                        <div class="formulaire" id="menuModifC" style="display:none"></div>
                    </div>
                </div>
            </div>
            <div class="block">
                <div class="block-bot">
                    <div class="head">
                        <div class="head-cnt">
                            <h3><a  id="SupprClt" href="#" onClick="return false"> Supprimer un client</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div style="display:none" id="toggleSupp">
                        <div class="search" >
                            <span id="erreurSuppression" style="display:none"></span>
                            <form class="formulaire" id ="formSupprimmerC" name="session" action="" method=post>
                                <fieldset>
                                    <legend>Identifiant du compte</legend>
                                    <div class="fieldplace">
                                        <input class="field" type ="text" name="login_cs" id="login_cs" />
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
                            <h3><a  id="VoirTousClt" href="#" onClick="return false"> Voir tous les clients</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div style="display:none" id="toggleVoir">
                        <span id="erreurVoir" style="display:none"></span>
                        <div id="voirClt" class="formulaire">
                            <fieldset>
                                <legend >Client</legend>
                                <div id="afficherClt" class="formulaire"></div>
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

