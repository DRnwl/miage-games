
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var='view' value='/index' scope='session' />

<!-- Page -->
<div id="page" class="shell">
    <!-- Header -->
    <div id="header">
        <!-- Top Navigation -->
        <div id="top-nav">
            <ul>
                <li class="home"><a href="/MiageGames/index.jsp">Accueil</a></li>
                <c:forEach var="categorie" items="${categories}">

                    <li><a href="<c:url value='categorie?cat=${categorie.nom}'/>">${categorie.nom}</a></li>

                </c:forEach> 
            </ul>
        </div>
        <!-- / Top Navigation -->
        <div class="cl">&nbsp;</div>
        <!-- Logo -->
        <div id="logo">
            <h1><a href="#">Miage <span>Games</span></a></h1>
            <p class="description">Votre zone de jeu</p>
        </div>
        <!-- / Logo -->
        <!-- Main Navigation -->
        <div id="main-nav">
            <div class="bg-right">
                <div class="bg-left">
                    <ul>
                        <li><a href="#">Mettre les différents tags</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- / Main Navigation -->
    </div>
    <div class="cl">&nbsp;</div>
    <!-- / Header -->

    <!-- Main -->
    <div id="main">
        <div id="main-bot">
            <div class="cl">&nbsp;</div>
