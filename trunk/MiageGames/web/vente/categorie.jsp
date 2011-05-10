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
                <title>Miage Games - ${param.cat}</title>
		<link rel="stylesheet" href="../css/style.css" type="text/css" media="all" />
		<!--[if IE 6]>
			<link rel="stylesheet" href="css/ie6-style.css" type="text/css" media="all" />
		<![endif]-->
		<script src="../js/jquery-1.4.2.js" type="text/javascript"></script>
		<script src="../js/fns.js" type="text/javascript"></script>
    </head>
    <body>
        <%@include file="/header.jsp" %>
        <%@include file="/menu.jsp" %>
        <h1>&nbsp;Categorie ${param.cat}</h1> 
       <%@include file="/footer.jsp" %>
        
    </body>
</html>
