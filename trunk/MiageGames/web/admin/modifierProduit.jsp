<%-- 
    Document   : modifierProduit
    Created on : 18 mai 2011, 02:55:38
    Author     : Sangre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Miage Games - Modifier Produit</title>
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
        <div id="content">

            <div class="block">
                <div class="block-bot">
                    <div class="head">
                        <div class="head-cnt">
                            <h3>Modifier un produit</h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <span id="erreurModification" style="display:none"></span>
                    <form class="formulaire" id ="formModificationP" name="session" action="" method=post>
                        <fieldset>
                            <legend>Informations du produit</legend>
                            <label class="texte" for="nom_pm">Nom: </label>
                            <input name="nom_pm" id="nom_pm" value="${modifProduit.nom}"/>
                            <br />
                            <label class="texte" for="prix_pm">Prix:</label>
                            <input type="text" name="prix_pm" id="prix_pm" value="${modifProduit.prix}"/>
                            <br />
                            <label class="texte" for="categorie_pm">Categorie:</label>
                            <select style="width: 135px;" name="categorie_pm" id="categorie_pm" >
                                <c:forEach var="categorie" items="${categories}">
                                    <c:choose>
                                    <c:when test='${categorie.nom==modifProduit.categorie.nom}'>
                                        <option selected="selected">${categorie.nom}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${categorie.nom}</option>
                                    </c:otherwise>
                                </c:choose>
                                    
                                </c:forEach> 
                            </select>
                            <br />

                            <label class="texte" for="distributeur_pm">Distributeur: </label>
                            <input type="text" name="distributeur_pm" id="distributeur_pm" value="${modifProduit.distributeur.nom_distributeur}"/>
                            <br />
                            <label class="texte" for="editeur_pm">Editeur: </label>
                            <input type="text" name="editeur_pm" id="editeur_pm" value="${modifProduit.editeur.nomEditeur}"/>
                            <br />
                            <label class="texte" for="developpeur_pm">Developpeur: </label>
                            <input type="text" name="developpeur_pm" id="developpeur_pm" value="${modifProduit.developpeur.nomDeveloppeur}"/>
                            <br />
                            <label class="texte" for="date_pm">Sortie:</label>
                            <input type="text" name="date_pm" id="date_pm" readonly="readonly" value="${modifProduit.sortie}"/>
                            <br />
                            <label class="texte" for="image_pm">Image (url)</label>
                            <input type="text" name="image_pm" id="image_pm" value="${modifProduit.image}"/>
                            <br />
                            <label class="texte"  for="description_pm">Description: </label>
                            <textarea cols="14" rows="5" style="resize: none;width: 133px; height: 91px;" name="description_pm" id="description_pm" >${modifProduit.description}</textarea>
                            <br />
                            <label class="texte" for="categorieage_pm">Categorie:</label>
                            <select  style="width: 135px;" name="categorieage_pm" id="categorieage_pm" >
                                <c:forEach var="categorie_age" items="${categorieAge}">
                                    <c:choose>
                                    <c:when test='${categorie_age.nom==modifProduit.categorieAge.nom}'>
                                        <option selected="selected">${categorie_age.nom}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option>${categorie_age.nom}</option>
                                    </c:otherwise>
                                </c:choose>
                                    
                                </c:forEach> 
                            </select>
                            <br />
                            <label class="texte"  for="quantite_pm">Quantité:</label>
                            <input type="text" name="quantite_pm" id="quantite_pm" value="${modifProduit.quantiteProduit}"/>
                            <br />
                        </fieldset>
                        <br />

                        <input id="ValiderModifierBoutonP" class="button" value=" Valider " name="Valider" type="submit" />
                        <br />
                    </form>


                </div>
            </div>
        </div>
        <%@include file="/config/menu.jsp" %>
        <%@include file="/config/footer.jsp" %>

    </body>
</html>


