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
        <title>Jeux vidéo ${param.cat} sur Miage Games</title>
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
	
            $(function () {  $("#item").pagination();  });
	
        </script>

    </head>
    <body>
        <%@include file="/config/header.jsp" %>
        <%@include file="/config/menu.jsp" %>

        <div id="content">



            <div class="block">
                <div class="block-bot">

                    <div class="head">
                        <div class="head-cnt">
                            <h3>La sélection Miage Games "${param.cat}" </h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>

                    <ul>
                        <div id="item">


                            <c:forEach var="produit" items="${categoryProducts}">

                                <div >
                                    <div class="cl">&nbsp;</div>
                                    <div class="article">

                                        <div class="flottante">
                                            <a href="<c:url value='information?nomProduit=${produit.nom}'/>"> <img src="${produit.image}" alt="" /></a>
                                        </div>



                                        <div class ="flottante" >
                                            <h4><a href="<c:url value='information?nomProduit=${produit.nom}'/>">${produit.nom}</a></h4> 
                                            <br>

                                            <br>

                                            <p class="grey">

                                                Editeur :${produit.editeur.nomEditeur}
                                                <br>



                                            </p>



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







        <%@include file="/config/footer.jsp" %>

    </body>
</html>
