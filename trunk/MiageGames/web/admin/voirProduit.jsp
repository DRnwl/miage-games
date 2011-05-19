<%-- 
    Document   : voirProduit
    Created on : 17 mai 2011, 16:26:14
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
                            <h3><a id="AjoutProd" href="#" onClick="return false">Ajouter un produit</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div style="display:none" id="toggleCrea">
                        <span id="erreurCreation" style="display:none"></span>
                        <form class="formulaire" id ="formCreationP" name="session" action="" method=post>
                            <fieldset>
                                <legend>Informations du produit</legend>
                                <label class="texte" for="nom_p">Nom: </label>
                                <input name="nom_p" id="nom_p" />
                                <br />
                                <label class="texte" for="prix_p">Prix:</label>
                                <input type="text" name="prix_p" id="prix_p" />
                                <br />
                                <label class="texte" for="categorie_p">Categorie:</label>
                                <select style="width: 135px;" name="categorie_p" id="categorie_p" >
                                    <c:forEach var="categorie" items="${categories}">
                                        <option>${categorie.nom}</option>
                                    </c:forEach> 
                                </select>
                                <br />

                                <label class="texte" for="distributeur_p">Distributeur: </label>
                                <input type="text" name="distributeur_p" id="distributeur_p" />
                                <br />
                                <label class="texte" for="editeur_p">Editeur: </label>
                                <input type="text" name="editeur_p" id="editeur_p" />
                                <br />
                                <label class="texte" for="developpeur_p">Developpeur: </label>
                                <input type="text" name="developpeur_p" id="developpeur_p" />
                                <br />
                                <label class="texte" for="date">Sortie:</label>
                                <input type="text" name="date" id="date" readonly="readonly"/>
                                <br />
                                <label class="texte" for="image_p">Image (url)</label>
                                <input type="text" name="image_p" id="image_p" />
                                <br />
                                <label class="texte"  for="description_p">Description: </label>
                                <textarea cols="14" rows="5" style="resize: none;width: 133px; height: 91px;" name="description_p" id="description_p" ></textarea>
                                <br />
                                <label class="texte" for="categorieage_p">Categorie:</label>
                                <select  style="width: 135px;" name="categorieage_p" id="categorieage_p" >
                                    <c:forEach var="categorie_age" items="${categorieAge}">
                                        <option>${categorie_age.nom}</option>
                                    </c:forEach> 
                                </select>
                                <br />
                                <label class="texte"  for="quantite_p">Quantité:</label>
                                <input type="text" name="quantite_p" id="quantite_p" />
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
                            <h3><a id="RechMProd" href="#" onClick="return false">Modifier un produit</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div id="toggleModif" style="display:none">
                        <div class="search" >
                            <span id="erreurRecherche" style="display:none"></span>

                            <form   class="formulaire" id ="formRechercheP" name="session" action="" method=post>

                                <fieldset>
                                    <legend>Recherche d'un produit</legend>
                                    <select style="margin-left: auto;margin-right:auto;height: 22px;width: 135px;" name="categorie_pr" id="categorie_pr" >
                                        <c:forEach var="categorie" items="${categories}">
                                            <option>${categorie.nom}</option>
                                        </c:forEach> 
                                    </select>
                                    <div class="fieldplace">

                                        <input class="field" type ="text" name="nom_pr" id="nom_pr" />

                                    </div>
                                    <input id="ValiderRechercheBouton" class="button" value=" Valider " name="Valider" type="submit" />

                                </fieldset>
                                <br />
                                <br />
                            </form>

                        </div>
                        <span id="erreurModification" style="display:none"></span>
                        <div class="formulaire" id="menuModifP" style="display:none"></div>
                    </div>
                </div>
            </div>
            <div class="block">
                <div class="block-bot">
                    <div class="head">
                        <div class="head-cnt">
                            <h3><a  id="SupprProd" href="#" onClick="return false"> Supprimer un produit</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div style="display:none" id="toggleSupp">
                        <div class="search" >
                            <span id="erreurSuppression" style="display:none"></span>
                            <form class="formulaire" id ="formSupprimmerP" name="session" action="" method=post>
                                <fieldset>
                                    <legend>Nom du produit</legend>
                                    <select style="margin-left: auto;margin-right:auto;height: 22px;width: 135px;" name="categorie_ps" id="categorie_ps" >
                                            <c:forEach var="categorie" items="${categories}">
                                                <option>${categorie.nom}</option>
                                            </c:forEach> 
                                        </select>
                                    <div class="fieldplace">
                                        <input class="field" type ="text" name="nom_ps" id="nom_ps" />
                                        
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
                            <h3><a  id="VoirTousProd" href="#" onClick="return false"> Voir tous les produits</a></h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div style="display:none" id="toggleVoir">
                        <span id="erreurVoir" style="display:none"></span>
                        <div id="voirTousProd" class="formulaire">
                            <fieldset>
                                <legend >Produits</legend>
                                <div id="afficherProd" class="formulaire"></div>
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


