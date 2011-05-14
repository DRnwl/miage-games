<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jeux vidÃ©o ${param.cat} sur Miage Games</title>
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
        <%@include file="/config/menu.jsp" %>
        <h1>&nbsp;Categorie ${param.cat}</h1> 


        <div id="categoryRightColumn">

            

            <table id="productTable">

                <c:forEach var="produit" items="${categoryProducts}" varStatus="iter">

                    <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                       

                        <td>
                            <br>
                           <fmt:message key='${produit.nom}'/></span>
                        </td>


                       
                    </tr>

                </c:forEach>

            </table>
        </div>









        <%@include file="/config/footer.jsp" %>

    </body>
</html>
