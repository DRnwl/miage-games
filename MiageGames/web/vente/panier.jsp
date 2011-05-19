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


        <script type="text/javascript" src="js/tabber.js"></script>
        <link rel="stylesheet" href="css/example.css" TYPE="text/css" MEDIA="screen">
        <link rel="stylesheet" href="css/example-print.css" TYPE="text/css" MEDIA="print">






    </head>
    <body>
        <%@include file="/config/header.jsp" %>



        <%@include file="/config/menu.jsp" %>


        <div id="content">



            <div class="block">
                <div class="block-bot">

                    <div class="head">
                        <div class="head-cnt">
                            <h3>PANIER </h3>
                            <div class="cl">&nbsp;</div>
                        </div>

                        

                        <c:if test="${panier.nombreElements == 0}">
                            <h2>Votre panier est vide</h2>
                        </c:if>





                    </div>

                    <br>

                    <c:if test="${!empty panier && panier.nombreElements != 0}">

                        <h2 id="subtotal" style=";margin-left: 8px">Prix sans tva : ${panier.subtotal}&euro;

                        </h2>

                        <table border="10" style="width:96%;margin-left: 10px">
                            <!-- La ligne de titre du tableau des comptes -->
                            <tr>
                                <td>Nom du produit</td>
                                <td>Image</td>
                                <td>Prix (en €)</td>
                                <td>Quantite</td>


                            </tr>

                            <c:forEach var="cartItem" items="${liste}" varStatus="iter">



                                <c:set var="produit" value="${cartItem.produit}"/>

                                <tr>
                                    <td><div class ="flottante" >
                                            <h4>${produit.nom}</h4> 


                                        </div></td>


                                    <td><div class="flottante">
                                            <img src="${produit.image}" alt=""/>


                                        </div></td>

                                    <td><div class ="flottante">  
                                            ${produit.prix}

                                        </div></td>

                                    <td>
                                        <form class="formulaire" action="<c:url value='updateCart'/>" method="post">
                                            <input type="hidden"
                                                   name="nomProduitCommande"
                                                   value="${produit.nom}">
                                            <input type="text"
                                                   maxlength="2"
                                                   size="2"
                                                   value="${cartItem.quantiteCommande}"
                                                   
                                                   name="quantite"
                                                   style="margin:5px">
                                            <input class="button" type="submit"
                                                   name="submit"
                                                   value=MAJ>
                                        </form>
                                    </td>




                                </c:forEach>


                        </table>
                    </c:if>

                </div>

                <div class ="article"</div>





                <% if (session.getAttribute("groupeUtilisateur").equals("visiteur")) {%>

                <h2> veuillez vous connecter!! </h2>


                <% } else if (session.getAttribute("groupeUtilisateur").equals("client")) {%>

                <div class ="flottante">  

                    <a title="Valider votre commande" href="paiement">
                        <img alt="Acheter" src="http://www.micromania.fr/v3b/micromania/images/button-valider-commande.gif"></img>
                    </a>

                    <br>
                </div>




                <%} else if (session.getAttribute("groupeUtilisateur").equals("administrateur")) {%>
                <h2> pas droit!! </h2>


                <%}%>




                <h3><a style="float:right;margin-top: 35px" href="<c:url value='ServletPrincipal'/>">Retour aux achats</a></h3>

                <br>


                <c:if test="${!empty panier && panier.nombreElements != 0}">

                    <c:url var="url" value="panier">
                        <c:param name="clear" value="true"/>
                    </c:url>

                        <h3> <a  style="float:right" href="${url}">Vider le panier</a></h3>

                </c:if>

            </div>
        </div>



    </div>





    <%@include file="/config/footer.jsp" %>

</body>
</html>
