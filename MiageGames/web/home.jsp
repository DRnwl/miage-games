<%-- 
    Document   : home
    Created on : 8 mai 2011, 19:06:26
    Author     : Sangre
--%>
<%
// On verra plus tard pour ça -> on veut que si la personne lance cette page seul, elle soit redirigé sur l'accueil

    /*System.out.println(session.getAttribute("groupeUtilisateur"));
    
    if(session.getAttribute("groupeUtilisateur") == null) 
    response.sendRedirect("index.jsp");
    System.out.println("");*/
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Miage Games - Page Principal</title>
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

        <script type="text/javascript">
	
            $(function () {  $("#divListeProduits").pagination();  });
	
        </script>

    </head>
    <body>
        <%@include file="/config/header.jsp" %>

        <div class="cl">&nbsp;</div>
        <!-- Content -->



        <div id="content">



            <div class="block">
                <div class="block-bot">

                    <div class="head">
                        <div class="head-cnt">
                            <h3>Tous les jeux de la Miage Games</h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>

                    <ul>

                        <div id="divListeProduits">

                            <c:forEach var="produit" items="${produits}">

                                <div >
                                    <div class="cl">&nbsp;</div>
                                    <div class="article">

                                        <div class="flottante">
                                            <a href="<c:url value='information?nomProduit=${produit.nom}'/>"><img src="${produit.image}" alt="" /> </a>
                                        </div>

                                        <div class ="flottante" >


                                            <h3><li><a href="<c:url value='information?nomProduit=${produit.nom}'/>">${produit.nom}</a></h3> 

                                            <br>

                                            <h4 style="font-size: 11px"> Sortie : <br> ${produit.sortie} </h4>


                                            <br>

                                            <h5> Categorie: ${produit.categorie.nom} </h5>

                                            <br>

                                            <h6 style="font-size: 12px">  Classification: <br> ${produit.categorieAge.nom}</h6>



                                        </div>

                                        <div class ="flottante">  
                                            <strong class="price">Prix : ${produit.prix}</strong> €
                                           


                                            <td>
                                                <form action="<c:url value='addToCart'/>" method="post">
                                                    <input type="hidden"
                                                           name="nomProduitCommande"
                                                           value="${produit.nom}">
                                                    <input type="submit"
                                                           name="submit"
                                                           value=ajouterAuPanier>
                                                </form>
                                            </td>

                                            <br>

                                        </div>


                                    </div>


                                    <br class="clear">


                                </div>

                            </c:forEach>

                        </div>
                    </ul>



                </div>
            </div>

        </div>






        <!-- / Content -->
        <!--  -->
        <%@include file="/config/menu.jsp" %>

        <%@include file="/config/footer.jsp" %>


    </body>
</html>
