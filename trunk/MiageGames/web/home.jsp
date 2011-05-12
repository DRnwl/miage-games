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

    </head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Miage Games - Page Principal</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
        <!--[if IE 6]>
			<link rel="stylesheet" href="css/ie6-style.css" type="text/css" media="all" />
		<![endif]-->
        <script src="js/jquery-1.6.js" type="text/javascript"></script>
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

            <div class="block"> 
                <div class="block-bot">
                    <div class="block-cnt">
                        <div id="slider">
                            <div class="buttons">
                                <span class="prev">prev</span>
                                <span class="next">next</span>
                            </div>
                            <div class="holder">
                                <div class="frame">&nbsp;</div>
                                <div class="content">
                                    <ul>
                                        <c:forEach var="produit" items="${produits}">
                                            <li class="fragment">
                                                <div class="image">
                                                    <a href="#"><img src="css/images/img10.jpg" alt="" /></a>
                                                </div>
                                                <div class="cnt">
                                                    <div class="cl">&nbsp;</div>
                                                    <div class="side-a">
                                                        <h4>${produit.nom}</h4>
                                                        <ul class="rating">
                                                            <li><span class="star full-star">&nbsp;</span></li>
                                                            <li><span class="star full-star">&nbsp;</span></li>
                                                            <li><span class="star full-star">&nbsp;</span></li>
                                                            <li><span class="star full-star">&nbsp;</span></li>
                                                            <li><span class="star empty-star">&nbsp;</span></li>
                                                            <li><span class="votes">1.456 votes</span></li>
                                                        </ul>
                                                    </div>
                                                    <div class="side-b">
                                                        <p>${produit.description}</p>
                                                    </div>
                                                    <div class="cl">&nbsp;</div>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="block">
                <div class="block-bot">
                    <div class="head">
                        <div class="head-cnt">
                            <a href="#" class="view-all">view all</a>
                            <h3>Top Reviews</h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <div class="col-articles articles">
                        <div class="cl">&nbsp;</div>
                        <div class="article">
                            <div class="image">
                                <a href="#"><img src="css/images/img4.jpg" alt="" /></a>
                            </div>
                            <h4><a href="#">F.E.A.R.2</a></h4>
                            <p class="console"><strong>PSP3</strong></p>
                        </div>
                        <div class="article">
                            <div class="image">
                                <a href="#"><img src="css/images/img5.jpg" alt="" /></a>
                            </div>
                            <h4><a href="#">FALLOUT 3</a></h4>
                            <p class="console"><strong>PC</strong></p>
                        </div>
                        <div class="article">
                            <div class="image">
                                <a href="#"><img src="css/images/img6.jpg" alt="" /></a>
                            </div>
                            <h4><a href="#">STARCRAF II</a></h4>
                            <p class="console"><strong>PC</strong></p>
                        </div>
                        <div class="cl">&nbsp;</div>
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
