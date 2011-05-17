<%-- 
    Document   : categorie
    Created on : 8 mai 2011, 20:25:48
    Author     : Sangre
--%>

<%@page import="gestionnaire.GestionnaireProduit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Miage Games</title>
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
        <script src="js/paginator.js"></script>
    </head>
    <body>
        <%@include file="/config/header.jsp" %>
        <%@include file="/config/menu.jsp" %>


        <div id="content">



            <div class="block">
                <div class="block-bot">

                    <div class="head">
                        <div class="head-cnt">
                            <h3>Fiche technique"${nomProduit}" </h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>



                    <c:if test="${nomProduit} == ${produitRecherche.nom}"></c:if>


                    <div >
                        <div class="cl">&nbsp;</div>
                        <div class="article">

                            <div class="flottante">
                                <img src="${produitRecherche.image}" alt=""/>
                            </div>



                            <div class ="flottante" >
                                <h4>${produitRecherche.nom}</h4> 

                                <br>
                                <br>

                                <h5 style="font-size: 11px"> Sortie: ${produitRecherche.sortie} </h5>

                                <br>
                                <br>

                                <p class="grey">

                                    Developpeur : ${produitRecherche.developpeur.nomDeveloppeur}
                                    <br>
                                    <br>

                                    Editeur : ${produitRecherche.editeur.nomEditeur}

                                    <br>
                                    <br>

                                    Classification: <img src="${produitRecherche.categorieAge.nomImage}" alt="" />
                                    </br>
                                </p>

                            </div>

                            <div class ="flottante">  
                                <strong class="price">Prix : ${produitRecherche.prix}</strong> €
                                <a title="Acheter" href="#">
                                    <img alt="Acheter" src="http://www.micromania.fr/v3b/micromania/images/button-acheter-mini.gif"></img>
                                </a>

                                <br>
                            </div>


                        </div>


                        <br class="clear">


                    </div>


                </div>
            </div>

        </div>

        <%@include file="/config/footer.jsp" %>

    </body>
</html>