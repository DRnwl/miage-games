<%-- 
    Document   : voirCommandes
    Created on : 15 mai 2011, 17:41:39
    Author     : Sangre
--%>

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
                            <h3>Vos commandes</h3>
                            <div class="cl">&nbsp;</div>
                        </div>
                    </div>
                    <c:forEach var="commande" items="${typeUtilisateur.collectionCommandeClient}">
                        ${commande}:${typeUtilisateur.login}
                    </c:forEach>
                </div>
            </div>

        </div>
        <!-- / Content -->
        <!--  -->
        <%@include file="/config/menu.jsp" %>
        
        <%@include file="/config/footer.jsp" %>
        

    </body>
</html>
