<%-- 
    Document   : detailCommande
    Created on : 18 mai 2011, 17:36:15
    Author     : Sangre
--%>

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
        <title>Miage Games - Creer un client</title>
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
                            <h3>Création de compte</h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="block-bot">
                <div id="total"><h2>Total de la commande: ${montant}&euro;</h2></div>
                <ul>

                    <div id="divListeProduits">

                        <c:forEach var="commande" items="${commandeC}">

                            <div>
                                <div class="cl">&nbsp;</div>
                                <div class="article">
                                    <div class="flottante">
                                        <a href="<c:url value='information?nomProduit=${commande.produit.nom}'/>"><img src="${commande.produit.image}" alt="" /> </a>
                                    </div>
                                    <div class ="flottante" >
                                        <h3><li><a href="<c:url value='information?nomProduit=${commande.produit.nom}'/>">${commande.produit.nom}</a></h3> 
                                        <br>
                                        <h4 style="font-size: 11px"> Sortie : <br> ${commande.produit.sortie} </h4>
                                        <br>
                                        <h5> Categorie: ${commande.produit.categorie.nom} </h5>
                                        <br>
                                        <h6 style="font-size: 12px">  Classification: <br> ${commande.produit.categorieAge.nom}</h6>
                                    </div>
                                    <div class ="flottante">  
                                        <strong class="price">Prix : ${commande.produit.prix}</strong> &euro;
                                        <br>
                                        <strong class="price">Quantité: ${commande.quantite}</strong>
                                    </div>
                                    <div class ="flottante">  
                                        <strong class="price">Total : ${commande.produit.prix*commande.quantite}</strong> &euro;
                                    </div>
                                </div>
                                <br class="clear">
                            </div>
                        </c:forEach>

                    </div>
                    <br />
                </ul>
                <br />

            </div>
        </div>
        <%@include file="/config/menu.jsp" %>
        <%@include file="/config/footer.jsp" %>

    </body>
</html>

