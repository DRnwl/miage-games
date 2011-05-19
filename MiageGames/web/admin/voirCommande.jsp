<%-- 
    Document   : voirCommande
    Created on : 17 mai 2011, 16:44:27
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
                            <h3><a id="AjoutComd" href="#" onClick="return false">Ajouter une commande</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div style="display:none" id="toggleCrea">
                        <span id="erreurCreation" style="display:none"></span>
                        <form class="formulaire" id ="formCreationCo" name="session" action="" method=post>
                            <fieldset>
                              
                                <legend>Informations commandes</legend>
                                
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
                            <h3><a id="RechMComd" href="#" onClick="return false">Modifier une commande</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div id="toggleModif" style="display:none">
                        <div class="search" >
                            <span id="erreurRecherche" style="display:none"></span>

                            <form   class="formulaire" id ="formRechercheCo" name="session" action="" method=post>

                                <fieldset>
                                    <legend>Recherche d'une commande</legend>

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
                            <h3><a  id="SupprComd" href="#" onClick="return false"> Supprimer une commande</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div style="display:none" id="toggleSupp">
                        <div class="search" >
                            <span id="erreurSuppression" style="display:none"></span>
                            <form class="formulaire" id ="formSupprimmerCo" name="session" action="" method=post>
                                <fieldset>
                                    <legend>Numero de confirmation de la commande</legend>
                                    <div class="fieldplace">
                                        <input class="field" type ="text" name="numero_cs" id="numero_cs" />
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
                            <h3><a  id="VoirTousComd" href="#" onClick="return false"> Voir toutes les commandes</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div style="display:none" id="toggleVoir">
                        <span id="erreurVoir" style="display:none"></span>
                        <div id="voirTousComd" class="formulaire">
                            <fieldset>
                                <legend >Commandes</legend>
                                <div id="afficherComd" class="formulaire"></div>
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


