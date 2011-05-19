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
        <link rel="stylesheet" href="css/afflebean.css" type="text/css" media="all" />

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
                            <h3> récapitulatif de votre commande </h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>

                </div>

                <br>
                <br>

                <h4>Votre commande a bien été prise en compte et nous vous en remercions. <br>

                    Nous mettons tout en œuvre pour qu'elle vous soit livrée dans les délais les plus rapides. </h4>


                <ul>

                    <br>
                    <br>

                    <div id="item">


                        <h4 id="subtotal">Votre carte ne sera debitée de cette montant ${panier.subtotal} €   <br>qu'au moment où les articles commandés sont prêts à l'envoi. </h4>
                        <br>
                        <br>


                        <table border="10">
                            <!-- La ligne de titre du tableau des comptes -->
                            <tr>
                                <td>Nom du produit</td>
                                <td>Quantite</td>
                                <td>Prix (en €)</td>



                            </tr>

                            <c:forEach var="cartItem" items="${liste}" varStatus="iter">



                                <c:set var="produit" value="${cartItem.produit}"/>

                                <tr>
                                    <td><div class ="flottante" >
                                            <h4>${produit.nom}</h4> 


                                        </div></td>



                                    <td><div class ="flottante">  
                                            ${produit.quantiteProduit}

                                        </div></td>


                                    <td><div class ="flottante">  
                                            ${produit.prix}

                                        </div></td>

                                </tr>





                            </c:forEach>

                        </table>

                    </div>
                </ul>
            </div>
        </div>






        <%@include file="/config/footer.jsp" %>

    </body>
</html>
